package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.annotations.a;
import com.huawei.openalliance.ad.beans.base.RspBean;

/* JADX INFO: loaded from: classes6.dex */
public class ParamFromServer extends RspBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a
    private String f6887a;

    @a
    private String sig;

    @a
    private String t;

    public void c(String str) {
        this.sig = str;
    }

    public void b(String str) {
        this.f6887a = str;
    }

    public String b() {
        return this.sig;
    }

    public void a(String str) {
        this.t = str;
    }

    public String a() {
        return this.f6887a;
    }
}
