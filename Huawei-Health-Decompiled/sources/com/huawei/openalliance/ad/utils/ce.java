package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.text.TextUtils;
import com.huawei.openalliance.ad.hq;

/* JADX INFO: loaded from: classes11.dex */
public class ce {
    private static String a(Context context, int i) {
        return null;
    }

    public static String a(Context context, int i, int i2) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            String nameForUid = packageManager.getNameForUid(i);
            if (!TextUtils.isEmpty(nameForUid) && nameForUid.contains(":")) {
                hq.b("PackageNameUtil", "pkg=" + nameForUid);
                nameForUid = a(context, i2);
            }
            if (!TextUtils.isEmpty(nameForUid)) {
                return nameForUid;
            }
            String[] packagesForUid = packageManager.getPackagesForUid(i);
            return !bj.a(packagesForUid) ? packagesForUid[0] : nameForUid;
        } catch (Throwable unused) {
            hq.c("PackageNameUtil", "get name for uid error");
            return "";
        }
    }

    public static String a(Context context) {
        if (context.getPackageManager() != null) {
            return a(context, Binder.getCallingUid(), Binder.getCallingPid());
        }
        hq.c("PackageNameUtil", "pm is null");
        return "";
    }
}
