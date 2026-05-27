package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.text.TextUtils;
import com.huawei.hianalytics.core.transport.Utils;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class wru {
    private static Context b;

    public static void e(Context context) {
        if (context != null) {
            b = context.getApplicationContext();
        }
    }

    public static Context e() {
        return b;
    }

    public static boolean c(String str) {
        return !TextUtils.isEmpty(str) && str.length() <= 255;
    }

    public static boolean b(int i, String str) {
        if (TextUtils.isEmpty(str)) {
            wro.d(Utils.TAG, "isValidSrcPkgName srcPkgName is null");
            return false;
        }
        wro.a(Utils.TAG, "client srcPkgNames:" + str);
        String[] packagesForUid = e().getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null) {
            wro.a(Utils.TAG, "calling uid srcPkgNames:" + Arrays.toString(packagesForUid));
            int length = packagesForUid.length;
            for (int i2 = 0; i2 < length; i2++) {
                String str2 = packagesForUid[i2];
                if ("com.huawei.health".equals(str2) || str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int a() {
        return Binder.getCallingUid();
    }

    public static int b() {
        return Binder.getCallingPid();
    }

    public static Intent fBF_(Intent intent) {
        PackageManager packageManager = e().getPackageManager();
        if (packageManager == null) {
            wro.d(Utils.TAG, "getPackageManager is null");
            return null;
        }
        List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.size() != 1) {
            wro.e(Utils.TAG, "implicitIntent List are null");
            return null;
        }
        ResolveInfo resolveInfo = listQueryIntentServices.get(0);
        ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }
}
