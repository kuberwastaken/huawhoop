package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import android.util.Pair;
import com.huawei.openalliance.ad.hq;
import com.huawei.operation.utils.Constants;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class q implements bs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8013a = "q";

    protected abstract Object b();

    @Override // com.huawei.openalliance.ad.utils.bs
    public Pair<Integer, Pair<String, String>> a(int i) {
        Object objB = b();
        if (objB == null) {
            return null;
        }
        Class<?>[] clsArr = {Integer.TYPE};
        Object[] objArr = {Integer.valueOf(i)};
        Pair<String, String> pairA = a(objB, clsArr, objArr);
        Integer numB = b(objB, clsArr, objArr);
        if (pairA != null) {
            return new Pair<>(numB, pairA);
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.utils.bs
    public int a() {
        Object objB = b();
        if (objB == null) {
            return 0;
        }
        Object objA = co.a(objB, "getPreferredDataSubscription", (Class<?>[]) null, (Object[]) null);
        if (objA == null || !(objA instanceof Integer)) {
            return -1;
        }
        return ((Integer) objA).intValue();
    }

    private Integer b(Object obj, Class<?>[] clsArr, Object[] objArr) {
        Object objA = co.a(obj, "getNetworkType", clsArr, objArr);
        if (objA == null || !(objA instanceof Integer)) {
            return 0;
        }
        return (Integer) objA;
    }

    static Object a(String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Class<?> cls = Class.forName(str);
            return cls.getDeclaredMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
        } catch (ClassNotFoundException unused) {
            str2 = f8013a;
            str3 = "getDefaultTelephoneManager ClassNotFoundException";
            hq.c(str2, str3);
            return null;
        } catch (IllegalAccessException unused2) {
            str2 = f8013a;
            str3 = "getDefaultTelephoneManager IllegalAccessException";
            hq.c(str2, str3);
            return null;
        } catch (IllegalArgumentException unused3) {
            str2 = f8013a;
            str3 = "getDefaultTelephoneManager IllegalArgumentException";
            hq.c(str2, str3);
            return null;
        } catch (NoSuchMethodException unused4) {
            str2 = f8013a;
            str3 = "getDefaultTelephoneManager NoSuchMethodException";
            hq.c(str2, str3);
            return null;
        } catch (SecurityException unused5) {
            str2 = f8013a;
            str3 = "getDefaultTelephoneManager SecurityException";
            hq.c(str2, str3);
            return null;
        } catch (InvocationTargetException unused6) {
            str2 = f8013a;
            str3 = "getDefaultTelephoneManager InvocationTargetException";
            hq.c(str2, str3);
            return null;
        } catch (Throwable th) {
            hq.c(f8013a, "getDefaultTelephoneManager error: " + th.getClass().getSimpleName());
            return null;
        }
    }

    private Pair<String, String> a(Object obj, Class<?>[] clsArr, Object[] objArr) {
        String strSubstring;
        String strSubstring2;
        Object objA = co.a(obj, "getNetworkOperator", clsArr, objArr);
        String str = (objA == null || !(objA instanceof String)) ? null : (String) objA;
        if (str == null || Constants.NULL.equalsIgnoreCase(str) || str.length() <= 3) {
            strSubstring = null;
            strSubstring2 = null;
        } else {
            strSubstring2 = str.substring(0, 3);
            strSubstring = str.substring(3);
        }
        if (strSubstring2 == null || strSubstring == null) {
            return null;
        }
        return new Pair<>(strSubstring2, strSubstring);
    }
}
