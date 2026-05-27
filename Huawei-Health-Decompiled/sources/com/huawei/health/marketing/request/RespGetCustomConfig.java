package com.huawei.health.marketing.request;

/* JADX INFO: loaded from: classes10.dex */
public class RespGetCustomConfig {
    private CustomConfigInfo customConfig;
    private int resultCode;

    public int getResultCode() {
        return this.resultCode;
    }

    public void setResultCode(int i) {
        this.resultCode = i;
    }

    public CustomConfigInfo getCustomConfig() {
        return this.customConfig;
    }

    public void setCustomConfig(CustomConfigInfo customConfigInfo) {
        this.customConfig = customConfigInfo;
    }
}
