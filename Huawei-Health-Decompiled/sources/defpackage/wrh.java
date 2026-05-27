package defpackage;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes8.dex */
public class wrh {
    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        wrm.b("Preconditions", String.valueOf(obj));
        throw new wqt(5);
    }

    public static String c(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        wrm.b("Preconditions", String.valueOf(obj));
        throw new wqt(5);
    }

    public static void b(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (str.getBytes("UTF-8").length <= i) {
                    return;
                }
            }
            wrm.b("Preconditions", "checkArgumentByteLimit exceeded the maximum length: " + str);
            throw new wqt(5);
        } catch (UnsupportedEncodingException unused) {
            wrm.b("Preconditions", "checkArgumentByteLimit UnsupportedEncodingException");
            throw new wqt(5);
        }
    }
}
