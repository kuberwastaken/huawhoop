package defpackage;

import com.huawei.devicesdk.strategy.ScanStrategy;
import health.compact.a.LogUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;

/* JADX INFO: loaded from: classes10.dex */
public class cgb {
    private static final cgb b = new cgb();
    private static final Object e = new Object();
    private Timer c;
    private Set<ScanStrategy> d = new HashSet();

    private cgb() {
    }

    public void a(Timer timer) {
        this.c = timer;
    }

    public void b(ScanStrategy scanStrategy) {
        synchronized (e) {
            this.d.add(scanStrategy);
        }
    }

    public void d(ScanStrategy scanStrategy) {
        synchronized (e) {
            this.d.remove(scanStrategy);
        }
    }

    public void c() {
        LogUtil.a("ScanStrategyCache", "stop scan");
        Timer timer = this.c;
        if (timer != null) {
            timer.cancel();
            this.c = null;
        }
        synchronized (e) {
            Iterator<ScanStrategy> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().stopScan(true);
                it.remove();
            }
        }
    }

    public static cgb d() {
        return b;
    }
}
