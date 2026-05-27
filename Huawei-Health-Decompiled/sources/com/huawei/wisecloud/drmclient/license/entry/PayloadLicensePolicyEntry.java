package com.huawei.wisecloud.drmclient.license.entry;

/* JADX INFO: loaded from: classes8.dex */
public class PayloadLicensePolicyEntry {
    private String endTime;
    private boolean persistence;
    private String startTime;

    public boolean isPersistence() {
        return this.persistence;
    }

    public void setPersistence(boolean z) {
        this.persistence = z;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }
}
