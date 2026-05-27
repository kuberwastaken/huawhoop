package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public class aup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f329a = false;
    private static int c;
    private static int d;
    private static int e;

    public static int a() {
        return e;
    }

    public static void b() {
        d = 0;
    }

    public static boolean c() {
        return f329a;
    }

    public static int d() {
        return d;
    }

    public static int e() {
        return c;
    }

    public static void c(int i) {
        avi.b("CloudSyncCompatibility", "setHisyncOldVersion, oldVersion = " + i);
        e = i;
    }

    public static void d(int i) {
        d = i;
    }

    public static void e(int i) {
        c = i;
    }

    public static void a(boolean z) {
        avi.b("CloudSyncCompatibility", "IsRecycleProcess = " + z);
        f329a = z;
    }
}
