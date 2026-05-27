package defpackage;

import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;

/* JADX INFO: loaded from: classes8.dex */
public class ybx {
    public static Method c(Method method, ClassLoader classLoader) throws NoSuchMethodException, ClassNotFoundException {
        return Class.forName(method.getDeclaringClass().getName(), true, classLoader).getDeclaredMethod(method.getName(), method.getParameterTypes());
    }

    public static <T> T c(Class<T> cls, InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return cls.cast(Proxy.newProxyInstance(ybx.class.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    public static InvocationHandler c(Object obj) {
        if (obj == null) {
            return null;
        }
        return new c(obj);
    }

    public static Object b(InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return ((c) invocationHandler).c();
    }

    /* JADX INFO: loaded from: classes11.dex */
    static class c implements InvocationHandler {
        private final Object d;

        public c(Object obj) {
            this.d = obj;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                return ybx.c(method, this.d.getClass().getClassLoader()).invoke(this.d, objArr);
            } catch (InvocationTargetException e) {
                throw e.getTargetException();
            } catch (ReflectiveOperationException e2) {
                throw new RuntimeException("Reflection failed for method " + method, e2);
            }
        }

        public Object c() {
            return this.d;
        }
    }

    private static boolean a() {
        return "eng".equals(Build.TYPE) || "userdebug".equals(Build.TYPE);
    }

    public static boolean a(Collection<String> collection, String str) {
        if (!collection.contains(str)) {
            if (a()) {
                if (collection.contains(str + ":dev")) {
                }
            }
            return false;
        }
        return true;
    }
}
