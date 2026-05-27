package com.huawei.maps.offlinedata.service.cloud.utils;

import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.maps.offlinedata.utils.g;
import com.huawei.openalliance.ad.beans.inner.CountryCodeBean;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f6694a;

    public static String a() {
        String str = f6694a;
        if (str != null) {
            return str;
        }
        if (b()) {
            g.a("CountryCodeUtil", "airplane Mode is on");
            return "UNKNOWN";
        }
        String strD = d();
        f6694a = strD;
        if (TextUtils.isEmpty(strD) && !c()) {
            f6694a = f();
        }
        if (TextUtils.isEmpty(f6694a)) {
            f6694a = "UNKNOWN";
            g.a("CountryCodeUtil", "get countryCode is UNKNOWN");
        }
        g.b("CountryCodeUtil", "getLocatorCountryCode：" + f6694a);
        return f6694a;
    }

    public static boolean b() {
        return Settings.Global.getInt(com.huawei.maps.offlinedata.utils.a.a().getApplicationContext().getContentResolver(), "airplane_mode_on", 0) != 0;
    }

    public static boolean c() {
        try {
            Object systemService = com.huawei.maps.offlinedata.utils.a.a().getApplicationContext().getSystemService("phone");
            if (systemService instanceof TelephonyManager) {
                return ((TelephonyManager) systemService).isNetworkRoaming();
            }
            return false;
        } catch (Exception e) {
            g.d("CountryCodeUtil", e.getMessage());
            return false;
        }
    }

    public static String d() {
        Object systemService;
        try {
            if (e() || (systemService = com.huawei.maps.offlinedata.utils.a.a().getSystemService("phone")) == null || !(systemService instanceof TelephonyManager)) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            return telephonyManager.getPhoneType() != 2 ? a(telephonyManager.getNetworkCountryIso()) : "";
        } catch (Exception unused) {
            g.d("CountryCodeUtil", "getNetworkCountryCode exception");
            return "";
        }
    }

    public static boolean e() {
        Object systemService = com.huawei.maps.offlinedata.utils.a.a().getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            int simState = ((TelephonyManager) systemService).getSimState();
            z = simState == 0 || simState == 1 || simState == 2 || simState == 3 || simState == 6 || simState == 7 || simState == 8;
            g.b("CountryCodeUtil", "simState:" + simState);
        }
        return z;
    }

    public static String f() {
        try {
            Object systemService = com.huawei.maps.offlinedata.utils.a.a().getSystemService("phone");
            if (!(systemService instanceof TelephonyManager)) {
                return "";
            }
            TelephonyManager telephonyManager = (TelephonyManager) systemService;
            return a(telephonyManager.getSimState() == 5 ? telephonyManager.getSimCountryIso() : null);
        } catch (Exception e) {
            g.d("CountryCodeUtil", e.getMessage());
            return "";
        }
    }

    private static String a(String str) {
        return (TextUtils.isEmpty(str) || str.length() != 2) ? "" : str;
    }

    public static String g() {
        Locale locale = Locale.getDefault();
        if (locale != null) {
            return locale.getCountry();
        }
        return null;
    }

    public static String h() {
        String property = SystemPropUtils.getProperty("get", CountryCodeBean.VENDORCOUNTRY_SYSTEMPROP, "android.os.SystemProperties", "UNKNOWN");
        return (TextUtils.isEmpty(property) || "UNKNOWN".equals(property)) ? SystemPropUtils.getProperty("get", CountryCodeBean.VENDORCOUNTRY_SYSTEMPROP_HN, "android.os.SystemProperties", "UNKNOWN") : property;
    }
}
