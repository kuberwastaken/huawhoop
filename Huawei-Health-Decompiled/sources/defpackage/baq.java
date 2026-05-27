package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class baq {
    private static volatile baq b;
    private static final Object c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f395a;
    private long d;
    private String e;

    public long f() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public long b() {
        try {
            return this.f395a.getLong("providerUpdateTime", 0L);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public String e() {
        return this.f395a.getString("homeCountryInProvider", null);
    }

    public void a(String str) {
        this.e = str;
        this.d = str != null ? System.currentTimeMillis() : 0L;
    }

    public long d() {
        try {
            return this.f395a.getLong("effectiveduration", 47839000L);
        } catch (Exception unused) {
            return 47839000L;
        }
    }

    public void c(String str) {
        try {
            this.f395a.edit().putString("homeCountryInProvider", str).commit();
            this.f395a.edit().putLong("providerUpdateTime", System.currentTimeMillis()).commit();
        } catch (Exception unused) {
            Log.e("HomeCountrySharedPreference", "setHomeCountryInProvider, putString error");
        }
    }

    public void e(long j) {
        try {
            this.f395a.edit().putLong("effectiveduration", j).commit();
        } catch (Exception unused) {
            Log.e("HomeCountrySharedPreference", "setEffectiveDuration, putLong error");
        }
    }

    public void a() {
        try {
            SharedPreferences.Editor editorEdit = this.f395a.edit();
            editorEdit.clear();
            editorEdit.commit();
        } catch (Exception unused) {
            Log.e("HomeCountrySharedPreference", "clear error");
        }
    }

    public static baq b(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new baq(context);
                }
            }
        }
        return b;
    }

    private baq(Context context) {
        try {
            this.f395a = context.createDeviceProtectedStorageContext().getSharedPreferences("MarketHomeCountry.DataStorage", 0);
        } catch (Exception unused) {
            Log.e("HomeCountrySharedPreference", "getSharedPreference error");
        }
    }
}
