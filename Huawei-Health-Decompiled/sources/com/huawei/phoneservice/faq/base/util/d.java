package com.huawei.phoneservice.faq.base.util;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;

/* JADX INFO: loaded from: classes6.dex */
public class d {
    private static String c;

    public static boolean a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean d() {
        synchronized (d.class) {
            if (c == null) {
                c = d("ro.build.characteristics");
            }
        }
        return "tablet".equals(c) || "car".equals(c) || e();
    }

    public static boolean e(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean c(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) == null) {
            return false;
        }
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
            if (networkInfo != null && networkInfo.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public static boolean c() {
        return f() && a("6.0.0") >= 0;
    }

    public static void cjt_(Activity activity) {
        View viewPeekDecorView;
        if (activity == null || (viewPeekDecorView = activity.getWindow().peekDecorView()) == null || viewPeekDecorView.getWindowToken() == null) {
            return;
        }
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(viewPeekDecorView.getWindowToken(), 0);
    }

    public static int d(Context context) {
        return (a(context) ? b(context) : e(context)) / 2;
    }

    public static int e(Context context) {
        return cjs_(context).widthPixels;
    }

    public static int b(Context context) {
        return cjs_(context).heightPixels;
    }

    private static boolean f() {
        return b("com.huawei.android.os.BuildEx");
    }

    private static boolean e() {
        return "Y".equalsIgnoreCase(i.e().getSdk(FaqConstants.FAQ_IS_OTHER_BRAND_CAR));
    }

    private static String d(String str) {
        Class<?> cls;
        String str2;
        String str3;
        Method declaredMethod = null;
        try {
            cls = Class.forName("android.os.SystemProperties");
        } catch (ClassNotFoundException unused) {
            cls = null;
        } catch (NoSuchMethodException unused2) {
            cls = null;
        } catch (Exception unused3) {
            cls = null;
        }
        try {
            declaredMethod = cls.getDeclaredMethod("get", String.class);
        } catch (ClassNotFoundException unused4) {
            str2 = "ClassNotFoundException";
            h.e("FaqCommonUtils", str2);
        } catch (NoSuchMethodException unused5) {
            str2 = "NoSuchMethodException";
            h.e("FaqCommonUtils", str2);
        } catch (Exception unused6) {
            h.e("FaqCommonUtils", "Exception");
        }
        if (declaredMethod != null) {
            try {
                return (String) declaredMethod.invoke(cls, str);
            } catch (IllegalAccessException unused7) {
                str3 = "IllegalAccessException";
                h.e("FaqCommonUtils", str3);
                return "";
            } catch (IllegalArgumentException unused8) {
                str3 = "IllegalArgumentException";
                h.e("FaqCommonUtils", str3);
                return "";
            } catch (InvocationTargetException unused9) {
                str3 = "InvocationTargetException";
                h.e("FaqCommonUtils", str3);
                return "";
            } catch (Exception unused10) {
                h.e("FaqCommonUtils", "Exception");
            }
        }
        return "";
    }

    private static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static String a() {
        return d("ro.build.version.emui");
    }

    private static String b() {
        try {
            String strA = a();
            if (TextUtils.isEmpty(strA)) {
                return null;
            }
            return strA.split("_")[1];
        } catch (Exception unused) {
            h.e("FaqCommonUtils", "getEmui()  Exception...");
            return null;
        }
    }

    private static DisplayMetrics cjs_(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null) {
            ((WindowManager) context.getSystemService(Constants.NATIVE_WINDOW_SUB_DIR)).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return -1;
        }
        if (str.equals(strB)) {
            return 0;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = strB.split("\\.");
        int length = strArrSplit.length;
        int length2 = strArrSplit2.length;
        int iMin = Math.min(length, length2);
        for (int i = 0; i < iMin; i++) {
            int i2 = Integer.parseInt(strArrSplit[i]);
            int i3 = Integer.parseInt(strArrSplit2[i]);
            if (i2 > i3) {
                return -1;
            }
            if (i2 < i3) {
                return 1;
            }
        }
        return Integer.compare(length2, length);
    }
}
