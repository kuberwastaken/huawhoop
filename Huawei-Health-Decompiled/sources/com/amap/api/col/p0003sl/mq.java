package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
public final class mq extends oa {
    public static int a(nz nzVar, int i, byte b, int i2, int i3) {
        nzVar.b(4);
        c(nzVar, i3);
        b(nzVar, i2);
        a(nzVar, i);
        a(nzVar, b);
        return a(nzVar);
    }

    private static void a(nz nzVar, int i) {
        nzVar.b(0, i);
    }

    private static void a(nz nzVar, byte b) {
        nzVar.a(1, b);
    }

    private static void b(nz nzVar, int i) {
        nzVar.b(2, i);
    }

    public static int a(nz nzVar, int[] iArr) {
        nzVar.a(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            nzVar.a(iArr[length]);
        }
        return nzVar.a();
    }

    private static void c(nz nzVar, int i) {
        nzVar.b(3, i);
    }

    public static int b(nz nzVar, int[] iArr) {
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
