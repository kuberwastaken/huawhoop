package com.huawei.health.ecologydevice.networkclient;

/* JADX INFO: loaded from: classes10.dex */
public class ResponseResult {
    private String accessToken;
    private String code;
    private String msg;
    private boolean success;

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getAccessToken() {
        return this.accessToken;
    }
}
