package com.huawei.phoneservice.faq.base;

import com.huawei.phoneservice.faq.base.util.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class e {
    private static void e(Exception exc, String str) {
        if (exc == null || exc.getMessage() == null) {
            return;
        }
        h.e(str, exc.getMessage());
    }

    public static String d(String str) {
        Exception e;
        Class<?> cls;
        Method declaredMethod;
        try {
            cls = Class.forName("android.os.SystemProperties");
            try {
                declaredMethod = cls.getDeclaredMethod("get", String.class);
            } catch (ClassNotFoundException e2) {
                e = e2;
                e(e, "CommonUtils");
                declaredMethod = null;
            } catch (NoSuchMethodException e3) {
                e = e3;
                e(e, "CommonUtils");
                declaredMethod = null;
            }
        } catch (ClassNotFoundException | NoSuchMethodException e4) {
            e = e4;
            cls = null;
        }
        if (declaredMethod == null) {
            return null;
        }
        try {
            return (String) declaredMethod.invoke(cls, str);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e5) {
            e(e5, "CommonUtils");
            return null;
        }
    }
}
