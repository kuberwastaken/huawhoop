package com.huawei.uikit.hwcolumnsystem.widget;

import defpackage.vnj;

/* JADX INFO: loaded from: classes8.dex */
public abstract class akxao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11115a;
    protected int b;
    protected float c;
    protected float d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;
    public float j;
    public int k;
    public boolean l;

    public abstract float a(int i);

    public void a(int i, int i2, float f, boolean z) {
        this.f11115a = i;
        this.b = i2;
        this.c = f;
        this.l = z;
    }

    public abstract int b();

    public void b(int i) {
        this.k = i;
    }

    public abstract int c();

    public void c(int i) {
        this.g = i;
    }

    public abstract int d();

    public abstract void e();

    public void a(vnj vnjVar, int i, boolean z) {
        this.l = z;
        this.e = vnjVar.d();
        this.f = vnjVar.a();
        this.g = vnjVar.c();
        this.h = vnjVar.b();
        this.i = i;
        e();
    }

    public int a() {
        return this.k;
    }
}
