package health.compact.a;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class HuaweiHealth {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f13756a;

    private HuaweiHealth() {
    }

    public static void e(Context context) {
        f13756a = context;
    }

    public static Context b() {
        return f13756a;
    }

    public static String d() {
        Context context = f13756a;
        return context != null ? context.getPackageName() : "com.huawei.health";
    }
}
