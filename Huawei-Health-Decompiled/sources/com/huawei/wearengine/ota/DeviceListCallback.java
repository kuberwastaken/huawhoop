package com.huawei.wearengine.ota;

import com.huawei.wearengine.device.Device;
import defpackage.wsw;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface DeviceListCallback {
    void onDeviceListObtain(wsw wswVar, List<Device> list);
}
