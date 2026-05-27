package com.huawei.secure.android.common.detect;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.secure.android.common.detect.utils.c;

/* JADX INFO: loaded from: classes11.dex */
public abstract class ProxyDetect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8912a = "ProxyDetect";

    public static boolean isWifiProxy(Context context) {
        int i;
        String property = null;
        try {
            property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            i = Integer.parseInt(property2);
        } catch (SecurityException e) {
            c.b(f8912a, "message : " + e.getMessage());
            i = 0;
        }
        return (TextUtils.isEmpty(property) || i == -1) ? false : true;
    }
}
