package com.huawei.ucd.helper.gles;

/* JADX INFO: loaded from: classes11.dex */
public interface IGLActor {

    public interface RequestRenderListener {
        void onRequestRenderCalled();
    }

    RequestRenderListener getRequestRenderListener();

    boolean isSurfaceCreated();

    void onDrawFrame();

    void onSurfaceChanged(int i, int i2);

    void onSurfaceCreated();

    void requestRender();

    void setRequestRenderListener(RequestRenderListener requestRenderListener);
}
