package com.huawei.hms.mlsdk.asr.o;

import android.os.Build;
import com.huawei.hms.framework.common.EmuiUtil;
import com.huawei.hms.mlsdk.asr.engine.utils.SmartLogger;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f5289a = -1;

    static {
        Object obj;
        int iIntValue;
        String str;
        try {
            try {
                Class<?> cls = Class.forName(EmuiUtil.BUILDEX_VERSION);
                Field declaredField = cls.getDeclaredField(EmuiUtil.EMUI_SDK_INT);
                AccessibleObject.setAccessible(new Field[]{declaredField}, true);
                obj = declaredField.get(cls);
            } catch (ClassCastException unused) {
                obj = null;
            }
        } catch (ClassNotFoundException unused2) {
            SmartLogger.e("EmuiUtil", "ClassNotFoundException: ");
        } catch (IllegalAccessException unused3) {
            SmartLogger.e("EmuiUtil", "IllegalAccessException: ");
        } catch (NoSuchFieldException unused4) {
            SmartLogger.e("EmuiUtil", "NoSuchFieldException: ");
        }
        if (obj != null) {
            try {
                iIntValue = ((Integer) obj).intValue();
            } catch (ClassCastException unused5) {
                SmartLogger.e("EmuiUtil", "ClassCastException: getEMUIVersionCode is not a number " + obj);
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        if (iIntValue >= 17) {
            f5289a = 90;
        } else if (iIntValue >= 15) {
            f5289a = 81;
        } else if (iIntValue >= 14) {
            f5289a = 60;
        } else if (iIntValue >= 11) {
            f5289a = 50;
        } else if (iIntValue >= 10) {
            f5289a = 41;
        } else if (iIntValue >= 9) {
            f5289a = 40;
        } else if (iIntValue >= 8) {
            f5289a = 31;
        } else if (iIntValue >= 7) {
            f5289a = 30;
        }
        if (f5289a == -1) {
            try {
                Class<?> cls2 = Class.forName("android.os.SystemProperties");
                Method declaredMethod = cls2.getDeclaredMethod("get", String.class);
                str = Build.BRAND.equals("HONOR") ? (String) declaredMethod.invoke(cls2, "ro.build.version.magic") : (String) declaredMethod.invoke(cls2, "ro.build.version.emui");
            } catch (ClassNotFoundException unused6) {
                SmartLogger.e("EmuiUtil", "ClassNotFoundException");
                str = "";
            } catch (IllegalAccessException unused7) {
                SmartLogger.e("EmuiUtil", "IllegalAccessException");
                str = "";
            } catch (NoSuchMethodException unused8) {
                SmartLogger.e("EmuiUtil", "NoSuchMethodException");
                str = "";
            } catch (InvocationTargetException unused9) {
                SmartLogger.e("EmuiUtil", "InvocationTargetException");
                str = "";
            }
            if (str != null) {
                if (str.contains("EmotionUI_3.0")) {
                    f5289a = 30;
                    return;
                }
                if (str.contains("EmotionUI_3.1")) {
                    f5289a = 31;
                    return;
                }
                if (str.contains("EmotionUI_4.0")) {
                    f5289a = 40;
                    return;
                }
                if (str.contains("EmotionUI_4.1")) {
                    f5289a = 41;
                } else if (str.contains("EmotionUI_5.0")) {
                    f5289a = 50;
                } else if (str.contains("EmotionUI_6.0")) {
                    f5289a = 60;
                }
            }
        }
    }

    public static boolean a() {
        return f5289a != -1;
    }
}
