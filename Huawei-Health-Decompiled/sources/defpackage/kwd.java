package defpackage;

import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class kwd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14955a;
    private int b;
    private int c;
    private long d;
    private int e;

    public long b() {
        return this.d;
    }

    public void a(long j) {
        this.d = (j / 60) * 60;
    }

    public int a() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public int c() {
        return this.b;
    }

    public void e(int i) {
        this.b = i;
    }

    public int d() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public int e() {
        return this.f14955a;
    }

    public void c(int i) {
        this.f14955a = i;
    }

    public String toString() {
        return "DataRawSportData{startTime=" + new Date(this.d * 1000) + ", currentStatus=" + this.e + ", totalSteps=" + this.b + ", totalCalorie=" + this.c + ", totalDistance=" + this.f14955a + '}';
    }
}
