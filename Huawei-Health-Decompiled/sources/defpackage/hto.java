package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class hto {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("bodyMassIndex")
    private Float f13968a;

    @SerializedName("bloodPressureSource")
    private Integer b;

    @SerializedName("diastolicPressure")
    private Integer c;

    @SerializedName("bloodPressureGrade")
    private Integer d;

    @SerializedName("bloodPressureTimestamp")
    private Long e;

    @SerializedName("fatPercentage")
    private Float f;

    @SerializedName("fattyLiverGrade")
    private Float g;

    @SerializedName("fatPercentageTimestamp")
    private Long h;

    @SerializedName("fattyLiverTimestamp")
    private Long i;

    @SerializedName("fattyLiverRisk")
    private Integer j;

    @SerializedName("systolicPressure")
    private Integer k;

    @SerializedName("sleepApneaTimestamp")
    private Long l;

    @SerializedName("weight")
    private Float m;

    @SerializedName("height")
    private Integer n;

    @SerializedName("sleepApneaGrade")
    private Integer o;

    @SerializedName("weightTimestamp")
    private Long p;

    public Integer b() {
        Integer num = this.n;
        if (num == null) {
            return 0;
        }
        return num;
    }

    public void d(Integer num) {
        this.n = num;
    }

    public Float c() {
        Float f = this.m;
        return f == null ? Float.valueOf(0.0f) : f;
    }

    public void b(Float f) {
        this.m = f;
    }

    public void b(Long l) {
        this.p = l;
    }

    public void c(Float f) {
        this.f13968a = f;
    }

    public void h(Integer num) {
        this.k = num;
    }

    public void b(Integer num) {
        this.c = num;
    }

    public void e(Integer num) {
        this.d = num;
    }

    public void a(Integer num) {
        this.b = num;
    }

    public void a(Long l) {
        this.e = l;
    }

    public void a(Float f) {
        this.f = f;
    }

    public void d(Long l) {
        this.h = l;
    }

    public void c(Integer num) {
        this.j = num;
    }

    public void d(Float f) {
        this.g = f;
    }

    public void c(Long l) {
        this.i = l;
    }

    public void i(Integer num) {
        this.o = num;
    }

    public void e(Long l) {
        this.l = l;
    }

    public String toString() {
        return "HealthGlanceData{height=" + this.n + ", weight=" + this.m + ", weightTimestamp=" + this.p + ", bodyMassIndex=" + this.f13968a + ", systolicPressure=" + this.k + ", diastolicPressure=" + this.c + ", bloodPressureGrade=" + this.d + ", bloodPressureSource=" + this.b + ", bloodPressureTimestamp=" + this.e + ", fatPercentage=" + this.f + ", fatPercentageTimestamp=" + this.h + ", fattyLiverRisk=" + this.j + ", fattyLiverGrade=" + this.g + ", fattyLiverTimestamp=" + this.i + ", sleepApneaGrade=" + this.o + ", sleepApneaTimestamp=" + this.l + '}';
    }
}
