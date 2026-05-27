package com.huawei.wearengine.ota;

import com.huawei.wearengine.device.Device;
import defpackage.wsw;

/* JADX INFO: loaded from: classes11.dex */
public interface UpgradeCallback {
    void onUpgradeStatus(Device device, wsw wswVar, String str);
}
