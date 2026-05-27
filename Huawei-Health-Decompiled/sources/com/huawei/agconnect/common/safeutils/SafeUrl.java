package com.huawei.agconnect.common.safeutils;

import android.text.TextUtils;
import com.huawei.agconnect.common.api.Logger;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes10.dex */
public class SafeUrl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1754a = "SafeUrl";

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.i(f1754a, "url is null");
            return str;
        }
        try {
            return new URL(str.replaceAll("[\\\\#]", "/")).getHost();
        } catch (MalformedURLException e) {
            Logger.e(f1754a, "getHostByURI error  MalformedURLException : " + e.getMessage());
            return "";
        }
    }
}
