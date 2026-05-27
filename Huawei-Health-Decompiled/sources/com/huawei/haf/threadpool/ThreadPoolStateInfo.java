package com.huawei.haf.threadpool;

import com.huawei.haf.threadpool.ThreadPoolManager;

/* JADX INFO: loaded from: classes.dex */
public final class ThreadPoolStateInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f2201a;
    private int b;
    private int c;
    private long d;
    private int e;
    private int f;
    private int g;
    private long h;
    private int i;
    private long j;
    private long k;
    private int l;
    private int m;
    private long n;
    private long o;
    private long r;

    void d(ThreadPoolManager.HealthThreadPoolExecutor healthThreadPoolExecutor, int i) {
        this.f = healthThreadPoolExecutor.getMaximumPoolSize();
        this.b = healthThreadPoolExecutor.getCorePoolSize();
        this.g = healthThreadPoolExecutor.getPoolSize();
        this.f2201a = healthThreadPoolExecutor.getLargestPoolSize();
        this.e = i;
        this.m = healthThreadPoolExecutor.c();
        this.l = healthThreadPoolExecutor.d();
        this.c = healthThreadPoolExecutor.a();
        this.i = healthThreadPoolExecutor.e();
    }

    void e(long j, long j2, long j3, long j4) {
        this.k = j;
        this.j = j2;
        this.h = j3;
        this.n = j4;
    }

    void b(long j, long j2, long j3) {
        this.o = j;
        this.r = j2;
        this.d = j3;
    }

    public int g() {
        return this.f;
    }

    public int c() {
        return this.b;
    }

    public int e() {
        return this.f2201a;
    }

    public int f() {
        return this.g;
    }

    public int a() {
        return this.e;
    }

    public int k() {
        return this.m;
    }

    public int l() {
        return this.l;
    }

    public int d() {
        return this.c;
    }

    public int h() {
        return this.i;
    }

    public long m() {
        return this.k;
    }

    public long i() {
        return this.j;
    }

    public long j() {
        return this.h;
    }

    public long o() {
        return this.n;
    }

    public long n() {
        return this.o;
    }

    public long s() {
        return this.r;
    }

    public long b() {
        return this.d;
    }
}
