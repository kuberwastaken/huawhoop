package com.huawei.ui.commonui.linechart.anchor;

import android.content.Context;
import defpackage.pfm;

/* JADX INFO: loaded from: classes7.dex */
public class Layout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f9208a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public boolean h = false;
    public float i;
    public float j;
    public float k;
    public int l;
    public float m;
    public float n;
    public int o;
    public float p;
    public float q;
    public int r;
    public int s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    float y;
    private Context z;

    public Layout(Context context) {
        this.z = context;
    }

    public pfm a(float f, float f2, float f3) {
        float f4 = this.l;
        float f5 = this.c;
        float f6 = this.b;
        float f7 = this.m;
        float f8 = this.k;
        float f9 = this.s;
        float f10 = this.r;
        float f11 = this.n;
        float f12 = this.j;
        float f13 = this.e;
        float f14 = this.o;
        float f15 = this.w + f14 + this.u + this.f + this.x + this.v + this.q;
        float f16 = f14 + this.p + this.t;
        if (f16 > f15) {
            f15 = f16;
        }
        this.d = f - (((((f4 + f5) + f6) + f7) + f8) + f9);
        this.f9208a = f2 - ((((f10 + f11) + f12) + f13) + f15);
        return new pfm(this.z, this);
    }

    public Layout b(float f, float f2) {
        this.g = f;
        this.i = f2;
        return this;
    }

    public Layout i(float f) {
        this.n = f;
        return this;
    }

    public Layout c(float f) {
        this.e = f;
        return this;
    }

    public Layout e(float f) {
        this.b = f;
        return this;
    }

    public Layout b(float f) {
        this.c = f;
        return this;
    }

    public Layout g(float f) {
        this.k = f;
        return this;
    }

    public Layout h(float f) {
        this.m = f;
        return this;
    }

    public Layout o(float f) {
        this.w = f;
        return this;
    }

    public Layout l(float f) {
        this.u = f;
        return this;
    }

    public Layout a(float f) {
        this.f = f;
        return this;
    }

    public Layout b(boolean z) {
        this.h = z;
        return this;
    }

    public float h() {
        return this.w;
    }

    public float j() {
        return this.u;
    }

    public float e() {
        return this.f;
    }

    public float c() {
        return this.b;
    }

    public float b() {
        return this.k;
    }

    public Layout d(float f) {
        this.j = f;
        return this;
    }

    public Layout n(float f) {
        this.x = f;
        return this;
    }

    public Layout m(float f) {
        this.v = f;
        return this;
    }

    public Layout k(float f) {
        this.q = f;
        return this;
    }

    public Layout j(float f) {
        this.t = f;
        return this;
    }

    public float g() {
        return this.x;
    }

    public float i() {
        return this.v;
    }

    public float a() {
        return this.q;
    }

    public float d() {
        return this.t;
    }

    public Layout f(float f) {
        this.p = f;
        return this;
    }

    public Layout t(float f) {
        this.y = f;
        return this;
    }

    public float f() {
        return this.y;
    }

    public Layout d(int i) {
        this.l = i;
        return this;
    }

    public Layout b(int i) {
        this.s = i;
        return this;
    }

    public Layout e(int i) {
        this.r = i;
        return this;
    }

    public Layout c(int i) {
        this.o = i;
        return this;
    }
}
