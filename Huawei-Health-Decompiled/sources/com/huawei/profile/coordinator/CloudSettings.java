package com.huawei.profile.coordinator;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes7.dex */
public class CloudSettings {
    private static String wiseDeviceUrl;

    private CloudSettings() {
    }

    public static String getWiseDeviceUrl() {
        if (TextUtils.isEmpty(wiseDeviceUrl)) {
            return ProfileRequestConstants.ENVIRONMENT_URL.toString();
        }
        return wiseDeviceUrl;
    }

    public static void setWiseDeviceUrl(String str) {
        wiseDeviceUrl = str;
    }
}
