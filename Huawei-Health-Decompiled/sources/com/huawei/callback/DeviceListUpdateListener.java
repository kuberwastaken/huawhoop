package com.huawei.callback;

import com.huawei.health.devicemgr.business.entity.DeviceInfo;
import com.huawei.hwdevice.outofprocess.mgr.device.CloudDeviceInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface DeviceListUpdateListener {
    void onDeviceListUpdate(List<DeviceInfo> list, List<CloudDeviceInfo> list2);
}
