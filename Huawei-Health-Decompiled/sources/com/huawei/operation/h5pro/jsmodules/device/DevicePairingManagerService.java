package com.huawei.operation.h5pro.jsmodules.device;

import com.huawei.haf.common.utils.NetworkUtil;
import com.huawei.health.h5pro.service.anotation.H5ProCallback;
import com.huawei.health.h5pro.service.anotation.H5ProMethod;
import com.huawei.health.h5pro.service.anotation.H5ProService;

/* JADX INFO: loaded from: classes.dex */
@H5ProService(name = DevicePairingManagerService.TAG, users = {"9ea3f06fe2dea3e2c7c21ea1ba1e07c370a786c68417a4a96cb986576883e10f"})
public class DevicePairingManagerService {
    private static final String TAG = "DevicePairingManager";
    private static final String TAG_RELEASE = "DEVMGR_DevicePairingManager";

    @H5ProCallback
    interface IH5ProCallback<T> {
        void onFailure(int i, String str);

        void onSuccess(T t);
    }

    @H5ProMethod(name = "queryNetworkStatus")
    public static void queryNetworkStatus(IH5ProCallback<Boolean> iH5ProCallback) {
        iH5ProCallback.onSuccess(Boolean.valueOf(NetworkUtil.f()));
    }
}
