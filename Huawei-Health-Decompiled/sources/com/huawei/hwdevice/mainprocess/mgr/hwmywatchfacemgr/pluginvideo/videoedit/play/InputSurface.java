package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.videoedit.play;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import com.huawei.haf.common.exception.ExceptionUtils;
import com.huawei.watchface.videoedit.utils.Releasable;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes6.dex */
public class InputSurface implements Releasable {
    private static final int CONST_EIGHT = 8;
    private static final int CONST_THREE = 3;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private static final int LENGTH = 2;
    private static final String TAG = "InputSurface";
    private Surface mSurface;
    private EGLDisplay mEglDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;
    private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;

    public InputSurface(Surface surface) {
        surface.getClass();
        this.mSurface = surface;
        try {
            eglSetup();
        } catch (IllegalStateException e) {
            LogUtil.d(TAG, "InputSurface IllegalStateException ", ExceptionUtils.a(e));
        }
    }

    private void eglSetup() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        this.mEglDisplay = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new IllegalStateException("InputSurface unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(this.mEglDisplay, iArr, 0, iArr, 1)) {
            this.mEglDisplay = null;
            throw new IllegalStateException("InputSurface unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (!EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 64, EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            throw new IllegalStateException("InputSurface unable to find RGB888+recordable ES2 EGL config");
        }
        this.mEglContext = EGL14.eglCreateContext(this.mEglDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 3, 12344}, 0);
        checkEglError("eglCreateContext");
        if (this.mEglContext == null) {
            throw new IllegalStateException("InputSurface null context");
        }
        this.mEglSurface = EGL14.eglCreateWindowSurface(this.mEglDisplay, eGLConfigArr[0], this.mSurface, new int[]{12344}, 0);
        checkEglError("eglCreateWindowSurface");
        if (this.mEglSurface == null) {
            throw new IllegalStateException("InputSurface surface was null");
        }
    }

    @Override // com.huawei.watchface.videoedit.utils.Releasable
    public void release() {
        if (this.mEglDisplay != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglDestroySurface(this.mEglDisplay, this.mEglSurface);
            EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEglDisplay);
        }
        LogUtil.a(TAG, "InputSurface mSurface released");
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEglContext = EGL14.EGL_NO_CONTEXT;
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mSurface = null;
    }

    public void makeCurrent() {
        EGLDisplay eGLDisplay = this.mEglDisplay;
        EGLSurface eGLSurface = this.mEglSurface;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
            throw new IllegalStateException("InputSurface eglMakeCurrent failed");
        }
    }

    public boolean swapBuffers() {
        return EGL14.eglSwapBuffers(this.mEglDisplay, this.mEglSurface);
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public int getWidth() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12375, iArr, 0);
        return iArr[0];
    }

    public int getHeight() {
        int[] iArr = new int[1];
        EGL14.eglQuerySurface(this.mEglDisplay, this.mEglSurface, 12374, iArr, 0);
        return iArr[0];
    }

    public void setPresentationTime(long j) {
        EGLExt.eglPresentationTimeANDROID(this.mEglDisplay, this.mEglSurface, j);
    }

    private void checkEglError(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new IllegalStateException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }
}
