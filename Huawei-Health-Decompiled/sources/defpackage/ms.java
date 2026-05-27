package defpackage;

import android.content.Context;
import defpackage.kk;

/* JADX INFO: loaded from: classes9.dex */
public class ms {
    public static void d(Context context) {
        kj.e = kk.b.b.e(context.getApplicationContext());
        kj.f14704a = true;
    }

    public static String e(Context context) {
        if (kj.f14704a) {
            return kk.b.b.d(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static boolean e() {
        if (kj.f14704a) {
            return kj.e;
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
