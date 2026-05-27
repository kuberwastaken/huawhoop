package com.huawei.openalliance.ad.beans.server;

import com.huawei.openalliance.ad.beans.base.RspBean;

/* JADX INFO: loaded from: classes6.dex */
public class ThirdReportRsp extends RspBean {
    private int httpCode;

    public void a(int i) {
        this.httpCode = i;
    }

    public int a() {
        return this.httpCode;
    }
}
