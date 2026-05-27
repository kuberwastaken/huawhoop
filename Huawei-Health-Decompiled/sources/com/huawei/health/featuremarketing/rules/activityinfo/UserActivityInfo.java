package com.huawei.health.featuremarketing.rules.activityinfo;

/* JADX INFO: loaded from: classes4.dex */
public class UserActivityInfo {
    private final String activityId;
    private final int joinStatus;
    private final long joinTime;
    private final int level;

    public UserActivityInfo(c cVar) {
        this.activityId = cVar.b;
        this.level = cVar.c;
        this.joinStatus = cVar.f2396a;
        this.joinTime = cVar.e;
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2396a;
        private String b;
        private int c;
        private long e;
    }

    public String getActivityId() {
        return this.activityId;
    }

    public int getLevel() {
        return this.level;
    }

    public int getJoinStatus() {
        return this.joinStatus;
    }

    public long getJoinTime() {
        return this.joinTime;
    }
}
