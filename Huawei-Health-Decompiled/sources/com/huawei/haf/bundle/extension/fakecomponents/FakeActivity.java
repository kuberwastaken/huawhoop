package com.huawei.haf.bundle.extension.fakecomponents;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import health.compact.a.LogUtil;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class FakeActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        int iYs_ = ys_(this);
        super.onCreate(bundle);
        yl_(this, iYs_);
        if (getIntent() != null) {
            setIntent(null);
        }
        finish();
    }

    private static int ys_(Activity activity) {
        int i = -1;
        if (Build.VERSION.SDK_INT != 26 || activity.getApplicationInfo().targetSdkVersion <= 26 || !yr_(activity) || !yn_(activity)) {
            return -1;
        }
        try {
            Object objYm_ = ym_(activity);
            Field fieldA = a();
            int i2 = fieldA.getInt(objYm_);
            if (i2 != -1) {
                try {
                    fieldA.setInt(objYm_, -1);
                } catch (IllegalAccessException | NoSuchFieldException e) {
                    e = e;
                    i = i2;
                    LogUtil.d("Bundle_FakeActivity", "releaseFixedOrientation:ex=", LogUtil.c(e));
                    return i;
                }
            }
            return i2;
        } catch (IllegalAccessException e2) {
            e = e2;
        } catch (NoSuchFieldException e3) {
            e = e3;
        }
    }

    private static void yl_(Activity activity, int i) {
        if (i != -1 && Build.VERSION.SDK_INT == 26 && activity.getApplicationInfo().targetSdkVersion > 26 && yr_(activity) && !yn_(activity)) {
            try {
                Object objYm_ = ym_(activity);
                Field fieldA = a();
                if (fieldA.getInt(objYm_) == -1) {
                    fieldA.setInt(objYm_, i);
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
                LogUtil.d("Bundle_FakeActivity", "fixedOrientation:ex=", LogUtil.c(e));
            }
        }
    }

    private static boolean yr_(Activity activity) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$styleable");
            Field declaredField = cls.getDeclaredField("Window");
            boolean z = true;
            declaredField.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("Window_windowIsTranslucent");
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("Window_windowSwipeToDismiss");
            declaredField3.setAccessible(true);
            Field declaredField4 = cls.getDeclaredField("Window_windowIsFloating");
            declaredField4.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj instanceof int[]) {
                TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes((int[]) obj);
                if (!yo_(typedArrayObtainStyledAttributes, declaredField4) && !yq_(typedArrayObtainStyledAttributes, declaredField2) && !yp_(typedArrayObtainStyledAttributes, declaredField3, declaredField2)) {
                    z = false;
                }
                typedArrayObtainStyledAttributes.recycle();
                return z;
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            LogUtil.d("Bundle_FakeActivity", "isTranslucentOrFloating:ex=", LogUtil.c(e));
        }
        return false;
    }

    private static boolean yo_(TypedArray typedArray, Field field) throws IllegalAccessException {
        Object obj = field.get(null);
        if (obj instanceof Integer) {
            return typedArray.getBoolean(((Integer) obj).intValue(), false);
        }
        return false;
    }

    private static boolean yq_(TypedArray typedArray, Field field) throws IllegalAccessException {
        Object obj = field.get(null);
        if (obj instanceof Integer) {
            return typedArray.getBoolean(((Integer) obj).intValue(), false);
        }
        return false;
    }

    private static boolean yp_(TypedArray typedArray, Field field, Field field2) throws IllegalAccessException {
        Object obj = field.get(null);
        boolean z = obj instanceof Integer ? typedArray.getBoolean(((Integer) obj).intValue(), false) : false;
        Object obj2 = field2.get(null);
        return obj2 instanceof Integer ? !typedArray.hasValue(((Integer) obj2).intValue()) && z : z;
    }

    private static boolean yn_(Activity activity) {
        try {
            Object objYm_ = ym_(activity);
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isFixedOrientation", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(objYm_, new Object[0]);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e) {
            LogUtil.d("Bundle_FakeActivity", "isFixedOrientation:ex=", LogUtil.c(e));
            return false;
        }
    }

    private static Object ym_(Activity activity) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
        declaredField.setAccessible(true);
        return declaredField.get(activity);
    }

    private static Field a() throws NoSuchFieldException {
        Field declaredField = ActivityInfo.class.getDeclaredField("screenOrientation");
        declaredField.setAccessible(true);
        return declaredField;
    }
}
