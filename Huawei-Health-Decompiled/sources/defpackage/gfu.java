package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class gfu extends aqt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enableRecord")
    private boolean f13432a;

    @SerializedName("maxRecordHour")
    private int b;

    @SerializedName("isThreshold")
    private boolean c;

    @SerializedName("isSleepRemind")
    private boolean d;

    @SerializedName("isWakeupFeel")
    private boolean e;

    @SerializedName("sleepMinute")
    private int g;

    @SerializedName("thresholdSize")
    private int h;

    @SerializedName("sleepHour")
    private int i;

    private gfu() {
        this.i = 23;
        this.f13432a = true;
        this.b = 10;
        this.c = false;
        this.h = 100;
        this.d = true;
        this.e = true;
    }

    public gfu(int i, int i2, int i3, String str) {
        super(i, i2, i3, str);
        this.i = 23;
        this.f13432a = true;
        this.b = 10;
        this.c = false;
        this.h = 100;
        this.d = true;
        this.e = true;
    }

    public int l() {
        return this.g;
    }

    public void c(int i) {
        this.g = i;
    }

    public int f() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public boolean k() {
        return this.f13432a;
    }

    public void d(boolean z) {
        this.f13432a = z;
    }

    public int i() {
        return this.b;
    }

    public boolean m() {
        return this.c;
    }

    public int o() {
        return this.h;
    }

    public boolean n() {
        return this.d;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public boolean r() {
        return this.e;
    }
}
