package com.huawei.health.group.constants;

/* JADX INFO: loaded from: classes4.dex */
public class GroupActivityBo {
    private int activityId;
    private String activityName;
    private int activityStatus;
    private int activityType;
    private String beginTime;
    private String endTime;
    private String metadata;
    private String snsGroupId;
    private String teamId;
    private int version;

    public int getActivityId() {
        return this.activityId;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public String getSnsGroupId() {
        return this.snsGroupId;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public String getBeginTime() {
        return this.beginTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public int getActivityStatus() {
        return this.activityStatus;
    }
}
