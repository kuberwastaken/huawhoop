package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.jsoperation.JsUtil;
import com.huawei.ui.commonui.linechart.HwHealthChartHolder;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ggx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("acti_dur")
    private List<Integer> f13452a;

    @SerializedName("sleep_latency")
    private int aa;

    @SerializedName("sleep_avgrr")
    private int ab;

    @SerializedName("sleep_avgspo")
    private int ac;

    @SerializedName("sleep_osa")
    private int ad;

    @SerializedName("total_duration")
    private int ae;

    @SerializedName("steady_ratio")
    private Integer af;

    @SerializedName("wake_times")
    private int ag;

    @SerializedName("wake_duration")
    private int ah;

    @SerializedName("acti_ts")
    private List<Long> b;

    @SerializedName("awake_time")
    private long c;

    @SerializedName("avg_pressure")
    private int d;

    @SerializedName("asleep_time")
    private long e;

    @SerializedName("bed_duration")
    private int f;

    @SerializedName("deep_continuity")
    private int g;

    @SerializedName("data_src")
    private int h;

    @SerializedName("deep_duration")
    private int i;

    @SerializedName("cur_time")
    private long j;

    @SerializedName("light_duration")
    private int k;

    @SerializedName("hr_list")
    private List<Integer> l;

    @SerializedName("nap_dur")
    private List<Integer> m;

    @SerializedName("hr_ts")
    private List<Long> n;

    @SerializedName("max_hr")
    private int o;

    @SerializedName("nap_ts")
    private List<Long> p;

    @SerializedName("on_bed_time")
    private long q;

    @SerializedName("rdi")
    private int r;

    @SerializedName("noise")
    private int s;

    @SerializedName("off_bed_time")
    private long t;

    @SerializedName("sleep_avghrv")
    private int u;

    @SerializedName("rem_duration")
    private int v;

    @SerializedName(HwHealthChartHolder.LAYER_ID_REST_HR)
    private int w;

    @SerializedName(JsUtil.SCORE)
    private int x;

    @SerializedName("sleep_avghr")
    private int y;

    @SerializedName("sleep_efficiency")
    private int z;

    public void s(int i) {
        this.af = Integer.valueOf(i);
    }

    public void e(long j) {
        this.j = j;
    }

    public void l(int i) {
        this.x = i;
    }

    public void c(long j) {
        this.e = j;
    }

    public long a() {
        return this.e;
    }

    public void d(long j) {
        this.c = j;
    }

    public long b() {
        return this.c;
    }

    public void b(long j) {
        this.q = j;
    }

    public long e() {
        return this.q;
    }

    public void a(long j) {
        this.t = j;
    }

    public void e(int i) {
        this.i = i;
    }

    public void g(int i) {
        this.k = i;
    }

    public void j(int i) {
        this.v = i;
    }

    public void u(int i) {
        this.ae = i;
    }

    public int f() {
        return this.ae;
    }

    public void x(int i) {
        this.ag = i;
    }

    public void y(int i) {
        this.ah = i;
    }

    public void b(int i) {
        this.g = i;
    }

    public void f(int i) {
        this.r = i;
    }

    public void n(int i) {
        this.w = i;
    }

    public void i(int i) {
        this.o = i;
    }

    public void c(int i) {
        this.d = i;
    }

    public void h(int i) {
        this.s = i;
    }

    public void q(int i) {
        this.z = i;
    }

    public void r(int i) {
        this.aa = i;
    }

    public void h(List<Long> list) {
        this.p = list;
    }

    public void c(List<Integer> list) {
        this.m = list;
    }

    public void e(List<Long> list) {
        this.n = list;
    }

    public void b(List<Integer> list) {
        this.l = list;
    }

    public void a(List<Long> list) {
        this.b = list;
    }

    public void d(List<Integer> list) {
        this.f13452a = list;
    }

    public int c() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    public void a(int i) {
        this.h = i;
    }

    public int d() {
        return this.h;
    }

    public void t(int i) {
        this.ad = i;
    }

    public void k(int i) {
        this.y = i;
    }

    public void o(int i) {
        this.ab = i;
    }

    public void m(int i) {
        this.u = i;
    }

    public void p(int i) {
        this.ac = i;
    }

    public String toString() {
        return "SleepInfo{dataSrc=" + this.h + ", curTime=" + this.j + ", score=" + this.x + ", asleepTime=" + this.e + ", awakeTime=" + this.c + ", onBedTime=" + this.q + ", offBedTime=" + this.t + ", deepDuration=" + this.i + ", lightDuration=" + this.k + ", remDuration=" + this.v + ", totalDuration=" + this.ae + ", bedDuration=" + this.f + ", wakeTimes=" + this.ag + ", wakeDuration=" + this.ah + ", deepContinuity=" + this.g + ", rdi=" + this.r + ", restHr=" + this.w + ", maxHr=" + this.o + ", avgPressure=" + this.d + ", noise=" + this.s + ", sleepEfficiency=" + this.z + ", sleepLatency=" + this.aa + ", sleepOsa=" + this.ad + ", sleepAvghr=" + this.y + ", sleepAvghrv=" + this.u + ", sleepAvgrr=" + this.ab + ", sleepAvgspo=" + this.ac + ", napTs=" + this.p + ", napDur=" + this.m + ", hrTs=" + this.n + ", hrList=" + this.l + ", actiTs=" + this.b + ", actiDur=" + this.f13452a + '}';
    }
}
