package defpackage;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes9.dex */
class tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile tb f17930a;
    private final SharedPreferences c;

    static tb d(Context context) {
        if (f17930a == null) {
            synchronized (tb.class) {
                if (f17930a == null) {
                    f17930a = new tb(bN_(context));
                }
            }
        }
        return f17930a;
    }

    private static SharedPreferences bN_(Context context) {
        return context.getSharedPreferences("com.braintreepayments.api.SHARED_PREFERENCES", 0);
    }

    tb(SharedPreferences sharedPreferences) {
        this.c = sharedPreferences;
    }

    String d(String str, String str2) {
        return this.c.getString(str, str2);
    }

    void e(String str, String str2) {
        this.c.edit().putString(str, str2).apply();
    }

    boolean c(String str) {
        return this.c.contains(str);
    }

    long a(String str) {
        return this.c.getLong(str, 0L);
    }

    void d(String str, String str2, String str3, long j) {
        this.c.edit().putString(str, str2).putLong(str3, j).apply();
    }
}
