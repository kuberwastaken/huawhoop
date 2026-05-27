package com.huawei.agconnect.credential.internal;

import com.huawei.agconnect.https.annotation.Result;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GetDomainResponse {

    @Result("backDomain")
    private List<DomainInfo> backDomain;

    @Result("mainDomain")
    private List<DomainInfo> mainDomain;

    @Result("ret")
    private ConnectRet ret;

    @Result("ttl")
    String ttl;

    public String d() {
        return this.ttl;
    }

    public ConnectRet c() {
        return this.ret;
    }

    public List<DomainInfo> b() {
        return this.mainDomain;
    }

    public List<DomainInfo> a() {
        return this.backDomain;
    }
}
