package com.huawei.hms.common.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import defpackage.mly;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class PresetUtil {
    public static boolean isSystemApp(Context context, String str) {
        PackageInfo packageInfo;
        boolean z = false;
        if (context == null) {
            mly.b("PresetUtil", "Invalid context.", true);
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            mly.a("PresetUtil", "Invalid pkgName.", true);
            return false;
        }
        mly.c("PresetUtil", "pkgName: " + str, true);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e) {
            mly.b("PresetUtil", "getSystemApp flag error for " + str + ":" + e.getMessage(), true);
            packageInfo = null;
        }
        if (packageInfo != null && (packageInfo.applicationInfo.flags & 1) != 0) {
            z = true;
        }
        mly.c("PresetUtil", "isSystemApp: " + z, true);
        return z;
    }

    public static boolean isPrivApp(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null) {
            mly.b("PresetUtil", "Invalid context.", true);
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            mly.b("PresetUtil", "Invalid pkgName.", true);
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (PackageManager.NameNotFoundException e) {
            mly.b("PresetUtil", "getPrivAppFlag err for " + str + ":" + e.getMessage(), true);
            packageInfo = null;
        }
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            mly.a("PresetUtil", "Get pkg application null:" + str, true);
            return false;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        try {
            final Field field = applicationInfo.getClass().getField("privateFlags");
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.common.utils.PresetUtil.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    field.setAccessible(true);
                    return null;
                }
            });
            Object obj = field.get(applicationInfo);
            if (!(obj instanceof Integer)) {
                mly.a("PresetUtil", "Get privFlag instance error.", true);
                return false;
            }
            int iIntValue = ((Integer) obj).intValue();
            mly.c("PresetUtil", "privFlag of " + str + " is:" + iIntValue, true);
            return (iIntValue & 8) != 0;
        } catch (IllegalAccessException | NoSuchFieldException e2) {
            mly.b("PresetUtil", "getPrivAppFlag err for " + str + ":" + e2.getMessage(), true);
            return false;
        }
    }

    public static String getSystemAppPackage(Context context, Intent intent) {
        String str;
        if (context != null && intent != null) {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) {
                mly.a("PresetUtil", "empty sys pkg", true);
            } else {
                for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                    if (resolveInfo.activityInfo != null && (str = resolveInfo.activityInfo.packageName) != null) {
                        boolean zIsSystemApp = isSystemApp(context, str);
                        boolean zIsPrivApp = isPrivApp(context, str);
                        mly.a("PresetUtil", "sys app pkg: " + str + ", " + zIsSystemApp + zIsPrivApp, true);
                        if (zIsSystemApp || zIsPrivApp) {
                            return str;
                        }
                    }
                }
                return "";
            }
        }
        return "";
    }

    public static String getSystemAppPackage(Context context, Intent intent, HashSet<String> hashSet) {
        String str;
        String str2 = "";
        if (context != null && intent != null) {
            List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (listQueryIntentActivities == null || listQueryIntentActivities.size() == 0) {
                mly.a("PresetUtil", "empty sys pkg", true);
            } else {
                String str3 = "";
                for (ResolveInfo resolveInfo : listQueryIntentActivities) {
                    if (resolveInfo.activityInfo != null && (str = resolveInfo.activityInfo.packageName) != null) {
                        boolean zIsSystemApp = isSystemApp(context, str);
                        boolean zIsPrivApp = isPrivApp(context, str);
                        mly.a("PresetUtil", "sys app pkg: " + str + ", " + zIsSystemApp + zIsPrivApp, true);
                        if (zIsSystemApp || zIsPrivApp) {
                            if (TextUtils.isEmpty(str3)) {
                                str3 = str;
                            }
                            if (hashSet == null || !hashSet.contains(str)) {
                                str2 = str;
                                break;
                            }
                        }
                    }
                }
                return !TextUtils.isEmpty(str2) ? str2 : str3;
            }
        }
        return "";
    }
}
