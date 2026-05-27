package com.huawei.pluginachievement.manager.model;

/* JADX INFO: loaded from: classes7.dex */
public class ActivityInfo {
    private String activityId;
    private String beginTime;
    private String endTime;

    public String acquireActivityId() {
        return this.activityId;
    }

    public void saveActivityId(String str) {
        this.activityId = str;
    }

    public String acquireBeginTime() {
        return this.beginTime;
    }

    public void saveBeginTime(String str) {
        this.beginTime = str;
    }

    public String acquireEndTime() {
        return this.endTime;
    }

    public void saveEndTime(String str) {
        this.endTime = str;
    }

    public String toString() {
        return "ActivityInfo{activityId='" + this.activityId + "', beginTime=" + this.beginTime + ", endTime=" + this.endTime + '}';
    }
}
