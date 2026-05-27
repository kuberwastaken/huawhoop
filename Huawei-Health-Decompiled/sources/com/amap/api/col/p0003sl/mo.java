package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
public final class mo extends oa {
    public static int a(nz nzVar, int i, int i2, int i3) {
        nzVar.b(3);
        c(nzVar, i3);
        b(nzVar, i2);
        a(nzVar, i);
        return a(nzVar);
    }

    private static void a(nz nzVar, int i) {
        nzVar.b(0, i);
    }

    public static int a(nz nzVar, byte[] bArr) {
        nzVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            nzVar.a(bArr[length]);
        }
        return nzVar.a();
    }

    private static void b(nz nzVar, int i) {
        nzVar.b(1, i);
    }

    public static int b(nz nzVar, byte[] bArr) {
        nzVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            nzVar.a(bArr[length]);
        }
        return nzVar.a();
    }

    private static void c(nz nzVar, int i) {
        nzVar.b(2, i);
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
