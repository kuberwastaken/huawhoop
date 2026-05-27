package com.huawei.openalliance.ad.beans.metadata;

/* JADX INFO: loaded from: classes6.dex */
public class FlowControl {
    int fcRatio = 0;
    long fcEndTime = 0;

    public long b() {
        return this.fcEndTime;
    }

    public void a(long j) {
        this.fcEndTime = j;
    }

    public void a(int i) {
        this.fcRatio = i;
    }

    public int a() {
        return this.fcRatio;
    }
}
