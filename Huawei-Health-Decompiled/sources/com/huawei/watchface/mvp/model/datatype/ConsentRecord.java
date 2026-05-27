package com.huawei.watchface.mvp.model.datatype;

/* JADX INFO: loaded from: classes11.dex */
public class ConsentRecord {
    private String appVersion;
    private String consentType;
    private String countryCode;
    private String personalSwitch;
    private String recordTime;
    private String userId;

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String getRecordTime() {
        return this.recordTime;
    }

    public void setRecordTime(String str) {
        this.recordTime = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getPersonalSwitch() {
        return this.personalSwitch;
    }

    public void setPersonalSwitch(String str) {
        this.personalSwitch = str;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getConsentType() {
        return this.consentType;
    }

    public void setConsentType(String str) {
        this.consentType = str;
    }
}
