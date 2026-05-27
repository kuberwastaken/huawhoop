package health.compact.a;

/* JADX INFO: loaded from: classes.dex */
public final class SystemProperties {
    private static SystemPropertiesReader e;

    static {
        try {
            e = new SystemPropertiesReader("android.os.SystemProperties");
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            LogUtil.d("HAF_SystemProperties", "init SystemProperties ex=", LogUtil.c(e2));
        }
    }

    private SystemProperties() {
    }

    public static String e(String str) {
        return c(str, "");
    }

    public static String c(String str, String str2) {
        SystemPropertiesReader systemPropertiesReader = e;
        return systemPropertiesReader != null ? systemPropertiesReader.c(str, str2) : str2;
    }

    public static boolean b(String str, boolean z) {
        SystemPropertiesReader systemPropertiesReader = e;
        return systemPropertiesReader != null ? systemPropertiesReader.c(str, z) : z;
    }

    public static int d(String str, int i) {
        SystemPropertiesReader systemPropertiesReader = e;
        return systemPropertiesReader != null ? systemPropertiesReader.c(str, i) : i;
    }
}
