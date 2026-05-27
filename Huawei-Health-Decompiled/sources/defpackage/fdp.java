package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fdp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f12916a;
    private int b;
    private CharSequence c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private CharSequence j;
    private CharSequence l;
    private List<Integer> m;
    private CharSequence o;

    public fdp(long j, int i, CharSequence charSequence, int i2) {
        this.f12916a = j;
        this.f = i;
        this.o = charSequence;
        this.h = i2;
    }

    public long e() {
        return this.f12916a;
    }

    public int g() {
        return this.f;
    }

    public CharSequence k() {
        return this.o;
    }

    public int h() {
        return this.h;
    }

    public CharSequence j() {
        return this.j;
    }

    public void e(CharSequence charSequence) {
        this.j = charSequence;
    }

    public int f() {
        return this.i;
    }

    public void e(int i) {
        this.i = i;
    }

    public CharSequence c() {
        return this.c;
    }

    public void d(CharSequence charSequence) {
        this.c = charSequence;
    }

    public CharSequence m() {
        return this.l;
    }

    public void b(CharSequence charSequence) {
        this.l = charSequence;
    }

    public int i() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
    }

    public List<Integer> l() {
        return this.m;
    }

    public void a(List<Integer> list) {
        this.m = list;
    }

    public int a() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public int b() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int d() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public String toString() {
        return "SectionActiveWeekBean{mDayTimeMillis=" + this.f12916a + ", mIconResourceId=" + this.f + ", mTitle=" + ((Object) this.o) + ", mIconTipResourceId=" + this.h + ", mTipText=" + ((Object) this.j) + ", mEventType=" + this.i + ", mDayValue=" + ((Object) this.c) + ", mWeekValue=" + ((Object) this.l) + ", mGoalValue=" + this.g + ", mValueList=" + this.m + ", mBarChartColor=" + this.e + ", mBarChartHighlightColor=" + this.d + ", mBarChartTargetColor=" + this.b + '}';
    }
}
