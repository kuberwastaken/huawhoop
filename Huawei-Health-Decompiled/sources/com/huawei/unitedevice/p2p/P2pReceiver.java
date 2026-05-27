package com.huawei.unitedevice.p2p;

import com.huawei.devicesdk.entity.DeviceInfo;
import defpackage.vsa;

/* JADX INFO: loaded from: classes8.dex */
public interface P2pReceiver {
    void onReceiveMessage(DeviceInfo deviceInfo, vsa vsaVar);
}
