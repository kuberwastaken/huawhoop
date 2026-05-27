package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class kjs {
    private static final String[] d = {""};

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : d) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }
}
