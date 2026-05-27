package defpackage;

import java.util.Date;

/* JADX INFO: loaded from: classes6.dex */
public class loa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15345a;
    private int b;
    private long c;
    private long d;
    private int e;

    public void e(long j) {
        this.c = j;
    }

    public void a(int i) {
        long j = i;
        this.d = j;
        this.f15345a = this.c + j;
    }

    public void e(int i) {
        this.b = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public long b() {
        return this.c;
    }

    public long a() {
        return this.f15345a;
    }

    public int e() {
        return this.b;
    }

    public int c() {
        return this.e;
    }

    public void d(int i) {
        long j = i;
        this.d += j;
        this.f15345a += j;
    }

    public String toString() {
        return "StatusPoint{startTime=" + new Date(this.c * 1000) + "endTime=" + new Date(this.f15345a * 1000) + ", duration=" + this.d + ", type=" + this.b + '}';
    }
}
