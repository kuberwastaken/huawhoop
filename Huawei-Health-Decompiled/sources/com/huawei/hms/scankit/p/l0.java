package com.huawei.hms.scankit.p;

import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import com.huawei.hms.scankit.p.k0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Camera f6007a;

    public k0 a() {
        int maxNumMeteringAreas;
        RuntimeException e;
        Rect rect;
        k0 k0Var;
        synchronized (this) {
            try {
                maxNumMeteringAreas = this.f6007a.getParameters().getMaxNumMeteringAreas();
            } catch (RuntimeException e2) {
                maxNumMeteringAreas = 0;
                e = e2;
            }
            try {
                rect = this.f6007a.getParameters().getMeteringAreas().get(0).rect;
            } catch (RuntimeException e3) {
                e = e3;
                Log.w("CameraManager", "CameraMeteringManager::getCameraMeteringData failed: " + e.getMessage());
                rect = null;
            }
            k0Var = new k0(maxNumMeteringAreas, rect);
        }
        return k0Var;
    }

    public void a(Camera camera) {
        synchronized (this) {
            this.f6007a = camera;
        }
    }

    public void a(List list) {
        synchronized (this) {
            Camera camera = this.f6007a;
            if (camera == null) {
                return;
            }
            Camera.Parameters parameters = camera.getParameters();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(new Camera.Area(((k0.a) list.get(i)).f6002a, ((k0.a) list.get(i)).b));
            }
            parameters.setMeteringAreas(arrayList);
            try {
                this.f6007a.setParameters(parameters);
            } catch (RuntimeException e) {
                Log.w("CameraManager", "CameraMeteringManager::setCameraMeteringArea failed: " + e.getMessage());
            }
        }
    }
}
