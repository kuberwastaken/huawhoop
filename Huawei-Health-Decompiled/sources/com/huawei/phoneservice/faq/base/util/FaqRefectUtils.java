package com.huawei.phoneservice.faq.base.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes6.dex */
public class FaqRefectUtils {
    public static void e(Object obj, Class<?> cls, String str, int i) {
        if (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                b(declaredField, true);
                declaredField.set(obj, Integer.valueOf(i));
            } catch (IllegalAccessException | NoSuchFieldException e2) {
                c(e2, "RefectUtilss");
            }
        }
    }

    public enum ResType {
        RES_TYPE_ID("id"),
        RES_TYPE_LAYOUT("layout"),
        RES_TYPE_STRING("string"),
        RES_TYPE_DRAWABLE("drawable"),
        RES_TYPE_XML("xml"),
        RES_TYPE_STYLEABLE("styleable"),
        RES_TYPE_STYLE("style"),
        RES_TYPE_MENU("menu");

        private String type;

        @Override // java.lang.Enum
        public String toString() {
            return this.type;
        }

        ResType(String str) {
            this.type = str;
        }
    }

    public static void b(AccessibleObject accessibleObject, boolean z) {
        if (accessibleObject != null) {
            AccessController.doPrivileged(new e(accessibleObject, z));
        }
    }

    private static void c(Exception exc, String str) {
        if (exc == null || exc.getMessage() == null) {
            return;
        }
        h.e(str, exc.getMessage());
    }

    public static Object a(String str, String str2, Object obj, Class<?>[] clsArr, Object[] objArr) {
        Class<?> cls;
        Object objC;
        if (clsArr != null && objArr != null && clsArr.length == objArr.length) {
            try {
                cls = Class.forName(str);
            } catch (ClassNotFoundException e2) {
                c(e2, "RefectUtilss");
                cls = null;
            }
            if (cls != null && (objC = c(cls, obj)) != null) {
                return b(cls, objC, str2, clsArr, objArr);
            }
        }
        return null;
    }

    class e implements PrivilegedAction<Object> {
        final /* synthetic */ boolean d;
        final /* synthetic */ AccessibleObject e;

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.e.setAccessible(this.d);
            return null;
        }

        e(AccessibleObject accessibleObject, boolean z) {
            this.e = accessibleObject;
            this.d = z;
        }
    }

    private static Object b(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        Method method;
        try {
            method = cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            c(e2, "RefectUtilss");
            method = null;
        }
        if (method != null) {
            try {
                return method.invoke(obj, objArr);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
                c(e3, "RefectUtilss");
            }
        }
        return null;
    }

    public static Object c(Class cls, Object obj) {
        if (cls == null) {
            h.e("RefectUtilss", "getReflectConstructor is null");
            return null;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        declaredConstructors[0].setAccessible(true);
        try {
            return declaredConstructors[0].newInstance(obj);
        } catch (Throwable unused) {
            h.e("RefectUtilss", "getReflectConstructor exception");
            return null;
        }
    }
}
