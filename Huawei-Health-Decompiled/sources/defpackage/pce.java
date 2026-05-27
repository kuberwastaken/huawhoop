package defpackage;

import android.graphics.LinearGradient;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes7.dex */
public class pce {
    private LinearGradient aa;
    private LinearGradient b;
    private LinearGradient f;
    private LinearGradient j;
    private LinearGradient k;
    private LinearGradient p;
    private LinearGradient s;
    private PointF w;
    private Path x;
    private LinearGradient z;
    private float u = 437.0f;
    private float v = 501.0f;
    private int o = 868255472;
    private int g = 864320759;
    private int q = 872267365;
    private int n = 872255062;
    private int ad = 862505936;
    private int y = 860537305;
    private int e = 866117244;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16618a = 862374758;
    private int i = 1301911961;
    private int m = -4159760;
    private int l = -8094473;
    private int t = -147867;
    private int r = -160170;
    private int ac = -9909296;
    private int ab = -11877927;
    private int h = -6297988;
    private int d = -10040474;
    private PointF ae = new PointF(218.5f, -21.381f);
    private PointF c = new PointF(218.5f, 492.83408f);

    public pce() {
        Path path = new Path();
        this.x = path;
        path.moveTo(63.997f, 64.143f);
        this.x.cubicTo(149.327f, -21.381f, 287.673f, -21.381f, 373.003f, 64.143f);
        this.x.cubicTo(458.332f, 149.666f, 458.332f, 288.328f, 373.003f, 373.851f);
        this.x.cubicTo(287.673f, 459.375f, 234.885f, 485.212f, 228.763f, 489.662f);
        this.x.cubicTo(222.642f, 494.113f, 214.358f, 494.113f, 208.237f, 489.662f);
        this.x.cubicTo(202.115f, 485.212f, 149.327f, 459.375f, 63.997f, 373.851f);
        this.x.cubicTo(-21.332f, 288.328f, -21.332f, 149.666f, 63.997f, 64.143f);
        this.x.close();
        this.j = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.o, this.g, Shader.TileMode.CLAMP);
        this.p = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.q, this.n, Shader.TileMode.CLAMP);
        this.aa = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.ad, this.y, Shader.TileMode.CLAMP);
        this.b = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.e, this.f16618a, Shader.TileMode.CLAMP);
        this.k = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.m, this.l, Shader.TileMode.CLAMP);
        this.s = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.t, this.r, Shader.TileMode.CLAMP);
        this.z = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.ac, this.ab, Shader.TileMode.CLAMP);
        this.f = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.h, this.d, Shader.TileMode.CLAMP);
        this.w = new PointF(this.u / 2.0f, this.v);
    }

    public float g() {
        return this.u;
    }

    public float h() {
        return this.v;
    }

    public Path cFp_() {
        return this.x;
    }

    public PointF cFq_() {
        return this.w;
    }

    public LinearGradient cFm_() {
        return this.k;
    }

    public LinearGradient cFo_() {
        return this.s;
    }

    public LinearGradient cFs_() {
        return this.z;
    }

    public LinearGradient cFl_() {
        return this.j;
    }

    public LinearGradient cFn_() {
        return this.p;
    }

    public LinearGradient cFr_() {
        return this.aa;
    }

    public LinearGradient cFj_() {
        return this.b;
    }

    public LinearGradient cFk_() {
        return this.f;
    }

    public int n() {
        return this.i;
    }

    public void i(int i) {
        this.m = i;
        this.k = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, i, this.l, Shader.TileMode.CLAMP);
    }

    public void d(int i) {
        this.o = i;
        this.j = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, i, this.g, Shader.TileMode.CLAMP);
    }

    public void b(int i) {
        this.l = i;
        this.k = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.m, i, Shader.TileMode.CLAMP);
    }

    public void c(int i) {
        this.g = i;
        this.j = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.o, i, Shader.TileMode.CLAMP);
    }

    public void g(int i) {
        this.t = i;
        this.s = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, i, this.r, Shader.TileMode.CLAMP);
    }

    public void h(int i) {
        this.q = i;
        this.p = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, i, this.n, Shader.TileMode.CLAMP);
    }

    public void f(int i) {
        this.n = i;
        this.p = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.q, i, Shader.TileMode.CLAMP);
    }

    public void j(int i) {
        this.r = i;
        this.s = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.t, i, Shader.TileMode.CLAMP);
    }

    public void m(int i) {
        this.ac = i;
        this.z = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, i, this.ab, Shader.TileMode.CLAMP);
    }

    public void o(int i) {
        this.ad = i;
        this.aa = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, i, this.y, Shader.TileMode.CLAMP);
    }

    public void n(int i) {
        this.ab = i;
        this.z = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.ac, i, Shader.TileMode.CLAMP);
    }

    public void k(int i) {
        this.y = i;
        this.aa = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.ad, i, Shader.TileMode.CLAMP);
    }

    public void a(int i) {
        this.h = i;
        this.f = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, i, this.d, Shader.TileMode.CLAMP);
    }

    public void e(int i) {
        this.d = i;
        this.f = new LinearGradient(this.ae.x, this.ae.y, this.c.x, this.c.y, this.h, i, Shader.TileMode.CLAMP);
    }
}
