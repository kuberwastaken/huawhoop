package com.huawei.trade.datatype;

/* JADX INFO: loaded from: classes7.dex */
public class DeviceBenefitInfoDetail {
    private int benefitType;
    private String deviceSbomId;

    public DeviceBenefitInfoDetail() {
    }

    public DeviceBenefitInfoDetail(int i, String str) {
        this.benefitType = i;
        this.deviceSbomId = str;
    }

    public int getBenefitType() {
        return this.benefitType;
    }

    public void setBenefitType(int i) {
        this.benefitType = i;
    }

    public String getDeviceSbomId() {
        return this.deviceSbomId;
    }

    public void setDeviceSbomId(String str) {
        this.deviceSbomId = str;
    }

    public String toString() {
        return "DeviceBenefitInfoDetail{benefitType=" + this.benefitType + ", deviceSbomId='" + this.deviceSbomId + "'}";
    }
}
