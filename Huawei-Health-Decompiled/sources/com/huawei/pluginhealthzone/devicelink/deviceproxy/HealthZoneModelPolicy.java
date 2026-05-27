package com.huawei.pluginhealthzone.devicelink.deviceproxy;

import com.huawei.pluginhealthzone.devicelink.callback.DeviceDataListener;
import defpackage.obv;
import defpackage.vsa;

/* JADX INFO: loaded from: classes7.dex */
public interface HealthZoneModelPolicy {
    void activeSendMsgToDevice(int i, obv obvVar, DeviceDataListener deviceDataListener);

    void receiveDataFromDevice(int i, vsa vsaVar);
}
