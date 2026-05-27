package com.huawei.openalliance.ad.beans.metadata;

import com.huawei.openalliance.ad.beans.base.RspBean;

/* JADX INFO: loaded from: classes6.dex */
public class Rule extends RspBean {
    private static final String TAG = "Rule";
    private long noShowTime;
    private int skippedAdMaxTimes;
    private int skippedAdMinTimes;
    private int timeScope;

    public long d() {
        return this.noShowTime;
    }

    public int c() {
        return this.skippedAdMaxTimes;
    }

    public int b() {
        return this.skippedAdMinTimes;
    }

    public int a() {
        return this.timeScope;
    }
}
