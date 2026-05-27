package com.huawei.haf.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import com.huawei.haf.application.BaseApplication;
import health.compact.a.LogUtil;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class AppInfoUtils {
    private AppInfoUtils() {
    }

    public static File a(String str) {
        File dataDir = BaseApplication.a().getDataDir();
        return TextUtils.isEmpty(str) ? dataDir : new File(dataDir, str);
    }

    public static File h(String str) {
        File filesDir = BaseApplication.a().getFilesDir();
        return TextUtils.isEmpty(str) ? filesDir : new File(filesDir, str);
    }

    public static File d(String str) {
        File cacheDir = BaseApplication.a().getCacheDir();
        return TextUtils.isEmpty(str) ? cacheDir : new File(cacheDir, str);
    }

    public static File e(String str) {
        File externalCacheDir;
        File parentFile = (!"mounted".equals(Environment.getExternalStorageState()) || (externalCacheDir = BaseApplication.a().getExternalCacheDir()) == null) ? null : externalCacheDir.getParentFile();
        if (TextUtils.isEmpty(str)) {
            return parentFile;
        }
        if (parentFile != null) {
            return new File(parentFile, str);
        }
        return null;
    }

    public static File b(String str) {
        File externalFilesDir = "mounted".equals(Environment.getExternalStorageState()) ? BaseApplication.a().getExternalFilesDir(null) : null;
        if (TextUtils.isEmpty(str)) {
            return externalFilesDir;
        }
        if (externalFilesDir != null) {
            return new File(externalFilesDir, str);
        }
        return null;
    }

    public static File c(String str) {
        File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? BaseApplication.a().getExternalCacheDir() : null;
        if (TextUtils.isEmpty(str)) {
            return externalCacheDir;
        }
        if (externalCacheDir != null) {
            return new File(externalCacheDir, str);
        }
        return null;
    }

    public static String b() {
        return BaseApplication.d();
    }

    public static String g() {
        return BaseApplication.i();
    }

    public static int d() {
        return BaseApplication.c();
    }

    public static String a() {
        Context contextA = BaseApplication.a();
        return contextA.getApplicationInfo().loadLabel(contextA.getPackageManager()).toString();
    }

    public static long e() {
        PackageInfo packageInfoZb_ = zb_(0);
        if (packageInfoZb_ != null) {
            return packageInfoZb_.firstInstallTime;
        }
        return 0L;
    }

    public static long c() {
        PackageInfo packageInfoZb_ = zb_(0);
        if (packageInfoZb_ != null) {
            return packageInfoZb_.lastUpdateTime;
        }
        return 0L;
    }

    private static PackageInfo zb_(int i) {
        try {
            Context contextA = BaseApplication.a();
            return contextA.getPackageManager().getPackageInfo(contextA.getPackageName(), i);
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.b("HAF_AppInfoUtils", "getPackageInfo fail, ex=", LogUtil.c(e));
            return null;
        }
    }
}
