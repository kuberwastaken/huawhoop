package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class wut {
    private static Context d;

    public static void e(Context context) {
        if (context != null) {
            d = context.getApplicationContext();
        }
    }

    public static Context d() {
        return d;
    }

    public static String e(Context context, String str) throws Throwable {
        if (context == null || TextUtils.isEmpty(str)) {
            wrm.e("PackageUtil", "getPackageFingerprint params is empty");
            return null;
        }
        Certificate certificateB = b(context, str);
        if (certificateB != null) {
            try {
                return wup.a(c(certificateB.getEncoded()), true);
            } catch (CertificateEncodingException unused) {
                wrm.b("PackageUtil", "getPackageFingerprint CertificateEncodingException");
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.cert.Certificate b(android.content.Context r4, java.lang.String r5) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "getPackageCertificate IOException"
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            java.lang.String r1 = "PackageUtil"
            r2 = 0
            if (r4 != 0) goto L11
            java.lang.String r4 = "getPackageManager is null"
            defpackage.wrm.b(r1, r4)
            return r2
        L11:
            r3 = 64
            android.content.pm.PackageInfo r4 = r4.getPackageInfo(r5, r3)     // Catch: java.lang.Throwable -> L3e java.security.cert.CertificateException -> L40 android.content.pm.PackageManager.NameNotFoundException -> L49
            if (r4 == 0) goto L58
            android.content.pm.Signature[] r5 = r4.signatures     // Catch: java.lang.Throwable -> L3e java.security.cert.CertificateException -> L40 android.content.pm.PackageManager.NameNotFoundException -> L49
            int r5 = r5.length     // Catch: java.lang.Throwable -> L3e java.security.cert.CertificateException -> L40 android.content.pm.PackageManager.NameNotFoundException -> L49
            if (r5 <= 0) goto L58
            android.content.pm.Signature[] r4 = r4.signatures     // Catch: java.lang.Throwable -> L3e java.security.cert.CertificateException -> L40 android.content.pm.PackageManager.NameNotFoundException -> L49
            r5 = 0
            r4 = r4[r5]     // Catch: java.lang.Throwable -> L3e java.security.cert.CertificateException -> L40 android.content.pm.PackageManager.NameNotFoundException -> L49
            byte[] r4 = r4.toByteArray()     // Catch: java.lang.Throwable -> L3e java.security.cert.CertificateException -> L40 android.content.pm.PackageManager.NameNotFoundException -> L49
            java.io.ByteArrayInputStream r5 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L3e java.security.cert.CertificateException -> L40 android.content.pm.PackageManager.NameNotFoundException -> L49
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L3e java.security.cert.CertificateException -> L40 android.content.pm.PackageManager.NameNotFoundException -> L49
            java.lang.String r4 = "X.509"
            java.security.cert.CertificateFactory r4 = java.security.cert.CertificateFactory.getInstance(r4)     // Catch: java.security.cert.CertificateException -> L41 android.content.pm.PackageManager.NameNotFoundException -> L4a java.lang.Throwable -> L5e
            java.security.cert.Certificate r4 = r4.generateCertificate(r5)     // Catch: java.security.cert.CertificateException -> L41 android.content.pm.PackageManager.NameNotFoundException -> L4a java.lang.Throwable -> L5e
            r5.close()     // Catch: java.io.IOException -> L3a
            goto L3d
        L3a:
            defpackage.wrm.b(r1, r0)
        L3d:
            return r4
        L3e:
            r4 = move-exception
            goto L60
        L40:
            r5 = r2
        L41:
            java.lang.String r4 = "getPackageCertificate CertificateException"
            defpackage.wrm.b(r1, r4)     // Catch: java.lang.Throwable -> L5e
            if (r5 == 0) goto L58
            goto L51
        L49:
            r5 = r2
        L4a:
            java.lang.String r4 = "getPackageCertificate NameNotFoundException"
            defpackage.wrm.b(r1, r4)     // Catch: java.lang.Throwable -> L5e
            if (r5 == 0) goto L58
        L51:
            r5.close()     // Catch: java.io.IOException -> L55
            goto L58
        L55:
            defpackage.wrm.b(r1, r0)
        L58:
            java.lang.String r4 = "getPackageCertificate failed to get certificate"
            defpackage.wrm.b(r1, r4)
            return r2
        L5e:
            r4 = move-exception
            r2 = r5
        L60:
            if (r2 == 0) goto L69
            r2.close()     // Catch: java.io.IOException -> L66
            goto L69
        L66:
            defpackage.wrm.b(r1, r0)
        L69:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wut.b(android.content.Context, java.lang.String):java.security.cert.Certificate");
    }

    private static byte[] c(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            wrm.b("PackageUtil", "digest NoSuchAlgorithmException");
            return new byte[0];
        }
    }

    public static Intent fDL_(Intent intent) {
        if (d() == null) {
            wrm.b("PackageUtil", "createExplicitFromImplicitIntent context is null");
            throw null;
        }
        PackageManager packageManager = d().getPackageManager();
        if (packageManager == null) {
            wrm.b("PackageUtil", "getPackageManager is null");
            return null;
        }
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (listQueryIntentActivities == null || listQueryIntentActivities.size() != 1) {
            wrm.e("PackageUtil", "createExplicitFromImplicitIntent implicitIntent List are null");
            return null;
        }
        ResolveInfo resolveInfo = listQueryIntentActivities.get(0);
        String str = resolveInfo.activityInfo.packageName;
        String str2 = resolveInfo.activityInfo.name;
        if (!c(str)) {
            wrm.b("PackageUtil", "createExplicitActivityIntent verifyAppIdentity failed");
            return null;
        }
        ComponentName componentName = new ComponentName(str, str2);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        return intent2;
    }

    public static boolean c(String str) throws Throwable {
        wrm.d("PackageUtil", "verifyAppIdentity package name is : " + str);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.equals("com.huawei.health")) {
            wrm.b("PackageUtil", "verifyAppIdentity app's queryPkgName is not equal");
            return false;
        }
        String strE = e(d(), str);
        if (TextUtils.isEmpty(strE)) {
            wrm.b("PackageUtil", "verifyAppIdentity app's fp is empty");
            return false;
        }
        if (strE.equals("B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05") || strE.equals("B2881B2EE3D4EFA03342AE07DAFC0466B63EDE959EC2E2F58C05A54266F45748")) {
            return true;
        }
        wrm.b("PackageUtil", "verifyAppIdentity app's fp is not equal");
        return false;
    }
}
