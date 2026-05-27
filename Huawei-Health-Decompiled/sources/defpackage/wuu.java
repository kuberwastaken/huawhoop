package defpackage;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes8.dex */
public class wuu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f18940a = "ReleaseLogUtil";
    private static Method c;
    private static Class<?> e;

    private static void e() {
        if (e != null) {
            return;
        }
        try {
            e = Class.forName("com.huawei.wearengine.utills.WearEngineReflectUtil");
            b();
        } catch (ClassNotFoundException unused) {
            Log.e(f18940a, "class ClassNotFoundException");
        }
    }

    private static void b() {
        Class<?> cls;
        if (c == null && (cls = e) != null) {
            try {
                c = cls.getDeclaredMethod("log", Integer.TYPE, String.class, Object[].class);
            } catch (NoSuchMethodException unused) {
                Log.e(f18940a, "log NoSuchMethodException");
            }
        }
    }

    public static void c(int i, String str, Object... objArr) {
        Method method;
        e();
        Class<?> cls = e;
        if (cls == null || (method = c) == null) {
            Log.w(f18940a, "log clazz or logMethod is null");
            return;
        }
        try {
            method.invoke(cls, Integer.valueOf(i), "WearEngine_" + str, d(objArr));
        } catch (IllegalAccessException unused) {
            Log.e(f18940a, "log IllegalAccessException");
        } catch (InvocationTargetException unused2) {
            Log.e(f18940a, "log InvocationTargetException");
        }
    }

    private static Object[] d(Object... objArr) {
        Object[] objArr2 = new Object[objArr.length];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        return objArr2;
    }
}
