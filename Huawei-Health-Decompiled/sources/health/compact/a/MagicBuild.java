package health.compact.a;

/* JADX INFO: loaded from: classes.dex */
public final class MagicBuild extends BaseBuild {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f13767a;
    public static final boolean b;
    public static final String d;

    static {
        boolean z = ReflectionUtils.a("com.hihonor.android.os.Build") != null;
        b = z;
        f13767a = e(z ? ReflectionUtils.a("com.hihonor.android.os.Build$VERSION") : null, "MAGIC_SDK_INT", 0);
        d = z ? SystemProperties.e("ro.build.version.magic") : "";
    }

    private MagicBuild() {
    }

    private static int e(Class cls, String str, int i) {
        if (cls != null) {
            Object objA = ReflectionUtils.a((Class<?>) cls, str);
            if (objA instanceof Integer) {
                return ((Integer) objA).intValue();
            }
        }
        return i;
    }
}
