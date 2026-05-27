package defpackage;

import android.graphics.RectF;
import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes8.dex */
public class vnu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18682a;
    private int b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private float[] g;
    private float h;
    private float i;
    private float j;
    private float k;
    private int l;
    private int m;
    private float n;
    private float o;
    private float[][] p;
    private boolean q;
    private float[][] u;
    private float[][] v;
    private float[][] w;
    private ConcurrentHashMap<Integer, Float> x;
    private int s = -1;
    private RectF t = new RectF();
    private RectF r = new RectF();

    public int a() {
        return this.s;
    }

    public int aa() {
        return this.b;
    }

    public float ab() {
        return this.o;
    }

    public int ad() {
        return this.f18682a;
    }

    public ConcurrentHashMap<Integer, Float> b() {
        return this.x;
    }

    public void c(float[] fArr) {
        this.g = fArr;
    }

    public boolean c() {
        return this.c;
    }

    public int d() {
        return this.m;
    }

    public boolean e() {
        return this.q;
    }

    public void eAv_(RectF rectF) {
        if (rectF == null) {
            return;
        }
        if (this.t == null) {
            this.t = new RectF();
        }
        RectF rectF2 = this.t;
        rectF2.left = rectF.left;
        rectF2.top = rectF.top;
        rectF2.right = rectF.right;
        rectF2.bottom = rectF.bottom;
    }

    public RectF eAw_() {
        return this.r;
    }

    public RectF eAx_() {
        return this.t;
    }

    public vnu f() {
        vnu vnuVar = new vnu();
        vnuVar.q(aa());
        vnuVar.t(ad());
        vnuVar.c(h());
        vnuVar.d(i());
        vnuVar.e(m());
        vnuVar.o(ab());
        vnuVar.s(a());
        vnuVar.b(c());
        vnuVar.p(z());
        vnuVar.i(u());
        vnuVar.a(l());
        vnuVar.r(d());
        vnuVar.l(x());
        vnuVar.d(n());
        vnuVar.a(k());
        vnuVar.b(y());
        vnuVar.e(o());
        vnuVar.g(v());
        if (eAx_() != null && vnuVar.eAx_() != null) {
            RectF rectFEAx_ = vnuVar.eAx_();
            RectF rectFEAx_2 = eAx_();
            rectFEAx_.left = rectFEAx_2.left;
            rectFEAx_.top = rectFEAx_2.top;
            rectFEAx_.right = rectFEAx_2.right;
            rectFEAx_.bottom = rectFEAx_2.bottom;
        }
        if (eAw_() != null && vnuVar.eAw_() != null) {
            RectF rectFEAw_ = vnuVar.eAw_();
            RectF rectFEAw_2 = eAw_();
            rectFEAw_.left = rectFEAw_2.left;
            rectFEAw_.top = rectFEAw_2.top;
            rectFEAw_.right = rectFEAw_2.right;
            rectFEAw_.bottom = rectFEAw_2.bottom;
        }
        return vnuVar;
    }

    public void g(float f) {
        this.k = f;
    }

    public float[] h() {
        return this.g;
    }

    public float i() {
        return this.j;
    }

    public void i(float f) {
        this.n = f;
    }

    public void j(float f) {
        ac();
        if (this.c) {
            this.r.left = f;
        } else {
            this.r.right = f;
        }
    }

    public boolean j() {
        ConcurrentHashMap<Integer, Float> concurrentHashMap = this.x;
        return concurrentHashMap == null || concurrentHashMap.size() == 0;
    }

    public void k(int i) {
        this.d = i;
    }

    public float l() {
        return this.h;
    }

    public void l(float f) {
        ac();
        this.r.bottom = f;
    }

    public void l(int i) {
        this.l = i;
    }

    public float m() {
        return this.i;
    }

    public void o(float f) {
        this.o = f;
    }

    public void o(int i) {
        this.f = i;
    }

    public void p(int i) {
        if (i > 0) {
            this.e = i;
        }
    }

    public void q(int i) {
        this.b = i;
    }

    public void t(int i) {
        this.f18682a = i;
    }

    public int z() {
        return this.e;
    }

    public void a(float f) {
        this.h = f;
    }

    public void e(float f) {
        this.i = f;
    }

    public void eAu_(RectF rectF) {
        this.r = rectF;
    }

    public void f(float f) {
        ac();
        if (this.c) {
            this.r.right = f;
        } else {
            this.r.left = f;
        }
    }

    public void h(float f) {
        ac();
        this.r.top = f;
    }

    public float[][] k() {
        return this.w;
    }

    public void n(int i) {
        ConcurrentHashMap<Integer, Float> concurrentHashMap = this.x;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(Integer.valueOf(i));
        }
    }

    public float[][] o() {
        return this.u;
    }

    public float p() {
        RectF rectF = this.r;
        if (rectF != null) {
            return rectF.top;
        }
        return 0.0f;
    }

    public float q() {
        RectF rectF = this.r;
        if (rectF != null) {
            return this.c ? rectF.right : rectF.left;
        }
        return 0.0f;
    }

    public void r(int i) {
        this.m = i;
    }

    public float s() {
        RectF rectF = this.r;
        if (rectF != null) {
            return this.c ? rectF.left : rectF.right;
        }
        return 0.0f;
    }

    public void s(int i) {
        this.s = i;
    }

    public float u() {
        return this.n;
    }

    public float v() {
        return this.k;
    }

    public int x() {
        return this.l;
    }

    public float[][] y() {
        return this.v;
    }

    public void b(float f, float f2, float f3, float f4) {
        f(f);
        h(f2);
        j(f3);
        l(f4);
    }

    public void b(float[][] fArr) {
        this.v = fArr;
    }

    public float[] d(boolean z, int i) {
        float fD;
        float[] fArr = new float[this.e];
        for (int i2 = 0; i2 < this.e; i2++) {
            if (z) {
                fD = b(i2, i);
            } else {
                fD = d(i2, i);
            }
            fArr[i2] = fD;
        }
        return fArr;
    }

    public float f(int i) {
        int iU = u(i);
        if (e(this.u, iU)) {
            return 0.0f;
        }
        return this.u[iU][this.c ? 1 : 0];
    }

    public float[] i(int i) {
        float[] fArr = new float[this.e];
        for (int i2 = 0; i2 < this.e; i2++) {
            fArr[i2] = b(i2, i);
        }
        return fArr;
    }

    public float r() {
        RectF rectF = this.r;
        if (rectF != null) {
            return rectF.bottom;
        }
        return 0.0f;
    }

    public float d(int i) {
        int iU = u(i);
        if (e(this.v, iU)) {
            return 0.0f;
        }
        return this.v[iU][2];
    }

    public float h(int i) {
        int iU = u(i);
        if (e(this.u, iU)) {
            return 0.0f;
        }
        return this.u[iU][!this.c ? 1 : 0];
    }

    public float[] m(int i) {
        float[] fArr = new float[this.e];
        for (int i2 = 0; i2 < this.e; i2++) {
            fArr[i2] = d(i2, i);
        }
        return fArr;
    }

    private int u(int i) {
        return this.c ? (this.e - 1) - i : i;
    }

    public float[][] n() {
        return this.p;
    }

    public void d(float[][] fArr) {
        this.p = fArr;
    }

    public float e(int i) {
        int iU = u(i);
        if (e(this.v, iU)) {
            return 0.0f;
        }
        return this.v[iU][!this.c ? 1 : 0];
    }

    public float g(int i) {
        int iU = u(i);
        if (e(this.v, iU)) {
            return 0.0f;
        }
        return this.v[iU][this.c ? 1 : 0];
    }

    public float j(int i) {
        int iU = u(i);
        if (e(this.u, iU)) {
            return 0.0f;
        }
        return this.u[iU][2];
    }

    public boolean d(boolean z, int i, float[] fArr) {
        if (this.p != null && this.w != null && fArr != null && fArr.length == this.e) {
            for (int i2 = 0; i2 < this.e; i2++) {
                if (i != i2) {
                    if (Math.abs((z ? b(i2, i) : d(i2, i)) - fArr[i2]) > 1.0f) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void c(float f, float f2, float f3, float f4) {
        if (this.t == null) {
            this.t = new RectF();
        }
        RectF rectF = this.t;
        rectF.left = f;
        rectF.top = f2;
        rectF.right = f3;
        rectF.bottom = f4;
    }

    public float e(boolean z, int i) {
        return z ? g(i) : f(i);
    }

    public void c(int i, float f) {
        float[] fArr = this.g;
        if (fArr == null || i < 0 || i >= fArr.length) {
            return;
        }
        fArr[i] = f;
    }

    public void e(boolean z) {
        this.q = z;
    }

    public void a(float[][] fArr) {
        this.w = fArr;
    }

    public boolean a(boolean z, int i, float f, float f2) {
        float fE = e(z, i);
        float fA = a(z, i);
        float fAbs = Math.abs(fE - f);
        float fAbs2 = Math.abs(fA - f2);
        float fAbs3 = Math.abs(fA - fE) / 8.0f;
        return (Float.compare(fAbs, fAbs3) < 0) && (Float.compare(fAbs2, fAbs3) < 0);
    }

    public void g() {
        ConcurrentHashMap<Integer, Float> concurrentHashMap = this.x;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public void c(float f) {
        int i = this.e;
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, 3);
        this.w = fArr;
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, 3);
        this.u = fArr2;
        float[] fArr3 = fArr2[0];
        fArr3[0] = f;
        float f2 = this.k;
        fArr3[1] = f + f2;
        float f3 = (f2 / 2.0f) + f;
        fArr3[2] = f3;
        float[] fArr4 = fArr[0];
        fArr4[1] = (this.h / 2.0f) + f;
        fArr4[0] = f3;
        fArr4[2] = f3;
        int i2 = 1;
        while (true) {
            int i3 = this.e;
            if (i2 >= i3) {
                return;
            }
            float[][] fArr5 = this.u;
            float[] fArr6 = fArr5[i2];
            int i4 = i2 - 1;
            float[] fArr7 = fArr5[i4];
            float f4 = fArr7[0];
            float f5 = this.m;
            float f6 = this.h;
            fArr6[0] = f4 + f5 + f6;
            fArr6[1] = fArr7[1] + f5 + f6;
            fArr6[2] = fArr7[2] + f5 + f6;
            float[][] fArr8 = this.w;
            float[] fArr9 = fArr8[i2];
            fArr9[1] = fArr8[i4][1] + f5 + f6;
            float f7 = (r10 * i2) + f;
            float f8 = this.k;
            float f9 = (i2 * f6) + f7 + (f8 / 2.0f);
            fArr9[0] = f9;
            fArr9[2] = f7 + f8 + (f6 / 2.0f) + (i4 * f6);
            if (i2 == i3 - 1) {
                fArr9[1] = f9;
            }
            i2++;
        }
    }

    public void e(int i, float f) {
        if (this.x == null) {
            this.x = new ConcurrentHashMap<>();
        }
        this.x.put(Integer.valueOf(i), Float.valueOf(f));
    }

    public void b(float f) {
        int i = this.e;
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, 3);
        this.p = fArr;
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, 3);
        this.v = fArr2;
        float[] fArr3 = fArr2[0];
        fArr3[0] = f;
        float f2 = this.n;
        float f3 = f + f2;
        fArr3[1] = f3;
        fArr3[2] = (f3 + f) / 2.0f;
        float[] fArr4 = fArr[0];
        float f4 = this.i;
        fArr4[1] = f + f4;
        float f5 = (f2 / 2.0f) + f;
        fArr4[0] = f5;
        fArr4[2] = f5;
        float f6 = f4 * 2.0f;
        int i2 = 1;
        while (true) {
            int i3 = this.e;
            if (i2 >= i3) {
                return;
            }
            float[][] fArr5 = this.v;
            float[] fArr6 = fArr5[i2];
            int i4 = i2 - 1;
            float[] fArr7 = fArr5[i4];
            float f7 = fArr7[0];
            float f8 = this.l;
            fArr6[0] = f7 + f8 + f6;
            fArr6[1] = fArr7[1] + f8 + f6;
            fArr6[2] = fArr7[2] + f8 + f6;
            float[][] fArr8 = this.p;
            float[] fArr9 = fArr8[i2];
            fArr9[1] = fArr8[i4][1] + f8 + f6;
            float f9 = (r11 * i2) + f;
            float f10 = this.n;
            float f11 = (i2 * f6) + f9 + (f10 / 2.0f);
            fArr9[0] = f11;
            fArr9[2] = f9 + f10 + this.i + (i4 * f6);
            if (i2 == i3 - 1) {
                fArr9[1] = f11;
            }
            i2++;
        }
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void d(float f) {
        this.j = f;
    }

    public void e(float[][] fArr) {
        this.u = fArr;
    }

    public float a(int i) {
        int iU = u(i);
        if (e(this.w, iU)) {
            return 0.0f;
        }
        return this.w[iU][this.c ? (char) 2 : (char) 1];
    }

    public float a(boolean z, int i) {
        return z ? e(i) : h(i);
    }

    public float d(int i, int i2) {
        int iU = u(i);
        if (e(this.w, iU)) {
            return 0.0f;
        }
        if (i > i2) {
            return this.w[iU][this.c ? (char) 1 : (char) 2];
        }
        if (i < i2) {
            return this.w[iU][this.c ? (char) 2 : (char) 1];
        }
        return this.w[iU][0];
    }

    public float[] b(boolean z, int i) {
        return z ? i(i) : m(i);
    }

    public float b(int i) {
        int iU = u(i);
        if (e(this.w, iU)) {
            return 0.0f;
        }
        return this.w[iU][this.c ? (char) 1 : (char) 2];
    }

    public float b(int i, int i2) {
        int iU = u(i);
        if (e(this.p, iU)) {
            return 0.0f;
        }
        if (i > i2) {
            return this.p[iU][this.c ? (char) 1 : (char) 2];
        }
        if (i < i2) {
            return this.p[iU][this.c ? (char) 2 : (char) 1];
        }
        return this.p[iU][0];
    }

    public float c(boolean z, int i) {
        return z ? d(i) : j(i);
    }

    public float c(int i) {
        int iU = u(i);
        if (e(this.w, iU)) {
            return 0.0f;
        }
        return this.w[iU][0];
    }

    public float a(boolean z) {
        if (z) {
            return (this.n / 2.0f) - this.i;
        }
        return (this.k - this.h) / 2.0f;
    }

    private boolean e(float[][] fArr, int i) {
        return fArr == null || i < 0 || i >= fArr.length;
    }

    private void ac() {
        if (this.r == null) {
            this.r = new RectF();
        }
    }
}
