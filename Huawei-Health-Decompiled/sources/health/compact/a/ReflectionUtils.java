package health.compact.a;

import android.text.TextUtils;
import com.huawei.haf.common.utils.CollectionUtils;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ReflectionUtils {
    private ReflectionUtils() {
    }

    public static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            LogUtil.b("HAF_ReflectionUtils", "getClass ex=", LogUtil.c(e));
            return null;
        }
    }

    public static Class<?> a(String str, ClassLoader classLoader) {
        try {
            return Class.forName(str, true, classLoader);
        } catch (ClassNotFoundException e) {
            LogUtil.b("HAF_ReflectionUtils", "getClass ex=", LogUtil.c(e));
            return null;
        }
    }

    public static Object a(Object obj, String str) {
        try {
            return e(obj, str).get(obj);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            LogUtil.b("HAF_ReflectionUtils", "getFieldValue ex=", LogUtil.c(e));
            return null;
        }
    }

    public static boolean e(Object obj, String str, Object obj2) {
        try {
            e(obj, str).set(obj, obj2);
            return true;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            LogUtil.b("HAF_ReflectionUtils", "setFieldValue ex=", LogUtil.c(e));
            return false;
        }
    }

    public static Object a(Class<?> cls, String str) {
        try {
            return c(cls, str).get(null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            LogUtil.b("HAF_ReflectionUtils", "getStaticFieldValue ex=", LogUtil.c(e));
            return null;
        }
    }

    public static boolean a(Class<?> cls, String str, Object obj) {
        try {
            c(cls, str).set(null, obj);
            return true;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            LogUtil.b("HAF_ReflectionUtils", "setStaticFieldValue ex=", LogUtil.c(e));
            return false;
        }
    }

    public static Object d(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException | InvocationTargetException e) {
            LogUtil.b("HAF_ReflectionUtils", "invokeMethod ex=", LogUtil.c(e));
            return null;
        }
    }

    public static Object b(Object obj, String str) {
        try {
            return d(e(obj, str, (Class<?>[]) null), obj, null);
        } catch (NoSuchMethodException e) {
            LogUtil.b("HAF_ReflectionUtils", "invokeMethod ex=", LogUtil.c(e));
            return null;
        }
    }

    public static Object e(Class<?> cls, String str) {
        try {
            Method methodA = a(cls, str, (Class<?>[]) null);
            return d(methodA, null, null);
        } catch (NoSuchMethodException e) {
            LogUtil.b("HAF_ReflectionUtils", "invokeStaticMethod ex=", LogUtil.c(e));
            return null;
        }
    }

    public static Object e(Constructor<?> constructor, Object... objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            LogUtil.b("HAF_ReflectionUtils", "newInstance ex=", LogUtil.c(e));
            return null;
        }
    }

    public static Object c(String str) {
        Class<?> clsA = a(str);
        if (clsA != null) {
            return a(clsA);
        }
        return null;
    }

    public static Object d(String str, ClassLoader classLoader) {
        Class<?> clsA = a(str, classLoader);
        if (clsA != null) {
            return a(clsA);
        }
        return null;
    }

    public static Object a(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            LogUtil.b("HAF_ReflectionUtils", "newInstance ex=", LogUtil.c(e));
            return null;
        }
    }

    public static Class<?> b(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public static Class<?> e(String str, ClassLoader classLoader) throws ClassNotFoundException {
        return Class.forName(str, true, classLoader);
    }

    public static Field e(Object obj, String str) throws NoSuchFieldException {
        return c(obj.getClass(), str);
    }

    public static Field c(Class<?> cls, String str) throws NoSuchFieldException {
        Field fieldB = b(cls, str);
        if (!fieldB.isAccessible()) {
            fieldB.setAccessible(true);
        }
        return fieldB;
    }

    public static Field d(Class<?> cls, String str) {
        Field fieldB;
        try {
            fieldB = b(cls, str);
        } catch (NoSuchFieldException e) {
            e = e;
            fieldB = null;
        }
        try {
            if (!fieldB.isAccessible()) {
                fieldB.setAccessible(true);
            }
        } catch (NoSuchFieldException e2) {
            e = e2;
            LogUtil.d("HAF_ReflectionUtils", "findField ex=", LogUtil.c(e));
        }
        return fieldB;
    }

    private static Field b(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            return cls.getField(str);
        } catch (NoSuchFieldException unused) {
            for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                try {
                    return superclass.getDeclaredField(str);
                } catch (NoSuchFieldException unused2) {
                }
            }
            throw new NoSuchFieldException(b("Field", str, cls, null));
        }
    }

    public static Method e(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        return a(obj.getClass(), str, clsArr);
    }

    public static Method a(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method methodC = c(cls, str, clsArr);
        if (!methodC.isAccessible()) {
            methodC.setAccessible(true);
        }
        return methodC;
    }

    public static Method b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return a(cls, str, clsArr);
        } catch (NoSuchMethodException e) {
            LogUtil.d("HAF_ReflectionUtils", "findMethod ex=", LogUtil.c(e));
            return null;
        }
    }

    private static Method c(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException unused) {
            for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                try {
                    return superclass.getDeclaredMethod(str, clsArr);
                } catch (NoSuchMethodException unused2) {
                }
            }
            throw new NoSuchMethodException(b("Method", str, cls, clsArr));
        }
    }

    public static Constructor<?> d(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        Constructor<?> constructorB = b(cls, clsArr);
        if (!constructorB.isAccessible()) {
            constructorB.setAccessible(true);
        }
        return constructorB;
    }

    private static Constructor<?> b(Class<?> cls, Class<?>... clsArr) throws NoSuchMethodException {
        try {
            return cls.getConstructor(clsArr);
        } catch (NoSuchMethodException unused) {
            for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                try {
                    return superclass.getDeclaredConstructor(clsArr);
                } catch (NoSuchMethodException unused2) {
                }
            }
            throw new NoSuchMethodException(b("Constructor", "", cls, clsArr));
        }
    }

    private static String b(String str, String str2, Class<?> cls, Class<?>... clsArr) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(str);
        if (!TextUtils.isEmpty(str2)) {
            sb.append(' ');
            sb.append(str2);
        }
        if (clsArr != null) {
            sb.append(" with parameters ");
            sb.append(Arrays.asList(clsArr));
        }
        sb.append(" not found in ");
        sb.append(cls);
        return sb.toString();
    }

    public static void b(Object obj, String str, Object[] objArr) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (CollectionUtils.b(objArr)) {
            return;
        }
        Field fieldE = e(obj, str);
        Object obj2 = fieldE.get(obj);
        if (!(obj2 instanceof Object[])) {
            LogUtil.b("HAF_ReflectionUtils", "expandFieldArray object is not array: ", obj2);
            return;
        }
        Object[] objArr2 = (Object[]) obj2;
        Object objNewInstance = Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        if (objNewInstance instanceof Object[]) {
            Object[] objArr3 = (Object[]) objNewInstance;
            System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
            System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
            fieldE.set(obj, objArr3);
        }
    }

    public static void e(Object obj, String str, Object[] objArr) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        if (CollectionUtils.b(objArr)) {
            return;
        }
        Field fieldE = e(obj, str);
        Object obj2 = fieldE.get(obj);
        if (!(obj2 instanceof Object[])) {
            LogUtil.b("HAF_ReflectionUtils", "reduceFieldArray object is not array: ", obj2);
            return;
        }
        Object[] objArr2 = (Object[]) obj2;
        int length = objArr2.length - objArr.length;
        if (length < 0) {
            LogUtil.b("HAF_ReflectionUtils", "reduceFieldArray target length error: ", Integer.valueOf(length));
            return;
        }
        Object objNewInstance = Array.newInstance(objArr2.getClass().getComponentType(), length);
        if (objNewInstance instanceof Object[]) {
            Object[] objArr3 = (Object[]) objNewInstance;
            List listAsList = Arrays.asList(objArr);
            int i = 0;
            for (Object obj3 : objArr2) {
                if (!listAsList.contains(obj3)) {
                    if (i == objArr3.length) {
                        throw new IllegalArgumentException("extraElements exist data error.");
                    }
                    objArr3[i] = obj3;
                    i++;
                }
            }
            if (i != objArr3.length) {
                throw new IllegalArgumentException("extraElements exist data duplicate.");
            }
            fieldE.set(obj, objArr3);
        }
    }
}
