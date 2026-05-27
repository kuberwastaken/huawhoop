package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes3.dex */
public class cax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f561a;
    private long b;
    private long c;
    private int d;
    private int e;
    private int f;

    @SerializedName("snoreFreq")
    private int g;
    private int h;
    private long i;
    private float j;
    private long o;

    public void e(long j) {
        this.i = j;
    }

    public long g() {
        return this.i;
    }

    public void a(long j) {
        this.b = j;
    }

    public long a() {
        return this.b;
    }

    public void c(long j) {
        this.o = j;
    }

    public long f() {
        return this.o;
    }

    public void d(int i) {
        this.h = i;
    }

    public int h() {
        return this.h;
    }

    public void c(int i) {
        this.f = i;
    }

    public int d() {
        return this.f;
    }

    public void b(long j) {
        this.c = j;
    }

    public long c() {
        return this.c;
    }

    public void e(float f) {
        this.j = f;
    }

    public float j() {
        return this.j;
    }

    public void b(int i) {
        this.d = i;
    }

    public int b() {
        return this.d;
    }

    public void a(int i) {
        this.f561a = i;
    }

    public int e() {
        return this.f561a;
    }

    public void e(int i) {
        this.g = i;
    }

    public int i() {
        return this.g;
    }

    public String toString() {
        return "SleepCalcFrame{startTime=" + this.i + "fallAsleepTime=" + this.b + "wakeUpTime=" + this.o + "sleepScore=" + this.h + "sleepLatency=" + this.f + "goBedTime=" + this.c + "validData=" + this.j + "sleepEfficiency=" + this.d + "deepSleepTime=" + this.e + "deepSleepPart=" + this.f561a + "snoreFrequency=" + this.g;
    }
}
