package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Random;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class op {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static op f16463a;
    public static Context c;
    public String b;
    public long d;
    public String e;
    public String f;
    public boolean i = false;
    public String j;

    public String a() {
        return this.e;
    }

    public final void a(Context context) {
        if (context != null) {
            c = context.getApplicationContext();
        }
        if (this.i) {
            return;
        }
        this.i = true;
        j();
    }

    public final String c() {
        return Long.toHexString(System.currentTimeMillis()) + (new Random().nextInt(9000) + 1000);
    }

    public String d() {
        String hexString = Long.toHexString(System.currentTimeMillis());
        return hexString.length() > 10 ? hexString.substring(hexString.length() - 10) : hexString;
    }

    public String e() {
        return this.b;
    }

    public final void f() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tid", this.e);
            jSONObject.put("client_key", this.b);
            jSONObject.put("timestamp", this.d);
            jSONObject.put("vimei", this.j);
            jSONObject.put("vimsi", this.f);
            c.d("alipay_tid_storage", "tidinfo", jSONObject.toString(), true);
        } catch (Exception e) {
            ov.b(e);
        }
    }

    public final void g() {
        this.e = "";
        this.b = d();
        this.d = System.currentTimeMillis();
        this.j = c();
        this.f = c();
        c.c("alipay_tid_storage", "tidinfo");
    }

    public final void i() {
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void j() {
        /*
            r9 = this;
            java.lang.String r0 = ""
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            r2 = 0
            java.lang.String r3 = "alipay_tid_storage"
            java.lang.String r4 = "tidinfo"
            r5 = 1
            java.lang.String r3 = op.c.e(r3, r4, r5)     // Catch: java.lang.Exception -> L51
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L51
            if (r4 != 0) goto L4d
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L51
            r4.<init>(r3)     // Catch: java.lang.Exception -> L51
            java.lang.String r3 = "tid"
            java.lang.String r3 = r4.optString(r3, r0)     // Catch: java.lang.Exception -> L51
            java.lang.String r5 = "client_key"
            java.lang.String r5 = r4.optString(r5, r0)     // Catch: java.lang.Exception -> L4b
            java.lang.String r6 = "timestamp"
            long r7 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L48
            long r6 = r4.optLong(r6, r7)     // Catch: java.lang.Exception -> L48
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch: java.lang.Exception -> L48
            java.lang.String r6 = "vimei"
            java.lang.String r6 = r4.optString(r6, r0)     // Catch: java.lang.Exception -> L48
            java.lang.String r7 = "vimsi"
            java.lang.String r2 = r4.optString(r7, r0)     // Catch: java.lang.Exception -> L46
            goto L58
        L46:
            r0 = move-exception
            goto L55
        L48:
            r0 = move-exception
            r6 = r2
            goto L55
        L4b:
            r0 = move-exception
            goto L53
        L4d:
            r0 = r2
            r5 = r0
            r6 = r5
            goto L5a
        L51:
            r0 = move-exception
            r3 = r2
        L53:
            r5 = r2
            r6 = r5
        L55:
            defpackage.ov.b(r0)
        L58:
            r0 = r2
            r2 = r3
        L5a:
            java.lang.String r3 = "mspl"
            java.lang.String r4 = "tid_str: load"
            defpackage.ov.d(r3, r4)
            boolean r3 = r9.d(r2, r5, r6, r0)
            if (r3 == 0) goto L6b
            r9.g()
            goto L79
        L6b:
            r9.e = r2
            r9.b = r5
            long r1 = r1.longValue()
            r9.d = r1
            r9.j = r6
            r9.f = r0
        L79:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.op.j():void");
    }

    public static op b(Context context) {
        op opVar;
        synchronized (op.class) {
            if (f16463a == null) {
                f16463a = new op();
            }
            if (c == null) {
                f16463a.a(context);
            }
            opVar = f16463a;
        }
        return opVar;
    }

    public static class c {
        public static void c(String str, String str2) {
            if (op.c == null) {
                return;
            }
            op.c.getSharedPreferences(str, 0).edit().remove(str2).apply();
        }

        public static String e(String str, String str2, boolean z) {
            if (op.c == null) {
                return null;
            }
            String string = op.c.getSharedPreferences(str, 0).getString(str2, null);
            if (!TextUtils.isEmpty(string) && z) {
                string = nm.d(a(), string, string);
                if (TextUtils.isEmpty(string)) {
                    ov.d("mspl", "tid_str: pref failed");
                }
            }
            ov.d("mspl", "tid_str: from local");
            return string;
        }

        public static void d(String str, String str2, String str3, boolean z) {
            if (op.c == null) {
                return;
            }
            SharedPreferences sharedPreferences = op.c.getSharedPreferences(str, 0);
            if (z) {
                String strA = a();
                String strC = nm.c(strA, str3, str3);
                if (TextUtils.isEmpty(strC)) {
                    String.format("LocalPreference::putLocalPreferences failed %s，%s", str3, strA);
                }
                str3 = strC;
            }
            sharedPreferences.edit().putString(str2, str3).apply();
        }

        public static String a() {
            String packageName;
            try {
                packageName = op.c.getApplicationContext().getPackageName();
            } catch (Throwable th) {
                ov.b(th);
                packageName = "";
            }
            return (packageName + "0000000000000000000000000000").substring(0, 24);
        }
    }

    public final boolean d(String str, String str2, String str3, String str4) {
        return TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4);
    }

    public void c(String str, String str2) {
        ov.d("mspl", "tid_str: save");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.e = str;
        this.b = str2;
        this.d = System.currentTimeMillis();
        f();
        i();
    }
}
