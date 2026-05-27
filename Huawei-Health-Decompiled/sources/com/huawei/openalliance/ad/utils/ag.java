package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.inter.data.FeedbackInfo;
import com.huawei.profile.profile.ProfileExtendConstants;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f7860a;
    private static long b;

    public static void b() {
        b = System.currentTimeMillis();
    }

    public static boolean a(List<FeedbackInfo> list) {
        if (bj.a(list)) {
            return false;
        }
        for (FeedbackInfo feedbackInfo : list) {
            if (feedbackInfo != null && feedbackInfo.b()) {
                return true;
            }
        }
        return false;
    }

    public static boolean a() {
        if (Math.abs(System.currentTimeMillis() - f7860a) < 500 || Math.abs(System.currentTimeMillis() - b) < ProfileExtendConstants.TIME_OUT) {
            return true;
        }
        f7860a = System.currentTimeMillis();
        return false;
    }
}
