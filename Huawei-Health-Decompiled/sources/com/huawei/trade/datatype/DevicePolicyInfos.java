package com.huawei.trade.datatype;

import com.google.gson.annotations.SerializedName;
import defpackage.mgx;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class DevicePolicyInfos {

    @SerializedName("deviceInboxInfoList")
    private List<DeviceInboxInfo> deviceInboxInfoList = new ArrayList(10);

    @SerializedName("devicePerfPurchaseInfoList")
    private List<DevicePerfPurchaseInfo> devicePerfPurchaseInfoList = new ArrayList(10);

    @SerializedName("deviceBenefitInfoList")
    private List<DeviceBenefitInfo> deviceBenefitInfoList = new ArrayList(10);

    public List<DeviceInboxInfo> getDeviceInboxInfoList() {
        return this.deviceInboxInfoList;
    }

    public void setDeviceInboxInfoList(List<DeviceInboxInfo> list) {
        if (mgx.e(list)) {
            this.deviceInboxInfoList.addAll(list);
        }
    }

    public List<DevicePerfPurchaseInfo> getDevicePerfPurchaseInfoList() {
        return this.devicePerfPurchaseInfoList;
    }

    public void setDevicePerfPurchaseInfoList(List<DevicePerfPurchaseInfo> list) {
        if (mgx.e(list)) {
            this.devicePerfPurchaseInfoList.addAll(list);
        }
    }

    public List<DeviceBenefitInfo> getDeviceBenefitInfoList() {
        return this.deviceBenefitInfoList;
    }

    public void setDeviceBenefitInfoList(List<DeviceBenefitInfo> list) {
        if (mgx.e(list)) {
            this.deviceBenefitInfoList.addAll(list);
        }
    }
}
