package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.huawei.hihealth.dictionary.model.HealthDataMergePolicy;

/* JADX INFO: loaded from: classes6.dex */
public class mlv {
    public static String e(Context context) {
        NetworkInfo.State state;
        mly.a("NetUtils", "getNetType begin", true);
        if (context == null) {
            mly.b("NetUtils", "context is null", true);
            return HealthDataMergePolicy.NONE;
        }
        Context applicationContext = context.getApplicationContext();
        ConnectivityManager connectivityManager = (ConnectivityManager) applicationContext.getSystemService("connectivity");
        if (connectivityManager == null) {
            return HealthDataMergePolicy.NONE;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            mly.b("NetUtils", "activeNetInfo is null or activeNetInfo is not available", true);
            return HealthDataMergePolicy.NONE;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
            return "WIFI";
        }
        if (applicationContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
            mly.a("NetUtils", "no Permission READ_PHONE_STATE", true);
            return HealthDataMergePolicy.NONE;
        }
        return a(applicationContext);
    }

    private static String a(Context context) {
        if (context == null) {
            mly.b("NetUtils", "activity is null", true);
            return HealthDataMergePolicy.NONE;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            mly.b("NetUtils", "telephonyManager is null", true);
            return HealthDataMergePolicy.NONE;
        }
        try {
            int networkType = telephonyManager.getNetworkType();
            mly.a("NetUtils", "networkType is " + networkType, false);
            switch (networkType) {
            }
        } catch (Throwable th) {
            mly.b("NetUtils", "no permission " + th.getClass().getSimpleName(), true);
            return HealthDataMergePolicy.NONE;
        }
        return HealthDataMergePolicy.NONE;
    }
}
