package com.huawei.pluginsport.helper;

import com.huawei.hwbasemgr.IBaseResponseCallback;

/* JADX INFO: loaded from: classes7.dex */
public interface DeviceInterface {
    void getDeviceStepRateAlgorithmEnterprise(IBaseResponseCallback iBaseResponseCallback);

    void getOperator(IBaseResponseCallback iBaseResponseCallback);

    void setBoltWearStatusListener(String str, IBaseResponseCallback iBaseResponseCallback);

    void unregBoltWearStatusListener(String str);
}
