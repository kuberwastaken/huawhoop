package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class mkg {
    public static int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            mly.b("CloudSettings-Util", "paseInt error " + e.getClass().getSimpleName(), true);
            return -1;
        }
    }
}
