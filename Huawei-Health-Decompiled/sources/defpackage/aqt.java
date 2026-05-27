package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class aqt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enabled")
    private boolean f271a;

    @SerializedName("daysOfWeek")
    private int b;

    @SerializedName("alarmId")
    private int c;

    @SerializedName("hour")
    private int d;

    @SerializedName("label")
    private String e;

    @SerializedName("ringTone")
    private String f;

    @SerializedName("retryTimes")
    private int g;

    @SerializedName("minute")
    private int h;

    @SerializedName("toneDuration")
    private int i;

    @SerializedName("name")
    private String j;

    @SerializedName("vibrate")
    private int m;

    @SerializedName("toneInterval")
    private int n;

    public aqt() {
        this.f271a = true;
        this.d = 7;
        this.m = 1;
        this.i = 5;
        this.n = 10;
        this.g = 3;
    }

    public aqt(int i, int i2, int i3, String str) {
        this.f271a = true;
        this.m = 1;
        this.i = 5;
        this.n = 10;
        this.g = 3;
        this.c = i;
        this.d = i2;
        this.h = i3;
        this.f = str;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return (obj instanceof aqt) && e() == ((aqt) obj).e();
    }

    public int hashCode() {
        return e();
    }

    public boolean g() {
        return this.f271a;
    }

    public void a(boolean z) {
        this.f271a = z;
    }

    public int c() {
        return this.h;
    }

    public int b() {
        return this.d;
    }

    public int a() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public int j() {
        return this.m;
    }

    public int h() {
        return this.n;
    }

    public int d() {
        return this.g;
    }

    public int e() {
        return this.c;
    }

    public void e(int i) {
        this.h = i;
    }

    public void d(int i) {
        this.d = i;
    }
}
