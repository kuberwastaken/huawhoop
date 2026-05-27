package com.huawei.updatesdk.a.a.d.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes8.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f11316a;

    public static boolean d(Context context) {
        ConnectivityManager connectivityManagerB;
        if (context == null || (connectivityManagerB = b(context)) == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManagerB.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return a(connectivityManagerB);
        }
        return true;
    }

    public static int c(Context context) {
        return a(a(context));
    }

    private static ConnectivityManager b(Context context) {
        if (f11316a == null) {
            f11316a = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        }
        return f11316a;
    }

    private static boolean a(ConnectivityManager connectivityManager) {
        NetworkCapabilities networkCapabilities;
        Network activeNetwork = connectivityManager.getActiveNetwork();
        if (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null) {
            return false;
        }
        return networkCapabilities.hasCapability(16);
    }

    private static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManagerB = b(context);
        if (connectivityManagerB != null) {
            return connectivityManagerB.getActiveNetworkInfo();
        }
        return null;
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (1 == type || 13 == type) {
                return 1;
            }
            if (type == 0) {
                switch (networkInfo.getSubtype()) {
                }
                return 1;
            }
        }
        return 0;
    }
}
