package com.huawei.hwdevice.mainprocess.mgr.hwmywatchfacemgr.pluginvideo.mmedit;

import android.text.TextUtils;
import com.huawei.haf.common.exception.ExceptionUtils;
import com.huawei.hwlogsmodel.LogUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class EmuiUtils {
    public static final boolean PRODUCT_4K = getString("ro.hardware", "").contains("kirin9");
    private static final String TAG = "EmuiUtils";

    public static class VERSION {
        public static final int EMUI_SDK_INT = EmuiUtils.getInt("ro.build.hw_emui_api_level", 0);
    }

    public static int getInt(String str, int i) {
        Object objInvoke = invoke(getMethod("android.os.SystemProperties", "getInt", String.class, Integer.TYPE), null, str, Integer.valueOf(i));
        return objInvoke instanceof Integer ? ((Integer) objInvoke).intValue() : i;
    }

    public static String getString(String str, String str2) {
        Object objInvoke = invoke(getMethod("android.os.SystemProperties", "get", String.class, String.class), null, str, str2);
        return objInvoke instanceof String ? (String) objInvoke : str2;
    }

    public static Method getMethod(String str, String str2, Class... clsArr) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return Class.forName(str).getMethod(str2, clsArr);
            } catch (ClassNotFoundException e) {
                LogUtil.a(TAG, "getMethod classNotFoundException ", ExceptionUtils.a(e));
                return null;
            } catch (NoSuchMethodException e2) {
                LogUtil.a(TAG, "getMethod noSuchMethodException", ExceptionUtils.a(e2));
                return null;
            } catch (Exception e3) {
                LogUtil.a(TAG, "getMethod exception", ExceptionUtils.a(e3));
                return null;
            }
        }
        LogUtil.a(TAG, "getMethod param className or methodname can not be null!");
        return null;
    }

    public static Object invoke(Method method, Object obj, Object... objArr) {
        if (method == null) {
            LogUtil.a(TAG, "invoke param method can not be null!");
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (InvocationTargetException e) {
            LogUtil.a(TAG, method, " invoke  invocationTargetException ", ExceptionUtils.a(e));
            return null;
        } catch (Exception e2) {
            LogUtil.a(TAG, method, " invoke exception", ExceptionUtils.a(e2));
            return null;
        }
    }
}
