package com.huawei.agconnect.common.crypto;

import com.huawei.agconnect.common.api.RandomWrapper;
import com.huawei.secure.android.common.util.HexUtil;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class CryptoUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f1743a = 16;

    public static SecretKey a(String str, String str2, String str3, int i) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return new SecretKeySpec(SecretKeyFactory.getInstance(str3).generateSecret(new PBEKeySpec(str.toCharArray(), HexUtil.hexStr2ByteArray(str2), i, 128)).getEncoded(), "AES");
    }

    public static String a(String str, String str2) {
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] bArrHexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        if (bArrHexStr2ByteArray == null || bArrHexStr2ByteArray2 == null || bArrHexStr2ByteArray.length != bArrHexStr2ByteArray2.length) {
            return null;
        }
        int length = bArrHexStr2ByteArray.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) (bArrHexStr2ByteArray[i] ^ bArrHexStr2ByteArray2[i]);
        }
        return HexUtil.byteArray2HexStr(bArr);
    }

    public static String a(String str, int i) {
        byte[] bArrHexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        if (bArrHexStr2ByteArray == null || bArrHexStr2ByteArray.length == 0) {
            return null;
        }
        for (int i2 = 0; i2 < bArrHexStr2ByteArray.length; i2++) {
            if (i < 0) {
                bArrHexStr2ByteArray[i2] = (byte) (bArrHexStr2ByteArray[i2] << (-i));
            } else {
                bArrHexStr2ByteArray[i2] = (byte) (bArrHexStr2ByteArray[i2] >> i);
            }
        }
        return HexUtil.byteArray2HexStr(bArrHexStr2ByteArray);
    }

    static String a(int i) {
        return HexUtil.byteArray2HexStr(RandomWrapper.generateSecureRandom(i / 2));
    }
}
