package com.huawei.datatype;

import defpackage.kqt;

/* JADX INFO: loaded from: classes3.dex */
public class DataDeviceIntelligentInfo {
    private String deviceHiv;
    private String deviceaManu;
    private String productId;

    public String getDeviceManu() {
        return (String) kqt.e(this.deviceaManu);
    }

    public void setDeviceManu(String str) {
        this.deviceaManu = (String) kqt.e(str);
    }

    public String getDeviceProductId() {
        return (String) kqt.e(this.productId);
    }

    public void setDeviceProductId(String str) {
        this.productId = (String) kqt.e(str);
    }

    public String getDeviceHiv() {
        return (String) kqt.e(this.deviceHiv);
    }

    public void setDeviceHiv(String str) {
        this.deviceHiv = (String) kqt.e(str);
    }

    public String toString() {
        return "DataDeviceIntelligentInfo{deviceaManu=" + this.deviceaManu + ", productId=" + this.productId + ", deviceHiv=" + this.deviceHiv + '}';
    }
}
