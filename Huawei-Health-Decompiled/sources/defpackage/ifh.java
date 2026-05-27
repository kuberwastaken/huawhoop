package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public class ifh {
    private static Context e;

    public static void d(Context context) {
        if (context == null) {
            throw new RuntimeException("HealthApplication context is null");
        }
        e = context;
    }

    public static Context a() {
        return e;
    }
}
