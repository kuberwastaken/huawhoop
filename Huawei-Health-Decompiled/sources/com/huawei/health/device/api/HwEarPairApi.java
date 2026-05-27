package com.huawei.health.device.api;

import com.huawei.health.device.callback.EarphoneInfoCallback;
import com.huawei.health.devicemgr.business.entity.DeviceInfo;

/* JADX INFO: loaded from: classes4.dex */
public interface HwEarPairApi {
    void getEarphoneInfoFromCache(DeviceInfo deviceInfo, EarphoneInfoCallback earphoneInfoCallback);
}
