package defpackage;

import com.huawei.pluginachievement.ui.model.BestAchievementBasic;

/* JADX INFO: loaded from: classes7.dex */
public class nvs extends BestAchievementBasic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f16199a;
    private long b;
    private long c;
    private long d;
    private int e;

    public long a() {
        return this.c;
    }

    public void b(long j) {
        this.c = j;
    }

    public long b() {
        return this.b;
    }

    public void c(long j) {
        this.b = j;
    }

    public int c() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public long d() {
        return this.f16199a;
    }

    public void d(long j) {
        this.f16199a = j;
    }

    public long e() {
        return this.d;
    }

    public void e(long j) {
        this.d = j;
    }

    public String toString() {
        return "BestMotion{value=" + this.c + ", startTime=" + this.b + ", source=" + this.e + ", deviceCode=" + this.f16199a + '}';
    }
}
