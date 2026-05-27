package com.huawei.hwcommonmodel.camera;

import android.media.Image;

/* JADX INFO: loaded from: classes9.dex */
public interface CameraStateListener {
    void onCameraError(String str);

    void onCameraOpened(int i);

    void onPreviewFrame(Image image, int i);
}
