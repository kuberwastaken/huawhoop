package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.alipay.sdk.m.l0.e;
import com.huawei.agconnect.common.aaid.AaidUtils;

/* JADX INFO: loaded from: classes9.dex */
public class mw {
    public static volatile mw c = null;
    public static boolean e = false;
    public BroadcastReceiver h;
    public mv b = new mv("udid");
    public mv d = new mv("oaid");
    public mv j = new mv("vaid");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public mv f15905a = new mv(AaidUtils.f1731a);
    public mx f = new mx();

    public final void c(Context context) {
        synchronized (this) {
            if (this.h != null) {
                return;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.meizu.flyme.openid.ACTION_OPEN_ID_CHANGE");
            e eVar = new e();
            this.h = eVar;
            context.registerReceiver(eVar, intentFilter, "com.meizu.flyme.openid.permission.OPEN_ID_CHANGE", null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String a(android.content.Context r10, defpackage.mv r11) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "queryId : "
            r0.<init>(r1)
            java.lang.String r1 = r11.b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            android.content.ContentResolver r1 = r10.getContentResolver()     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
            r7 = 1
            java.lang.String[] r5 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
            java.lang.String r3 = r11.b     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
            r8 = 0
            r5[r8] = r3     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
            r3 = 0
            r4 = 0
            r6 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L97 java.lang.Exception -> L99
            if (r1 == 0) goto L77
            my r2 = bo_(r1)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r0 = r2.b     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r11.e(r0)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            long r3 = r2.c     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r11.c(r3)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            int r3 = r2.e     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r11.e(r3)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r3.<init>()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r4 = r11.b     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r3.append(r4)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r4 = " errorCode : "
            r3.append(r4)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            int r11 = r11.f15891a     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r3.append(r11)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r11 = r3.toString()     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            e(r11)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            int r11 = r2.e     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            r2 = 1000(0x3e8, float:1.401E-42)
            if (r11 == r2) goto L8e
            r9.c(r10)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            boolean r11 = r9.d(r10, r8)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            if (r11 != 0) goto L8e
            boolean r10 = r9.d(r10, r7)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r11 = "not support, forceQuery isSupported: "
            goto L87
        L77:
            boolean r11 = r9.d(r10, r8)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            if (r11 == 0) goto L8e
            boolean r10 = r9.d(r10, r7)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            java.lang.String r11 = "forceQuery isSupported : "
        L87:
            java.lang.String r10 = r11.concat(r10)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
            e(r10)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
        L8e:
            if (r1 == 0) goto Lb9
            goto Lb4
        L91:
            r10 = move-exception
            goto Lbb
        L93:
            r10 = move-exception
            r11 = r0
            r0 = r1
            goto L9b
        L97:
            r10 = move-exception
            goto Lba
        L99:
            r10 = move-exception
            r11 = r0
        L9b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = "queryId, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L97
            java.lang.String r10 = r10.getMessage()     // Catch: java.lang.Throwable -> L97
            r1.append(r10)     // Catch: java.lang.Throwable -> L97
            java.lang.String r10 = r1.toString()     // Catch: java.lang.Throwable -> L97
            e(r10)     // Catch: java.lang.Throwable -> L97
            if (r0 == 0) goto Lb8
            r1 = r0
            r0 = r11
        Lb4:
            r1.close()
            goto Lb9
        Lb8:
            r0 = r11
        Lb9:
            return r0
        Lba:
            r1 = r0
        Lbb:
            if (r1 == 0) goto Lc0
            r1.close()
        Lc0:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mw.a(android.content.Context, mv):java.lang.String");
    }

    public final boolean d(Context context, boolean z) {
        if (this.f.c() && !z) {
            return this.f.b();
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        String strBp_ = bp_(packageManager, "com.meizu.flyme.openidsdk");
        if (TextUtils.isEmpty(strBp_)) {
            return false;
        }
        String strBq_ = bq_(packageManager, strBp_);
        if (this.f.c() && this.f.a(strBq_)) {
            e("use same version cache, safeVersion : ".concat(String.valueOf(strBq_)));
            return this.f.b();
        }
        this.f.e(strBq_);
        boolean zD = d(context);
        e("query support, result : ".concat(String.valueOf(zD)));
        this.f.d(zD);
        return zD;
    }

    public final String c(Context context, mv mvVar) {
        String str;
        if (mvVar == null) {
            str = "getId, openId = null.";
        } else {
            if (mvVar.c()) {
                return mvVar.c;
            }
            if (d(context, true)) {
                return a(context, mvVar);
            }
            str = "getId, isSupported = false.";
        }
        e(str);
        return null;
    }

    public static String bq_(PackageManager packageManager, String str) {
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionName;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            e("getAppVersion, Exception : " + e2.getMessage());
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0057 A[PHI: r7
      0x0057: PHI (r7v3 android.database.Cursor) = (r7v2 android.database.Cursor), (r7v4 android.database.Cursor) binds: [B:18:0x0055, B:12:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(android.content.Context r8) {
        /*
            java.lang.String r0 = "querySupport version : 1.0.8"
            e(r0)
            java.lang.String r0 = "content://com.meizu.flyme.openidsdk/"
            android.net.Uri r2 = android.net.Uri.parse(r0)
            r0 = 0
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r8 = 1
            java.lang.String[] r5 = new java.lang.String[r8]     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            java.lang.String r3 = "supported"
            r5[r0] = r3     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r3 = 0
            r4 = 0
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            if (r7 == 0) goto L3a
            my r1 = bo_(r7)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            int r2 = r1.e     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r3 != r2) goto L35
            java.lang.String r2 = "0"
            java.lang.String r1 = r1.b     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L3d java.lang.Exception -> L3f
            if (r1 == 0) goto L36
        L35:
            r0 = r8
        L36:
            r7.close()
            return r0
        L3a:
            if (r7 == 0) goto L5a
            goto L57
        L3d:
            r8 = move-exception
            goto L5b
        L3f:
            r8 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3d
            java.lang.String r2 = "querySupport, Exception : "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L3d
            r1.append(r8)     // Catch: java.lang.Throwable -> L3d
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L3d
            e(r8)     // Catch: java.lang.Throwable -> L3d
            if (r7 == 0) goto L5a
        L57:
            r7.close()
        L5a:
            return r0
        L5b:
            if (r7 == 0) goto L60
            r7.close()
        L60:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mw.d(android.content.Context):boolean");
    }

    public static void e(String str) {
        if (e) {
            Log.d("OpenIdManager", str);
        }
    }

    public static String bp_(PackageManager packageManager, String str) {
        ProviderInfo providerInfoResolveContentProvider;
        if (packageManager == null || (providerInfoResolveContentProvider = packageManager.resolveContentProvider(str, 0)) == null || (providerInfoResolveContentProvider.applicationInfo.flags & 1) == 0) {
            return null;
        }
        return providerInfoResolveContentProvider.packageName;
    }

    public static final mw d() {
        if (c == null) {
            synchronized (mw.class) {
                if (c == null) {
                    c = new mw();
                }
            }
        }
        return c;
    }

    public static my bo_(Cursor cursor) {
        String str;
        my myVar = new my(null, 0);
        if (cursor == null) {
            str = "parseValue fail, cursor is null.";
        } else {
            if (!cursor.isClosed()) {
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex("value");
                if (columnIndex >= 0) {
                    myVar.b = cursor.getString(columnIndex);
                } else {
                    e("parseValue fail, index < 0.");
                }
                int columnIndex2 = cursor.getColumnIndex("code");
                if (columnIndex2 >= 0) {
                    myVar.e = cursor.getInt(columnIndex2);
                } else {
                    e("parseCode fail, index < 0.");
                }
                int columnIndex3 = cursor.getColumnIndex("expired");
                if (columnIndex3 >= 0) {
                    myVar.c = cursor.getLong(columnIndex3);
                } else {
                    e("parseExpired fail, index < 0.");
                }
                return myVar;
            }
            str = "parseValue fail, cursor is closed.";
        }
        e(str);
        return myVar;
    }
}
