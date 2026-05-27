package com.huawei.openalliance.ad.inter;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.hms.ads.inner.IECCallback;
import com.huawei.openalliance.ad.constant.Constants;
import com.huawei.openalliance.ad.hq;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f7277a = new byte[0];
    private static a b;
    private IECCallback c;
    private String d;

    public String c() {
        return this.d;
    }

    public String b() {
        IECCallback iECCallback = this.c;
        if (iECCallback != null) {
            return iECCallback.getAccessToken();
        }
        hq.b("ECATManager", "accessTokenProvider is null, return");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[PHI: r1
      0x0033: PHI (r1v2 android.net.Uri) = (r1v1 android.net.Uri), (r1v7 android.net.Uri) binds: [B:9:0x001a, B:11:0x002e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.content.Context r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "ECATManager"
            if (r6 != 0) goto L8
            java.lang.String r6 = "context is null."
            goto L83
        L8:
            boolean r1 = android.text.TextUtils.isEmpty(r7)
            if (r1 == 0) goto L12
            java.lang.String r6 = "url is null."
            goto L83
        L12:
            android.net.Uri r1 = r5.b(r7)
            boolean r2 = r5.a(r1)
            if (r2 != 0) goto L33
            java.lang.String r1 = "url invalid."
            com.huawei.openalliance.ad.hq.b(r0, r1)
            java.lang.String r7 = r5.c(r7)
            android.net.Uri r1 = r5.b(r7)
            boolean r7 = r5.a(r1)
            if (r7 != 0) goto L33
            java.lang.String r6 = "decode url invalid."
            goto L83
        L33:
            java.lang.String r7 = com.huawei.openalliance.ad.utils.j.d(r6)
            boolean r2 = android.text.TextUtils.isEmpty(r7)
            if (r2 == 0) goto L40
            java.lang.String r6 = "not install hms."
            goto L83
        L40:
            android.content.Intent r2 = new android.content.Intent     // Catch: java.lang.Throwable -> L6c
            java.lang.String r3 = "android.intent.action.VIEW"
            r2.<init>(r3, r1)     // Catch: java.lang.Throwable -> L6c
            r2.setPackage(r7)     // Catch: java.lang.Throwable -> L6c
            boolean r7 = r6 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L6c
            if (r7 != 0) goto L53
            r7 = 268435456(0x10000000, float:2.524355E-29)
            r2.addFlags(r7)     // Catch: java.lang.Throwable -> L6c
        L53:
            android.os.Bundle r7 = new android.os.Bundle     // Catch: java.lang.Throwable -> L6c
            r7.<init>()     // Catch: java.lang.Throwable -> L6c
            java.lang.String r1 = "openFromSDK"
            r3 = 1
            r7.putBoolean(r1, r3)     // Catch: java.lang.Throwable -> L6c
            java.lang.String r1 = "accessToken"
            java.lang.String r4 = r5.d     // Catch: java.lang.Throwable -> L6c
            r7.putString(r1, r4)     // Catch: java.lang.Throwable -> L6c
            r2.putExtras(r7)     // Catch: java.lang.Throwable -> L6c
            r6.startActivity(r2)     // Catch: java.lang.Throwable -> L6c
            return r3
        L6c:
            r6 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r1 = "openLandingPage exception "
            r7.<init>(r1)
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getSimpleName()
            r7.append(r6)
            java.lang.String r6 = r7.toString()
        L83:
            com.huawei.openalliance.ad.hq.b(r0, r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.inter.a.a(android.content.Context, java.lang.String):boolean");
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(IECCallback iECCallback) {
        this.c = iECCallback;
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Uri.decode(str);
        } catch (Throwable th) {
            hq.b("ECATManager", "decodeUrl exception " + th.getClass().getSimpleName());
            return null;
        }
    }

    private Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Uri.parse(str);
        } catch (Throwable th) {
            hq.b("ECATManager", "getUri exception " + th.getClass().getSimpleName());
            return null;
        }
    }

    private boolean a(Uri uri) {
        String str;
        if (uri == null) {
            str = "uri is null.";
        } else if (URLUtil.isNetworkUrl(uri.toString())) {
            str = "uri is http or https url.";
        } else {
            try {
                String host = uri.getHost();
                if (TextUtils.equals("hwpps", uri.getScheme())) {
                    return TextUtils.equals(Constants.SCHEME_HOST, host);
                }
                return false;
            } catch (Throwable th) {
                str = "isUriValid exception " + th.getClass().getSimpleName();
            }
        }
        hq.b("ECATManager", str);
        return false;
    }

    public static a a() {
        a aVar;
        synchronized (f7277a) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    private a() {
    }
}
