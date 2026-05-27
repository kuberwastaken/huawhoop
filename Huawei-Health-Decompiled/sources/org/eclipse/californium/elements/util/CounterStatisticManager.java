package org.eclipse.californium.elements.util;

import defpackage.ygo;
import defpackage.ygp;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes8.dex */
public abstract class CounterStatisticManager {
    protected final ygo.d align;
    private final ScheduledExecutorService executor;
    private final long interval;
    private AtomicLong lastTransfer;
    private final List<String> orderedKeys;
    private AtomicBoolean running;
    private final ConcurrentMap<String, ygo> statistics;
    protected final String tag;
    private ScheduledFuture<?> taskHandle;
    private final TimeUnit unit;

    public abstract void dump();

    public abstract boolean isEnabled();

    public CounterStatisticManager(String str) {
        this.align = new ygo.d();
        this.statistics = new ConcurrentHashMap();
        this.orderedKeys = new CopyOnWriteArrayList();
        this.running = new AtomicBoolean();
        this.lastTransfer = new AtomicLong(ClockUtil.b());
        this.tag = ygp.h(str);
        this.interval = 0L;
        this.unit = null;
        this.executor = null;
    }

    public CounterStatisticManager(String str, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        this.align = new ygo.d();
        this.statistics = new ConcurrentHashMap();
        this.orderedKeys = new CopyOnWriteArrayList();
        this.running = new AtomicBoolean();
        this.lastTransfer = new AtomicLong(ClockUtil.b());
        if (scheduledExecutorService == null) {
            throw new NullPointerException("executor must not be null!");
        }
        this.tag = ygp.h(str);
        if (isEnabled()) {
            this.interval = j;
            this.unit = timeUnit;
            this.executor = j <= 0 ? null : scheduledExecutorService;
        } else {
            this.interval = 0L;
            this.unit = null;
            this.executor = null;
        }
    }

    protected void add(String str, ygo ygoVar) {
        addByKey(str + ygoVar.c(), ygoVar);
    }

    protected void add(ygo ygoVar) {
        addByKey(ygoVar.c(), ygoVar);
    }

    protected void addByKey(String str, ygo ygoVar) {
        if (this.statistics.put(str, ygoVar) != null) {
            this.orderedKeys.remove(str);
        }
        this.orderedKeys.add(str);
    }

    protected void removeByKey(String str, ygo ygoVar) {
        if (this.statistics.remove(str, ygoVar)) {
            this.orderedKeys.remove(str);
        }
    }

    protected void removeByKey(String str) {
        if (this.statistics.containsKey(str)) {
            this.statistics.remove(str);
            this.orderedKeys.remove(str);
        }
    }

    protected ygo get(String str) {
        return this.statistics.get(str);
    }

    public ygo getByKey(String str) {
        return this.statistics.get(str);
    }

    public List<String> getKeys() {
        return Collections.unmodifiableList(this.orderedKeys);
    }

    public void start() {
        synchronized (this) {
            if (this.executor != null && this.taskHandle == null) {
                this.running.set(true);
                ScheduledExecutorService scheduledExecutorService = this.executor;
                Runnable runnable = new Runnable() { // from class: org.eclipse.californium.elements.util.CounterStatisticManager.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (CounterStatisticManager.this.running.get()) {
                            CounterStatisticManager.this.dump();
                        }
                    }
                };
                long j = this.interval;
                this.taskHandle = scheduledExecutorService.scheduleAtFixedRate(runnable, j, j, this.unit);
            }
        }
    }

    public boolean stop() {
        synchronized (this) {
            if (this.taskHandle == null) {
                return false;
            }
            this.running.set(false);
            this.taskHandle.cancel(false);
            this.taskHandle = null;
            return true;
        }
    }

    public long getLastTransferTime() {
        return this.lastTransfer.get();
    }

    public void transferCounter() {
        Iterator<ygo> it = this.statistics.values().iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        this.lastTransfer.set(ClockUtil.b());
    }

    public void reset() {
        Iterator<ygo> it = this.statistics.values().iterator();
        while (it.hasNext()) {
            it.next().j();
        }
        this.lastTransfer.set(ClockUtil.b());
    }

    public long getCounter(String str) {
        return getByKey(str).d();
    }

    public long getCounterByKey(String str) {
        return getByKey(str).d();
    }

    public String getTag() {
        return this.tag;
    }
}
