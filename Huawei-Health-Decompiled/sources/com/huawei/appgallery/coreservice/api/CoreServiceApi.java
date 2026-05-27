package com.huawei.appgallery.coreservice.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.appgallery.coreservice.e;
import defpackage.baa;
import defpackage.bab;

/* JADX INFO: loaded from: classes10.dex */
public abstract class CoreServiceApi {
    public static void setHomeCountry(Context context, String str) {
        baa.a().d(context, str);
    }

    @Deprecated
    public static void setAppName(Context context, String str) {
        baa.a().b(context, str);
    }

    public static IConnectionResult getGuideInstallPendingIntent(Context context) {
        return e.d(context);
    }

    public static String getAppGalleryPkg(Context context) {
        return e.e(context);
    }

    public static AppGalleryInfo getAppGalleryInfo(Context context) {
        String strE = e.e(context);
        if (TextUtils.isEmpty(strE)) {
            return null;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(strE, 128);
            if (packageInfo != null) {
                return new AppGalleryInfo(packageInfo.versionName, packageInfo.versionCode);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            bab.b("CoreServiceApi", "NameNotFoundException ");
        } catch (RuntimeException unused2) {
            bab.d("CoreServiceApi", "getPackageInfo RuntimeException");
        }
        return null;
    }
}
