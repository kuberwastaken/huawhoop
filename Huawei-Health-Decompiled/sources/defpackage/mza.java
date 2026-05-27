package defpackage;

import android.util.Log;
import com.huawei.operation.utils.Constants;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class mza {
    public static final Boolean e = false;

    public static int a(String str, String str2) {
        return d(str, str2, false);
    }

    public static int d(String str, String str2, boolean z) {
        return Log.d("HwMultiSIM", e(str, str2, z));
    }

    public static int b(String str, String str2) {
        if (e.booleanValue()) {
            return e(str, str2);
        }
        return 0;
    }

    public static int e(String str, String str2) {
        return b(str, str2, false);
    }

    public static int a(String str, String str2, String str3) {
        if (e.booleanValue()) {
            return e(str, str2 + str3);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(str3 != null ? Integer.valueOf(str3.length()) : Constants.NULL);
        return e(str, sb.toString());
    }

    public static int d(String str, String str2) {
        return b(str, str2);
    }

    public static int b(String str, String str2, boolean z) {
        return Log.i("HwMultiSIM", e(str, str2, z));
    }

    public static int h(String str, String str2) {
        return c(str, str2, false);
    }

    public static int c(String str, String str2, boolean z) {
        return Log.w("HwMultiSIM", e(str, str2, z));
    }

    public static int c(String str, String str2) {
        return a(str, str2, false);
    }

    public static int b(String str, String str2, Exception exc) {
        if (e.booleanValue()) {
            return c(str, str2 + Arrays.toString(exc.getStackTrace()));
        }
        return c(str, str2 + exc.getMessage());
    }

    public static int a(String str, String str2, boolean z) {
        return Log.e("HwMultiSIM", e(str, str2, z));
    }

    private static String e(String str, String str2, boolean z) {
        String str3;
        if (z) {
            str3 = d() + "->";
        } else {
            str3 = "";
        }
        return str + "->" + str3 + str2;
    }

    private static String d() {
        return "thread id = " + Thread.currentThread().getId();
    }

    public static int a(String str, String str2, Object... objArr) {
        return Log.i("HwMultiSIM", e(str, String.format(str2, objArr), false));
    }

    public static int c(String str, String str2, Object... objArr) {
        return Log.w("HwMultiSIM", e(str, String.format(str2, objArr), false));
    }

    public static int d(String str, String str2, Object... objArr) {
        return Log.e("HwMultiSIM", e(str, String.format(str2, objArr), false));
    }
}
