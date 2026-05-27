package com.huawei.hihealth.motion.common;

import android.util.Log;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class AsyncInvocationHandler implements InvocationHandler {
    private Object b;

    public AsyncInvocationHandler(Object obj) {
        this.b = obj;
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        try {
            return method.invoke(this.b, objArr);
        } catch (IllegalAccessException e) {
            Log.w("HealthOpenSDK_HSC", "IllegalAccessException ex=" + e.getMessage());
            return null;
        } catch (InvocationTargetException e2) {
            Log.w("HealthOpenSDK_HSC", "InvocationTargetException ex=" + e2.getMessage());
            return null;
        }
    }
}
