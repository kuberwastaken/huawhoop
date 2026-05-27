package lib.android.paypal.com.magnessdk;

import android.content.Context;
import defpackage.xuw;
import java.io.File;
import lib.android.paypal.com.magnessdk.c;
import lib.android.paypal.com.magnessdk.log.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f15177a = 1000;
    private static final String b = "_TIME";
    private static final String c = "_DATA";

    protected abstract JSONObject a();

    protected abstract void a(JSONObject jSONObject);

    protected abstract JSONObject b();

    protected abstract JSONObject c();

    protected abstract String d();

    public String b(Context context, String str) {
        a.c(getClass(), 0, "Loading loadCachedConfigTime");
        return xuw.c(new File(context.getFilesDir(), str + b));
    }

    public static boolean c(Context context, String str) {
        a.c(b.class, 0, "entering deleteCachedConfigDataFromDisk");
        File file = new File(context.getFilesDir(), str + c);
        File filesDir = context.getFilesDir();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(b);
        return xuw.b(file) && xuw.b(new File(filesDir, sb.toString()));
    }

    public static boolean a(JSONObject jSONObject, long j, c.EnumC0332c enumC0332c) {
        return System.currentTimeMillis() > j + (jSONObject.optLong(enumC0332c == c.EnumC0332c.RAMP ? c.i.CONF_REFRESH_TIME_KEY.toString() : enumC0332c == c.EnumC0332c.REMOTE ? c.j.CONF_REFRESH_TIME_KEY.toString() : "", 0L) * 1000);
    }

    public static void a(Context context, String str, String str2) throws Throwable {
        a.c(b.class, 0, "entering saveConfigData");
        File file = new File(context.getFilesDir(), str2 + c);
        File file2 = new File(context.getFilesDir(), str2 + b);
        xuw.d(file, str);
        xuw.d(file2, String.valueOf(System.currentTimeMillis()));
    }

    public static JSONObject a(String str, Context context) {
        String strA;
        a.c(b.class, 0, "entering getCachedConfig");
        try {
            strA = a(context, str);
        } catch (Exception e) {
            a.d(b.class, 3, e);
        }
        if (strA.isEmpty()) {
            a.c(b.class, 0, "leaving getCachedConfig,cached config loaded empty");
            return null;
        }
        a.c(b.class, 0, "leaving getCachedConfig,cached config loadsuccessfully");
        return new JSONObject(strA);
    }

    protected static String a(Context context, String str) {
        a.c(b.class, 0, "Loading loadCachedConfigData");
        return xuw.c(new File(context.getFilesDir(), str + c));
    }
}
