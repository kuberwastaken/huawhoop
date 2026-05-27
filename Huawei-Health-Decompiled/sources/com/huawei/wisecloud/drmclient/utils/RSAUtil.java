package com.huawei.wisecloud.drmclient.utils;

import com.huawei.wisecloud.drmclient.exception.HwDrmException;
import com.huawei.wisecloud.drmclient.license.HwDrmConstant;
import com.huawei.wisecloud.drmclient.log.HwDrmLog;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

/* JADX INFO: loaded from: classes8.dex */
public class RSAUtil {
    private static final String RSA_DECRYPT_MGF1 = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
    private static final String RSA_DECRYPT_PKCS1 = "RSA/ECB/PKCS1Padding";

    public static boolean verifyRSASignature(String str, PublicKey publicKey, int i, byte[] bArr) throws HwDrmException {
        try {
            byte[] bytes = str.getBytes(HwDrmConstant.DRM_CHARSET);
            Signature signature = Signature.getInstance(RSASignAlgo.getAlgoName(i));
            signature.initVerify(publicKey);
            signature.update(bytes);
            return signature.verify(bArr);
        } catch (InvalidKeyException e) {
            String str2 = "fail to verify, InvalidKeyException: " + HwDrmLog.printException((Exception) e);
            HwDrmLog.e("RSAUtil", str2);
            throw new HwDrmException(str2);
        } catch (NoSuchAlgorithmException e2) {
            String str3 = "fail to verify, NoSuchAlgorithmException: " + HwDrmLog.printException((Exception) e2);
            HwDrmLog.e("RSAUtil", str3);
            throw new HwDrmException(str3);
        } catch (SignatureException e3) {
            String str4 = "fail to verify, SignatureException: " + HwDrmLog.printException((Exception) e3);
            HwDrmLog.e("RSAUtil", str4);
            throw new HwDrmException(str4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] decrypt(byte[] r7, java.security.PrivateKey r8, java.lang.String r9) throws com.huawei.wisecloud.drmclient.exception.HwDrmException {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.wisecloud.drmclient.utils.RSAUtil.decrypt(byte[], java.security.PrivateKey, java.lang.String):byte[]");
    }
}
