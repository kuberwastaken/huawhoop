package com.huawei.ui.openservice.db.model;

/* JADX INFO: loaded from: classes8.dex */
public class UserServiceAuth {
    private int authType;
    private String huid;
    private String serviceID;

    public UserServiceAuth() {
    }

    public UserServiceAuth(String str, String str2, int i) {
        this.huid = str;
        this.serviceID = str2;
        this.authType = i;
    }

    public String getHuid() {
        return this.huid;
    }

    public void configHuid(String str) {
        this.huid = str;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public void configServiceID(String str) {
        this.serviceID = str;
    }

    public int fetchAuthType() {
        return this.authType;
    }

    public void configAuthType(int i) {
        this.authType = i;
    }
}
