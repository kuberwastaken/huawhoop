package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcommonmodel.fitnessdatatype.HeartZoneConf;

/* JADX INFO: loaded from: classes.dex */
public class omm {
    private static final HeartZoneConf c = new HeartZoneConf();

    @SerializedName("walkRunThreshold")
    private int k = 110;

    @SerializedName("climbThreshold")
    private int g = 60;

    @SerializedName("heartRateThreshold")
    private int h = 65;

    @SerializedName("cycleSpeedThreshold")
    private int f = 80;

    @SerializedName("sampleThreshold")
    private int n = 3;

    @SerializedName("countLength")
    private int j = 5;

    @SerializedName("walkRunThreshold_v2")
    private int q = 105;

    @SerializedName("climbThreshold_v2")
    private int e = 60;

    @SerializedName("heartRateThreshold_v2")
    private int b = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("cycleSpeedThreshold_v2")
    private int f16455a = 88;

    @SerializedName("sampleThreshold_v2")
    private int l = 1;

    @SerializedName("countLength_v2")
    private int d = 1;

    @SerializedName("walkRunThresholdWithHeartRate_v2")
    private int o = 40;

    @SerializedName("heartRateThreshold_v3")
    private int i = 25;

    @SerializedName("walkRunSpeedThreshold_v2")
    private int m = 40;

    public int n() {
        return this.k;
    }

    public int a() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public int b() {
        return this.f;
    }

    public int j() {
        return this.n;
    }

    public int e() {
        return this.j;
    }

    public void e(int i) {
        this.g = i;
    }

    public void h(int i) {
        this.h = i;
    }

    public void b(int i) {
        this.f = i;
    }

    public void j(int i) {
        this.n = i;
    }

    public void d(int i) {
        this.j = i;
    }

    public int m() {
        return this.m;
    }

    public void o(int i) {
        this.m = i;
    }

    public void m(int i) {
        this.k = i;
    }

    public int a(HeartZoneConf heartZoneConf) {
        return (int) (((h() / 100.0f) * (heartZoneConf.getMaxThreshold() - heartZoneConf.getRestHeartRate())) + heartZoneConf.getRestHeartRate());
    }

    public int l() {
        return this.q;
    }

    public void l(int i) {
        this.q = i;
    }

    public int d() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int g() {
        return this.f16455a;
    }

    public void g(int i) {
        this.f16455a = i;
    }

    public int i() {
        return this.l;
    }

    public void i(int i) {
        this.l = i;
    }

    public int c() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int k() {
        return this.o;
    }

    public int h() {
        return this.i;
    }

    public void f(int i) {
        this.i = i;
    }

    public String toString() {
        return "SportIntensityConfig WalkRunThreshold = " + this.q + " ClimbThreshold = " + this.e + " CycleSpeedThreshold = " + this.f16455a + " WalkRunSpeedThreshold = " + this.m + " WalkRunThresholdWithHeartRate = " + this.o + " heartRateThreshold = " + this.i;
    }
}
