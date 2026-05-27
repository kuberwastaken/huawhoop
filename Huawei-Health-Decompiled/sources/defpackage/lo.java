package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class lo {
    public static void d(String str, String str2) {
        try {
            System.clearProperty(str);
        } catch (Throwable unused) {
        }
    }

    public static String c(String str) {
        try {
            System.clearProperty(str);
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }
}
