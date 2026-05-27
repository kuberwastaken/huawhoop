package com.huawei.updatesdk.b.h;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class a {
    private static final Map<Integer, String> d;
    private static a e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f11349a;
    private int b = 0;
    private String c = "";

    public String c() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int a() {
        return this.f11349a;
    }

    private void h() {
        try {
            Class<?> cls = Class.forName("com.hihonor.android.os.Build");
            String str = (String) cls.getDeclaredField("MAGIC_VERSION").get(cls);
            if (str == null) {
                str = "";
            }
            this.c = str;
        } catch (Throwable th) {
            com.huawei.updatesdk.a.a.a.c("SystemSupportUtil", "initMagicVersion, error: " + th.getMessage());
        }
    }

    private void g() {
        try {
            Class<?> cls = Class.forName("com.hihonor.android.os.Build$VERSION");
            this.b = cls.getDeclaredField("MAGIC_SDK_INT").getInt(cls);
        } catch (Throwable th) {
            com.huawei.updatesdk.a.a.a.c("SystemSupportUtil", "initMagicApiLevel, error: " + th.getMessage());
        }
    }

    public static a f() {
        return e;
    }

    private int e() {
        return com.huawei.updatesdk.a.a.d.i.c.a("ro.build.hw_emui_api_level", 0);
    }

    private int d() {
        String strA = a(com.huawei.updatesdk.a.a.d.i.c.a("ro.build.version.emui", ""));
        if (TextUtils.isEmpty(strA)) {
            return 0;
        }
        for (Map.Entry<Integer, String> entry : d.entrySet()) {
            if (strA.equals(entry.getValue())) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    private String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length == 2) {
                return strArrSplit[1];
            }
        }
        return "";
    }

    private a() {
        int iE = e();
        this.f11349a = iE;
        if (iE == 0) {
            this.f11349a = d();
        }
        g();
        h();
        com.huawei.updatesdk.a.a.a.b("SystemSupportUtil", "emuiVersion:" + this.f11349a + ", magicApiLevel:" + this.b + ", magicVersion:" + this.c);
    }

    static {
        HashMap map = new HashMap();
        d = map;
        e = new a();
        map.put(1, "1.0");
        map.put(2, "1.5");
        map.put(3, "1.6");
        map.put(4, "2.0");
        map.put(5, "2.0");
        map.put(6, "2.3");
        map.put(7, "3.0");
        map.put(8, "3.0.5");
        map.put(8, "3.1");
        map.put(9, "4.0");
        map.put(10, "4.1");
        map.put(11, "5.0");
        map.put(12, "5.1");
    }
}
