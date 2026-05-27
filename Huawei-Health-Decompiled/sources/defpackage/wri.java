package defpackage;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes11.dex */
public class wri {
    public static <T> T e(T t, Object obj) {
        if (t != null) {
            return t;
        }
        wro.d("ServicePreconditions", String.valueOf(obj));
        throw new IllegalStateException(String.valueOf(5));
    }

    public static String a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        wro.d("ServicePreconditions", String.valueOf(obj));
        throw new IllegalArgumentException(String.valueOf(obj));
    }
}
