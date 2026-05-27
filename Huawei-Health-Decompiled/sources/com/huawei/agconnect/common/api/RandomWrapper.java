package com.huawei.agconnect.common.api;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class RandomWrapper {
    public static byte[] generateSecureRandom(int i) {
        EncryptUtil.setBouncycastleFlag(true);
        byte[] bArrGenerateSecureRandom = EncryptUtil.generateSecureRandom(i);
        if (bArrGenerateSecureRandom.length != 0) {
            return bArrGenerateSecureRandom;
        }
        byte[] bArr = new byte[i];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
