package defpackage;

import com.huawei.pluginachievement.ui.model.BestAchievementBasic;

/* JADX INFO: loaded from: classes7.dex */
public class nvq extends BestAchievementBasic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f16197a;
    private long b;
    private long c;
    private int d;
    private long e;

    public double d() {
        return this.f16197a;
    }

    public void e(double d) {
        this.f16197a = d;
    }

    public long b() {
        return this.b;
    }

    public void a(long j) {
        this.b = j;
    }

    public long e() {
        return this.e;
    }

    public void c(long j) {
        this.e = j;
    }

    public int c() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public long a() {
        return this.c;
    }

    public void b(long j) {
        this.c = j;
    }

    public String toString() {
        return "BestMotionPace{value=" + this.f16197a + ", startTime=" + this.b + ", source=" + this.d + ", deviceCode=" + this.e + '}';
    }
}
