package com.huawei.agconnect.credential.obs;

import android.content.Context;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f1816a;
    private static final List<String> b;

    public static c a(Context context, String str, String str2, String str3) {
        if (str3 != null) {
            List<String> list = b;
            Locale locale = Locale.ENGLISH;
            if (list.contains(str3.toUpperCase(locale))) {
                return e.a(context, new f(str, str2, str3.toUpperCase(locale)));
            }
        }
        Log.e("HiAnalyticsBridge", "RoutePolicy check failed: ".concat(String.valueOf(str3)));
        return null;
    }

    public static c a(Context context, String str, String str2) {
        return e.a(context, new f(str, str2, ""));
    }

    static {
        String[] strArr = {"CN", "DE", "SG", "RU", "UNKNOWN"};
        f1816a = strArr;
        b = Collections.unmodifiableList(Arrays.asList(strArr));
    }
}
