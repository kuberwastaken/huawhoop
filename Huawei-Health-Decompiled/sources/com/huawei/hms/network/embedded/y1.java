package com.huawei.hms.network.embedded;

import com.huawei.secure.android.common.encrypt.aes.AesGcm;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5767a = "Secure";

    public static byte[] encryptBody(byte[] bArr) throws IOException {
        byte[] bArrEncrypt = AesGcm.encrypt(bArr, w1.a(true));
        if (bArrEncrypt == null || bArrEncrypt.length == 0) {
            throw new a("Encrypt body failed");
        }
        return bArrEncrypt;
    }

    public static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }

    public static class b extends IOException {
        public b(String str) {
            super(str);
        }
    }

    public static byte[] decryptBody(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            throw new a("Decrypt body is empty");
        }
        try {
            byte[] bArrDecrypt = AesGcm.decrypt(bArr, w1.a(false));
            if (bArrDecrypt == null || bArrDecrypt.length == 0) {
                throw new a("Decrypt body failed");
            }
            return bArrDecrypt;
        } catch (IndexOutOfBoundsException unused) {
            throw new a("The cached file is tampered, throw a indexOutOfBoundsException");
        }
    }
}
