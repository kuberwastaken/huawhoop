package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hihealth.ResultUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: classes8.dex */
public class thc implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mBoneMineral")
    private double f17981a;

    @SerializedName("mBodyScore")
    private double b;

    @SerializedName("mBmr")
    private double c;

    @SerializedName("deviceUuid")
    private String d;

    @SerializedName("mBmi")
    private double e;

    @SerializedName("mFatLevel")
    private double f;

    @SerializedName("mDeviceType")
    private int g;

    @SerializedName("mDeviceId")
    private int h;

    @SerializedName("mMetaData")
    private String i;

    @SerializedName("mClientId")
    private int j;

    @SerializedName("mMuscles")
    private double k;

    @SerializedName("type")
    private int m;

    @SerializedName("mProtein")
    private double o;

    @SerializedName("mWaterRate")
    private double u;

    @SerializedName("mWater")
    private double v;

    @SerializedName("mTime")
    private long n = 0;

    @SerializedName("mTimeExtra")
    private long l = 0;

    @SerializedName("mValueFirst")
    private double t = 0.0d;

    @SerializedName("mValueSecond")
    private double p = 0.0d;

    @SerializedName("mValueThird")
    private double w = 0.0d;

    @SerializedName("mValueForth")
    private double s = 0.0d;

    @SerializedName("mValueFifth")
    private double q = 0.0d;

    @SerializedName("mValueSixth")
    private String r = "";

    public String toString() {
        return "HealthData-->[mTime =" + this.n + "; temeextra = " + this.l + "; mValue1 = " + this.t + "; mValue2 = " + this.p + "; mValue3 = " + this.w + "; mValue4 = " + this.s + "; mValue5 = " + this.q + "; type = " + this.m + "]";
    }

    public String f() {
        return this.d;
    }

    public void a(String str) {
        this.d = (String) ResultUtils.d(str);
    }

    public String i() {
        return this.i;
    }

    public void b(String str) {
        this.i = str;
    }

    public void c(long j) {
        this.n = j;
    }

    public long h() {
        return ((Long) too.c(Long.valueOf(this.n))).longValue();
    }

    public void b(long j) {
        this.l = j;
    }

    public long j() {
        return ((Long) too.c(Long.valueOf(this.l))).longValue();
    }

    public void c(double d) {
        this.t = d;
    }

    public double n() {
        return ((Double) too.c(Double.valueOf(this.t))).doubleValue();
    }

    public void b(double d) {
        this.p = d;
    }

    public double k() {
        return ((Double) too.c(Double.valueOf(this.p))).doubleValue();
    }

    public void e(double d) {
        this.w = d;
    }

    public double o() {
        return ((Double) too.c(Double.valueOf(this.w))).doubleValue();
    }

    public void d(double d) {
        this.s = d;
    }

    public double l() {
        return ((Double) too.c(Double.valueOf(this.s))).doubleValue();
    }

    public void a(double d) {
        this.q = d;
    }

    public double m() {
        return ((Double) too.c(Double.valueOf(this.q))).doubleValue();
    }

    public void l(double d) {
        this.v = d;
    }

    public void m(double d) {
        this.u = d;
    }

    public void h(double d) {
        this.f = d;
    }

    public void i(double d) {
        this.f17981a = d;
    }

    public void j(double d) {
        this.e = d;
    }

    public void f(double d) {
        this.c = d;
    }

    public void n(double d) {
        this.k = d;
    }

    public void k(double d) {
        this.o = d;
    }

    public void g(double d) {
        this.b = d;
    }

    public int b() {
        return this.h;
    }

    public void d(int i) {
        this.h = i;
    }

    public int e() {
        return this.g;
    }

    public void c(int i) {
        this.g = i;
    }

    public int a() {
        return this.j;
    }

    public void e(int i) {
        this.j = i;
    }

    public int g() {
        return this.m;
    }

    public void i(int i) {
        this.m = i;
    }
}
