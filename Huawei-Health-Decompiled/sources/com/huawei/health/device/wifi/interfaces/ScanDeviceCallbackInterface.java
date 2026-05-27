package com.huawei.health.device.wifi.interfaces;

import defpackage.dqn;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface ScanDeviceCallbackInterface {
    void onDeviceDiscovered(List<dqn> list);

    void onDeviceDiscoveryFinished();

    void onFailure(Object obj);
}
