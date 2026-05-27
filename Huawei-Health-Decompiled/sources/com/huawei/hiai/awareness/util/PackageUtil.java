package com.huawei.hiai.awareness.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes10.dex */
public class PackageUtil {
    public static final String HIAI_PACKAGE_NAME = "com.huawei.hiai";
    private static final String TAG = "PackageUtil";

    public static boolean isSystemAppOrHasSameSignatureByUri(Context context, Uri uri) {
        if (context == null) {
            LogUtil.e(TAG, "context is null");
            return false;
        }
        if (uri == null) {
            LogUtil.e(TAG, "uri is null");
            return false;
        }
        String authority = uri.getAuthority();
        if (authority == null) {
            LogUtil.e(TAG, "the authority of uri is null");
            return false;
        }
        try {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            if (providerInfoResolveContentProvider == null) {
                LogUtil.e(TAG, "providerInfo is null");
                return false;
            }
            ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
            if (applicationInfo == null) {
                LogUtil.e(TAG, "applicationInfo of providerInfo is null");
                return false;
            }
            String str = applicationInfo.packageName;
            LogUtil.i(TAG, "the package name of the target provider is " + str);
            if (TextUtils.isEmpty(str)) {
                LogUtil.e(TAG, "the name of the package is empty");
                return false;
            }
            if (isSameSignatureWithHiai(context, str)) {
                LogUtil.i(TAG, str + " has same signature with hiai");
                return true;
            }
            if (isSystemApp(applicationInfo)) {
                LogUtil.i(TAG, str + " is system app");
                return true;
            }
            LogUtil.e(TAG, str + " is neither system app nor has same signature with hiai");
            return false;
        } catch (Exception unused) {
            LogUtil.e(TAG, "resolveContentProvider failed");
            return false;
        }
    }

    private static boolean isSameSignatureWithHiai(Context context, String str) {
        return context.getPackageManager().checkSignatures("com.huawei.hiai", str) == 0;
    }

    private static boolean isSystemApp(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) == 1;
    }
}
