package com.huawei.health.featuremarketing.rules.activityinfo;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ActivityInfo {
    private final String resultCode;
    private final String resultDesc;
    private final UserActivityInfo userActivityInfo;
    private final List<UserActivityInfo> userActivityInfoList;

    public ActivityInfo(a aVar) {
        this.resultCode = aVar.b;
        this.resultDesc = aVar.f2395a;
        this.userActivityInfo = aVar.d;
        this.userActivityInfoList = aVar.e;
    }

    /* JADX INFO: loaded from: classes10.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f2395a;
        private String b;
        private UserActivityInfo d;
        private List<UserActivityInfo> e;
    }

    public String getResultCode() {
        return this.resultCode;
    }

    public String getResultDesc() {
        return this.resultDesc;
    }

    public UserActivityInfo getUserActivityInfo() {
        return this.userActivityInfo;
    }

    public List<UserActivityInfo> getUserActivityInfoList() {
        return this.userActivityInfoList;
    }
}
