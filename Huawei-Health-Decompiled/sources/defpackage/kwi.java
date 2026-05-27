package defpackage;

import com.huawei.health.devicemgr.business.entity.DeviceInfo;

/* JADX INFO: loaded from: classes5.dex */
public class kwi {
    private long b;
    private DeviceInfo e;
    private int f;
    private int g = 0;
    private int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14958a = 0;
    private int c = 0;

    public int g() {
        return this.f;
    }

    public void f(int i) {
        this.f = i;
    }

    public int d() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue();
    }

    public void g(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void e(int i) {
        this.d += i;
    }

    public int e() {
        return ((Integer) kqt.e(Integer.valueOf(this.f14958a))).intValue();
    }

    public void b(int i) {
        this.f14958a = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void a(int i) {
        this.f14958a += i;
    }

    public int c() {
        return ((Integer) kqt.e(Integer.valueOf(this.c))).intValue();
    }

    public void c(int i) {
        this.c = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void d(int i) {
        this.c += i;
    }

    public long b() {
        return ((Long) kqt.e(Long.valueOf(this.b))).longValue();
    }

    public void c(long j) {
        this.b = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public DeviceInfo a() {
        return this.e;
    }

    public void c(DeviceInfo deviceInfo) {
        this.e = deviceInfo;
    }

    public String toString() {
        return "LastTotalValue{sportType=" + this.g + ", lastTotalSteps=" + this.d + ", lastTotalCalories=" + this.f14958a + ", lastTotalDistance=" + this.c + ", lastTimeStamp=" + this.b + '}';
    }
}
