package com.huawei.phoneservice.faq.base.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* JADX INFO: loaded from: classes6.dex */
public class j {
    public static void a(Context context) {
        d(context);
        c(context);
        e(context);
    }

    private static void d(Context context) {
        InputMethodManager inputMethodManager;
        StringBuilder sb;
        String message;
        if (context == null || (inputMethodManager = (InputMethodManager) context.getSystemService("input_method")) == null) {
            return;
        }
        String[] strArr = {"mCurRootView", "mServedView", "mNextServedView"};
        for (int i = 0; i < 3; i++) {
            try {
                Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                if (!declaredField.isAccessible()) {
                    AccessController.doPrivileged(new c(declaredField));
                }
                Object obj = declaredField.get(inputMethodManager);
                if (obj != null && (obj instanceof View)) {
                    if (((View) obj).getContext() != context) {
                        break;
                    } else {
                        declaredField.set(inputMethodManager, null);
                    }
                }
            } catch (ExceptionInInitializerError e2) {
                sb = new StringBuilder("ExceptionInInitializerError");
                message = e2.getMessage();
                sb.append(message);
                h.a("FaqMemoryLeakUtils", sb.toString());
                return;
            } catch (NoSuchMethodException e3) {
                sb = new StringBuilder("NoSuchMethodException:");
                message = e3.getMessage();
                sb.append(message);
                h.a("FaqMemoryLeakUtils", sb.toString());
                return;
            } catch (ReflectiveOperationException e4) {
                sb = new StringBuilder("ReflectiveOperationException");
                message = e4.getMessage();
                sb.append(message);
                h.a("FaqMemoryLeakUtils", sb.toString());
                return;
            } catch (Exception e5) {
                sb = new StringBuilder("Exception");
                message = e5.getMessage();
                sb.append(message);
                h.a("FaqMemoryLeakUtils", sb.toString());
                return;
            }
        }
        cjA_(inputMethodManager);
    }

    private static void c(Context context) {
        StringBuilder sb;
        String message;
        try {
            Class<?> cls = Class.forName("android.gestureboost.GestureBoostManager");
            Field declaredField = cls.getDeclaredField("sGestureBoostManager");
            AccessController.doPrivileged(new b(declaredField));
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mContext");
            AccessController.doPrivileged(new d(declaredField2));
            if (context == declaredField2.get(obj)) {
                h.a("FaqMemoryLeakUtils", "Checked GestureBoostManagerLeak");
                declaredField2.set(obj, null);
            }
        } catch (ExceptionInInitializerError e2) {
            sb = new StringBuilder("ExceptionInInitializerError");
            message = e2.getMessage();
            sb.append(message);
            h.a("FaqMemoryLeakUtils", sb.toString());
        } catch (ReflectiveOperationException e3) {
            sb = new StringBuilder("ReflectiveOperationException");
            message = e3.getMessage();
            sb.append(message);
            h.a("FaqMemoryLeakUtils", sb.toString());
        } catch (Exception e4) {
            sb = new StringBuilder("Exception");
            message = e4.getMessage();
            sb.append(message);
            h.a("FaqMemoryLeakUtils", sb.toString());
        }
    }

    class a implements PrivilegedAction<Object> {
        final /* synthetic */ Method d;

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.d.setAccessible(true);
            return null;
        }

        a(Method method) {
            this.d = method;
        }
    }

    class b implements PrivilegedAction<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Field f8537a;

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.f8537a.setAccessible(true);
            return null;
        }

        b(Field field) {
            this.f8537a = field;
        }
    }

    class c implements PrivilegedAction<Object> {
        final /* synthetic */ Field c;

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.c.setAccessible(true);
            return null;
        }

        c(Field field) {
            this.c = field;
        }
    }

    class d implements PrivilegedAction<Object> {
        final /* synthetic */ Field e;

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.e.setAccessible(true);
            return null;
        }

        d(Field field) {
            this.e = field;
        }
    }

    class e implements PrivilegedAction<Object> {
        final /* synthetic */ Field c;

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.c.setAccessible(true);
            return null;
        }

        e(Field field) {
            this.c = field;
        }
    }

    class g implements PrivilegedAction<Object> {
        final /* synthetic */ Field d;

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.d.setAccessible(true);
            return null;
        }

        g(Field field) {
            this.d = field;
        }
    }

    private static void cjA_(InputMethodManager inputMethodManager) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Method method = inputMethodManager.getClass().getMethod("resetInTransitionState", new Class[0]);
        AccessController.doPrivileged(new a(method));
        method.invoke(inputMethodManager, new Object[0]);
    }

    private static void e(Context context) {
        StringBuilder sb;
        String message;
        try {
            Class<?> cls = Class.forName("android.rms.iaware.FastgrabConfigReader");
            Field declaredField = cls.getDeclaredField("mFastgrabConfigReader");
            AccessController.doPrivileged(new e(declaredField));
            Object obj = declaredField.get(cls);
            Field declaredField2 = cls.getDeclaredField("mContext");
            AccessController.doPrivileged(new g(declaredField2));
            if (context == declaredField2.get(obj)) {
                h.a("FaqMemoryLeakUtils", "Checked FastgrabConfigReaderLeak");
                declaredField2.set(obj, null);
            }
        } catch (ExceptionInInitializerError e2) {
            sb = new StringBuilder("ExceptionInInitializerError:");
            message = e2.getMessage();
            sb.append(message);
            h.a("FaqMemoryLeakUtils", sb.toString());
        } catch (ReflectiveOperationException e3) {
            sb = new StringBuilder("ReflectiveOperationException:");
            message = e3.getMessage();
            sb.append(message);
            h.a("FaqMemoryLeakUtils", sb.toString());
        } catch (Exception e4) {
            sb = new StringBuilder("Exception:");
            message = e4.getMessage();
            sb.append(message);
            h.a("FaqMemoryLeakUtils", sb.toString());
        }
    }
}
