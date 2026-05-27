package com.huawei.health.manager;

import defpackage.kql;

/* JADX INFO: loaded from: classes.dex */
public class CaloriesManager$CaloriesData {
    public long b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f2824a = 0.0d;

    public long d() {
        return this.b;
    }

    public void a(long j, double d) {
        this.b = kql.r(j);
        this.f2824a = d;
    }

    public void e() {
        this.b = 0L;
        this.f2824a = 0.0d;
    }

    public void a(double d) {
        this.f2824a += d;
    }
}
