package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import android.util.Log;

/* JADX INFO: loaded from: classes10.dex */
public class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Camera f5971a;

    public g0 a() {
        g0 g0Var;
        synchronized (this) {
            g0Var = new g0(this.f5971a.getParameters().getMaxExposureCompensation(), this.f5971a.getParameters().getMinExposureCompensation(), this.f5971a.getParameters().getExposureCompensation(), this.f5971a.getParameters().getExposureCompensationStep());
        }
        return g0Var;
    }

    public void a(Camera camera) {
        synchronized (this) {
            this.f5971a = camera;
        }
    }

    public void a(int i) {
        synchronized (this) {
            Camera camera = this.f5971a;
            if (camera == null) {
                return;
            }
            try {
                Camera.Parameters parameters = camera.getParameters();
                parameters.setExposureCompensation(i);
                Log.i("WWYYEHG", "setExpuseModeA: " + parameters.getAutoExposureLock());
                this.f5971a.setParameters(parameters);
                Log.i("WWYYEHG", "setExpuseModeB: " + parameters.getAutoExposureLock());
            } catch (RuntimeException unused) {
                Log.w("CameraManager", "CameraExposureManager::setCompensation failed");
            }
        }
    }
}
