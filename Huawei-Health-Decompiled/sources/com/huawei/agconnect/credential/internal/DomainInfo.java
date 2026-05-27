package com.huawei.agconnect.credential.internal;

import com.huawei.agconnect.https.annotation.Result;

/* JADX INFO: loaded from: classes3.dex */
public class DomainInfo {

    @Result("domain")
    String domain;

    @Result("siteCode")
    String siteCode;

    public String b() {
        return this.siteCode;
    }

    public String a() {
        return this.domain;
    }
}
