package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.hihonor.android.os.Build;
import com.huawei.hms.android.SystemUtils;
import com.huawei.openalliance.ad.constant.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class bat {
    private static Map<String, Object> b = new HashMap();

    public static boolean h() {
        String str;
        try {
            return bbb.e("hw_sc.product.useBrandCust", false);
        } catch (RuntimeException unused) {
            str = "get isUseBrandCust fail: RuntimeException";
            bbf.b("DeviceUtil", str);
            return false;
        } catch (Exception unused2) {
            str = "get isUseBrandCust fail: Exception";
            bbf.b("DeviceUtil", str);
            return false;
        }
    }

    private static void h(Context context) {
        DisplayMetrics displayMetricsB = b(context);
        if (displayMetricsB != null) {
            b.put("DPI", String.valueOf(displayMetricsB.densityDpi));
            int i = displayMetricsB.widthPixels;
            int i2 = displayMetricsB.heightPixels;
            b.put("RESOLUTION", String.valueOf(i) + "_" + String.valueOf(i2));
        }
    }

    public static boolean j(Context context) {
        return context.getPackageManager().hasSystemFeature("com.huawei.software.features.car");
    }

    public static int j() {
        Integer num = (Integer) b.get("SystemBit");
        if (num != null) {
            return num.intValue();
        }
        Integer numValueOf = Integer.valueOf(bbb.a("ro.product.cpu.abi", "").contains("arm64") ? 2 : 1);
        b.put("SystemBit", numValueOf);
        return numValueOf.intValue();
    }

    public static boolean f(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static int i() {
        return Build.VERSION.SDK_INT;
    }

    public static boolean a(Context context) {
        String str;
        if (context == null) {
            str = "isTelevision: context is null!";
        } else {
            Resources resources = context.getResources();
            if (resources != null) {
                return (resources.getConfiguration().uiMode & 15) == 4;
            }
            str = "isTelevision: resource is null!";
        }
        bbf.c("DeviceUtil", str);
        return false;
    }

    public static String a() {
        String strB = bbb.b("ro.product.hw_model");
        if (TextUtils.isEmpty(strB)) {
            strB = bbb.b("ro.product.hn_model");
            if (TextUtils.isEmpty(strB)) {
                strB = Build.MODEL;
            }
        }
        bbf.b("DeviceUtil", "phoneType:" + strB);
        return strB;
    }

    public static String c(Context context) {
        String str = (String) b.get("DPI");
        if (str != null) {
            return str;
        }
        h(context);
        return (String) b.get("DPI");
    }

    public static String e() {
        String strA;
        try {
            strA = com.hihonor.android.os.Build.MAGIC_VERSION;
        } catch (Error | Exception unused) {
            strA = bbb.a("ro.build.version.magic", "");
        }
        bbf.b("DeviceUtil", "magicVer:" + strA);
        return strA;
    }

    public static String d(Context context) {
        String str = (String) b.get("RESOLUTION");
        if (str != null) {
            return str;
        }
        h(context);
        return (String) b.get("RESOLUTION");
    }

    public static int d() {
        int iA;
        try {
            iA = Build.VERSION.MAGIC_SDK_INT;
        } catch (Error | Exception unused) {
            iA = bbb.a("ro.build.magic_api_level", 0);
        }
        bbf.b("DeviceUtil", "magicApiLevel:" + iA);
        return iA;
    }

    public static String b() {
        return String.valueOf(android.os.Build.DISPLAY);
    }

    public static DisplayMetrics b(Context context) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR);
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String c() {
        return bbb.b(SystemUtils.PRODUCT_BRAND);
    }

    public static int e(Context context) {
        if (a(context)) {
            return 1;
        }
        if (f(context)) {
            return 2;
        }
        return j(context) ? 7 : 0;
    }
}
