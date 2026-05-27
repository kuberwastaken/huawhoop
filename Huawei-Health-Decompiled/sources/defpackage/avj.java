package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.huawei.health.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* JADX INFO: loaded from: classes10.dex */
public class avj {
    public static String a(Context context) throws Throwable {
        if (context == null) {
            avi.c("KeyUtil", "getHiCloudSignForEMUI11: context is null");
            return "";
        }
        return b(context, R.string._2130852156_res_0x7f02393c) + a(context, R.xml._2132082698_res_0x7f15000a) + d(context, "HiCloudSign");
    }

    public static String c(Context context) throws Throwable {
        if (context == null) {
            avi.c("KeyUtil", "getHiCloudSign: context is null");
            return "";
        }
        return b(context, R.string._2130851872_res_0x7f023820) + a(context, R.xml._2132082688_res_0x7f150000) + d(context, "ApplicationSign");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r2 = r4.getAttributeValue(null, "value");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r4, int r5) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "close xml Exception, ignore."
            java.lang.String r1 = "KeyUtil"
            if (r4 != 0) goto Le
            java.lang.String r4 = "getSignFromXml: context is null"
            defpackage.avi.c(r1, r4)
            java.lang.String r4 = ""
            return r4
        Le:
            r2 = 0
            android.content.res.Resources r4 = r4.getResources()     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b org.xmlpull.v1.XmlPullParserException -> L57
            android.content.res.XmlResourceParser r4 = r4.getXml(r5)     // Catch: java.lang.Throwable -> L49 java.io.IOException -> L4b org.xmlpull.v1.XmlPullParserException -> L57
            if (r4 == 0) goto L3f
            int r5 = r4.next()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4c org.xmlpull.v1.XmlPullParserException -> L58
        L1d:
            r3 = 1
            if (r5 == r3) goto L3f
            r3 = 2
            if (r5 != r3) goto L37
            java.lang.String r5 = "config"
            java.lang.String r3 = r4.getName()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4c org.xmlpull.v1.XmlPullParserException -> L58
            boolean r5 = r5.equals(r3)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4c org.xmlpull.v1.XmlPullParserException -> L58
            if (r5 == 0) goto L37
            java.lang.String r5 = "value"
            java.lang.String r5 = r4.getAttributeValue(r2, r5)     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4c org.xmlpull.v1.XmlPullParserException -> L58
            r2 = r5
            goto L3f
        L37:
            int r5 = r4.next()     // Catch: java.lang.Throwable -> L3c java.io.IOException -> L4c org.xmlpull.v1.XmlPullParserException -> L58
            goto L1d
        L3c:
            r5 = move-exception
            r2 = r4
            goto L67
        L3f:
            if (r4 == 0) goto L66
            r4.close()     // Catch: java.lang.Exception -> L45
            goto L66
        L45:
            defpackage.avi.d(r1, r0)
            goto L66
        L49:
            r4 = move-exception
            goto L68
        L4b:
            r4 = r2
        L4c:
            java.lang.String r5 = "IOException getComponentFromXml"
            defpackage.avi.c(r1, r5)     // Catch: java.lang.Throwable -> L3c
            if (r4 == 0) goto L66
            r4.close()     // Catch: java.lang.Exception -> L63
            goto L66
        L57:
            r4 = r2
        L58:
            java.lang.String r5 = "XmlPullParserException getComponentFromXml"
            defpackage.avi.c(r1, r5)     // Catch: java.lang.Throwable -> L3c
            if (r4 == 0) goto L66
            r4.close()     // Catch: java.lang.Exception -> L63
            goto L66
        L63:
            defpackage.avi.d(r1, r0)
        L66:
            return r2
        L67:
            r4 = r5
        L68:
            if (r2 == 0) goto L71
            r2.close()     // Catch: java.lang.Exception -> L6e
            goto L71
        L6e:
            defpackage.avi.d(r1, r0)
        L71:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.avj.a(android.content.Context, int):java.lang.String");
    }

    public static String a(Context context, String str) {
        if (context != null && str != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    avi.c("KeyUtil", "getSignForPkgName: packageManager is null");
                    return "";
                }
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
                if (packageInfo == null) {
                    avi.c("KeyUtil", "getSignForPkgName: packageInfo is null");
                    return "";
                }
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null && signatureArr.length >= 1) {
                    Signature signature = signatureArr[0];
                    if (signature == null) {
                        avi.c("KeyUtil", "getSignForPkgName: sign[0] is null");
                        return "";
                    }
                    X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()));
                    if (x509Certificate == null) {
                        avi.c("KeyUtil", "getSignForPkgName: cert is null");
                        return "";
                    }
                    PublicKey publicKey = x509Certificate.getPublicKey();
                    if (publicKey == null) {
                        avi.c("KeyUtil", "getSignForPkgName: publicKey is null");
                        return "";
                    }
                    return d(publicKey.getEncoded());
                }
                avi.c("KeyUtil", "getSignForPkgName: signs is null or signs.length < 1");
                return "";
            } catch (PackageManager.NameNotFoundException unused) {
                avi.c("KeyUtil", "getSignForPkgName: name found error");
                return "";
            } catch (CertificateException e) {
                avi.c("KeyUtil", "getSignForPkgName: CertificateException = " + e.toString());
                return "";
            }
        }
        avi.c("KeyUtil", "getSignForPkgName: context or pkgName is null");
        return "";
    }

    private static String d(Context context, String str) throws Throwable {
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream;
        Exception e;
        InputStream inputStreamOpen;
        byte[] bArr;
        String string = "";
        if (context != null && !TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                inputStreamOpen = context.getAssets().open(str);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                } catch (Exception e2) {
                    e = e2;
                    byteArrayOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    a(inputStreamOpen);
                    a(byteArrayOutputStream2);
                    throw th;
                }
            } catch (Exception e3) {
                byteArrayOutputStream = null;
                e = e3;
                inputStreamOpen = null;
            } catch (Throwable th3) {
                th = th3;
                byteArrayOutputStream = null;
                inputStreamOpen = inputStream;
                byteArrayOutputStream2 = byteArrayOutputStream;
                a(inputStreamOpen);
                a(byteArrayOutputStream2);
                throw th;
            }
            try {
                bArr = new byte[40];
            } catch (Exception e4) {
                e = e4;
                try {
                    avi.c("KeyUtil", "Assets Exception2" + e.getMessage());
                    a(inputStreamOpen);
                    a(byteArrayOutputStream);
                } catch (Throwable th4) {
                    th = th4;
                    inputStream = inputStreamOpen;
                    inputStreamOpen = inputStream;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    a(inputStreamOpen);
                    a(byteArrayOutputStream2);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                byteArrayOutputStream2 = byteArrayOutputStream;
                a(inputStreamOpen);
                a(byteArrayOutputStream2);
                throw th;
            }
            while (true) {
                int i = inputStreamOpen.read(bArr);
                if (i <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, i);
                return string;
            }
            string = byteArrayOutputStream.toString("utf-8");
            a(inputStreamOpen);
            a(byteArrayOutputStream);
            return string;
        }
        avi.c("KeyUtil", "getSignFromAssets: context or fileName is null");
        return "";
    }

    private static String b(Context context, int i) {
        if (context == null) {
            avi.c("KeyUtil", "getSignFromString: context is null");
            return "";
        }
        return context.getString(i);
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                avi.c("KeyUtil", "closeStream exception :" + e.getMessage());
            }
        }
    }

    private static String d(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            int i2 = i * 2;
            cArr2[i2] = cArr[(b >>> 4) & 15];
            cArr2[i2 + 1] = cArr[b & 15];
        }
        return new String(cArr2);
    }

    public static String b() {
        return "com.huawei.hidisk";
    }
}
