package defpackage;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class fde {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f12907a;
    private int aa;
    private float ab;
    private int ac;
    private int ad;
    private Map<Long, Integer> ae;
    private Map<Long, Integer> af;
    private int ag;
    private Map<Long, Integer> ah;
    private int ai;
    private float b;
    private int c;
    private long d;
    private int e;
    private float f;
    private int g;
    private boolean h = false;
    private int i;
    private long j;
    private int k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private long[] p;
    private int q;
    private int r;
    private int s;
    private int t;
    private float u;
    private long v;
    private int w;
    private int x;
    private int y;
    private int z;

    public int ab() {
        return this.aa;
    }

    public void p(int i) {
        this.aa = i;
    }

    public boolean ah() {
        return this.h;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public int d() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public int y() {
        return this.x;
    }

    public void k(int i) {
        this.x = i;
    }

    public float v() {
        return this.u;
    }

    public void c(float f) {
        this.u = f;
    }

    public int w() {
        return this.w;
    }

    public float x() {
        return this.ab;
    }

    public void b(float f) {
        this.ab = f;
    }

    public void m(int i) {
        this.w = i;
    }

    public int u() {
        return this.y;
    }

    public void l(int i) {
        this.y = i;
    }

    public Map<Long, Integer> ag() {
        return this.ae;
    }

    public void b(Map<Long, Integer> map) {
        this.ae = map;
    }

    public Map<Long, Integer> z() {
        return this.ah;
    }

    public void a(Map<Long, Integer> map) {
        this.ah = map;
    }

    public int ac() {
        return this.ac;
    }

    public void t(int i) {
        this.ac = i;
    }

    public int i() {
        return this.i;
    }

    public void e(int i) {
        this.i = i;
    }

    public int f() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
    }

    public int b() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public int s() {
        return this.t;
    }

    public void n(int i) {
        this.t = i;
    }

    public int t() {
        return this.r;
    }

    public void o(int i) {
        this.r = i;
    }

    public float h() {
        return this.f;
    }

    public void e(float f) {
        this.f = f;
    }

    public int c() {
        return Math.round(this.b);
    }

    public float e() {
        return this.b;
    }

    public void d(float f) {
        this.b = f;
    }

    public float j() {
        return this.f12907a;
    }

    public void a(float f) {
        this.f12907a = f;
    }

    public long r() {
        return this.v;
    }

    public void d(long j) {
        this.v = j;
    }

    public void a(long j) {
        this.j = j;
    }

    public long g() {
        long j = this.d;
        return j == 0 ? System.currentTimeMillis() : j;
    }

    public void e(long j) {
        this.d = j;
    }

    public void d(long[] jArr) {
        this.p = jArr == null ? new long[0] : (long[]) jArr.clone();
    }

    public int aa() {
        return this.ai;
    }

    public void s(int i) {
        this.ai = i;
    }

    public int n() {
        return this.k;
    }

    public void f(int i) {
        this.k = i;
    }

    public int ad() {
        return this.z;
    }

    public void q(int i) {
        this.z = i;
    }

    public int l() {
        return this.n;
    }

    public void j(int i) {
        this.n = i;
    }

    public int ai() {
        return this.ag;
    }

    public void v(int i) {
        this.ag = i;
    }

    public int p() {
        return this.q;
    }

    public void h(int i) {
        this.q = i;
    }

    public void e(boolean z) {
        this.l = z;
    }

    public boolean o() {
        return this.l;
    }

    public Map<Long, Integer> ae() {
        return this.af;
    }

    public void e(Map<Long, Integer> map) {
        this.af = map;
    }

    public int m() {
        return this.m;
    }

    public void a(int i) {
        this.m = i;
    }

    public void r(int i) {
        this.ad = i;
    }

    public int k() {
        return this.o;
    }

    public void g(int i) {
        this.o = i;
    }

    public int q() {
        return this.s;
    }

    public void i(int i) {
        this.s = i;
    }

    public String toString() {
        return "ActiveRecordData{mDayStep=" + this.aa + ", mStepValue=" + this.w + ", mStepGoal=" + this.y + ", mDayIntensity=" + this.ac + ", mIntensityValue=" + this.i + ", mIntensityGoal=" + this.g + ", mStandValue=" + this.t + ", mStandGoal=" + this.r + ", mDistance=" + this.f + ", mCalorie=" + this.b + ", mClimbs=" + this.f12907a + ", mDayTime=" + this.d + ", mStartTime=" + this.v + ", mEndTime=" + this.j + ", mStartEndOfWeek=" + Arrays.toString(this.p) + ", mWeekAverageStep=" + this.ai + ", mLastWeekAverageStep=" + this.k + ", mWeekAverageIntensity=" + this.z + ", mLastWeekAverageIntensity=" + this.n + ", mYesterdayStand=" + this.ag + ", mLastYesterdayStand=" + this.q + ", mIsSupportFloor=" + this.l + ", mPushesVal=" + this.s + '}';
    }

    public String a() {
        return "ActiveRecordData{a=" + this.aa + ", b=" + this.w + ", c=" + this.y + ", d=" + this.ac + ", e=" + this.i + ", f=" + this.g + ", g=" + this.t + ", h=" + this.r + ", i=" + this.f + ", j=" + this.b + ", k=" + this.f12907a + ", l=" + this.d + ", m=" + this.v + ", n=" + this.j + ", o=" + Arrays.toString(this.p) + ", p=" + this.ai + ", q=" + this.k + ", r=" + this.z + ", s=" + this.n + ", t=" + this.ag + ", u=" + this.q + ", v=" + this.l + ", pv=" + this.s + '}';
    }
}
