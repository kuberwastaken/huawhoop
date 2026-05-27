package defpackage;

import android.text.TextUtils;
import com.huawei.hms.framework.common.EmuiUtil;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes6.dex */
class mmb {
    public static Class<?> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!EmuiUtil.BUILDEX_VERSION.equals(str) && !EmuiUtil.IMMERSION_STYLE.equals(str)) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            mly.d("ReflectionUtils", "className not found:", true);
            return null;
        }
    }

    public static Object d(String str, String str2) {
        Class<?> clsD = d(str);
        if (clsD != null && !TextUtils.isEmpty(str2) && EmuiUtil.BUILDEX_VERSION.equals(str) && EmuiUtil.EMUI_SDK_INT.equals(str2)) {
            try {
                Field declaredField = clsD.getDeclaredField(str2);
                AccessibleObject.setAccessible(new Field[]{declaredField}, true);
                return declaredField.get(clsD);
            } catch (IllegalAccessException unused) {
                mly.d("ReflectionUtils", "Exception in getFieldObj :: IllegalAccessException", true);
            } catch (IllegalArgumentException unused2) {
                mly.d("ReflectionUtils", "Exception in getFieldObj :: IllegalArgumentException", true);
            } catch (NoSuchFieldException unused3) {
                mly.d("ReflectionUtils", "Exception in getFieldObj :: NoSuchFieldException", true);
            } catch (SecurityException unused4) {
                mly.a("ReflectionUtils", "not security int method getStaticFieldObj", true);
            }
        }
        return null;
    }
}
