package com.huawei.health.device.util;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import health.compact.a.hwlogsmodel.ReleaseLogUtil;
import health.compact.a.util.LogUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public class EventBus {
    private ArrayList<c> b = new ArrayList<>(16);
    private static final HashMap<String, EventBus> d = new HashMap<>(16);
    private static final ReentrantLock c = new ReentrantLock();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ThreadPoolExecutor f2314a = null;

    public interface ICallback {
        void onEvent(b bVar);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Bundle f2315a;
        private Intent b;
        private String e;

        public b(String str) {
            this(str, new Bundle());
        }

        public b(String str, Bundle bundle) {
            this.e = str;
            this.f2315a = bundle;
        }

        public b(String str, Intent intent) {
            this.e = str;
            this.b = intent;
        }

        public String e() {
            return this.e;
        }

        public Bundle Mk_() {
            return this.f2315a;
        }

        public Intent Ml_() {
            return this.b;
        }
    }

    private EventBus() {
    }

    public static void e(b bVar) {
        String str;
        if (bVar == null || (str = bVar.e) == null) {
            return;
        }
        c.lock();
        try {
            EventBus eventBus = d.get(str);
            if (eventBus != null) {
                ReleaseLogUtil.d("PluginDevice_EventBus", "EventBus publish ", bVar.e());
                Iterator<c> it = eventBus.b.iterator();
                while (it.hasNext()) {
                    it.next().a(bVar);
                }
            }
        } finally {
            c.unlock();
        }
    }

    public static void d(ICallback iCallback, int i, String... strArr) {
        if (iCallback == null || strArr == null || strArr.length == 0) {
            return;
        }
        c.lock();
        try {
            ReleaseLogUtil.d("PluginDevice_EventBus", "EventBus subscribe ", Arrays.toString(strArr));
            c cVar = null;
            for (String str : strArr) {
                if (str != null) {
                    HashMap<String, EventBus> map = d;
                    EventBus eventBus = map.get(str);
                    if (eventBus == null) {
                        eventBus = new EventBus();
                        map.put(str, eventBus);
                    }
                    ArrayList<c> arrayList = eventBus.b;
                    Iterator<c> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().f2316a == iCallback) {
                                break;
                            }
                        } else {
                            if (cVar == null) {
                                cVar = new c(iCallback, i);
                            }
                            arrayList.add(cVar);
                        }
                    }
                }
            }
        } finally {
            c.unlock();
        }
    }

    public static void d(ICallback iCallback, String... strArr) {
        EventBus eventBus;
        if (iCallback == null || strArr == null || strArr.length == 0) {
            return;
        }
        c.lock();
        try {
            ReleaseLogUtil.d("PluginDevice_EventBus", "EventBus unsubscribe ", Arrays.toString(strArr));
            for (String str : strArr) {
                if (str != null && (eventBus = d.get(str)) != null) {
                    ArrayList<c> arrayList = eventBus.b;
                    int size = arrayList.size();
                    int i = 0;
                    while (i < size && arrayList.get(i).f2316a != iCallback) {
                        i++;
                    }
                    if (i < size) {
                        arrayList.remove(i);
                        if (arrayList.isEmpty()) {
                            HashMap<String, EventBus> map = d;
                            map.remove(str);
                            if (map.isEmpty() && f2314a != null) {
                                f2314a = null;
                            }
                        }
                    }
                }
            }
        } finally {
            c.unlock();
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ICallback f2316a;
        Handler e;

        c(ICallback iCallback, int i) {
            this.f2316a = iCallback;
            if (i != 1) {
                if (i == 2) {
                    this.e = new Handler(Looper.getMainLooper());
                    return;
                } else {
                    this.e = null;
                    return;
                }
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                LogUtil.c("PluginDevice_EventBus", "No Looper; Looper.prepare() wasn't called on this thread.");
            } else {
                this.e = new Handler(looperMyLooper);
            }
        }

        void a(final b bVar) {
            Runnable runnable = new Runnable() { // from class: com.huawei.health.device.util.EventBus.c.1
                @Override // java.lang.Runnable
                public void run() {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        if (c.this.f2316a != null) {
                            ReleaseLogUtil.d("PluginDevice_EventBus", "EventBus onEvent ", bVar.e());
                            c.this.f2316a.onEvent(bVar);
                        }
                    } finally {
                        if (c.this.e == null) {
                            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                            if (jCurrentTimeMillis2 > 5000 && c.this.f2316a != null) {
                                LogUtil.c("PluginDevice_EventBus", c.this.f2316a.getClass().getName(), " takes too long (", Long.valueOf(jCurrentTimeMillis2), "ms)!");
                            }
                        }
                    }
                }
            };
            Handler handler = this.e;
            if (handler == null) {
                if (EventBus.f2314a == null) {
                    ThreadPoolExecutor unused = EventBus.f2314a = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    EventBus.f2314a.allowCoreThreadTimeOut(true);
                }
                EventBus.f2314a.execute(runnable);
                return;
            }
            handler.post(runnable);
        }
    }
}
