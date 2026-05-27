package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes6.dex */
public class mlw {
    private static void d(Class cls, Class[] clsArr, Object[] objArr) throws Exception {
        if (cls == null) {
            throw new ClassNotFoundException("class is null in staticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new ClassNotFoundException("paramsType is null, but params is not null");
            }
        } else {
            if (objArr == null) {
                throw new ClassNotFoundException("paramsType or params should be same");
            }
            if (clsArr.length == objArr.length) {
                return;
            }
            throw new ClassNotFoundException("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
        }
    }

    private static Object c(Class cls, String str, Class[] clsArr, Object[] objArr) throws Exception {
        d(cls, clsArr, objArr);
        try {
        } catch (NoSuchMethodException e) {
            mly.d("HwInvoke", "NoSuchMethodException" + e.getClass().getSimpleName(), true);
        } catch (Exception e2) {
            mly.d("HwInvoke", "Exception" + e2.getClass().getSimpleName(), true);
        }
        try {
            return cls.getMethod(str, clsArr).invoke(null, objArr);
        } catch (IllegalAccessException e3) {
            mly.d("HwInvoke", "IllegalAccessException" + e3.getClass().getSimpleName(), true);
            return null;
        } catch (IllegalArgumentException e4) {
            mly.d("HwInvoke", "IllegalArgumentException" + e4.getClass().getSimpleName(), true);
            return null;
        } catch (InvocationTargetException e5) {
            mly.d("HwInvoke", "InvocationTargetException" + e5.getClass().getSimpleName(), true);
            return null;
        }
    }

    public static Object e(String str, String str2, Class[] clsArr, Object[] objArr) {
        try {
            return c(Class.forName(str), str2, clsArr, objArr);
        } catch (ClassNotFoundException e) {
            mly.d("HwInvoke", "ClassNotFoundException" + e.getClass().getSimpleName(), true);
            return null;
        } catch (Exception e2) {
            mly.d("HwInvoke", "Exception" + e2.getClass().getSimpleName(), true);
            return null;
        } catch (Throwable th) {
            mly.d("HwInvoke", "Throwable" + th.getClass().getSimpleName(), true);
            return null;
        }
    }
}
