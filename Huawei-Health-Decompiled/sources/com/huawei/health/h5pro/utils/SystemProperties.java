package com.huawei.health.h5pro.utils;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes4.dex */
public class SystemProperties {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f2504a;

    public static void initSystemProperties() {
        if (f2504a != null) {
            return;
        }
        try {
            f2504a = Class.forName("android.os.SystemProperties");
        } catch (ClassNotFoundException e) {
            LogUtil.e("H5PRO_SystemProperties", "SystemProperties -> " + e.getMessage());
        }
    }

    public static String getString(String str, String str2) {
        initSystemProperties();
        if (f2504a != null && !TextUtils.isEmpty(str)) {
            try {
                return (String) f2504a.getMethod("get", String.class, String.class).invoke(f2504a, str, str2);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                LogUtil.e("H5PRO_SystemProperties", "getString -> " + e.getMessage());
            }
        }
        return str2;
    }

    public static int getInt(String str, int i) {
        initSystemProperties();
        if (f2504a != null && !TextUtils.isEmpty(str)) {
            try {
                Object objInvoke = f2504a.getMethod("getInt", String.class, Integer.TYPE).invoke(f2504a, str, Integer.valueOf(i));
                if (objInvoke instanceof Integer) {
                    return ((Integer) objInvoke).intValue();
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                LogUtil.e("H5PRO_SystemProperties", "getInt -> " + e.getMessage());
            }
        }
        return i;
    }
}
