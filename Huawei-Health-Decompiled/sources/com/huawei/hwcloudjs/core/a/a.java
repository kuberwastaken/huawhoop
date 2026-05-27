package com.huawei.hwcloudjs.core.a;

import com.huawei.hwcloudjs.core.JSRequest;
import com.huawei.hwcloudjs.core.JsCallback;
import com.huawei.hwcloudjs.f.d;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Method f6393a;
    private Class<?> b;

    public Class<?> b() {
        return this.b;
    }

    public void a(Object obj, JsCallback jsCallback) {
        String str;
        try {
            Object objNewInstance = this.f6393a.getDeclaringClass().newInstance();
            if (objNewInstance instanceof JSRequest) {
                ((JSRequest) objNewInstance).execute(this.f6393a, obj, jsCallback);
            } else {
                d.b("CallObject", "clazz.newInstance() is not JSRequest type", true);
            }
        } catch (IllegalAccessException unused) {
            str = "call IllegalAccessException";
            d.b("CallObject", str, true);
        } catch (InstantiationException unused2) {
            str = "call InstantiationException";
            d.b("CallObject", str, true);
        }
    }

    public Method a() {
        return this.f6393a;
    }

    public a(Method method) {
        Class<?> cls;
        this.b = null;
        this.f6393a = method;
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (parameterTypes.length <= 0 || JsCallback.class == (cls = parameterTypes[0])) {
            return;
        }
        this.b = cls;
    }
}
