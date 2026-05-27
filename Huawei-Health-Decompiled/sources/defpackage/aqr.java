package defpackage;

import android.util.Log;
import com.huawei.algorithm.bodycomposition.HWAlgorithm;

/* JADX INFO: loaded from: classes3.dex */
public class aqr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f270a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private int o;
    private int p;
    private int q;
    private float r;
    private int s;
    private int t;
    private float u;
    private float v;
    private float x;

    public aqr() {
    }

    public aqr(float f, float f2, int i, int i2, int i3, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        this.d = f;
        this.f270a = f2;
        this.o = i2;
        this.p = i;
        this.s = i3;
        this.q = 8;
        this.t = 1;
        this.g = f3;
        this.c = f4;
        this.h = f5;
        this.n = f6;
        this.l = f7;
        this.b = f8;
        this.f = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.m = 0.0f;
        this.e = 0.0f;
        this.r = f9;
        if (i2 >= 6 && i2 <= 17) {
            this.p = i + 3;
            this.o = (i2 * 10) + ((int) (((((double) i3) / 12.0d) + 0.05d) * 10.0d));
        }
        if (f9 == 0.0f) {
            this.u = 0.0f;
            this.x = 0.0f;
            this.v = 0.0f;
        }
    }

    public aqr(float f, float f2, int i, int i2, int i3, int i4, int i5, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15) {
        this.d = f;
        this.f270a = f2;
        this.o = i2;
        this.p = i;
        this.s = i3;
        this.q = i4;
        this.t = i5;
        this.g = f3;
        this.c = f4;
        this.h = f5;
        this.n = f6;
        this.l = f7;
        this.b = f8;
        this.f = f9;
        this.i = f10;
        this.j = f11;
        this.k = f12;
        this.m = f13;
        this.e = f14;
        this.r = f15;
        if (i2 >= 6 && i2 <= 17) {
            this.p = i + 3;
            this.o = (i2 * 10) + ((int) (((((double) i3) / 12.0d) + 0.05d) * 10.0d));
        }
        if (f15 == 0.0f) {
            this.u = 0.0f;
            this.x = 0.0f;
            this.v = 0.0f;
        }
    }

    public aqr(float f, float f2, int i, int i2, int i3, float f3, float f4) {
        this.d = f;
        this.f270a = f2;
        this.o = i2;
        this.p = i;
        this.s = i3;
        this.q = 4;
        this.t = 1;
        this.g = 0.0f;
        this.c = 0.0f;
        this.h = 0.0f;
        this.n = 0.0f;
        this.l = 0.0f;
        this.b = f3;
        this.f = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.m = 0.0f;
        this.e = 0.0f;
        this.r = f4;
        if (i2 >= 6 && i2 <= 17) {
            this.p = i + 3;
            this.o = (i2 * 10) + ((int) (((((double) i3) / 12.0d) + 0.05d) * 10.0d));
        }
        if (f4 == 0.0f) {
            this.u = 0.0f;
            this.x = 0.0f;
            this.v = 0.0f;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00a3, code lost:
    
        if (r6 <= 1500.0f) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int e() {
        /*
            Method dump skipped, instruction units count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.aqr.e():int");
    }

    public float aj() {
        return new HWAlgorithm().getTW(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float ap() {
        return new HWAlgorithm().getTWR(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float w() {
        return new HWAlgorithm().getMW(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float k() {
        return new HWAlgorithm().getIS(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float v() {
        return new HWAlgorithm().getOR(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float j() {
        return new HWAlgorithm().getFAP(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float c() {
        return new HWAlgorithm().getBMI(this.d, this.f270a);
    }

    public float ac() {
        return new HWAlgorithm().getRFMM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float s() {
        return new HWAlgorithm().getLFMM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float ah() {
        return new HWAlgorithm().getRHMM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float r() {
        return new HWAlgorithm().getLHMM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float am() {
        return new HWAlgorithm().getTMM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float ad() {
        return new HWAlgorithm().getRFFM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float q() {
        return new HWAlgorithm().getLFFM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float ag() {
        return new HWAlgorithm().getRHFM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float t() {
        return new HWAlgorithm().getLHFM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float ak() {
        return new HWAlgorithm().getTFM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float ab() {
        return new HWAlgorithm().getRFFAP(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float o() {
        return new HWAlgorithm().getLFFAP(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float aa() {
        return new HWAlgorithm().getRHFAP(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float p() {
        return new HWAlgorithm().getLHFAP(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float al() {
        return new HWAlgorithm().getTFAP(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float i() {
        return new HWAlgorithm().getCAL(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float ar() {
        return new HWAlgorithm().getWHR(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float ae() {
        return new HWAlgorithm().getSMM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float z() {
        return new HWAlgorithm().getRASM(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public int ao() {
        return new HWAlgorithm().getVFL(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public int ai() {
        return new HWAlgorithm().getSCORE(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public int a() {
        return new HWAlgorithm().getBODYAGE(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public int g() {
        return new HWAlgorithm().getBODYTYPE(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public int b() {
        return new HWAlgorithm().getBODYSHAPE(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public int y() {
        return new HWAlgorithm().getMB(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public int n() {
        return new HWAlgorithm().getFB(this.d, this.f270a, this.p, this.o, this.q, this.t, this.g, this.c, this.h, this.n, this.l, this.b, this.f, this.i, this.j, this.k, this.m, this.e, this.u, this.x, this.v);
    }

    public float u() {
        return new HWAlgorithm().getMWHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    public float as() {
        return new HWAlgorithm().getTWRHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    public float l() {
        return new HWAlgorithm().getISHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    public float x() {
        return new HWAlgorithm().getORHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    public float m() {
        return new HWAlgorithm().getFAPHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    public float h() {
        return new HWAlgorithm().getCALHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    public int aq() {
        return new HWAlgorithm().getVFLHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    public int af() {
        return new HWAlgorithm().getSCOREHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    public int d() {
        return new HWAlgorithm().getBODYAGEHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    public float an() {
        return new HWAlgorithm().getSMMHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    public int f() {
        return new HWAlgorithm().getBODYTYPEHalf(this.d, this.f270a, this.p, this.o, this.b, this.u, this.x, this.v);
    }

    static {
        System.loadLibrary("bodycomposition");
        Log.d("HWAlorithmUtil", "load lib success");
    }
}
