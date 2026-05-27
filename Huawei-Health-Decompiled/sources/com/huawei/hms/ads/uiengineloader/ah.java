package com.huawei.hms.ads.uiengineloader;

import android.os.IBinder;
import com.huawei.hms.ads.dynamic.IObjectWrapper;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes5.dex */
public final class ah<T> extends IObjectWrapper.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f4557a;

    public static <T> T a(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper instanceof ah) {
            return ((ah) iObjectWrapper).f4557a;
        }
        IBinder iBinderAsBinder = iObjectWrapper.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        int i = 0;
        for (Field field : declaredFields) {
            if (!field.isSynthetic()) {
                i++;
            }
        }
        if (i != 1) {
            throw new IllegalArgumentException("Unexpected number of IObjectWrapper declared fields: " + declaredFields.length);
        }
        if (declaredFields[0].isAccessible()) {
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        declaredFields[0].setAccessible(true);
        try {
            return (T) declaredFields[0].get(iBinderAsBinder);
        } catch (IllegalAccessException unused) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.");
        } catch (NullPointerException unused2) {
            throw new IllegalArgumentException("Binder object is null.");
        }
    }

    public static <T> IObjectWrapper a(T t) {
        return new ah(t);
    }

    private ah(T t) {
        this.f4557a = t;
    }
}
