package com.huawei.health.device.api;

import com.huawei.health.device.open.MeasureKit;

/* JADX INFO: loaded from: classes4.dex */
public interface MeasureKitManagerApi {
    MeasureKit getHealthDeviceKit(String str);

    com.huawei.hihealth.device.open.MeasureKit getHealthDeviceKitUniversal(String str);

    void registerExternalKit(String str, String str2);
}
