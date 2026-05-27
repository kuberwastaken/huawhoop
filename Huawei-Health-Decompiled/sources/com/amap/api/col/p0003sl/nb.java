package com.amap.api.col.p0003sl;

/* JADX INFO: loaded from: classes3.dex */
public final class nb extends oa {
    public static int a(nz nzVar, boolean z, long j, short s, int i, short s2, short s3) {
        nzVar.b(6);
        a(nzVar, j);
        a(nzVar, i);
        c(nzVar, s3);
        b(nzVar, s2);
        a(nzVar, s);
        a(nzVar, z);
        return a(nzVar);
    }

    private static void a(nz nzVar, boolean z) {
        nzVar.a(z);
    }

    private static void a(nz nzVar, long j) {
        nzVar.a(1, j);
    }

    private static void a(nz nzVar, short s) {
        nzVar.a(2, s);
    }

    private static void a(nz nzVar, int i) {
        nzVar.b(3, i);
    }

    private static void b(nz nzVar, short s) {
        nzVar.a(4, s);
    }

    private static void c(nz nzVar, short s) {
        nzVar.a(5, s);
    }

    private static int a(nz nzVar) {
        return nzVar.b();
    }
}
