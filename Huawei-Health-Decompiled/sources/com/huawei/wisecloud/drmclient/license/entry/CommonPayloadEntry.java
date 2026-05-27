package com.huawei.wisecloud.drmclient.license.entry;

/* JADX INFO: loaded from: classes8.dex */
public class CommonPayloadEntry {
    private PayloadLicenseEntry license;
    private PayloadServerInfoEntry serverInfo;

    public PayloadServerInfoEntry getServerInfo() {
        return this.serverInfo;
    }

    public void setServerInfo(PayloadServerInfoEntry payloadServerInfoEntry) {
        this.serverInfo = payloadServerInfoEntry;
    }

    public PayloadLicenseEntry getLicense() {
        return this.license;
    }

    public void setLicense(PayloadLicenseEntry payloadLicenseEntry) {
        this.license = payloadLicenseEntry;
    }
}
