package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes3.dex */
public class cag {
    public static int b(String str, int i) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class, Integer.class).invoke(cls, str, Integer.valueOf(i));
            if (objInvoke instanceof Integer) {
                i = ((Integer) objInvoke).intValue();
            }
            cal.d("HwLowerSdkAdapter", "value: " + i);
        } catch (ClassNotFoundException unused) {
            cal.c("HwLowerSdkAdapter", "getSysProperty ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            cal.c("HwLowerSdkAdapter", "getSysProperty IllegalAccessException");
        } catch (IllegalArgumentException unused3) {
            cal.c("HwLowerSdkAdapter", "getSysProperty IllegalArgumentException");
        } catch (NoSuchMethodException unused4) {
            cal.c("HwLowerSdkAdapter", "getSysProperty NoSuchMethodException");
        } catch (SecurityException unused5) {
            cal.c("HwLowerSdkAdapter", "getSysProperty SecurityException");
        } catch (InvocationTargetException unused6) {
            cal.c("HwLowerSdkAdapter", "getSysProperty InvocationTargetException");
        }
        return i;
    }

    public static String b(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object objInvoke = cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
            if (objInvoke instanceof String) {
                str2 = (String) objInvoke;
            }
            cal.d("HwLowerSdkAdapter", "value: " + str2);
        } catch (ClassNotFoundException unused) {
            cal.c("HwLowerSdkAdapter", "getSysProperty ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            cal.c("HwLowerSdkAdapter", "getSysProperty IllegalAccessException");
        } catch (IllegalArgumentException unused3) {
            cal.c("HwLowerSdkAdapter", "getSysProperty IllegalArgumentException");
        } catch (NoSuchMethodException unused4) {
            cal.c("HwLowerSdkAdapter", "getSysProperty NoSuchMethodException");
        } catch (SecurityException unused5) {
            cal.c("HwLowerSdkAdapter", "getSysProperty SecurityException");
        } catch (InvocationTargetException unused6) {
            cal.c("HwLowerSdkAdapter", "getSysProperty InvocationTargetException");
        }
        return str2;
    }
}
