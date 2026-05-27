package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class ddr {
    private int h;
    private int d = 30;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12197a = 180;

    @SerializedName("ackEnable")
    private boolean b = false;
    private long c = 0;

    @SerializedName("offsetEnable")
    private boolean e = false;

    public long f() {
        return ((Long) kqt.e(Long.valueOf(this.c))).longValue();
    }

    public void a(long j) {
        this.c = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public void c(boolean z) {
        this.b = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }

    public boolean c() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.b))).booleanValue();
    }

    public int e() {
        return ((Integer) kqt.e(Integer.valueOf(this.f12197a))).intValue();
    }

    public void a(int i) {
        this.f12197a = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int d() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue();
    }

    public int b() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue() * 1000;
    }

    public void c(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int i() {
        return ((Integer) kqt.e(Integer.valueOf(this.h))).intValue();
    }

    public void b(int i) {
        this.h = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public boolean a() {
        return ((Boolean) kqt.e(Boolean.valueOf(this.e))).booleanValue();
    }

    public void b(boolean z) {
        this.e = ((Boolean) kqt.e(Boolean.valueOf(z))).booleanValue();
    }
}
