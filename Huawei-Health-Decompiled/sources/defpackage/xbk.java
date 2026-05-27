package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes8.dex */
public class xbk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static xbk f18997a;
    private SharedPreferences b;

    public boolean b(String str, String str2) {
        try {
            this.b.edit().putString(str, str2).apply();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String e(String str, String str2) {
        return this.b.getString(str, str2);
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static xbk f18998a = new xbk();
    }

    public static xbk e(Context context) {
        if (context == null) {
            return null;
        }
        if (f18997a == null) {
            xbk xbkVar = d.f18998a;
            f18997a = xbkVar;
            xbkVar.b = context.getSharedPreferences("com.zhangyue.iReader.sdk.scheme.SharedPreferences", 0);
        }
        return f18997a;
    }

    private xbk() {
    }
}
