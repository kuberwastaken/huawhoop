package com.huawei.health.algorithm.model;

/* JADX INFO: loaded from: classes10.dex */
public class SleepMonitorQueryByTime {
    private long endTime;
    private long startTime;

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public String toString() {
        return "SleepMonitorQueryByTime{startTime=" + this.startTime + ", endTime=" + this.endTime + '}';
    }
}
