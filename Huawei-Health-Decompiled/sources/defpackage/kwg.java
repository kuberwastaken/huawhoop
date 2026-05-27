package defpackage;

import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public class kwg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f14957a;
    private long b;
    private long c;
    private int d;
    private int e;

    public void b(long j) {
        this.c = j;
    }

    public void e(int i) {
        long j = i;
        this.f14957a = j;
        this.b = this.c + j;
    }

    public void c(int i) {
        this.e = i;
    }

    public void a(int i) {
        this.d = i;
    }

    public long b() {
        return this.c;
    }

    public long e() {
        return this.b;
    }

    public int c() {
        return this.e;
    }

    public int a() {
        return this.d;
    }

    public void b(int i) {
        long j = i;
        this.f14957a += j;
        this.b += j;
    }

    public String toString() {
        return "StatusPoint{startTime=" + new Date(this.c * 1000) + "endTime=" + new Date(this.b * 1000) + ", duration=" + this.f14957a + ", type=" + this.e + '}';
    }
}
