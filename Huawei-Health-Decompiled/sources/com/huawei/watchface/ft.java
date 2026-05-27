package com.huawei.watchface;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes8.dex */
public class ft implements Comparable<Runnable>, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicLong f11558a = new AtomicLong();
    private final long b = f11558a.getAndIncrement();
    private final Runnable c;
    private int d;

    public ft(Runnable runnable, int i) {
        this.c = runnable;
        this.d = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0018  */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(java.lang.Runnable r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.huawei.watchface.ft
            if (r0 == 0) goto L7
            com.huawei.watchface.ft r5 = (com.huawei.watchface.ft) r5
            goto L19
        L7:
            boolean r0 = r5 instanceof com.huawei.watchface.fs
            if (r0 == 0) goto L18
            com.huawei.watchface.fs r5 = (com.huawei.watchface.fs) r5
            java.lang.Runnable r0 = r5.f11557a
            boolean r0 = r0 instanceof com.huawei.watchface.ft
            if (r0 == 0) goto L18
            java.lang.Runnable r5 = r5.f11557a
            com.huawei.watchface.ft r5 = (com.huawei.watchface.ft) r5
            goto L19
        L18:
            r5 = 0
        L19:
            if (r5 == 0) goto L36
            int r0 = r4.d
            int r1 = r5.d
            if (r0 != r1) goto L33
            java.lang.Runnable r0 = r5.c
            java.lang.Runnable r1 = r4.c
            if (r0 == r1) goto L36
            long r0 = r4.b
            long r2 = r5.b
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
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.watchface.ft.compareTo(java.lang.Runnable):int");
    }
}
