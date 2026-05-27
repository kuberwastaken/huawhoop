package com.huawei.hms.scankit.p;

import android.hardware.Camera;
import android.util.Log;

/* JADX INFO: loaded from: classes10.dex */
public class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Camera f6021a;

    public m0 a() {
        m0 m0Var;
        synchronized (this) {
            m0Var = new m0(this.f6021a.getParameters().getMaxZoom(), this.f6021a.getParameters().getZoom(), this.f6021a.getParameters().getZoomRatios());
        }
        return m0Var;
    }

    public boolean b() {
        synchronized (this) {
            Camera camera = this.f6021a;
            if (camera == null) {
                return false;
            }
            return camera.getParameters().isZoomSupported();
        }
    }

    public void a(Camera camera) {
        synchronized (this) {
            this.f6021a = camera;
        }
    }

    public void a(int i) {
        synchronized (this) {
            Camera camera = this.f6021a;
            if (camera == null) {
                return;
            }
            Camera.Parameters parameters = camera.getParameters();
            parameters.setZoom(i);
            try {
                this.f6021a.setParameters(parameters);
            } catch (RuntimeException e) {
                Log.e("CameraManager", "CameraZoomManager::setCameraZoomIndex failed: " + e.getMessage());
            }
        }
    }
}
