package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class dhf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12248a;
    private int b;

    @SerializedName("mAnaerobic")
    private int c;
    private float d;

    @SerializedName("mAerobic")
    private int e;
    private int f;
    private int g;

    @SerializedName("mFatburn")
    private int h;
    private int i;
    private int j;
    private int k;
    private String l;

    @SerializedName("mLimit")
    private int m;
    private String n;
    private int o;
    private int p;
    private int q;
    private int r;

    @SerializedName("mWarmup")
    private int s;
    private String t;

    public void c(String str) {
        this.l = str;
    }

    public String n() {
        return this.n;
    }

    public void e(String str) {
        this.n = str;
    }

    public void k(int i) {
        this.q = i;
    }

    public int h() {
        return this.f;
    }

    public void h(int i) {
        this.f = i;
    }

    public int j() {
        return this.j;
    }

    public void i(int i) {
        this.j = i;
    }

    public int f() {
        return this.g;
    }

    public void a(int i) {
        this.g = i;
    }

    public int l() {
        return this.k;
    }

    public void n(int i) {
        this.k = i;
    }

    public int o() {
        return this.o;
    }

    public void l(int i) {
        this.o = i;
    }

    public float c() {
        return this.d;
    }

    public void b(float f) {
        this.d = f;
    }

    public int e() {
        return this.f12248a;
    }

    public void c(int i) {
        this.f12248a = i;
    }

    public void m(int i) {
        this.p = i;
    }

    public int i() {
        return this.i;
    }

    public void g(int i) {
        this.i = i;
    }

    public int q() {
        return this.r;
    }

    public void o(int i) {
        this.r = i;
    }

    public int a() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public int m() {
        return this.m;
    }

    public void j(int i) {
        this.m = i;
    }

    public int d() {
        return this.c;
    }

    public void e(int i) {
        this.c = i;
    }

    public int b() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public int g() {
        return this.h;
    }

    public void f(int i) {
        this.h = i;
    }

    public int t() {
        return this.s;
    }

    public void s(int i) {
        this.s = i;
    }

    public String k() {
        return this.t;
    }

    public void d(String str) {
        this.t = str;
    }

    public String toString() {
        return "PostureRecord{id='" + this.l + "', postureId='" + this.n + "', startTime=" + this.p + ", endTime=" + this.i + ", totalTime=" + this.r + ", userTime=" + this.q + ", goalType=" + this.f + ", goal=" + this.j + ", doneCount=" + this.g + ", minHeartRate=" + this.k + ", maxHeartRate=" + this.o + ", mLimit=" + this.m + ", mAnaerobic=" + this.c + ", mAerobic=" + this.e + ", mFatburn=" + this.h + ", mWarmup=" + this.s + ", carlorie=" + this.d + ", bestRecord=" + this.f12248a + ", deviceType=" + this.b + ", postureName=" + this.t + '}';
    }
}
