package com.huawei.openalliance.ad.utils;

import android.content.Context;
import com.huawei.openalliance.ad.hq;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class bn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f7928a;
    private static Method b;
    private static Method c;
    private static Method d;
    private static Method e;
    private static Object f;

    private static String a(Context context, Method method) {
        Object obj = f;
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
            hq.d("MIdentifierManager", "invoke exception, %s", e2.getClass().getSimpleName());
            return null;
        }
    }

    public static String a(Context context) {
        return a(context, c);
    }

    static {
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            f7928a = cls;
            f = cls.newInstance();
            d = f7928a.getMethod("getUDID", Context.class);
            c = f7928a.getMethod("getOAID", Context.class);
            e = f7928a.getMethod("getVAID", Context.class);
            b = f7928a.getMethod("getAAID", Context.class);
        } catch (Exception e2) {
            hq.d("MIdentifierManager", "reflect exception, %s", e2.getClass().getSimpleName());
        }
    }
}
