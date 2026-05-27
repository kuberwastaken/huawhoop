package defpackage;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
class ym {
    private final Object d = new Object();
    private final Map<SoftReference<yd>, Boolean> b = new ConcurrentHashMap();
    private final ReferenceQueue<yd> c = new ReferenceQueue<>();

    static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final ym f19360a = new ym();
    }

    ym() {
    }

    public static ym b() {
        return e.f19360a;
    }

    public SoftReference<yd> d(yd ydVar) {
        SoftReference<yd> softReference = new SoftReference<>(ydVar, this.c);
        this.b.put(softReference, true);
        e();
        return softReference;
    }

    private void e() {
        while (true) {
            SoftReference softReference = (SoftReference) this.c.poll();
            if (softReference == null) {
                return;
            } else {
                this.b.remove(softReference);
            }
        }
    }
}
