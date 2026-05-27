package com.huawei.agconnect.common.aaid;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.agconnect.common.api.RandomWrapper;
import com.huawei.agconnect.common.appinfo.SafeAppInfo;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class AaidUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1731a = "aaid";
    public static final String b = "creationTime";

    private static long d(String str) {
        return (((((Long.decode("0x" + str.substring(0, 8)).longValue() << 16) | Long.decode("0x" + str.substring(8, 16)).longValue()) << 16) | Long.decode("0x" + str.substring(16, 24)).longValue()) << 16) | Long.decode("0x" + str.substring(24, 32)).longValue();
    }

    private static String c(String str) {
        String strA = SHACoder.a(str, "SHA-256");
        return ((TextUtils.isEmpty(strA) || strA.length() != 64) ? UUID.randomUUID() : a(strA)).toString();
    }

    static String b(String str) {
        String strC;
        synchronized (AaidUtils.class) {
            strC = c(str + a(32));
        }
        return strC;
    }

    private static UUID a(String str) {
        return new UUID(d(str.substring(0, 32)), d(str.substring(32, 64)));
    }

    public static String a(PushPreferences pushPreferences) {
        String strE;
        synchronized (AaidUtils.class) {
            if (pushPreferences.a(f1731a)) {
                strE = pushPreferences.e(f1731a);
            } else {
                String string = UUID.randomUUID().toString();
                pushPreferences.a(f1731a, string);
                pushPreferences.a(b, Long.valueOf(System.currentTimeMillis()));
                strE = string;
            }
        }
        return strE;
    }

    static String a(Context context) {
        PackageInfo packageInfoSafeGetPackageInfo;
        if (context == null || (packageInfoSafeGetPackageInfo = SafeAppInfo.safeGetPackageInfo(context.getPackageManager(), context.getPackageName(), 64)) == null) {
            return null;
        }
        return packageInfoSafeGetPackageInfo.signatures[0].toCharsString();
    }

    private static String a(int i) {
        return SHACoder.a(RandomWrapper.generateSecureRandom(i));
    }
}
