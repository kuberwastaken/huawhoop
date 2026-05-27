package com.huawei.hms.common.utils;

import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import defpackage.mly;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes5.dex */
public class AccountPickerEmuiUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f4661a = -1;
    private static int b;

    static {
        a();
    }

    private static void a() {
        int iC = c();
        b = iC;
        if (iC >= 17) {
            f4661a = 90;
        }
        if (iC >= 11) {
            f4661a = 50;
        } else if (iC >= 10) {
            f4661a = 41;
        } else if (iC >= 9) {
            f4661a = 40;
        } else if (iC >= 8) {
            f4661a = 31;
        } else if (iC >= 7) {
            f4661a = 30;
        }
        if (f4661a == -1) {
            b();
        }
    }

    private static void b() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "ro.build.version.emui");
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    f4661a = 30;
                } else if (str.contains("EmotionUI_3.1")) {
                    f4661a = 31;
                } else if (str.contains("EmotionUI_4.0")) {
                    f4661a = 40;
                } else if (str.contains("EmotionUI_4.1")) {
                    f4661a = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    f4661a = 50;
                }
            }
        } catch (RuntimeException unused) {
            mly.b("AccountPickerEmuiUtil", "RuntimeException getEmuiType.", true);
        } catch (Exception unused2) {
            mly.b("AccountPickerEmuiUtil", "getEmuiType Exception.", true);
        }
    }

    public static boolean isAboveEMUI100() {
        return b >= 21;
    }

    private static int c() {
        Object objB = ReflectionUtils.b();
        if (objB != null) {
            try {
                b = ((Integer) objB).intValue();
            } catch (ClassCastException unused) {
                mly.b("AccountPickerEmuiUtil", "EMUIVersionCode is not a number", true);
            }
        }
        return b;
    }

    static class ReflectionUtils {
        ReflectionUtils() {
        }

        public static Class<?> getClass(String str) {
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

        /* JADX INFO: Access modifiers changed from: private */
        public static Object b() {
            Class<?> cls = getClass(EmuiUtil.BUILDEX_VERSION);
            if (cls != null && !TextUtils.isEmpty(EmuiUtil.EMUI_SDK_INT)) {
                try {
                    Field declaredField = cls.getDeclaredField(EmuiUtil.EMUI_SDK_INT);
                    AccessibleObject.setAccessible(new Field[]{declaredField}, true);
                    return declaredField.get(cls);
                } catch (IllegalAccessException unused) {
                    mly.d("ReflectionUtils", "IllegalAccessException", true);
                } catch (IllegalArgumentException unused2) {
                    mly.d("ReflectionUtils", "IllegalArgumentException", true);
                } catch (NoSuchFieldException unused3) {
                    mly.d("ReflectionUtils", "NoSuchFieldException", true);
                } catch (SecurityException unused4) {
                    mly.a("ReflectionUtils", "not security int method", true);
                }
            }
            return null;
        }
    }
}
