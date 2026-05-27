package com.huawei.hwcloudjs.d.c.a;

import android.content.SharedPreferences;
import com.huawei.hwcloudjs.c;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f6412a = null;
    private static final String b = "SharedPreferencesStorage";

    public String c() {
        return com.huawei.hwcloudjs.b.a.a() != null ? com.huawei.hwcloudjs.b.a.a().getSharedPreferences(c.t, 0).getString(c.u, "") : "";
    }

    public void b(String str) {
        if (com.huawei.hwcloudjs.b.a.a() != null) {
            SharedPreferences.Editor editorEdit = com.huawei.hwcloudjs.b.a.a().getSharedPreferences(c.t, 0).edit();
            editorEdit.putString(c.u, str);
            editorEdit.commit();
        }
    }

    public boolean a(String str) {
        if (com.huawei.hwcloudjs.b.a.a() != null) {
            return com.huawei.hwcloudjs.b.a.a().getSharedPreferences(c.t, 0).getBoolean(str, false);
        }
        return false;
    }

    public void a(String str, boolean z) {
        if (com.huawei.hwcloudjs.b.a.a() != null) {
            SharedPreferences.Editor editorEdit = com.huawei.hwcloudjs.b.a.a().getSharedPreferences(c.t, 0).edit();
            editorEdit.putBoolean(str, z);
            editorEdit.commit();
        }
    }

    public void a() {
        if (com.huawei.hwcloudjs.b.a.a() != null) {
            com.huawei.hwcloudjs.b.a.a().getSharedPreferences(c.t, 0).edit().clear().commit();
        }
    }

    public static a b() {
        a aVar;
        synchronized (a.class) {
            if (f6412a == null) {
                f6412a = new a();
            }
            aVar = f6412a;
        }
        return aVar;
    }

    private a() {
    }
}
