package com.huawei.openalliance.ad;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.view.Surface;

/* JADX INFO: loaded from: classes11.dex */
public class ee {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ed f7079a;
    private EGLSurface b;

    public void e() {
        this.f7079a.a(this.b);
        this.b = EGL14.EGL_NO_SURFACE;
    }

    public void d() {
        this.f7079a.c(this.b);
    }

    public void c() {
        this.f7079a.b(this.b);
    }

    public int b() {
        return this.f7079a.a(this.b, 12374);
    }

    public int a() {
        return this.f7079a.a(this.b, 12375);
    }

    public ee(ed edVar, Surface surface) {
        this.f7079a = edVar;
        this.b = edVar.a(surface);
    }
}
