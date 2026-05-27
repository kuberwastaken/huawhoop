package com.huawei.health.tradeservice.cloud;

import com.huawei.trade.datatype.DevicePolicyInfos;

/* JADX INFO: loaded from: classes5.dex */
public class DeviceInboxAndPerfRsp extends BaseRsp {
    private DevicePolicyInfos devicePolicyInfos;

    public DevicePolicyInfos getDevicePolicyInfos() {
        return this.devicePolicyInfos;
    }

    public void setDevicePolicyInfos(DevicePolicyInfos devicePolicyInfos) {
        this.devicePolicyInfos = devicePolicyInfos;
    }
}
