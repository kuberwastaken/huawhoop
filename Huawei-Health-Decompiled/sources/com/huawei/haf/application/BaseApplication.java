package com.huawei.haf.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import health.compact.a.LogUtil;
import health.compact.a.ProcessUtil;
import health.compact.a.ReleaseLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class BaseApplication extends Application {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2100a;
    private static String b;
    private static ActivityStatusMonitor c;
    private static Application d;
    private static int e;

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        xJ_(this);
    }

    static void xJ_(Application application) {
        d = application;
        f2100a = application.getPackageName();
        xH_(application);
        ReleaseLogUtil.d("HAF_BaseApplication", "appType=", d(), ", verName=", i(), ", verCode=", Integer.valueOf(c()), ", procName=", h());
    }

    public static Context a() {
        return d;
    }

    public static String d() {
        return f2100a;
    }

    public static String i() {
        return b;
    }

    public static int c() {
        return e;
    }

    public static Application xD_() {
        return d;
    }

    public static String h() {
        return ProcessUtil.d();
    }

    public static Activity xE_() {
        ActivityStatusMonitor activityStatusMonitor = c;
        if (activityStatusMonitor != null) {
            return activityStatusMonitor.xB_();
        }
        return null;
    }

    public static Activity[] xC_() {
        ActivityStatusMonitor activityStatusMonitor = c;
        if (activityStatusMonitor != null) {
            return activityStatusMonitor.xA_();
        }
        return null;
    }

    public static void b() {
        ActivityStatusMonitor activityStatusMonitor = c;
        if (activityStatusMonitor != null) {
            activityStatusMonitor.b();
        }
    }

    public static boolean j() {
        ActivityStatusMonitor activityStatusMonitor = c;
        if (activityStatusMonitor != null) {
            return activityStatusMonitor.g();
        }
        return false;
    }

    public static boolean c(long j) {
        ActivityStatusMonitor activityStatusMonitor = c;
        if (activityStatusMonitor != null) {
            return activityStatusMonitor.c(j);
        }
        return true;
    }

    public static boolean d(long j) {
        ActivityStatusMonitor activityStatusMonitor = c;
        if (activityStatusMonitor != null) {
            return activityStatusMonitor.e(j);
        }
        return false;
    }

    public static int e(String str) {
        if (c == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        return c.d(str);
    }

    public static void xI_(Application application, boolean z) {
        if (c == null) {
            c = z ? new ActivityMonitor(application) : new ActivityStatusMonitor(true);
        }
    }

    private static void xH_(Application application) {
        PackageInfo packageInfo;
        try {
            packageInfo = application.getPackageManager().getPackageInfo(f2100a, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            LogUtil.b("HAF_BaseApplication", "initVersionInfo() ex=", LogUtil.c(e2));
            packageInfo = null;
        }
        b = xG_(packageInfo);
        e = xF_(packageInfo);
    }

    private static String xG_(PackageInfo packageInfo) {
        String str = packageInfo != null ? packageInfo.versionName : null;
        return TextUtils.isEmpty(str) ? "1.0.0.0" : str;
    }

    private static int xF_(PackageInfo packageInfo) {
        int i = packageInfo != null ? packageInfo.versionCode : 0;
        if (i < 1) {
            return 1;
        }
        return i;
    }
}
