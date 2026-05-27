package com.huawei.hms.ads.uiengineloader;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4558a = "Sha256Util";

    public static byte[] a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            af.d(f4558a, "sha256 NoSuchAlgorithmException");
            return new byte[0];
        }
    }
}
