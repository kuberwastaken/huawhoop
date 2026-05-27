package com.huawei.hms.feature.dynamic.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.extractor.ts.PsExtractor;
import com.huawei.hms.common.util.Logger;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4709a = "SignVerifier";
    private static final String b = "com.huawei.hms.fingerprint_signature";
    private static final String c = "com.huawei.hms.sign_certchain";
    private static final String d = "..";

    public static boolean b(Context context, String str) {
        String str2;
        if (context == null || TextUtils.isEmpty(str) || str.contains(d)) {
            str2 = "The context is null or module path is invalid.";
        } else if (!a(str)) {
            str2 = "The module file is in wrong format.";
        } else {
            if (a(context, str)) {
                return true;
            }
            str2 = "check signature failed.";
        }
        Logger.e(f4709a, str2);
        return false;
    }

    private static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            Logger.e(f4709a, "NoSuchAlgorithmException" + e.getMessage());
            return new byte[0];
        }
    }

    private static boolean a(String str, String str2, String str3) {
        String str4;
        byte[] bytes;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            str4 = "Args is invalid.";
        } else {
            List<X509Certificate> listB = e.b(str2);
            if (listB.size() == 0) {
                str4 = "CertChain is empty.";
            } else if (e.a(e.a(), listB)) {
                X509Certificate x509Certificate = listB.get(0);
                if (!e.a(x509Certificate, "Huawei CBG HMS Kit")) {
                    str4 = "CN is invalid";
                } else if (e.b(x509Certificate, "Huawei CBG Cloud Security Signer")) {
                    try {
                        bytes = str3.getBytes("UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        Logger.e(f4709a, "checkCertChain UnsupportedEncodingException:", e);
                        bytes = null;
                    }
                    if (e.a(x509Certificate, bytes, a.a(str))) {
                        return true;
                    }
                    str4 = "signature is invalid: ";
                } else {
                    str4 = "OU is invalid";
                }
            } else {
                str4 = "failed to verify cert chain";
            }
        }
        Logger.e(f4709a, str4);
        return false;
    }

    private static boolean a(String str) {
        String str2;
        try {
            new ZipFile(str).close();
            return true;
        } catch (ZipException unused) {
            str2 = "Check module file ZipException: not a valid zip.";
            Logger.w(f4709a, str2);
            return false;
        } catch (IOException unused2) {
            str2 = "Check module file IOException";
            Logger.w(f4709a, str2);
            return false;
        }
    }

    private static boolean a(Context context, String str) {
        String string;
        ApplicationInfo applicationInfo;
        StringBuilder sb;
        String str2;
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, PsExtractor.AUDIO_STREAM);
        if (packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null) {
            string = "PackageArchiveInfo is null.";
        } else {
            String str3 = packageArchiveInfo.packageName;
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null) {
                sb = new StringBuilder("Verify package ");
                sb.append(str3);
                str2 = " failed for metadata is null.";
            } else if (!bundle.containsKey(b)) {
                sb = new StringBuilder("Verify package ");
                sb.append(str3);
                str2 = " failed for no signer.";
            } else if (bundle.containsKey(c)) {
                String strA = a(packageArchiveInfo);
                if (TextUtils.isEmpty(strA)) {
                    string = "Get PackageSignature failed: null.";
                } else {
                    if (a(bundle.getString(b), bundle.getString(c), str3 + "&" + strA)) {
                        Logger.i(f4709a, "verify signature with cert chain success.");
                        return true;
                    }
                    string = "Check CertChain failed.";
                }
            } else {
                sb = new StringBuilder("Verify package ");
                sb.append(str3);
                str2 = " failed for no cert chain.";
            }
            sb.append(str2);
            string = sb.toString();
        }
        Logger.e(f4709a, string);
        return false;
    }

    private static String a(PackageInfo packageInfo) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length == 0) {
            Logger.e(f4709a, "Failed to get application signature certificate fingerprint.");
            return null;
        }
        byte[] byteArray = signatureArr[0].toByteArray();
        if (byteArray == null || byteArray.length == 0) {
            return null;
        }
        return b.b(a(byteArray), true);
    }
}
