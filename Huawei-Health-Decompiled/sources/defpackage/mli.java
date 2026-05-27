package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwidauth.api.ResultCallBack;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.openalliance.ad.constant.ParamConstants;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: loaded from: classes6.dex */
public class mli {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ResultCallBack f15704a = null;
    private static ResultCallBack b = null;
    private static ResultCallBack c = null;
    private static ResultCallBack d = null;
    private static ResultCallBack e = null;
    private static ResultCallBack f = null;
    private static ResultCallBack g = null;
    private static String h = "";
    private static ResultCallBack i;
    private static ResultCallBack j;
    private static ArrayList<String> l = new ArrayList<>();
    private static String n;

    public static String b() {
        return Build.VERSION.SDK_INT >= 33 ? "android.permission.READ_MEDIA_IMAGES" : "android.permission.WRITE_EXTERNAL_STORAGE";
    }

    private static String f(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage().toLowerCase(Locale.getDefault());
    }

    public static String d(Context context) {
        return context.getResources().getConfiguration().locale.getCountry().toLowerCase(Locale.getDefault());
    }

    public static void bXH_(Activity activity) {
        if (mlk.b()) {
            try {
                activity.getWindow().getAttributes().getClass().getDeclaredField(ParamConstants.Param.LAYOUT_IN_DISPLAY_CUTOUT_MODE).set(activity.getWindow().getAttributes(), 1);
            } catch (RuntimeException e2) {
                mly.b("BaseUtil", "RuntimeException: " + e2.getClass().getSimpleName(), true);
            } catch (Exception e3) {
                mly.b("BaseUtil", "Exception: " + e3.getClass().getSimpleName(), true);
            }
        }
    }

    public static boolean e() {
        return mlk.c() || a();
    }

    public static boolean a() {
        return mlk.d() || d();
    }

    public static boolean d() {
        return mlk.a();
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(b(context))) {
            return f(context) + Constants.LINK + d(context).toUpperCase(Locale.getDefault());
        }
        return f(context) + Constants.LINK + b(context) + Constants.LINK + d(context).toUpperCase(Locale.getDefault());
    }

    public static String b(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration == null || configuration.locale == null) {
            return null;
        }
        return configuration.locale.getScript();
    }

    public static byte[] d(String str) {
        if (TextUtils.isEmpty(str)) {
            mly.b("BaseUtil", "getUTF8Bytes, str is empty", true);
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            mly.b("BaseUtil", "getBytes error", true);
            return new byte[0];
        }
    }

    public static boolean c(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.tencent.mm", 0);
            mly.a("BaseUtil", "WXApp Installed", true);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            mly.b("BaseUtil", "NameNotFoundException getVersionTag error", true);
            return 0;
        }
    }

    public static int c(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e2) {
            mly.b("BaseUtil", "parseInt error " + e2.getClass().getSimpleName(), true);
            return -1;
        }
    }

    public static boolean e(String str) {
        try {
            Class.forName(str);
            mly.a("BaseUtil", "isExsitOfClass", true);
            return true;
        } catch (ClassNotFoundException unused) {
            mly.b("BaseUtil", "The class is not existing: ", true);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.os.Bundle bXK_(java.lang.String r3) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            r1 = 1
            if (r0 != 0) goto L21
            r0 = 63
            int r0 = r3.indexOf(r0)
            if (r0 >= 0) goto L15
            r0 = 35
            int r0 = r3.indexOf(r0)
        L15:
            if (r0 <= 0) goto L21
            int r0 = r0 + r1
            java.lang.String r3 = com.huawei.secure.android.common.util.SafeString.substring(r3, r0)
            android.os.Bundle r3 = bXL_(r3)
            goto L22
        L21:
            r3 = 0
        L22:
            java.lang.String r0 = "BaseUtil"
            java.lang.String r2 = "parseUrl"
            defpackage.mly.a(r0, r2, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mli.bXK_(java.lang.String):android.os.Bundle");
    }

    private static Bundle bXL_(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    String str3 = strArrSplit[0];
                    String str4 = strArrSplit[1];
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        bundle.putString(j(str3), j(str4));
                    }
                }
            }
        }
        return bundle;
    }

    private static String j(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            mly.b("BaseUtil", "Exception:" + e.getClass().getSimpleName(), true);
            return str;
        } catch (IllegalArgumentException e3) {
            e = e3;
            mly.b("BaseUtil", "Exception:" + e.getClass().getSimpleName(), true);
            return str;
        } catch (Exception e4) {
            mly.b("BaseUtil", "Exception:" + e4.getClass().getSimpleName(), true);
            return str;
        }
    }

    public static ResultCallBack c() {
        return f15704a;
    }

    public static ResultCallBack i() {
        return e;
    }

    public static ResultCallBack j() {
        return b;
    }

    public static ResultCallBack g() {
        return d;
    }

    public static ResultCallBack h() {
        return c;
    }

    public static void d(ResultCallBack resultCallBack) {
        synchronized (mli.class) {
            d = resultCallBack;
        }
    }

    public static void c(ResultCallBack resultCallBack) {
        synchronized (mli.class) {
            f15704a = resultCallBack;
        }
    }

    public static void a(ResultCallBack resultCallBack) {
        synchronized (mli.class) {
            b = resultCallBack;
        }
    }

    public static ResultCallBack f() {
        return f;
    }

    public static ResultCallBack l() {
        return j;
    }

    public static void e(ResultCallBack resultCallBack) {
        synchronized (mli.class) {
            i = resultCallBack;
        }
    }

    public static ResultCallBack n() {
        return i;
    }

    public static void b(ResultCallBack resultCallBack) {
        synchronized (mli.class) {
            c = resultCallBack;
        }
    }

    public static ResultCallBack m() {
        return g;
    }

    public static void f(ResultCallBack resultCallBack) {
        g = resultCallBack;
    }

    public static String k() {
        return h;
    }

    public static void a(String str) {
        synchronized (mli.class) {
            h = str;
        }
    }

    public static boolean i(Context context) {
        mly.a("BaseUtil", "enter networkIsAvaiable", true);
        if (context == null) {
            return false;
        }
        Object systemService = context.getApplicationContext().getSystemService("connectivity");
        if (systemService == null) {
            mly.a("BaseUtil", "connectivity is null,so networkIsAvaiable is unaviable", true);
            return false;
        }
        NetworkInfo[] allNetworkInfo = ((ConnectivityManager) systemService).getAllNetworkInfo();
        if (allNetworkInfo == null || allNetworkInfo.length == 0) {
            mly.a("BaseUtil", "NetworkInfo is null,so networkIsAvaiable is unaviable", true);
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        }
        mly.a("BaseUtil", "NetworkInfo state is unaviable", true);
        return false;
    }

    public static boolean bXI_(Bundle bundle) {
        return (bundle == null || TextUtils.isEmpty(bundle.getString("code", null))) ? false : true;
    }

    public static String o() {
        try {
            Object objE = mlw.e("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.config.marketing_name"});
            if (objE != null) {
                return (String) objE;
            }
        } catch (Exception e2) {
            mly.d("BaseUtil", e2.getClass().getSimpleName(), true);
        }
        return "";
    }

    public static void f(String str) {
        n = str;
    }

    public static String t() {
        return n;
    }

    public static ArrayList<String> r() {
        return l;
    }

    public static void d(ArrayList<String> arrayList) {
        l = arrayList;
    }

    public static void bXJ_(Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        c(activity.getWindow(), "addPrivateFlags", new Object[]{524288}, new Class[]{Integer.TYPE});
    }

    public static String s() {
        return System.currentTimeMillis() + q();
    }

    public static String q() {
        SecureRandom secureRandomE = mmd.e();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 19; i2++) {
            sb.append(secureRandomE.nextInt(10));
        }
        return sb.toString();
    }

    public static Object c(final Object obj, final String str, final Object[] objArr, final Class[] clsArr) {
        if (obj == null) {
            return null;
        }
        try {
            AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: mli.2
                @Override // java.security.PrivilegedAction
                public Object run() {
                    Method methodB = mli.b(obj, str, objArr, clsArr);
                    if (methodB != null) {
                        methodB.setAccessible(true);
                        try {
                            return methodB.invoke(obj, objArr);
                        } catch (IllegalAccessException e2) {
                            mly.a("BaseUtil", e2.getClass().getSimpleName(), true);
                        } catch (IllegalArgumentException e3) {
                            mly.a("BaseUtil", e3.getClass().getSimpleName(), true);
                        } catch (InvocationTargetException e4) {
                            mly.a("BaseUtil", e4.getClass().getSimpleName(), true);
                        }
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            mly.b("BaseUtil", "Exception: " + e2.getClass().getSimpleName(), true);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Method b(Object obj, String str, Object[] objArr, Class[] clsArr) {
        for (Class<?> superclass = obj.getClass(); superclass != Object.class; superclass = superclass.getSuperclass()) {
            try {
                return superclass.getDeclaredMethod(str, clsArr);
            } catch (NoSuchMethodException e2) {
                mly.a("BaseUtil", e2.getClass().getSimpleName(), true);
            } catch (SecurityException e3) {
                mly.a("BaseUtil", e3.getClass().getSimpleName(), true);
            }
        }
        return null;
    }

    public static String d(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static String p() {
        try {
            Object objE = mlw.e("android.os.SystemProperties", "get", new Class[]{String.class, String.class}, new Object[]{"ro.build.version.emui", ""});
            return objE != null ? (String) objE : "";
        } catch (Exception e2) {
            mly.d("BaseUtil", e2.getClass().getSimpleName(), true);
            return "";
        }
    }

    public static String i(String str) {
        return str != null ? str.replaceAll("\\s", "") : "";
    }
}
