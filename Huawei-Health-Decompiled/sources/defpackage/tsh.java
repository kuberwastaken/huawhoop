package defpackage;

import android.util.Pair;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class tsh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("baseTime")
    private long f18134a;

    @SerializedName("eatingWindow")
    private long b;

    @SerializedName("periodTime")
    private long c;

    @SerializedName("repeat")
    private int d;

    @SerializedName("settingEndTime")
    private int e;

    @SerializedName("settingInfo")
    private String f;

    @SerializedName("version")
    private int g = 0;

    @SerializedName("validWeekDays")
    private String h;

    public tsh(long j, long j2, int i) {
        this.b = j2;
        this.c = j;
        this.d = i;
    }

    public long e() {
        return this.f18134a;
    }

    public void b(long j) {
        this.f18134a = j;
    }

    public long d() {
        return this.b;
    }

    public long b() {
        return this.c;
    }

    public int g() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public int j() {
        return this.g;
    }

    public int i() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public String f() {
        return this.h;
    }

    public void a(String str) {
        this.h = str;
    }

    public void d(long j) {
        this.b = j;
    }

    public void e(long j) {
        this.c = j;
    }

    public Pair<Integer, Integer> edL_() {
        int i = (int) (this.f18134a / 60);
        int i2 = i / 60;
        if (i2 >= 24) {
            i2 %= 24;
        }
        return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i % 60));
    }

    public Pair<Integer, Integer> edK_() {
        int i = (int) ((this.f18134a + this.b) / 60);
        int i2 = i / 60;
        if (i2 >= 24) {
            i2 %= 24;
        }
        return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i % 60));
    }

    public String toString() {
        return "FastingLiteSetting{mBaseTime=" + this.f18134a + ", mEatingWindow=" + this.b + ", mPeriodTime=" + this.c + ", mRepeat=" + this.d + ", mSettingEndTime=" + this.e + ", mValidWeekDays=" + this.h + "}";
    }
}
