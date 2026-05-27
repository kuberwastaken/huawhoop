package com.huawei.hwcloudjs.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.watchface.mvp.model.webview.JsNetwork;

/* JADX INFO: loaded from: classes11.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6423a = "NetUtils";
    public static final String b = "none";
    public static final String c = "unknown";
    public static final String d = "2g";
    public static final String e = "3g";
    public static final String f = "4g";
    public static final String g = "wifi";
    public static final int h = 16;
    public static final int i = 17;
    public static final int j = 18;

    public static boolean b() {
        return !a().equalsIgnoreCase("none");
    }

    public static String a() {
        Context contextA = com.huawei.hwcloudjs.b.a.a();
        if (!(contextA.getSystemService("connectivity") instanceof ConnectivityManager)) {
            return "none";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) contextA.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return "none";
        }
        if (!JsNetwork.NetworkType.MOBILE.equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
            return "wifi";
        }
        switch (activeNetworkInfo.getSubtype()) {
        }
        return "none";
    }
}
