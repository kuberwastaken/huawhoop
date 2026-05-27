package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ggu implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("daily_factor_desc_input")
    private List<ggd> f13450a;

    @SerializedName("daily_advice")
    private List<ggb> b;

    @SerializedName("daily_factor_physio")
    private String d;

    @SerializedName("daily_factor")
    private List<Integer> e;

    @SerializedName("daily_major_reason")
    private int g;

    @SerializedName("daily_problem")
    private int h;

    @SerializedName("daily_problem_desc_input")
    private List<gga> i;

    @SerializedName("daily_problem_physio")
    private String k;

    @SerializedName("daily_problem_level")
    private int m;

    @SerializedName("daily_quality")
    private int n;

    @SerializedName("daily_task")
    private List<ggi> o;

    @SerializedName("generateTime")
    private long q;

    @SerializedName("result_code")
    private int r;

    @SerializedName("update")
    private boolean s;

    @SerializedName("daily_quality_desc")
    private String l = "";

    @SerializedName("daily_problem_desc")
    private String f = "";

    @SerializedName("daily_factor_desc")
    private String c = "";

    @SerializedName("daily_problem_impact")
    private String j = "";

    public int o() {
        return this.r;
    }

    public void e(String str) {
        this.l = str;
    }

    public String n() {
        return this.l;
    }

    public void a(int i) {
        this.h = i;
    }

    public int j() {
        return this.h;
    }

    public void c(int i) {
        this.m = i;
    }

    public int g() {
        return this.m;
    }

    public void c(String str) {
        this.f = str;
    }

    public String i() {
        return this.f;
    }

    public void b(List<gga> list) {
        this.i = list;
    }

    public List<gga> h() {
        return this.i;
    }

    public void b(String str) {
        this.j = str;
    }

    public String f() {
        return this.j;
    }

    public void c(List<Integer> list) {
        this.e = list;
    }

    public List<Integer> b() {
        return this.e;
    }

    public List<ggd> c() {
        return this.f13450a;
    }

    public void a(List<ggd> list) {
        this.f13450a = list;
    }

    public String e() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public void d(List<ggb> list) {
        this.b = list;
    }

    public List<ggb> d() {
        return this.b;
    }

    public void e(List<ggi> list) {
        this.o = list;
    }

    public List<ggi> m() {
        return this.o;
    }

    public boolean s() {
        return this.s;
    }

    public void a(boolean z) {
        this.s = z;
    }

    public long l() {
        return this.q;
    }

    public void d(long j) {
        this.q = j;
    }

    public String k() {
        return this.k;
    }

    public String a() {
        return this.d;
    }

    public String toString() {
        return "SleepDailyResultBean{resultCode=" + this.r + ", dailyQuality=" + this.n + ", dailyQualityDesc='" + this.l + "', dailyProblem=" + this.h + ", dailyProblemLevel=" + this.m + ", dailyProblemDesc='" + this.f + "', dailyFactorDesc='" + this.c + "', dailyProblemDescInput=" + this.i + ", dailyProblemImpact='" + this.j + "', dailyFactor=" + this.e + ", dailyFactorDescInput=" + this.f13450a + ", dailyMajorReason=" + this.g + ", dailyAdvice=" + this.b + ", dailyTask=" + this.o + ", isUpdated=" + this.s + ", generateTime=" + this.q + ", dailyProblemPhysio='" + this.k + "', dailyFactorPhysio='" + this.d + "'}";
    }
}
