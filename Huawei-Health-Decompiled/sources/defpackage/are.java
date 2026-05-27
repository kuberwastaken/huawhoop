package defpackage;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
public final class are {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Method f278a;
    private static Method c;
    private static Method d;
    private static Class<?> e;

    public static boolean b(String str, boolean z) {
        try {
            Class<?> cls = e;
            if (cls == null) {
                cls = Class.forName("android.os.SystemProperties");
                e = cls;
            }
            Method declaredMethod = c;
            if (declaredMethod == null) {
                declaredMethod = cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
                c = declaredMethod;
            }
            return ((Boolean) declaredMethod.invoke(null, str, Boolean.valueOf(z))).booleanValue();
        } catch (ClassNotFoundException unused) {
            a("ReflectSystemProperties", "ClassNotFoundException");
            return z;
        } catch (IllegalAccessException unused2) {
            a("ReflectSystemProperties", "IllegalAccessException");
            return z;
        } catch (IllegalArgumentException unused3) {
            a("ReflectSystemProperties", "IllegalArgumentException");
            return z;
        } catch (NoSuchMethodException unused4) {
            a("ReflectSystemProperties", "NoSuchMethodException");
            return z;
        } catch (SecurityException unused5) {
            a("ReflectSystemProperties", "SecurityException");
            return z;
        } catch (InvocationTargetException unused6) {
            a("ReflectSystemProperties", "InvocationTargetException");
            return z;
        }
    }

    public static String b(String str, String str2) {
        try {
            Class<?> cls = e;
            if (cls == null) {
                cls = Class.forName("android.os.SystemProperties");
                e = cls;
            }
            Method declaredMethod = d;
            if (declaredMethod == null) {
                declaredMethod = cls.getDeclaredMethod("get", String.class, String.class);
                d = declaredMethod;
            }
            return String.valueOf(declaredMethod.invoke(null, str, str2));
        } catch (ClassNotFoundException unused) {
            a("ReflectSystemProperties", "ClassNotFoundException");
            return str2;
        } catch (IllegalAccessException unused2) {
            a("ReflectSystemProperties", "IllegalAccessException");
            return str2;
        } catch (IllegalArgumentException unused3) {
            a("ReflectSystemProperties", "IllegalArgumentException");
            return str2;
        } catch (NoSuchMethodException unused4) {
            a("ReflectSystemProperties", "NoSuchMethodException");
            return str2;
        } catch (SecurityException unused5) {
            a("ReflectSystemProperties", "SecurityException");
            return str2;
        } catch (InvocationTargetException unused6) {
            a("ReflectSystemProperties", "InvocationTargetException");
            return str2;
        }
    }

    public static int e(String str, int i) {
        try {
            Class<?> cls = e;
            if (cls == null) {
                cls = Class.forName("android.os.SystemProperties");
                e = cls;
            }
            Method declaredMethod = f278a;
            if (declaredMethod == null) {
                declaredMethod = cls.getDeclaredMethod("getInt", String.class, Integer.TYPE);
                f278a = declaredMethod;
            }
            return ((Integer) declaredMethod.invoke(null, str, Integer.valueOf(i))).intValue();
        } catch (ClassNotFoundException unused) {
            a("ReflectSystemProperties", "ClassNotFoundException");
            return i;
        } catch (IllegalAccessException unused2) {
            a("ReflectSystemProperties", "IllegalAccessException");
            return i;
        } catch (IllegalArgumentException unused3) {
            a("ReflectSystemProperties", "IllegalArgumentException");
            return i;
        } catch (NoSuchMethodException unused4) {
            a("ReflectSystemProperties", "NoSuchMethodException");
            return i;
        } catch (SecurityException unused5) {
            a("ReflectSystemProperties", "SecurityException");
            return i;
        } catch (InvocationTargetException unused6) {
            a("ReflectSystemProperties", "InvocationTargetException");
            return i;
        }
    }

    public static void a(String str, String str2) {
        Log.e(str, b(str2));
    }

    private static String b(String str) {
        if (str != null && str.length() > 1000) {
            str = str.substring(0, 1000);
            Log.w("ReflectSystemProperties", "msg length bigger than 1000");
        }
        StringBuilder sb = new StringBuilder(str != null ? 50 + str.length() : 50);
        sb.append(str);
        return sb.toString();
    }
}
