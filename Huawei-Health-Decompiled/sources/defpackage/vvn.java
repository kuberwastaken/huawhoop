package defpackage;

import android.content.Context;
import com.huawei.wear.healthadapter.HealthAdapter;

/* JADX INFO: loaded from: classes8.dex */
public class vvn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HealthAdapter f18808a;
    private static Context d;

    public static Context a() {
        return d;
    }

    public static void d(Context context) {
        d = context;
    }

    public static HealthAdapter e() {
        return f18808a;
    }

    public static void b(HealthAdapter healthAdapter) {
        f18808a = healthAdapter;
    }
}
