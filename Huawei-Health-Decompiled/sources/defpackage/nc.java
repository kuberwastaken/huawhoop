package defpackage;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes9.dex */
public class nc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f16004a;
    public static Method b;
    public static Method c;
    public static Method d;
    public static Object e;
    public static Method g;

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f16004a = cls;
            e = cls.newInstance();
            d = f16004a.getMethod("getUDID", Context.class);
            c = f16004a.getMethod("getOAID", Context.class);
            b = f16004a.getMethod("getVAID", Context.class);
            g = f16004a.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            Log.e("IdentifierManager", "reflect exception!", e2);
        }
    }

    public static String b(Context context) {
        return d(context, c);
    }

    public static boolean c() {
        return (f16004a == null || e == null) ? false : true;
    }

    public static String d(Context context, Method method) {
        Object obj = e;
        if (obj == null || method == null) {
            return null;
        }
        try {
            Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (String) objInvoke;
            }
            return null;
        } catch (Exception e2) {
            Log.e("IdentifierManager", "invoke exception!", e2);
            return null;
        }
    }
}
