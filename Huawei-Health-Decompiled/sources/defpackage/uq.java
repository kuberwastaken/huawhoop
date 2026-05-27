package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes9.dex */
class uq {
    uq() {
    }

    static void e(String str, String str2, Context context) {
        context.getApplicationContext().getSharedPreferences("com.braintreepayment.browserswitch.persistentstore", 0).edit().putString(str, str2).apply();
    }

    static String a(String str, Context context) {
        return context.getApplicationContext().getSharedPreferences("com.braintreepayment.browserswitch.persistentstore", 0).getString(str, null);
    }

    static void e(String str, Context context) {
        context.getApplicationContext().getSharedPreferences("com.braintreepayment.browserswitch.persistentstore", 0).edit().remove(str).apply();
    }
}
