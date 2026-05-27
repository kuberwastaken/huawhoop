package com.huawei.haf.bundle.extension;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.huawei.haf.common.utils.CommonConstant;
import health.compact.a.LogUtil;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
final class ComponentInfoReader {
    private ComponentInfoReader() {
    }

    private static Class e() throws ClassNotFoundException {
        return Class.forName("com.huawei.haf.bundle.extension.ComponentInfo");
    }

    static String[] e(String str) {
        return e(str + "_A_", str, "Activities");
    }

    static String[] d(String str) {
        return e(str + "_S_", str, "Services");
    }

    static String[] c(String str) {
        return e(str + "_R_", str, "Receivers");
    }

    static String d(Context context, String str) {
        return c(context, str, b(str));
    }

    static String e(Context context, String str) {
        String strB = b(str);
        String strC = c(context, str, strB + "_desc", null);
        return TextUtils.isEmpty(strC) ? c(context, str, strB) : strC;
    }

    private static String c(Context context, String str, String str2) {
        return c(context, str, str2, str);
    }

    private static String c(Context context, String str, String str2, String str3) {
        try {
            Resources resources = context.getResources();
            return resources.getString(resources.getIdentifier(str2, "string", context.getPackageName()));
        } catch (Resources.NotFoundException e) {
            LogUtil.b("Bundle_ComponentInfoMgr", "getModuleString ", str, ", resId=", str2, ", ex =", LogUtil.c(e));
            return str3;
        }
    }

    private static String b(String str) {
        return a(str + "_T", str, str, "Title");
    }

    private static String[] e(String str, String str2, String str3) {
        int iA = a(str + "N", 0, str2, str3);
        if (iA == 0) {
            return CommonConstant.b;
        }
        String[] strArr = new String[iA];
        for (int i = 0; i < iA; i++) {
            strArr[i] = a(str + i, (String) null, str2, str3);
        }
        return strArr;
    }

    private static String a(String str, String str2, String str3, String str4) {
        Object objD = d(str, str3, str4);
        return objD instanceof String ? ((String) objD).intern() : str2;
    }

    private static int a(String str, int i, String str2, String str3) {
        Object objD = d(str, str2, str3);
        return objD instanceof Integer ? ((Integer) objD).intValue() : i;
    }

    private static Object d(String str, String str2, String str3) {
        try {
            Field field = e().getField(str);
            field.setAccessible(true);
            return field.get(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            LogUtil.c("Bundle_ComponentInfoMgr", "getComponentInfoValue, ", str2, " not exist ", str3);
            return null;
        }
    }
}
