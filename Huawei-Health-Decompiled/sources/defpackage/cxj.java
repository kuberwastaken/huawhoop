package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class cxj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("alarmId")
    private int f12071a;

    @SerializedName("hour")
    private int b;

    @SerializedName("daysOfWeek")
    private int c;

    @SerializedName("minute")
    private int d;

    @SerializedName("enabled")
    private boolean e;

    @SerializedName("planId")
    private int f;

    public int a() {
        return this.f12071a;
    }

    public void c(int i) {
        this.f12071a = i;
    }

    public int h() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public int c() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int e() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public int d() {
        return this.c;
    }

    public void e(int i) {
        this.c = i;
    }

    public boolean b() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public String toString() {
        return "BloodPressureAlarmInfoCloud{mAlarmId=" + this.f12071a + ", mPlanId=" + this.f + ", mHour=" + this.b + ", mMinute=" + this.d + ", mDaysOfWeek=" + this.c + ", mEnabled=" + this.e + "}";
    }
}
