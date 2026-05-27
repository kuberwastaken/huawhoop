package com.huawei.maps.offlinedata.service.cloud.utils;

import com.huawei.maps.offlinedata.BuildConfig;

/* JADX INFO: loaded from: classes6.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f6695a;
    private static String b;

    public static int a() {
        String strB = b();
        if (strB == null || strB.length() == 0) {
            return f6695a;
        }
        String[] strArrSplit = strB.split("\\.");
        if (strArrSplit.length > 2 && strArrSplit[2].length() == 1) {
            strArrSplit[2] = "0" + strArrSplit[2];
        }
        int length = strArrSplit.length <= 4 ? strArrSplit.length : 4;
        String str = "";
        for (int i = 0; i < length; i++) {
            str = str + strArrSplit[i];
        }
        if (str.length() > 0) {
            f6695a = Integer.parseInt(str);
        }
        return f6695a;
    }

    public static String b() {
        String str = b;
        if (str != null) {
            return str;
        }
        b = BuildConfig.VERSION_NAME;
        return BuildConfig.VERSION_NAME;
    }
}
