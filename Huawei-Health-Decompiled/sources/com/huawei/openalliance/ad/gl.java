package com.huawei.openalliance.ad;

import android.os.Bundle;
import android.os.IBinder;

/* JADX INFO: loaded from: classes6.dex */
public class gl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Bundle f7129a;

    public String toString() {
        try {
            return this.f7129a.toString();
        } catch (Throwable unused) {
            hq.d("SafeBundle", "toString exception.");
            return null;
        }
    }

    public IBinder e(String str) {
        try {
            return this.f7129a.getBinder(str);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "getBinder exception ex.");
            return null;
        }
    }

    public String d(String str) {
        try {
            return this.f7129a.getString(str);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "getString exception ex.");
            return "";
        }
    }

    public long c(String str) {
        return a(str, 0L);
    }

    public gl b(String str, boolean z) {
        try {
            this.f7129a.putBoolean(str, z);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "putBoolean exception ex.");
        }
        return this;
    }

    public gl b(String str, String str2) {
        try {
            this.f7129a.putString(str, str2);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "putString exception ex.");
        }
        return this;
    }

    public gl b(String str, long j) {
        try {
            this.f7129a.putLong(str, j);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "putLong exception ex.");
        }
        return this;
    }

    public gl b(String str, int i) {
        try {
            this.f7129a.putInt(str, i);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "putInt exception ex.");
        }
        return this;
    }

    public int b(String str) {
        return a(str, 0);
    }

    public boolean a(String str, boolean z) {
        try {
            return this.f7129a.getBoolean(str, z);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "getBoolean exception  ex.");
            return z;
        }
    }

    public boolean a(String str) {
        return a(str, false);
    }

    public String a(String str, String str2) {
        try {
            return this.f7129a.getString(str, str2);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "getString exception ex.");
            return str2;
        }
    }

    public gl a(String str, IBinder iBinder) {
        try {
            this.f7129a.putBinder(str, iBinder);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "putBundle exception ex.");
        }
        return this;
    }

    public Bundle a() {
        return this.f7129a;
    }

    public long a(String str, long j) {
        try {
            return this.f7129a.getLong(str, j);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "getLong exception ex.");
            return j;
        }
    }

    public int a(String str, int i) {
        try {
            return this.f7129a.getInt(str, i);
        } catch (Throwable unused) {
            hq.d("SafeBundle", "getInt exception ex.");
            return i;
        }
    }

    public gl(Bundle bundle) {
        this.f7129a = bundle == null ? new Bundle() : bundle;
    }

    public gl() {
        this(new Bundle());
    }
}
