package com.huawei.hwdevice.mainprocess.mgr.settingcamera;

import com.huawei.health.devicemgr.business.entity.DeviceInfo;

/* JADX INFO: loaded from: classes6.dex */
public interface CameraContorlInterface {
    boolean checkSupportCamera();

    boolean checkSupportCamera(DeviceInfo deviceInfo);

    void deleteCameraAuthorization(DeviceInfo deviceInfo);

    void getCameraStatus(CameraAuthStatusCallback cameraAuthStatusCallback);

    boolean supportAlgoArch();

    void unbindCameraService();

    void updateCameraAuthStatus(boolean z);
}
