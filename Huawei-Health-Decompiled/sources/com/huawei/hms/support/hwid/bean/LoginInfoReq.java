package com.huawei.hms.support.hwid.bean;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class LoginInfoReq {
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_USER_NAME = "username";
    private String packageName;
    private String password;
    private String username;

    public LoginInfoReq() {
    }

    public LoginInfoReq(String str, String str2) {
        this.username = str;
        this.password = str2;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public void setPassword(String str) {
        this.password = str;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", this.username);
        jSONObject.put("password", this.password);
        return jSONObject;
    }
}
