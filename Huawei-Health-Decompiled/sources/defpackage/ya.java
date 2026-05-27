package defpackage;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes9.dex */
public class ya {
    protected static final ThreadLocal<SoftReference<yd>> b;
    private static final ym d;

    static {
        d = "true".equals(System.getProperty("com.fasterxml.jackson.core.util.BufferRecyclers.trackReusableBuffers")) ? ym.b() : null;
        b = new ThreadLocal<>();
    }

    public static yd b() {
        SoftReference<yd> softReference;
        ThreadLocal<SoftReference<yd>> threadLocal = b;
        SoftReference<yd> softReference2 = threadLocal.get();
        yd ydVar = softReference2 == null ? null : softReference2.get();
        if (ydVar == null) {
            ydVar = new yd();
            ym ymVar = d;
            if (ymVar != null) {
                softReference = ymVar.d(ydVar);
            } else {
                softReference = new SoftReference<>(ydVar);
            }
            threadLocal.set(softReference);
        }
        return ydVar;
    }
}
