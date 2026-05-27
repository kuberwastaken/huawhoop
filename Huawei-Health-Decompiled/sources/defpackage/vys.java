package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class vys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile vys f18844a;
    private static final byte[] b = new byte[0];

    public String d(String str, String str2) {
        return str2;
    }

    public static vys a() {
        if (f18844a == null) {
            synchronized (b) {
                if (f18844a == null) {
                    f18844a = new vys();
                }
            }
        }
        return f18844a;
    }
}
