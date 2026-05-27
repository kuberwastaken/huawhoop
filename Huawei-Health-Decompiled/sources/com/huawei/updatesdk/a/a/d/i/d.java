package com.huawei.updatesdk.a.a.d.i;

import com.huawei.hms.mlsdk.asr.MLAsrConstants;

/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11314a = -1;

    public static int a() {
        if (f11314a == -1) {
            f11314a = (MLAsrConstants.LAN_ZH.equals(c.a("ro.product.locale.language", "")) && "CN".equals(c.a("ro.product.locale.region", ""))) ? 0 : 1;
        }
        return f11314a;
    }
}
