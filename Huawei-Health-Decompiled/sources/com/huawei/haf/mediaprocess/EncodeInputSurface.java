package com.huawei.haf.mediaprocess;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import health.compact.a.LogUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class EncodeInputSurface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EGLSurface f2166a;
    private Surface b;
    private EGLContext c;
    private EGLDisplay e;

    public EncodeInputSurface(Surface surface) throws IOException {
        if (surface == null) {
            LogUtil.d("EncodeInputSurface", "surface is null");
        }
        this.b = surface;
        e();
    }

    private void e() throws IOException {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.e = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            LogUtil.d("EncodeInputSurface", "unable to get EGL14 display");
            throw new IOException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.e, iArr, 0, iArr, 1)) {
            this.e = null;
            LogUtil.d("EncodeInputSurface", "unable to initialize EGL14");
            throw new IOException("unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.e, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            LogUtil.d("EncodeInputSurface", "unable to find RGB888+recordable ES2 EGL config");
            throw new IOException("unable to find RGB888+recordable ES2 EGL config");
        }
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(this.e, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        this.c = eGLContextEglCreateContext;
        if (eGLContextEglCreateContext == null) {
            LogUtil.d("EncodeInputSurface", "null eglcontext");
            throw new IOException("null eglcontext");
        }
        EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.e, eGLConfigArr[0], this.b, new int[]{12344}, 0);
        this.f2166a = eGLSurfaceEglCreateWindowSurface;
        if (eGLSurfaceEglCreateWindowSurface != null) {
            return;
        }
        LogUtil.d("EncodeInputSurface", "null eglSurface");
        throw new IOException("null eglSurface");
    }

    public void c() {
        if (EGL14.eglGetCurrentContext().equals(this.c)) {
            EGL14.eglMakeCurrent(this.e, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.e, this.f2166a);
        EGL14.eglDestroyContext(this.e, this.c);
        this.b.release();
        this.e = null;
        this.c = null;
        this.f2166a = null;
        this.b = null;
    }

    public void d() throws IOException {
        EGLDisplay eGLDisplay = this.e;
        EGLSurface eGLSurface = this.f2166a;
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.c)) {
            return;
        }
        LogUtil.d("EncodeInputSurface", "eglMakeCurrent failed");
        throw new IOException("eglMakeCurrent failed");
    }

    public boolean b() {
        return EGL14.eglSwapBuffers(this.e, this.f2166a);
    }

    public void d(long j) {
        EGLExt.eglPresentationTimeANDROID(this.e, this.f2166a, j);
    }
}
