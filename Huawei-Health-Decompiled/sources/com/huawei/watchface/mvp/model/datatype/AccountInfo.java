package com.huawei.watchface.mvp.model.datatype;

/* JADX INFO: loaded from: classes11.dex */
public class AccountInfo {
    private String accessToken;
    private String applicationID;
    private String clientID;
    private String countryCode;
    private String routeMode;

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getApplicationID() {
        return this.applicationID;
    }

    public void setApplicationID(String str) {
        this.applicationID = str;
    }

    public String getRouteMode() {
        return this.routeMode;
    }

    public void setRouteMode(String str) {
        this.routeMode = str;
    }

    public String getClientID() {
        return this.clientID;
    }

    public void setClientID(String str) {
        this.clientID = str;
    }
}
