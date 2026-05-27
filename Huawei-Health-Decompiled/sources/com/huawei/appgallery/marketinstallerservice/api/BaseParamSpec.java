package com.huawei.appgallery.marketinstallerservice.api;

/* JADX INFO: loaded from: classes3.dex */
public class BaseParamSpec {
    private String c = null;
    private String b = null;
    private String d = null;
    private boolean e = false;

    public void setUpdate(boolean z) {
        this.e = z;
    }

    public void setSubsystem(String str) {
        this.b = str;
    }

    public void setServerUrl(String str) {
        this.c = str;
    }

    public void setMarketPkg(String str) {
        this.d = str;
    }

    public boolean isUpdate() {
        return this.e;
    }

    public String getSubsystem() {
        return this.b;
    }

    public String getServerUrl() {
        return this.c;
    }

    public String getMarketPkg() {
        return this.d;
    }
}
