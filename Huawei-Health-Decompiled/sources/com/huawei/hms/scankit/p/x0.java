package com.huawei.hms.scankit.p;

/* JADX INFO: loaded from: classes10.dex */
final class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6102a;
    private final int b;
    private final int c;
    private final int d;
    private int e = -1;

    public String toString() {
        return this.e + "|" + this.d;
    }

    x0(int i, int i2, int i3, int i4) {
        this.f6102a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    boolean g() {
        return a(this.e);
    }

    void h() {
        this.e = ((this.d / 30) * 3) + (this.c / 3);
    }

    int f() {
        return this.b - this.f6102a;
    }

    int d() {
        return this.f6102a;
    }

    int b() {
        return this.b;
    }

    int a() {
        return this.c;
    }

    int e() {
        return this.d;
    }

    int c() {
        return this.e;
    }

    boolean a(int i) {
        return i != -1 && this.c == (i % 3) * 3;
    }

    void b(int i) {
        this.e = i;
    }
}
