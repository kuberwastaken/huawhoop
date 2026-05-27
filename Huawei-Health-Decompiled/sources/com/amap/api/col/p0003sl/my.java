package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
public final class my extends oa {
    public static int a(nz nzVar, int i, int i2, short s) {
        nzVar.b(4);
        b(nzVar, i2);
        a(nzVar, i);
        a(nzVar, s);
        a(nzVar);
        return b(nzVar);
    }

    private static void a(nz nzVar) {
        nzVar.a(0, (byte) 1);
    }

    private static void a(nz nzVar, int i) {
        nzVar.a(1, i);
    }

    private static void b(nz nzVar, int i) {
        nzVar.a(2, i);
    }

    private static void a(nz nzVar, short s) {
        nzVar.a(3, s);
    }

    private static int b(nz nzVar) {
        return nzVar.b();
    }
}
