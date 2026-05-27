package com.autonavi.base.ae.gmap;

/* JADX INFO: loaded from: classes3.dex */
public class GLEngineIDController {
    private static final String TAG = "GLEngineIDController";
    private static GLEngineIDController sController = new GLEngineIDController();
    private int engineIDIndex = 10000;

    private GLEngineIDController() {
    }

    public static GLEngineIDController getController() {
        return sController;
    }

    public int generate() {
        int i;
        synchronized (this) {
            i = this.engineIDIndex + 1;
            this.engineIDIndex = i;
        }
        return i;
    }
}
