package com.huawei.health.ecologydevice.callback;

import com.huawei.devicesdk.entity.DeviceInfo;

/* JADX INFO: loaded from: classes4.dex */
public interface ConnectStatusCallback {
    void doDeviceConnected(int i, DeviceInfo deviceInfo);

    void doDeviceConnecting(int i);

    void doDeviceDisconnect(int i);
}
