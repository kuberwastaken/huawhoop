package com.huawei.hwcloudmodel.model.unite;

import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes5.dex */
public class WifiDeviceGetWifiDeviceInfoRsp extends CloudCommonReponse {
    private DeviceDetailInfo deviceDetailInfo;

    public void setDeviceDetailInfo(DeviceDetailInfo deviceDetailInfo) {
        this.deviceDetailInfo = deviceDetailInfo;
    }

    public DeviceDetailInfo getDeviceDetailInfo() {
        return this.deviceDetailInfo;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "WifiDeviceGetWifiDeviceInfoRsp{" + this.deviceDetailInfo + '}';
    }
}
