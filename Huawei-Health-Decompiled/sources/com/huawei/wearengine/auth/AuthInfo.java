package com.huawei.wearengine.auth;

/* JADX INFO: loaded from: classes9.dex */
public class AuthInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11748a;
    private int b;
    private int c;
    private String d;
    private String e;
    private String i;

    public int getOpenStatus() {
        return this.f11748a;
    }

    public void setOpenStatus(int i) {
        this.f11748a = i;
    }

    public String getKey() {
        return this.e;
    }

    public void setKey(String str) {
        this.e = str;
    }

    public String getUserId() {
        return this.i;
    }

    public void setUserId(String str) {
        this.i = str;
    }

    public int getAppId() {
        return this.c;
    }

    public void setAppId(int i) {
        this.c = i;
    }

    public String getPermission() {
        return this.d;
    }

    public void setPermission(String str) {
        this.d = str;
    }

    public int getAppUid() {
        return this.b;
    }

    public void setAppUid(int i) {
        this.b = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("AuthInfo:{key=");
        stringBuffer.append(this.e);
        stringBuffer.append(", appUid=").append(this.b);
        stringBuffer.append(", appId=").append(this.c);
        stringBuffer.append(", userId=").append(this.i);
        stringBuffer.append(", permission=").append(this.d);
        stringBuffer.append(", openStatus=").append(this.f11748a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
