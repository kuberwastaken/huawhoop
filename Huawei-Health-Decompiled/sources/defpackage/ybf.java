package defpackage;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes8.dex */
public class ybf {
    private static Context c;

    public static int d(Context context) {
        if (context == null) {
            ybi.d("GlobalContext", "Context is null");
            return -1;
        }
        Context applicationContext = context.getApplicationContext();
        c = applicationContext;
        if (applicationContext != null && !TextUtils.isEmpty(applicationContext.getPackageName())) {
            return 0;
        }
        ybi.d("GlobalContext", "Invalid context.");
        return -1;
    }

    public static String d() {
        return c.getPackageName();
    }
}
