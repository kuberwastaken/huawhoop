package health.compact.a;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class BaseBuild {
    private static final Class d = c();
    private static final int b = i();
    private static final boolean c = g();

    public static boolean a() {
        return "HONOR".equals(Build.MANUFACTURER);
    }

    protected static boolean b() {
        return d != null;
    }

    protected static int d() {
        return b;
    }

    protected static boolean e() {
        return c;
    }

    private static int i() {
        if (!a() && b()) {
            return SystemProperties.d("ro.build.hw_emui_api_level", 0);
        }
        return 0;
    }

    private static Class c() {
        try {
            return ReflectionUtils.b("com.huawei.android.os.BuildEx");
        } catch (ClassNotFoundException e) {
            LogUtil.d("HAF_SystemBuild", "getEmuiBuildEx ex=", LogUtil.c(e));
            return null;
        }
    }

    private static boolean g() {
        String str;
        Object objE;
        if (a()) {
            return false;
        }
        try {
            objE = ReflectionUtils.e(ReflectionUtils.b("com.huawei.system.BuildEx"), "getOsBrand");
        } catch (ClassNotFoundException e) {
            LogUtil.d("HAF_SystemBuild", "isHarmonySystemImpl ex=", LogUtil.c(e));
        } catch (Exception e2) {
            LogUtil.d("HAF_SystemBuild", "isHarmonySystemImpl ex=", LogUtil.c(e2));
        }
        if (objE instanceof String) {
            str = (String) objE;
        } else {
            str = "";
        }
        return "harmony".equals(str);
    }
}
