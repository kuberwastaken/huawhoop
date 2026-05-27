package defpackage;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes9.dex */
public class mu {
    public static Method e;

    public static String a(Context context) {
        mw mwVarD = mw.d();
        return mwVarD.c(context.getApplicationContext(), mwVarD.d);
    }

    public static final boolean b() {
        Context context = null;
        try {
            if (e == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                e = method;
                method.setAccessible(true);
            }
            context = (Context) e.invoke(null, new Object[0]);
        } catch (Exception e2) {
            Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e2.toString());
        }
        if (context == null) {
            return false;
        }
        return mw.d().d(context, false);
    }
}
