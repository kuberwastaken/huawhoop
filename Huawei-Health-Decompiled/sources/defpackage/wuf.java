package defpackage;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes8.dex */
public class wuf {
    public static String e(Context context) {
        try {
            Class<?> cls = Class.forName("com.huawei.wearengine.utills.WearEngineReflectUtil");
            wro.b("AccountUtil", "reflectInvokeGetUserId getUserId");
            Object objInvoke = cls.getDeclaredMethod("getUserId", Context.class).invoke(cls, context);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
            return null;
        } catch (ClassNotFoundException unused) {
            wro.d("AccountUtil", "getUserId ClassNotFoundException");
            return null;
        } catch (IllegalAccessException unused2) {
            wro.d("AccountUtil", "getUserId IllegalAccessException");
            return null;
        } catch (IllegalArgumentException unused3) {
            wro.d("AccountUtil", "getUserId IllegalArgumentException");
            return null;
        } catch (NoSuchMethodException unused4) {
            wro.d("AccountUtil", "getUserId NoSuchMethodException");
            return null;
        } catch (InvocationTargetException unused5) {
            wro.d("AccountUtil", "getUserId InvocationTargetException");
            return null;
        }
    }

    public static Boolean b(Context context) {
        try {
            Class<?> cls = Class.forName("com.huawei.wearengine.utills.WearEngineReflectUtil");
            wro.b("AccountUtil", "reflectInvokeIsAuthorizedInHealth isAuthorizedInHealth");
            Object objInvoke = cls.getDeclaredMethod("isAuthorizedInHealth", Context.class).invoke(cls, context);
            if (objInvoke instanceof Boolean) {
                return (Boolean) objInvoke;
            }
        } catch (ClassNotFoundException unused) {
            wro.d("AccountUtil", "isAuthorizedInHealth ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            wro.d("AccountUtil", "isAuthorizedInHealth IllegalAccessException");
        } catch (IllegalArgumentException unused3) {
            wro.d("AccountUtil", "isAuthorizedInHealth IllegalArgumentException");
        } catch (NoSuchMethodException unused4) {
            wro.d("AccountUtil", "isAuthorizedInHealth NoSuchMethodException");
        } catch (InvocationTargetException unused5) {
            wro.d("AccountUtil", "isAuthorizedInHealth InvocationTargetException");
        }
        return false;
    }

    public static String c(Context context) {
        try {
            Class<?> cls = Class.forName("com.huawei.wearengine.utills.WearEngineReflectUtil");
            wro.b("AccountUtil", "reflectInvokeGetGrsUrl getGrsUrl");
            Object objInvoke = cls.getDeclaredMethod("getGrsUrl", Context.class).invoke(cls, context);
            return objInvoke instanceof String ? (String) objInvoke : "";
        } catch (ClassNotFoundException unused) {
            wro.d("AccountUtil", "getGrsUrl ClassNotFoundException");
            return "";
        } catch (IllegalAccessException unused2) {
            wro.d("AccountUtil", "getGrsUrl IllegalAccessException");
            return "";
        } catch (IllegalArgumentException unused3) {
            wro.d("AccountUtil", "getGrsUrl IllegalArgumentException");
            return "";
        } catch (NoSuchMethodException unused4) {
            wro.d("AccountUtil", "getGrsUrl NoSuchMethodException");
            return "";
        } catch (InvocationTargetException unused5) {
            wro.d("AccountUtil", "getGrsUrl InvocationTargetException");
            return "";
        }
    }

    public static boolean c(String str) {
        if (!TextUtils.isEmpty(str) && !"0".equals(str)) {
            return true;
        }
        wro.d("AccountUtil", "checkUserId userId is empty! userId = " + str);
        return false;
    }
}
