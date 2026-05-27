package defpackage;

import com.huawei.health.devicemgr.business.entity.DeviceInfo;

/* JADX INFO: loaded from: classes6.dex */
public class lnx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DeviceInfo f15342a;
    private long b;
    private int g;
    private int f = 0;
    private int d = 0;
    private int e = 0;
    private int c = 0;

    public int j() {
        return this.g;
    }

    public void g(int i) {
        this.g = i;
    }

    public int c() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue();
    }

    public void f(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void b(int i) {
        this.d += i;
    }

    public int d() {
        return ((Integer) kqt.e(Integer.valueOf(this.e))).intValue();
    }

    public void d(int i) {
        this.e = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void c(int i) {
        this.e += i;
    }

    public int b() {
        return ((Integer) kqt.e(Integer.valueOf(this.c))).intValue();
    }

    public void a(int i) {
        this.c = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void e(int i) {
        this.c += i;
    }

    public long e() {
        return ((Long) kqt.e(Long.valueOf(this.b))).longValue();
    }

    public void a(long j) {
        this.b = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public DeviceInfo a() {
        return this.f15342a;
    }

    public void d(DeviceInfo deviceInfo) {
        this.f15342a = deviceInfo;
    }

    public String toString() {
        return "LastTotalValue{sportType=" + this.f + ", lastTotalSteps=" + this.d + ", lastTotalCalories=" + this.e + ", lastTotalDistance=" + this.c + ", lastTimeStamp=" + this.b + '}';
    }
}
