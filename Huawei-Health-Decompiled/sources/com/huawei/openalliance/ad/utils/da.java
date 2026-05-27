package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.openalliance.ad.hq;
import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public abstract class da {
    public static String g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                return ah.h(externalCacheDir);
            }
            return null;
        } catch (Exception unused) {
            hq.c("StorageUtils", "getExternalFilesDir exception, use memory card folder.");
            return null;
        }
    }

    public static String f(Context context) {
        File cacheDir;
        return (context == null || (cacheDir = context.getCacheDir()) == null) ? "" : ah.h(cacheDir);
    }

    public static String e(Context context) {
        if (context == null) {
            return "";
        }
        try {
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                return ah.h(externalFilesDir);
            }
        } catch (Exception unused) {
            hq.c("StorageUtils", "getExternalFilesDir exception, use memory card folder.");
        }
        return null;
    }

    public static String d(Context context) {
        File filesDir;
        return (context == null || (filesDir = context.getFilesDir()) == null) ? "" : ah.h(filesDir);
    }

    public static String c(Context context) {
        String strG;
        return (!a() || Build.VERSION.SDK_INT > 27 || (strG = g(context)) == null) ? f(context) : strG;
    }

    protected static boolean b() {
        try {
            if (dh.a()) {
                return Environment.isExternalStorageRemovable();
            }
            return true;
        } catch (Throwable th) {
            hq.c("StorageUtils", "isExternalStorageRemovable, " + th.getClass().getSimpleName());
            return true;
        }
    }

    public static String b(Context context) {
        String strE;
        return (!a() || Build.VERSION.SDK_INT > 27 || (strE = e(context)) == null) ? d(context) : strE;
    }

    public static boolean a() {
        return TextUtils.equals("mounted", Environment.getExternalStorageState()) || !b();
    }

    public static String a(Context context) {
        String strE;
        return (!a() || (strE = e(context)) == null) ? d(context) : strE;
    }
}
