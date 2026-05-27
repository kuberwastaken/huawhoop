package com.huawei.appgallery.coreservice.api;

import defpackage.bab;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class ConnectConfig implements Cloneable, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f1899a;
    private String b;
    private String c;
    private String d;
    private String e;

    public void setInstallAppName(String str) {
        this.d = str;
    }

    public void setConnectServiceAction(String str) {
        this.b = str;
    }

    public void setConnectAppPkg(String str) {
        this.e = str;
    }

    public void setAppSignCertchain(String str) {
        this.f1899a = str;
    }

    public void setAppFingerprintSignature(String str) {
        this.c = str;
    }

    public String getInstallAppName() {
        return this.d;
    }

    public String getConnectServiceAction() {
        return this.b;
    }

    public String getConnectAppPkg() {
        return this.e;
    }

    public String getAppSignCertchain() {
        return this.f1899a;
    }

    public String getAppFingerprintSignature() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ConnectConfig m382clone() {
        try {
            return (ConnectConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            bab.d("ConnectConfig", "ConnectConfig Clone error:" + e.getMessage());
            return null;
        }
    }
}
