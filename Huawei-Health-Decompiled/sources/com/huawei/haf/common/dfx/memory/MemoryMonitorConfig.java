package com.huawei.haf.common.dfx.memory;

/* JADX INFO: loaded from: classes.dex */
public final class MemoryMonitorConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f2133a;
    private final int b;
    private final int d;
    private final int e;

    public MemoryMonitorConfig(int i, int i2) {
        this(i, i2, 5);
    }

    public MemoryMonitorConfig(int i, int i2, int i3) {
        this.f2133a = i;
        this.d = i + i3;
        this.b = i2;
        this.e = i2 + i3;
    }

    public int e() {
        return this.f2133a;
    }

    public int d() {
        return this.d;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.e;
    }
}
