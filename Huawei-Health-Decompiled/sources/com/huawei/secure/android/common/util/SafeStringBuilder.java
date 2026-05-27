package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes11.dex */
public class SafeStringBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8989a = "SafeStringBuilder";
    private static final String b = "";

    public static String substring(StringBuilder sb, int i) {
        if (TextUtils.isEmpty(sb) || sb.length() < i || i < 0) {
            return "";
        }
        try {
            return sb.substring(i);
        } catch (Exception e) {
            Log.e(f8989a, "substring exception: " + e.getMessage());
            return "";
        }
    }

    public static String substring(StringBuilder sb, int i, int i2) {
        if (TextUtils.isEmpty(sb) || i < 0 || i2 > sb.length() || i2 < i) {
            return "";
        }
        try {
            return sb.substring(i, i2);
        } catch (Exception e) {
            Log.e(f8989a, "substring: " + e.getMessage());
            return "";
        }
    }
}
