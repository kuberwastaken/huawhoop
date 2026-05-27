package com.huawei.hidatamanager.hwnaturalbase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.hidatamanager.util.LogUtils;

/* JADX INFO: loaded from: classes5.dex */
public class NBValidated {
    private static final String ODMF_PACKAGE_NAME = "com.huawei.nb.service";
    private static final String TAG = "NBValidated";

    public static boolean isOdmfInstalled(Context context) {
        boolean zCheckApkExist;
        synchronized (NBValidated.class) {
            zCheckApkExist = checkApkExist(context, ODMF_PACKAGE_NAME);
        }
        return zCheckApkExist;
    }

    private static boolean checkApkExist(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                return context.getPackageManager().getApplicationInfo(str, 0) != null;
            } catch (PackageManager.NameNotFoundException unused) {
                LogUtils.w(TAG, "depended package:" + str + " does n't exist!");
            }
        }
        return false;
    }
}
