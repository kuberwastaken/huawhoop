package health.compact.a;

/* JADX INFO: loaded from: classes.dex */
public final class HarmonyBuild extends BaseBuild {
    public static final boolean b = e();
    public static final String e = f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f13747a = g();
    public static final int c = c();

    private HarmonyBuild() {
    }

    private static String f() {
        return !e() ? "" : SystemProperties.e("hw_sc.build.platform.version");
    }

    private static boolean g() {
        if (e()) {
            return SystemProperties.b(com.huawei.openalliance.ad.constant.SystemProperties.HW_SC_BUILD_OS_ENABLE, false);
        }
        return false;
    }

    private static int c() {
        if (e()) {
            return SystemProperties.d(com.huawei.openalliance.ad.constant.SystemProperties.HW_SC_BUILD_OS_API_VERSION, 0);
        }
        return 0;
    }
}
