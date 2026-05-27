package com.huawei.hms.support.hwid.common.e;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

/* JADX INFO: loaded from: classes10.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Boolean f6196a;

    public static boolean a(Context context) {
        if (context == null) {
            g.c("SDKUtil", "context is null", true);
            return false;
        }
        Boolean bool = f6196a;
        if (bool != null && !bool.booleanValue()) {
            g.a("SDKUtil", "isPhoneStillInLockMode is already false", true);
            return false;
        }
        UserManager userManager = (UserManager) context.getSystemService(UserManager.class);
        if (userManager == null) {
            g.c("SDKUtil", "userManager is null.", true);
            return false;
        }
        if (!userManager.isUserUnlocked()) {
            g.c("SDKUtil", "isPhoneStillInLockMode true", true);
            f6196a = true;
        } else {
            f6196a = false;
            g.a("SDKUtil", "isPhoneStillInLockMode false", true);
        }
        g.c("SDKUtil", "Build.VERSION.SDK_INT : " + Build.VERSION.SDK_INT + " isPhoneStillInLockMode " + f6196a, true);
        Boolean bool2 = f6196a;
        return bool2 != null && bool2.booleanValue();
    }
}
