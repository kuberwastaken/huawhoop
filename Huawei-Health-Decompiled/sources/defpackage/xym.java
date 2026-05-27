package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class xym {
    public static <T> T d(T t) {
        t.getClass();
        return t;
    }

    public static <T> T c(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static String b(String str, Object obj) {
        c(str, obj);
        c(!TextUtils.isEmpty(str), obj);
        return str;
    }

    public static String c(String str, Object obj) {
        if (str != null) {
            b(str, obj);
        }
        return str;
    }

    public static void c(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void c(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }
}
