package defpackage;

import android.util.Log;
import com.huawei.openalliance.ad.constant.Constants;

/* JADX INFO: loaded from: classes8.dex */
public class ybi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<StringBuilder> f19225a = new ThreadLocal<StringBuilder>() { // from class: ybi.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };
    private static boolean b = true;
    private static boolean e = false;

    static {
        try {
            e = Log.isLoggable("HiChain", 3);
            b = Log.isLoggable("HiChain", 4);
        } catch (IllegalArgumentException unused) {
            d("HiChain", "error:getLogField--IllegalArgumentException");
        }
    }

    public static void e(String str, String str2) {
        if (b) {
            Log.i("HiChain", str + ":" + str2);
        }
    }

    public static void b(String str, Object... objArr) {
        if (b) {
            Log.i("HiChain", str + ":" + a(objArr));
        }
    }

    public static void b(String str, String str2) {
        Log.w("HiChain", str + ":" + str2);
    }

    public static void d(String str, String str2) {
        Log.e("HiChain", str + ":" + str2);
    }

    private static String a(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "NULL";
        }
        StringBuilder sbC = c();
        for (Object obj : objArr) {
            sbC.append(obj);
        }
        return sbC.toString().replaceAll("[\t" + System.lineSeparator() + "]", Constants.LINK);
    }

    private static StringBuilder c() {
        StringBuilder sb = f19225a.get();
        sb.setLength(0);
        return sb;
    }
}
