package com.huawei.hms.network.embedded;

/* JADX INFO: loaded from: classes10.dex */
public class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f5528a;
    public String b;
    public long c;

    public String toString() {
        return "BandwidthInfo{receivedTime=" + this.f5528a + ", currentHost='" + this.b + "', estimatedBandwidthBps=" + this.c + '}';
    }

    public void setTime(long j) {
        this.f5528a = j;
    }

    public void setEstimatedBandwidthBps(long j) {
        this.c = j;
    }

    public void setCurrentHost(String str) {
        this.b = str;
    }

    public long getReceivedTime() {
        return this.f5528a;
    }

    public long getEstimatedBandwidthBps() {
        return this.c;
    }

    public String getCurrentHost() {
        return this.b;
    }

    public k1(long j, String str, long j2) {
        this.f5528a = j;
        this.b = str;
        this.c = j2;
    }

    public k1() {
        this.f5528a = 0L;
        this.b = "unknown";
        this.c = 0L;
    }
}
