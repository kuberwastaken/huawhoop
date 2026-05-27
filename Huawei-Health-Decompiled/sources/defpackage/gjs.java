package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class gjs {

    @SerializedName("mCadence")
    private int e = -1;

    @SerializedName("mStepLength")
    private int k = -1;

    @SerializedName("mGroundContactTime")
    private int f = -1;

    @SerializedName("mGroundImpactAcceleration")
    private int j = -1;

    @SerializedName("mForeFootStrikePattern")
    private int d = -1;

    @SerializedName("mWholeFootStrikePattern")
    private int q = -1;

    @SerializedName("mHindPawStrikePattern")
    private int i = -1;

    @SerializedName("mStep")
    private int m = -1;

    @SerializedName("mSwingAngle")
    private int r = -1;

    @SerializedName("mEversionExcursion")
    private int c = -101;

    @SerializedName("mHangTime")
    private int g = -1;

    @SerializedName("mImpactHangRate")
    private int o = -1;

    @SerializedName("mTimeInfo")
    private long s = -1;

    @SerializedName("mRideCadence")
    private int n = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mAverageVerticalImpactRate")
    private float f13498a = -1.0f;

    @SerializedName("mImpactPeak")
    private float l = -1.0f;

    @SerializedName("mVerticalOscillation")
    private float t = -1.0f;

    @SerializedName("mGcTimeBalance")
    private float h = -1.0f;

    @SerializedName("mVerticalRatio")
    private float p = -1.0f;

    @SerializedName("mExtraDataMap")
    private LinkedHashMap<String, String> b = new LinkedHashMap<>();

    public int a() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int o() {
        return this.k;
    }

    public void h(int i) {
        this.k = i;
    }

    public int b() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    public int g() {
        return this.j;
    }

    public void b(int i) {
        this.j = i;
    }

    public int c() {
        return this.d;
    }

    public void e(int i) {
        this.d = i;
    }

    public int n() {
        return this.q;
    }

    public void l(int i) {
        this.q = i;
    }

    public int j() {
        return this.i;
    }

    public void i(int i) {
        this.i = i;
    }

    public int m() {
        return this.r;
    }

    public void n(int i) {
        this.r = i;
    }

    public int e() {
        return this.c;
    }

    public void a(int i) {
        this.c = i - 100;
    }

    public int h() {
        return this.g;
    }

    public void g(int i) {
        this.g = i;
    }

    public int i() {
        return this.o;
    }

    public void f(int i) {
        this.o = i;
    }

    public void c(long j) {
        this.s = j;
    }

    public int f() {
        return this.n;
    }

    public void j(int i) {
        this.n = i;
    }

    public LinkedHashMap<String, String> d() {
        return this.b;
    }

    public String toString() {
        return "RunPostureDataInfo {mCadence = " + this.e + "mStepLength = " + this.k + "mGroundContactTime = " + this.f + "mGroundImpactAcceleration = " + this.j + "mForeFootStrikePattern = " + this.d + "mWholeFootStrikePattern = " + this.q + "mHindPawStrikePattern = " + this.i + "mStep = " + this.m + "mSwingAngle = " + this.r + "mEversionExcursion = " + this.c + "mHangTime = " + this.g + "mImpactHangRate = " + this.o + "mTimeInfo = " + this.s + "mRideCadence = " + this.n + "mAverageVerticalImpactRate = " + this.f13498a + "mImpactPeak = " + this.l + "mVerticalOscillation = " + this.t + "mGcTimeBalance = " + this.h + "mVerticalRatio = " + this.p + "mExtraDataMap = " + this.b.toString() + "}";
    }
}
