package com.huawei.hms.ads.inner;

import android.content.Context;

/* JADX INFO: loaded from: classes10.dex */
public class HwECApi {
    public static void setECCallback(IECCallback iECCallback) {
        com.huawei.openalliance.ad.inter.a.a().a(iECCallback);
    }

    public static void setAccessToken(String str) {
        com.huawei.openalliance.ad.inter.a.a().a(str);
    }

    public static boolean openLandingPage(Context context, String str) {
        return com.huawei.openalliance.ad.inter.a.a().a(context, str);
    }
}
