package com.huawei.health.h5pro.utils;

import android.text.TextUtils;
import com.huawei.health.h5pro.vengine.H5ProAppInfo;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class AppInfoUtil {
    public static volatile AppInfoUtil c;
    public static final Object e = new Object();

    public String getPkgNameFromUrl(String str, String str2) {
        int iIndexOf;
        int i;
        int iIndexOf2;
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.startsWith(str2) || (iIndexOf = str.indexOf("/h5pro")) == -1 || (iIndexOf2 = str.indexOf(47, (i = iIndexOf + 7))) == -1) ? "" : str.substring(i, iIndexOf2);
    }

    public String getHostOrPkgNameFroUrl(String str, H5ProAppInfo h5ProAppInfo) {
        if (h5ProAppInfo != null) {
            String pkgNameFromUrl = getPkgNameFromUrl(str, h5ProAppInfo.getBaseUrl());
            if (!TextUtils.isEmpty(pkgNameFromUrl)) {
                return pkgNameFromUrl;
            }
        }
        return getHostFromUrl(str);
    }

    public String getHostFromUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e2) {
            LogUtil.e("H5PRO_AppInfoUtil", "getHostOrPkgName MalformedURLException:" + e2.getMessage());
            return "";
        }
    }

    public String getBaseUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] strArrSplit = str.toLowerCase(Locale.ENGLISH).split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb.insert(0, ".");
            sb.insert(0, str2);
        }
        sb.insert(0, "https://");
        return sb.substring(0, sb.length() - 1);
    }

    public static AppInfoUtil getInstance() {
        if (c == null) {
            synchronized (e) {
                if (c == null) {
                    c = new AppInfoUtil();
                }
            }
        }
        return c;
    }
}
