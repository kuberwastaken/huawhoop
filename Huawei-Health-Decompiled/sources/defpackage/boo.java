package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class boo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("endHour")
    private int f429a;

    @SerializedName("hour")
    private int b;

    @SerializedName("alarmId")
    private int c;

    @SerializedName("enabled")
    private boolean d;

    @SerializedName("endMinute")
    private int e;

    @SerializedName("minute")
    private int f;

    public boo(int i, boolean z) {
        this.c = i;
        this.d = z;
    }

    public int b() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public int d() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    public int c() {
        return this.f429a;
    }

    public void e(int i) {
        this.f429a = i;
    }

    public int e() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public boolean a() {
        return this.d;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public String toString() {
        return "DrinkWaterReminderBean{mAlarmId=" + this.c + ", mHour=" + this.b + ", mMinute=" + this.f + ", mEndHour=" + this.f429a + ", mEndMinute=" + this.e + ", mIsEnabled=" + this.d + '}';
    }
}
