package com.huawei.hiai.awareness.util;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public class SystemPropertiesUtil {
    private static final String EMUI_VERSION = "ro.build.version.emui";
    private static final String EMUI_VERSION_HEAD = "EmotionUI_";
    private static final String GET_METHOD = "get";
    private static final String PROPERTY_CLASS = "com.huawei.android.os.SystemPropertiesEx";
    private static final String TAG = "SystemPropertiesUtil";
    private static final String VERSION_COLON_KEY = "\\.";

    private SystemPropertiesUtil() {
    }

    public static int getSystemVersionCode() {
        String prop = getProp(EMUI_VERSION, "");
        try {
            if (prop.length() <= 0 || !prop.startsWith(EMUI_VERSION_HEAD)) {
                return 0;
            }
            return Integer.parseInt(prop.replace(EMUI_VERSION_HEAD, "").split(VERSION_COLON_KEY)[0]);
        } catch (NumberFormatException unused) {
            LogUtil.e(TAG, "getSystemVersionCode NumberFormatException");
            return 0;
        }
    }

    private static String getProp(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName(PROPERTY_CLASS);
            Object objInvoke = cls.getDeclaredMethod(GET_METHOD, String.class, String.class).invoke(cls.newInstance(), str, str2);
            str3 = (objInvoke == null || !(objInvoke instanceof String)) ? null : (String) objInvoke;
        } catch (Exception unused) {
            LogUtil.e(TAG, "System getProp Exception");
        }
        return !TextUtils.isEmpty(str3) ? str3 : str2;
    }
}
