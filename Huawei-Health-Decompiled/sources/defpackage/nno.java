package defpackage;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes6.dex */
public class nno implements Runnable, Comparable<Runnable> {
    private static final AtomicLong c = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16054a;
    private final long d = c.getAndIncrement();
    private final Runnable e;

    public nno(Runnable runnable, int i) {
        this.e = runnable;
        this.f16054a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.e.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(java.lang.Runnable r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof defpackage.nno
            if (r0 == 0) goto L7
            nno r5 = (defpackage.nno) r5
            goto L19
        L7:
            boolean r0 = r5 instanceof defpackage.nnq
            if (r0 == 0) goto L18
            nnq r5 = (defpackage.nnq) r5
            java.lang.Runnable r0 = r5.e
            boolean r0 = r0 instanceof defpackage.nno
            if (r0 == 0) goto L18
            java.lang.Runnable r5 = r5.e
            nno r5 = (defpackage.nno) r5
            goto L19
        L18:
            r5 = 0
        L19:
            if (r5 == 0) goto L36
            int r0 = r4.f16054a
            int r1 = r5.f16054a
            if (r0 != r1) goto L33
            java.lang.Runnable r0 = r5.e
            java.lang.Runnable r1 = r4.e
            if (r0 == r1) goto L36
            long r0 = r4.d
            long r2 = r5.d
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 >= 0) goto L31
            r5 = -1
            goto L37
        L31:
            r5 = 1
            goto L37
        L33:
            int r5 = r1 - r0
            goto L37
        L36:
            r5 = 0
        L37:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nno.compareTo(java.lang.Runnable):int");
    }
}
