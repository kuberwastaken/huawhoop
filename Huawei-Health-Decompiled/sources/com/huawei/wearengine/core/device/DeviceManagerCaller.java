package com.huawei.wearengine.core.device;

import android.os.RemoteException;
import com.huawei.wearengine.device.Device;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public interface DeviceManagerCaller {
    List<Device> getDeviceList() throws RemoteException;
}
