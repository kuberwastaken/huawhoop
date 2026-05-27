package com.huawei.openalliance.ad.utils;

/* JADX INFO: loaded from: classes11.dex */
public final class Size {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7823a;
    private final int b;

    public String toString() {
        return this.f7823a + "x" + this.b;
    }

    public int hashCode() {
        int i = this.b;
        int i2 = this.f7823a;
        return i ^ ((i2 << 16) | (i2 >>> 16));
    }

    public int getWidth() {
        return this.f7823a;
    }

    public int getHeight() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f7823a == size.f7823a && this.b == size.b;
    }

    public Size(int i, int i2) {
        this.f7823a = i;
        this.b = i2;
    }
}
