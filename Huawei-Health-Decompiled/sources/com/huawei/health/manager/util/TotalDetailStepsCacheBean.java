package com.huawei.health.manager.util;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class TotalDetailStepsCacheBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("sysClockTime")
    private long f2869a;

    @SerializedName("activeCount")
    private int b;

    @SerializedName("climbSteps")
    private int c;

    @SerializedName("intensityTime")
    private int d;

    @SerializedName("runningSteps")
    private int e;

    @SerializedName("timestamp")
    private long f;

    @SerializedName("todaySensorSteps")
    private int g;

    @SerializedName("walkSteps")
    private int h;

    public TotalDetailStepsCacheBean(Builder builder) {
        this.f = builder.f;
        this.g = builder.j;
        this.h = builder.i;
        this.e = builder.e;
        this.c = builder.c;
        this.f2869a = builder.f2870a;
        this.d = builder.d;
        this.b = builder.b;
    }

    public long g() {
        return this.f;
    }

    public int f() {
        return this.g;
    }

    public int i() {
        return this.h;
    }

    public int e() {
        return this.e;
    }

    public int a() {
        return this.c;
    }

    public long c() {
        return this.f2869a;
    }

    public int b() {
        return this.d;
    }

    public int d() {
        return this.b;
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f2870a;
        private int b;
        private int c;
        private int d;
        private int e;
        private long f;
        private int i;
        private int j;

        public Builder b(long j) {
            this.f = j;
            return this;
        }

        public Builder b(int i) {
            this.j = i;
            return this;
        }

        public Builder i(int i) {
            this.i = i;
            return this;
        }

        public Builder e(int i) {
            this.e = i;
            return this;
        }

        public Builder a(int i) {
            this.c = i;
            return this;
        }

        public Builder a(long j) {
            this.f2870a = j;
            return this;
        }

        public Builder c(int i) {
            this.d = i;
            return this;
        }

        public Builder d(int i) {
            this.b = i;
            return this;
        }

        public TotalDetailStepsCacheBean d() {
            return new TotalDetailStepsCacheBean(this);
        }
    }
}
