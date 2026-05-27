package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes4.dex */
public class ecq {
    private String b;
    private Context e;

    public ecq(Context context, String str) {
        this.b = str;
        this.e = context;
    }

    public String a(String str) {
        Context context = this.e;
        if (context == null) {
            return "0";
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.b, 0);
        return !sharedPreferences.contains(str) ? "0" : sharedPreferences.getString(str, "0");
    }

    public boolean d(String str) {
        Context context = this.e;
        if (context == null) {
            return false;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.b, 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getBoolean(str, false);
        }
        return false;
    }
}
