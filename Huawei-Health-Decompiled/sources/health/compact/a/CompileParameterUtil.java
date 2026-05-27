package health.compact.a;

/* JADX INFO: loaded from: classes.dex */
public class CompileParameterUtil {
    private CompileParameterUtil() {
    }

    public static String a(String str) {
        return BuildConfigProperties.a(str);
    }

    public static String d(String str, String str2) {
        return BuildConfigProperties.e(str, str2);
    }

    public static boolean b(String str) {
        return BuildConfigProperties.e(str, false);
    }

    public static boolean e(String str, boolean z) {
        return BuildConfigProperties.e(str, z);
    }
}
