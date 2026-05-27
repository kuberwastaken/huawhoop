package defpackage;

import android.util.Log;
import com.huawei.wisesecurity.ucs.common.log.ILogUcs;
import java.text.MessageFormat;

/* JADX INFO: loaded from: classes8.dex */
public class wzg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ILogUcs f18986a = new wzd();

    public static void b(String str, String str2, Object... objArr) {
        ILogUcs iLogUcs = f18986a;
        if (iLogUcs != null) {
            iLogUcs.w(a(str), c(str, str2, objArr));
        }
    }

    public static void d(ILogUcs iLogUcs) {
        if (iLogUcs != null) {
            f18986a = iLogUcs;
        }
    }

    public static void a(String str, String str2, Object... objArr) {
        ILogUcs iLogUcs = f18986a;
        if (iLogUcs != null) {
            iLogUcs.i(a(str), c(str, str2, objArr));
        }
    }

    private static String a(String str) {
        return "UCS-" + str;
    }

    private static String c(String str, String str2, Object... objArr) {
        try {
            return MessageFormat.format(str2, objArr);
        } catch (Throwable th) {
            Log.e(str, "log error : " + th.getMessage());
            return "return default";
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        ILogUcs iLogUcs = f18986a;
        if (iLogUcs != null) {
            iLogUcs.e(a(str), c(str, str2, objArr));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        ILogUcs iLogUcs = f18986a;
        if (iLogUcs != null) {
            iLogUcs.d(a(str), c(str, str2, objArr));
        }
    }
}
