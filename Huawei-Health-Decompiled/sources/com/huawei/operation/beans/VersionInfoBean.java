package com.huawei.operation.beans;

/* JADX INFO: loaded from: classes.dex */
public class VersionInfoBean {
    private String btMac;
    private String btVersion;
    private String deviceSoftVersion;
    private int deviceType;
    private String deviceVersion;
    private String model;
    private String prodId;
    private String sn;

    public String getBtVersion() {
        return this.btVersion;
    }

    public void setBtVersion(String str) {
        this.btVersion = str;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public String getDeviceVersion() {
        return this.deviceVersion;
    }

    public void setDeviceVersion(String str) {
        this.deviceVersion = str;
    }

    public String getBtMac() {
        return this.btMac;
    }

    public void setBtMac(String str) {
        this.btMac = str;
    }

    public String getDeviceSoftVersion() {
        return this.deviceSoftVersion;
    }

    public void setDeviceSoftVersion(String str) {
        this.deviceSoftVersion = str;
    }

    public String getSn() {
        return this.sn;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getProdId() {
        return this.prodId;
    }

    public void setProdId(String str) {
        this.prodId = str;
    }
}
