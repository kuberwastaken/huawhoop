package com.huawei.hms.iap.entity;

/* JADX INFO: loaded from: classes9.dex */
public class RedeemCodeResultInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4843a;
    private int b = 1;

    public void setReturnCode(int i) {
        this.b = i;
    }

    public void setRedeemCode(String str) {
        this.f4843a = str;
    }

    public int getReturnCode() {
        return this.b;
    }

    public String getRedeemCode() {
        return this.f4843a;
    }
}
