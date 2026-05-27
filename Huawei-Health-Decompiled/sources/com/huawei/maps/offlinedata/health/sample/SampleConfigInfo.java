package com.huawei.maps.offlinedata.health.sample;

/* JADX INFO: loaded from: classes11.dex */
public class SampleConfigInfo {
    private int mSupportCapability;
    private String mType;
    private long mConfigId = -1;
    private int mConfigAction = -1;
    private byte[] mByteConfigData = null;
    private Long mConfigModifyTime = null;

    public long getConfigId() {
        return this.mConfigId;
    }

    public void setConfigId(long j) {
        this.mConfigId = j;
    }

    public int getConfigAction() {
        return this.mConfigAction;
    }

    public void setConfigAction(int i) {
        this.mConfigAction = i;
    }

    public void setByteConfigData(byte[] bArr) {
        this.mByteConfigData = bArr;
    }

    public byte[] getByteConfigData() {
        return this.mByteConfigData;
    }

    public Long getConfigModifyTime() {
        return this.mConfigModifyTime;
    }

    public void setConfigModifyTime(Long l) {
        this.mConfigModifyTime = l;
    }

    public int getSupportCapability() {
        return this.mSupportCapability;
    }

    public void setSupportCapability(int i) {
        this.mSupportCapability = i;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }
}
