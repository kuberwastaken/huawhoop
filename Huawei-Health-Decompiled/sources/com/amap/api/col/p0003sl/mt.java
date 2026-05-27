package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
public final class mt extends oa {
    public static int a(nz nzVar, byte b, int i) {
        nzVar.b(2);
        a(nzVar, i);
        a(nzVar, b);
        return a(nzVar);
    }

    private static void a(nz nzVar, byte b) {
        nzVar.a(0, b);
    }

    private static void a(nz nzVar, int i) {
        nzVar.b(1, i);
    }

    public static int a(nz nzVar, byte[] bArr) {
        nzVar.a(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            nzVar.a(bArr[length]);
        }
        return nzVar.a();
    }

    private static int a(nz nzVar) {
        return nzVar.b();
    }
}
