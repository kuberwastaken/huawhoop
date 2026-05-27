package com.huawei.hms.hwid;

import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes5.dex */
public class aq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f4829a = -1;
    private static int b;

    static {
        b();
    }

    private static void b() {
        int iD = d();
        b = iD;
        if (iD >= 17) {
            f4829a = 90;
        }
        if (iD >= 11) {
            f4829a = 50;
        } else if (iD >= 10) {
            f4829a = 41;
        } else if (iD >= 9) {
            f4829a = 40;
        } else if (iD >= 8) {
            f4829a = 31;
        } else if (iD >= 7) {
            f4829a = 30;
        }
        if (f4829a == -1) {
            c();
        }
    }

    private static void c() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    f4829a = 30;
                } else if (str.contains("EmotionUI_3.1")) {
                    f4829a = 31;
                } else if (str.contains("EmotionUI_4.0")) {
                    f4829a = 40;
                } else if (str.contains("EmotionUI_4.1")) {
                    f4829a = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    f4829a = 50;
                }
            }
        } catch (RuntimeException unused) {
            as.d("EmuiUtil", "RuntimeException getEmuiType.", true);
        } catch (Exception unused2) {
            as.d("EmuiUtil", "getEmuiType Exception.", true);
        }
    }

    public static boolean a() {
        return b >= 21;
    }

    private static int d() {
        Object objA = a.a(EmuiUtil.BUILDEX_VERSION, EmuiUtil.EMUI_SDK_INT);
        if (objA != null) {
            try {
                b = ((Integer) objA).intValue();
            } catch (ClassCastException unused) {
                as.d("EmuiUtil", "getEMUIVersionCode is not a number", true);
            }
        }
        return b;
    }

    static class a {
        public static Class<?> a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!EmuiUtil.BUILDEX_VERSION.equals(str) && !EmuiUtil.IMMERSION_STYLE.equals(str)) {
                return null;
            }
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        public static Object a(String str, String str2) {
            Class<?> clsA = a(str);
            if (clsA != null && !TextUtils.isEmpty(str2) && EmuiUtil.BUILDEX_VERSION.equals(str) && EmuiUtil.EMUI_SDK_INT.equals(str2)) {
                try {
                    Field declaredField = clsA.getDeclaredField(str2);
                    AccessibleObject.setAccessible(new Field[]{declaredField}, true);
                    return declaredField.get(clsA);
                } catch (IllegalAccessException unused) {
                    as.c("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException", true);
                } catch (IllegalArgumentException unused2) {
                    as.c("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException", true);
                } catch (NoSuchFieldException unused3) {
                    as.c("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException", true);
                } catch (SecurityException unused4) {
                    as.b("ReflectionUtils", "not security int method getStaticFieldObj", true);
                }
            }
            return null;
        }
    }
}
