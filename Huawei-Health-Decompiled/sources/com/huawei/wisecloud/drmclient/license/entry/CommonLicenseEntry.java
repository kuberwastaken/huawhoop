package com.huawei.wisecloud.drmclient.license.entry;

/* JADX INFO: loaded from: classes8.dex */
public class CommonLicenseEntry {
    CommonHeaderEntry header;
    CommonPayloadEntry payload;

    public CommonLicenseEntry(CommonHeaderEntry commonHeaderEntry, CommonPayloadEntry commonPayloadEntry) {
        this.header = commonHeaderEntry;
        this.payload = commonPayloadEntry;
    }

    public CommonHeaderEntry getHeader() {
        return this.header;
    }

    public CommonPayloadEntry getPayload() {
        return this.payload;
    }
}
