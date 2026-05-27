package com.huawei.watchface;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.android.SystemUtils;
import com.huawei.watchface.utils.HwLog;
import java.lang.reflect.InvocationTargetException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: loaded from: classes8.dex */
public class di {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f11494a = "HONOR".equalsIgnoreCase(a(SystemUtils.PRODUCT_BRAND, ""));
    private static final boolean b = "HUAWEI".equalsIgnoreCase(a(SystemUtils.PRODUCT_BRAND, ""));
    private static final boolean c = a("ro.config.hw_novaThemeSupport", false);
    private static final boolean d;
    private static final boolean e;
    private static final boolean f;
    private static final int g;
    private static final String h;
    private static final Pattern i;

    static {
        d = (a("ro.config.hw_fold_disp", "").isEmpty() && a("persist.sys.fold.disp.size", "").isEmpty()) ? false : true;
        i = Pattern.compile("EmotionUI[ _]([0-9][0-9.]*)");
        e = b("com.huawei.android.os.BuildEx");
        f = g();
        g = k();
        h = i();
    }

    private static boolean f() {
        return e;
    }

    public static boolean a() {
        return f;
    }

    public static int b() {
        return g;
    }

    public static String c() {
        return h;
    }

    public static String a(String str) {
        return a(str, "");
    }

    static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class, String.class).invoke(null, str, str2);
            if (objInvoke instanceof String) {
                str2 = (String) objInvoke;
            }
        } catch (ClassNotFoundException unused) {
            HwLog.e("EnvironmentInfo", "getSystemProperties ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            HwLog.e("EnvironmentInfo", "getSystemProperties IllegalAccessException");
        } catch (NoSuchMethodException unused3) {
            HwLog.e("EnvironmentInfo", "getSystemProperties NoSuchMethodException");
        } catch (InvocationTargetException unused4) {
            HwLog.e("EnvironmentInfo", "getSystemProperties InvocationTargetException");
        }
        HwLog.d("EnvironmentInfo", "emui get system properties value = " + str2);
        return str2;
    }

    public static boolean a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("getBoolean", String.class, Boolean.TYPE).invoke(null, str, Boolean.valueOf(z));
            if (objInvoke instanceof Boolean) {
                z = ((Boolean) objInvoke).booleanValue();
            }
        } catch (ClassNotFoundException unused) {
            HwLog.e("EnvironmentInfo", "isGetSystemProperties ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            HwLog.e("EnvironmentInfo", "isGetSystemProperties IllegalAccessException");
        } catch (IllegalArgumentException unused3) {
            HwLog.e("EnvironmentInfo", "isGetSystemProperties IllegalArgumentException");
        } catch (NoSuchMethodException unused4) {
            HwLog.e("EnvironmentInfo", "isGetSystemProperties NoSuchMethodException");
        } catch (InvocationTargetException unused5) {
            HwLog.e("EnvironmentInfo", "isGetSystemProperties InvocationTargetException");
        }
        HwLog.i("EnvironmentInfo", "isGetSystemPropertiesBoolean isFind = " + z);
        return z;
    }

    public static boolean d() {
        return "HONOR".equals(Build.MANUFACTURER);
    }

    public static boolean e() {
        return d;
    }

    private static boolean g() {
        boolean zH = h();
        HwLog.i("EnvironmentInfo", "checkEmuiSystem, isEmuiBuildEx=" + f() + ", isEmui=" + zH);
        return zH;
    }

    private static boolean h() {
        if (!f()) {
            return false;
        }
        String strA = a("ro.build.version.emui");
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        return strA.contains("EmotionUI");
    }

    private static String i() {
        String strJ = j();
        HwLog.i("EnvironmentInfo", "initEmuiVersion, isEmuiBuildEx=" + f() + ", emuiVersion=" + strJ);
        return strJ;
    }

    private static String j() {
        if (!f()) {
            return "";
        }
        String strA = a("ro.build.version.emui");
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        try {
            Matcher matcher = i.matcher(strA);
            return matcher.find() ? matcher.group(1) : "";
        } catch (PatternSyntaxException e2) {
            HwLog.e("EnvironmentInfo", HwLog.printException((Exception) e2));
            return "";
        }
    }

    private static int k() {
        int iL = l();
        HwLog.i("EnvironmentInfo", "initEmuiVersionCodeEx, isEmuiBuildEx=" + f() + ", emuiVersionCode=" + iL);
        return iL;
    }

    private static int l() {
        if (!f()) {
            return 0;
        }
        String strA = a("ro.build.hw_emui_api_level");
        if (TextUtils.isEmpty(strA)) {
            return 0;
        }
        try {
            return Integer.parseInt(strA);
        } catch (NumberFormatException e2) {
            HwLog.e("EnvironmentInfo", HwLog.printException((Exception) e2));
            return 0;
        }
    }

    private static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            HwLog.e("EnvironmentInfo", "isSupportEmuiBuildEx ClassNotFoundException");
            return false;
        }
    }
}
