package defpackage;

import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class lnq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15339a;
    private long b;
    private int c;
    private int d;
    private int e;

    public long a() {
        return this.b;
    }

    public void c(long j) {
        this.b = (j / 60) * 60;
    }

    public int b() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int c() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public int e() {
        return this.f15339a;
    }

    public void e(int i) {
        this.f15339a = i;
    }

    public int d() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public String toString() {
        return "DataRawSportData{startTime=" + new Date(this.b * 1000) + ", currentStatus=" + this.d + ", totalSteps=" + this.c + ", totalCalorie=" + this.f15339a + ", totalDistance=" + this.e + '}';
    }
}
