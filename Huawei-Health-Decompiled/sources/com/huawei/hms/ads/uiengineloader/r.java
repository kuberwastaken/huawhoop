package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4576a = "r";
    private static final String b = "presplits";
    private static final String c = ",";

    private static Set<q> b(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (Throwable th) {
            af.d(f4576a, "getMetaSplits:cannot find the package:" + str + "info." + th.getClass().getSimpleName());
            applicationInfo = null;
        }
        return a(context, applicationInfo, str);
    }

    public static Set<q> a(Context context, ApplicationInfo applicationInfo, String str) {
        HashSet hashSet = new HashSet();
        if (context != null && applicationInfo != null) {
            try {
                if (applicationInfo.metaData != null) {
                    String string = applicationInfo.metaData.getString(b);
                    if (TextUtils.isEmpty(string)) {
                        af.b(f4576a, "No metadata: presplits found.");
                        return hashSet;
                    }
                    String[] strArrSplit = string.split(",");
                    HashMap<String, String> mapA = a(context, str);
                    if (strArrSplit.length != 0 && !mapA.isEmpty()) {
                        for (String str2 : strArrSplit) {
                            for (Map.Entry<String, String> entry : mapA.entrySet()) {
                                if (str2.equals(entry.getKey())) {
                                    hashSet.add(new q(new File(entry.getValue()), entry.getKey()));
                                }
                            }
                        }
                    }
                    return hashSet;
                }
            } catch (Throwable th) {
                af.c(f4576a, "getSplitsInfo err: " + th.getClass().getSimpleName());
            }
        }
        return hashSet;
    }

    private static HashMap<String, String> a(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        HashMap<String, String> map = new HashMap<>();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 128);
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
        } catch (PackageManager.NameNotFoundException e) {
            af.c(f4576a, "getSourceDir:cannot find the package:" + str + " info." + e.getClass().getSimpleName());
        } catch (Throwable th) {
            af.c(f4576a, "getSourceDir ex: " + th.getClass().getSimpleName());
        }
        if (packageInfo.splitNames != null && applicationInfo.splitSourceDirs != null) {
            int iMin = Math.min(packageInfo.splitNames.length, applicationInfo.splitSourceDirs.length);
            for (int i = 0; i < iMin; i++) {
                map.put(packageInfo.splitNames[i], applicationInfo.splitSourceDirs[i]);
            }
            return map;
        }
        af.c(f4576a, "splitNames or splitSourceDirs is null.");
        return map;
    }
}
