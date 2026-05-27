package com.huawei.operation.beans;

import com.huawei.operation.adapter.SportData;

/* JADX INFO: loaded from: classes11.dex */
public class JsSportData extends SportData {
    private String currentTime;
    private String version;

    public void setCurrentTime(String str) {
        this.currentTime = str;
    }

    public String getCurrentTime() {
        return this.currentTime;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getVersion() {
        return this.version;
    }
}
