package com.huawei.hms.ads.identifier;

import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes10.dex */
public class i {
    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            Log.e("Sha256Util", "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
