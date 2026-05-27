package com.unicom.online.account.kernel;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.eclipse.californium.elements.util.JceNames;

/* JADX INFO: loaded from: classes8.dex */
public final class v {
    static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) throws w {
        if (bArr == null || bArr.length != 16) {
            throw new w(q.E10410);
        }
        if (bArr3 == null) {
            throw new w(q.E10400);
        }
        if (bArr2 == null) {
            throw new w(q.E10411);
        }
        int length = bArr3.length;
        if (i == 1) {
            if (length <= 0) {
                throw new w(q.E10408);
            }
        } else if (length <= 0 || bArr3.length % 16 != 0) {
            throw new w(q.E10409);
        }
        if (bArr2.length != 16) {
            throw new w(q.E10411);
        }
        new SecretKeySpec(bArr, "SM4");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr2);
        try {
            Cipher cipher = Cipher.getInstance("SM4/CBC/PKCS5Padding", JceNames.JCE_PROVIDER_BOUNCY_CASTLE);
            cipher.init(i, new SecretKeySpec(bArr, "SM4"), ivParameterSpec);
            return cipher.doFinal(bArr3);
        } catch (Exception e) {
            if (i == 1) {
                throw new w(q.E10204, e);
            }
            throw new w(q.E10205, e);
        }
    }
}
