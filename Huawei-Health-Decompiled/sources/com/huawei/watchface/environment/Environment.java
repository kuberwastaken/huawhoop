package com.huawei.watchface.environment;

import android.R;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import com.huawei.watchface.dj;
import com.huawei.watchface.utils.HwLog;

/* JADX INFO: loaded from: classes8.dex */
public final class Environment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Application f11517a = null;
    private static String b = null;
    public static volatile boolean sIsAarInTheme = false;

    private Environment() {
    }

    public static void setApplication(Application application) {
        if (f11517a == null) {
            f11517a = application;
        }
        d();
    }

    public static Context a() {
        Application application = f11517a;
        if (application == null) {
            return null;
        }
        Resources resources = application.getResources();
        int identifier = resources == null ? 0 : resources.getIdentifier("androidhwext:style/Theme.Emui", null, null);
        if (identifier == 0) {
            return new ContextThemeWrapper(f11517a, R.style.Theme.Material);
        }
        return new ContextThemeWrapper(f11517a, identifier);
    }

    public static Application getApplicationContext() {
        return f11517a;
    }

    private static void d() {
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            sIsAarInTheme = false;
        } else {
            sIsAarInTheme = strB.equals(dj.f());
        }
    }

    public static Object a(String str) {
        Application application;
        if (TextUtils.isEmpty(str) || (application = f11517a) == null) {
            return null;
        }
        try {
            return application.getSystemService(str);
        } catch (Exception e) {
            HwLog.e(HwLog.TAG, "getSystemService error " + HwLog.printException(e));
            return null;
        }
    }

    public static String b() {
        Application application = f11517a;
        return application == null ? "" : application.getApplicationInfo().packageName;
    }

    public static String c() {
        if (TextUtils.isEmpty(b)) {
            b = AGConnectInstance.getInstance().getOptions().getString(AgConnectInfo.AgConnectKey.APPLICATION_ID);
            HwLog.i("Environment", "getHMSAppId: appId: " + b);
        }
        return b;
    }
}
