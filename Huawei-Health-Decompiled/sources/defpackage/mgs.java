package defpackage;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.google.gson.annotations.SerializedName;
import health.compact.a.CommonUtil;
import lib.android.paypal.com.magnessdk.g;

/* JADX INFO: loaded from: classes6.dex */
public class mgs {

    @SerializedName(CmcdConfiguration.KEY_STREAM_TYPE)
    private int aa;

    @SerializedName("ta")
    private int ac;

    @SerializedName("wdt")
    private long ag;

    @SerializedName("tr")
    private int ah;

    @SerializedName(g.t1)
    private int ai;

    @SerializedName("aat")
    private int b;

    @SerializedName("at")
    private int d;

    @SerializedName("cd")
    private int h;

    @SerializedName("hr")
    private int k;

    @SerializedName("hz")
    private int m;

    @SerializedName("dt")
    private long n;

    @SerializedName("cr")
    private int o;

    @SerializedName(CmcdConfiguration.KEY_OBJECT_TYPE)
    private int p;

    @SerializedName("mm")
    private long q;

    @SerializedName("pa")
    private float t;

    @SerializedName("rt")
    private long u;

    @SerializedName("pc")
    private int v;

    @SerializedName("ti")
    private long z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("al")
    private int f15626a = 0;

    @SerializedName("UUID")
    private String ae = "";

    @SerializedName("mActiveCalorie")
    private int c = 0;

    @SerializedName("mPower")
    private int w = 0;

    @SerializedName("mInclination")
    private int r = 0;

    @SerializedName("mCyclingCadence")
    private int l = 0;

    @SerializedName("mAnalogPower")
    private int g = 0;

    @SerializedName("mMaxSpeed")
    private int s = 0;

    @SerializedName("mAverageSpeed")
    private int i = 0;

    @SerializedName("mRealAvgPower")
    private int y = 0;

    @SerializedName("mRealAvgAnalogPower")
    private int x = 0;

    @SerializedName("mAnalogCadence")
    private int e = 0;

    @SerializedName("mAvgCadence")
    private int f = 0;

    @SerializedName("mAvgAnalogCadence")
    private int j = 0;

    @SerializedName("mThreeSecPower")
    private int ab = 0;

    @SerializedName("mThreeSecAnalogPower")
    private int ad = 0;

    public void o(int i) {
        this.l = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void q(int i) {
        this.w = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void z(int i) {
        this.r = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void a(long j) {
        this.ag = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int h() {
        return ((Integer) kqt.e(Integer.valueOf(this.k))).intValue();
    }

    public void n(int i) {
        this.k = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void k(int i) {
        this.m = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int m() {
        return ((Integer) kqt.e(Integer.valueOf(this.aa))).intValue();
    }

    public void x(int i) {
        this.aa = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int d() {
        return ((Integer) kqt.e(Integer.valueOf(this.h))).intValue();
    }

    public void h(int i) {
        this.h = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void a(float f) {
        this.t = ((Float) kqt.e(Float.valueOf(f))).floatValue();
    }

    public void e(long j) {
        this.n = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public int g() {
        return ((Integer) kqt.e(Integer.valueOf(this.o))).intValue();
    }

    public void m(int i) {
        this.o = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int k() {
        return ((Integer) kqt.e(Integer.valueOf(this.ah))).intValue();
    }

    public void ad(int i) {
        this.ah = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int l() {
        return ((Integer) kqt.e(Integer.valueOf(this.ai))).intValue();
    }

    public void u(int i) {
        this.ai = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int o() {
        return ((Integer) kqt.e(Integer.valueOf(this.ac))).intValue();
    }

    public void v(int i) {
        this.ac = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int c() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue();
    }

    public void e(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int b() {
        return ((Integer) kqt.e(Integer.valueOf(this.b))).intValue();
    }

    public void d(int i) {
        this.b = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int j() {
        return ((Integer) kqt.e(Integer.valueOf(this.v))).intValue();
    }

    public void s(int i) {
        this.v = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public long n() {
        return ((Long) kqt.e(Long.valueOf(this.z))).longValue();
    }

    public void d(long j) {
        this.z = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public void r(int i) {
        this.p = i;
    }

    public long f() {
        return this.u;
    }

    public void c(long j) {
        this.u = j;
    }

    public long i() {
        return this.q;
    }

    public void b(long j) {
        this.q = j;
    }

    public int e() {
        return this.f15626a;
    }

    public void c(int i) {
        this.f15626a = i;
    }

    public String s() {
        return this.ae;
    }

    public void d(String str) {
        this.ae = str;
    }

    public int a() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public void j(int i) {
        this.g = i;
    }

    public void p(int i) {
        this.x = i;
    }

    public void f(int i) {
        this.i = i;
    }

    public void l(int i) {
        this.s = i;
    }

    public void t(int i) {
        this.y = i;
    }

    public void a(int i) {
        this.e = i;
    }

    public void i(int i) {
        this.f = i;
    }

    public void g(int i) {
        this.j = i;
    }

    public void y(int i) {
        this.ab = i;
    }

    public void w(int i) {
        this.ad = i;
    }

    public String t() {
        return "WorkoutReportPlayData{wdt=" + this.ag + ", hr=" + this.k + ", hz=" + this.m + ", st=" + this.aa + ", cd=" + this.h + ", pa=" + this.t + ", dt=" + this.n + ", cr=" + this.o + ", tr=" + this.ah + ", td=" + this.ai + ", ta=" + this.ac + ", at=" + this.d + ", aat=" + this.b + ", pc=" + this.v + ", ti=" + this.z + ", ot=" + this.p + ", rt=" + this.u + ", mm=" + this.q + ", al=" + this.f15626a + ", cal=" + this.c + ", mAnalogPower=" + this.g + ", mAnalogCadence=" + this.e + ", mAvgCadence=" + this.f + ", mAvgAnalogCadence=" + this.j + ", mThreeSecPower=" + this.ab + ", mThreeSecAnalogPower=" + this.ad + ", UUID='" + CommonUtil.l(this.ae) + '}';
    }
}
