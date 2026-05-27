package com.huawei.health.h5pro.scalable.storage;

/* JADX INFO: loaded from: classes4.dex */
public class H5AppLoadStorageInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2491a;
    public long b;
    public long d;
    public long e;

    public String toString() {
        return "H5AppLoadStorageInfo{name='" + this.f2491a + "', count=" + this.d + ", loadTime=" + this.e + ", preLoadTime=" + this.b + '}';
    }

    public void setPreLoadTime(long j) {
        this.b = j;
    }

    public void setName(String str) {
        this.f2491a = str;
    }

    public void setLoadTime(long j) {
        this.e = j;
    }

    public void setCount(long j) {
        this.d = j;
    }

    public long getPreLoadTime() {
        return this.b;
    }

    public String getName() {
        return this.f2491a;
    }

    public long getLoadTime() {
        return this.e;
    }

    public long getCount() {
        return this.d;
    }
}
