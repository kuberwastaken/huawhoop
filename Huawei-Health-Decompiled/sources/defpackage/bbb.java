package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class bbb {
    public static boolean e(String str, boolean z) {
        String str2;
        try {
            return ((Boolean) Class.forName("android.os.SystemProperties").getMethod("getBoolean", String.class, Boolean.TYPE).invoke(null, str, Boolean.valueOf(z))).booleanValue();
        } catch (ClassNotFoundException e) {
            e = e;
            str2 = "ClassNotFoundException while getting system property: ";
            bbf.c("SystemPropertiesEx", str2, e);
            return z;
        } catch (Exception e2) {
            e = e2;
            str2 = "Exception while getting system property: ";
            bbf.c("SystemPropertiesEx", str2, e);
            return z;
        }
    }

    public static String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            bbf.c("SystemPropertiesEx", "ClassNotFoundException while getting system property: ", e);
            return "";
        } catch (Exception e2) {
            bbf.c("SystemPropertiesEx", "Exception while getting system property: ", e2);
            return str2;
        }
    }

    public static String b(String str) {
        String str2;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
        } catch (ClassNotFoundException e) {
            e = e;
            str2 = "ClassNotFoundException while getting system property: ";
            bbf.c("SystemPropertiesEx", str2, e);
            return "";
        } catch (Exception e2) {
            e = e2;
            str2 = "Exception while getting system property: ";
            bbf.c("SystemPropertiesEx", str2, e);
            return "";
        }
    }

    public static int a(String str, int i) {
        String str2;
        try {
            return ((Integer) Class.forName("android.os.SystemProperties").getMethod("getInt", String.class, Integer.TYPE).invoke(null, str, Integer.valueOf(i))).intValue();
        } catch (ClassNotFoundException e) {
            e = e;
            str2 = "ClassNotFoundException while getting system property: ";
            bbf.c("SystemPropertiesEx", str2, e);
            return i;
        } catch (Exception e2) {
            e = e2;
            str2 = "Exception while getting system property: ";
            bbf.c("SystemPropertiesEx", str2, e);
            return i;
        }
    }
}
