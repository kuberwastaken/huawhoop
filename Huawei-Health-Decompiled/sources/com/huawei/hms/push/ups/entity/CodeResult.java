package com.huawei.hms.push.ups.entity;

/* JADX INFO: loaded from: classes10.dex */
public class CodeResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5881a;
    private String b;

    public CodeResult() {
    }

    public String getReason() {
        return this.b;
    }

    public int getReturnCode() {
        return this.f5881a;
    }

    public void setReason(String str) {
        this.b = str;
    }

    public void setReturnCode(int i) {
        this.f5881a = i;
    }

    public CodeResult(int i) {
        this.f5881a = i;
    }

    public CodeResult(int i, String str) {
        this.f5881a = i;
        this.b = str;
    }
}
