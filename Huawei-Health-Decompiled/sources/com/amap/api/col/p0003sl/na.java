package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
public final class na extends oa {
    public static int a(nz nzVar, int i) {
        nzVar.b(1);
        b(nzVar, i);
        return a(nzVar);
    }

    private static void b(nz nzVar, int i) {
        nzVar.b(0, i);
    }

    public static int a(nz nzVar, int[] iArr) {
        nzVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            nzVar.a(iArr[length]);
        }
        return nzVar.a();
    }

    private static int a(nz nzVar) {
        return nzVar.b();
    }
}
