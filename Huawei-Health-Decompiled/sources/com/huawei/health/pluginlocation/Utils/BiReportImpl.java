package com.huawei.health.pluginlocation.Utils;

import android.text.TextUtils;
import defpackage.gbo;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes10.dex */
public class BiReportImpl {
    private static final String TAG = "AAR,BiReportImpl";
    private static BiApi biApi;

    public BiReportImpl(BiApi biApi2) {
        biApi = biApi2;
    }

    public static void setEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        biApi.setEvent(str, linkedHashMap);
    }

    public static void setEventWithReportImmediately(String str, LinkedHashMap<String, String> linkedHashMap) {
        biApi.setEventWithReportImmediately(str, linkedHashMap);
    }

    public static void nativeSetEvent(String str, String str2) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            gbo.c(TAG, "nativeSetEvent data is null");
            return;
        }
        gbo.d(TAG, "eventId is:" + str + ",data is:" + str2);
        String[] strArrSplit = str2.split(";");
        if (strArrSplit.length == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str3 : strArrSplit) {
            String[] strArrSplit2 = str3.split(",");
            if (strArrSplit2.length >= 2) {
                linkedHashMap.put(strArrSplit2[0], strArrSplit2[1]);
            }
        }
        setEvent(str, linkedHashMap);
    }
}
