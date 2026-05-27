package com.huawei.agconnect.core.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class ServiceRepository {
    private static Map<Class<?>, Service> c = new HashMap();
    private static Map<Class<?>, Object> d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<Class<?>, Service> f1805a = new HashMap();
    private Map<Class<?>, Object> b = new HashMap();

    public void a(List<Service> list, Context context) {
        Map<Class<?>, Service> map;
        String str;
        Log.d("AGC_ServiceRepository", "addService start");
        if (list == null) {
            return;
        }
        for (Service service : list) {
            if (service.isSharedInstance()) {
                if (!c.containsKey(service.getInterface())) {
                    map = c;
                }
                if (!service.isAutoCreated() && service.getType() != null && !d.containsKey(service.getInterface())) {
                    try {
                        Constructor constructorA = a(service.getType(), Context.class);
                        d.put(service.getInterface(), constructorA != null ? constructorA.newInstance(context) : service.getType().newInstance());
                    } catch (IllegalAccessException e) {
                        e = e;
                        str = "AccessException";
                        a(str, e);
                    } catch (InstantiationException e2) {
                        e = e2;
                        str = "InstantiationException";
                        a(str, e);
                    } catch (InvocationTargetException e3) {
                        e = e3;
                        str = "TargetException";
                        a(str, e);
                    }
                }
            } else {
                map = this.f1805a;
            }
            map.put(service.getInterface(), service);
            if (!service.isAutoCreated()) {
            }
        }
        Log.d("AGC_ServiceRepository", "addService end");
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t;
        Service service = this.f1805a.get(cls);
        if (service == null && (service = c.get(cls)) != null) {
            return (T) d.get(cls);
        }
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t = (T) this.b.get(cls)) != null) {
            return t;
        }
        T t2 = (T) a(aGConnectInstance, service);
        if (t2 != null && service.isSingleton()) {
            this.b.put(cls, t2);
        }
        return t2;
    }

    private void a(String str, Exception exc) {
        Log.e("AGC_ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        StringBuilder sb = new StringBuilder("cause message:");
        sb.append(exc.getCause() != null ? exc.getCause().getMessage() : "");
        Log.e("AGC_ServiceRepository", sb.toString());
    }

    private static Constructor a(Class cls, Class... clsArr) {
        boolean z = false;
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i = 0; i < clsArr.length; i++) {
                    z = parameterTypes[i] == clsArr[i];
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service) {
        StringBuilder sb;
        if (service.getInstance() != null) {
            return service.getInstance();
        }
        Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor constructorA = a(type, Context.class, AGConnectInstance.class);
            if (constructorA != null) {
                return constructorA.newInstance(aGConnectInstance.getContext(), aGConnectInstance);
            }
            Constructor constructorA2 = a(type, Context.class);
            return constructorA2 != null ? constructorA2.newInstance(aGConnectInstance.getContext()) : type.newInstance();
        } catch (IllegalAccessException e) {
            e = e;
            sb = new StringBuilder("Instantiate service exception ");
            sb.append(e.getLocalizedMessage());
            Log.e("AGC_ServiceRepository", sb.toString());
            return null;
        } catch (InstantiationException e2) {
            e = e2;
            sb = new StringBuilder("Instantiate service exception ");
            sb.append(e.getLocalizedMessage());
            Log.e("AGC_ServiceRepository", sb.toString());
            return null;
        } catch (InvocationTargetException e3) {
            e = e3;
            sb = new StringBuilder("Instantiate service exception ");
            sb.append(e.getLocalizedMessage());
            Log.e("AGC_ServiceRepository", sb.toString());
            return null;
        }
    }

    ServiceRepository(List<Service> list, Context context) {
        a(list, context);
    }
}
