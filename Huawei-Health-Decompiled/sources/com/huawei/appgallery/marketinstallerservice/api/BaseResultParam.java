package com.huawei.appgallery.marketinstallerservice.api;

/* JADX INFO: loaded from: classes3.dex */
public class BaseResultParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1910a = 0;
    private int c = 0;
    private int b = 0;
    private int e = 0;

    public void setRtnCode(int i) {
        this.e = i;
    }

    public void setResult(int i) {
        this.f1910a = i;
    }

    public void setResponseCode(int i) {
        this.b = i;
    }

    public void setReason(int i) {
        this.c = i;
    }

    public int getRtnCode() {
        return this.e;
    }

    public int getResult() {
        return this.f1910a;
    }

    public int getResponseCode() {
        return this.b;
    }

    public int getReason() {
        return this.c;
    }
}
