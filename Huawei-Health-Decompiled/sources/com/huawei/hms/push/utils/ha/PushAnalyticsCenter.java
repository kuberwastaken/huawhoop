package com.huawei.hms.push.utils.ha;

/* JADX INFO: loaded from: classes10.dex */
public class PushAnalyticsCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PushBaseAnalytics f5882a;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static PushAnalyticsCenter f5883a = new PushAnalyticsCenter();
    }

    public static PushAnalyticsCenter getInstance() {
        return a.f5883a;
    }

    public PushBaseAnalytics getPushAnalytics() {
        return this.f5882a;
    }

    public void register(PushBaseAnalytics pushBaseAnalytics) {
        this.f5882a = pushBaseAnalytics;
    }
}
