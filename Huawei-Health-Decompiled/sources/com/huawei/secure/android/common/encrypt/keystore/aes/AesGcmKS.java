package com.huawei.secure.android.common.encrypt.keystore.aes;

import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* JADX INFO: loaded from: classes7.dex */
public class AesGcmKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8932a = "GCMKS";
    private static final String b = "AndroidKeyStore";
    private static final String c = "AES/GCM/NoPadding";
    private static final String d = "";
    private static final int e = 12;
    private static final int f = 256;
    private static Map<String, SecretKey> g = new ConcurrentHashMap();

    private static boolean a() {
        return true;
    }

    private static SecretKey b(String str, Boolean bool) throws AesKsParamException {
        if (TextUtils.isEmpty(str)) {
            throw new AesKsParamException("alias is null");
        }
        if (g.get(str) == null) {
            synchronized (AesGcmKS.class) {
                if (g.get(str) == null) {
                    SecretKey secretKeyA = a(str, bool);
                    if (secretKeyA == null) {
                        throw new AesKsParamException("AES GCM is decrypt,but alias is null");
                    }
                    g.put(str, secretKeyA);
                }
            }
        }
        return g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f8932a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            b.b(f8932a, "decrypt: UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static String decryptNew(String str, String str2) throws AesKsParamException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f8932a, "alias or encrypt content is null");
            throw new AesKsParamException("alias or encrypt content is null");
        }
        try {
            return new String(decryptNew(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            b.b(f8932a, "decrypt: UnsupportedEncodingException : " + e2.getMessage());
            throw new AesKsParamException("decrypt: UnsupportedEncodingException");
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f8932a, "alias or encrypt content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            b.b(f8932a, "encrypt: UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static String encryptNew(String str, String str2) throws AesKsParamException {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f8932a, "alias or encrypt content is null");
            throw new AesKsParamException("alias or encrypt content is null");
        }
        try {
            return HexUtil.byteArray2HexStr(encryptNew(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException e2) {
            b.b(f8932a, "encrypt: UnsupportedEncodingException : " + e2.getMessage());
            throw new AesKsParamException("encrypt: UnsupportedEncodingException");
        }
    }

    private static SecretKey a(String str, Boolean bool) throws AesKsParamException {
        b.c(f8932a, "load key");
        try {
            KeyStore keyStore = KeyStore.getInstance(b);
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key instanceof SecretKey) {
                return (SecretKey) key;
            }
            if (!bool.booleanValue()) {
                return null;
            }
            b.c(f8932a, "generate key");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", b);
            keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setKeySize(256).build());
            return keyGenerator.generateKey();
        } catch (IOException e2) {
            b.b(f8932a, "IOException : " + e2.getMessage());
            throw new AesKsParamException("IOException : " + e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            b.b(f8932a, "InvalidAlgorithmParameterException : " + e3.getMessage());
            throw new AesKsParamException("InvalidAlgorithmParameterException : " + e3.getMessage());
        } catch (KeyStoreException e4) {
            b.b(f8932a, "KeyStoreException : " + e4.getMessage());
            throw new AesKsParamException("KeyStoreException : " + e4.getMessage());
        } catch (NoSuchAlgorithmException e5) {
            b.b(f8932a, "NoSuchAlgorithmException : " + e5.getMessage());
            throw new AesKsParamException("NoSuchAlgorithmException : " + e5.getMessage());
        } catch (NoSuchProviderException e6) {
            b.b(f8932a, "NoSuchProviderException : " + e6.getMessage());
            throw new AesKsParamException("NoSuchProviderException : " + e6.getMessage());
        } catch (UnrecoverableKeyException e7) {
            b.b(f8932a, "UnrecoverableKeyException : " + e7.getMessage());
            throw new AesKsParamException("UnrecoverableKeyException : " + e7.getMessage());
        } catch (CertificateException e8) {
            b.b(f8932a, "CertificateException : " + e8.getMessage());
            throw new AesKsParamException("CertificateException : " + e8.getMessage());
        } catch (Exception e9) {
            b.b(f8932a, "Exception: " + e9.getMessage());
            throw new AesKsParamException("Exception : " + e9.getMessage());
        }
    }

    public static byte[] decryptNew(String str, byte[] bArr) throws AesKsParamException {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (a()) {
                if (bArr.length > 12) {
                    return decryptNew(b(str, Boolean.FALSE), bArr);
                }
                b.b(f8932a, "Decrypt source data is invalid.");
                throw new AesKsParamException("Decrypt source data is invalid");
            }
            b.b(f8932a, "sdk version is too low");
            throw new AesKsParamException("sdk version is too low");
        }
        b.b(f8932a, "alias or encrypt content is null");
        throw new AesKsParamException("alias or encrypt content is null");
    }

    public static byte[] encryptNew(String str, byte[] bArr) throws AesKsParamException {
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (a()) {
                return encryptNew(b(str, Boolean.TRUE), bArr);
            }
            b.b(f8932a, "sdk version is too low");
            throw new AesKsParamException("sdk version is too low");
        }
        b.b(f8932a, "alias or encrypt content is null");
        throw new AesKsParamException("alias or encrypt content is null");
    }

    public static byte[] decrypt(String str, byte[] bArr) {
        SecretKey secretKeyB;
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f8932a, "sdk version is too low");
                return bArr2;
            }
            if (bArr.length <= 12) {
                b.b(f8932a, "Decrypt source data is invalid.");
                return bArr2;
            }
            try {
                secretKeyB = b(str, Boolean.FALSE);
            } catch (AesKsParamException e2) {
                b.b(f8932a, "e : " + e2.getMessage());
                secretKeyB = null;
            }
            return secretKeyB == null ? bArr2 : decrypt(secretKeyB, bArr);
        }
        b.b(f8932a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        SecretKey secretKeyB;
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f8932a, "sdk version is too low");
                return bArr2;
            }
            try {
                secretKeyB = b(str, Boolean.TRUE);
            } catch (AesKsParamException e2) {
                b.b(f8932a, "e : " + e2.getMessage());
                secretKeyB = null;
            }
            return secretKeyB == null ? bArr2 : encrypt(secretKeyB, bArr);
        }
        b.b(f8932a, "alias or encrypt content is null");
        return bArr2;
    }

    private static byte[] b(SecretKey secretKey, byte[] bArr) throws AesKsParamException {
        byte[] bArr2 = new byte[0];
        try {
            Cipher cipher = Cipher.getInstance(c);
            cipher.init(1, secretKey);
            byte[] bArrDoFinal = cipher.doFinal(bArr);
            byte[] iv = cipher.getIV();
            if (iv != null && iv.length == 12) {
                byte[] bArrCopyOf = Arrays.copyOf(iv, iv.length + bArrDoFinal.length);
                System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv.length, bArrDoFinal.length);
                return bArrCopyOf;
            }
            b.b(f8932a, "IV is invalid.");
            return bArr2;
        } catch (InvalidKeyException e2) {
            b.b(f8932a, "InvalidKeyException : " + e2.getMessage());
            throw new AesKsParamException("InvalidKeyException : " + e2.getMessage());
        } catch (NoSuchAlgorithmException e3) {
            b.b(f8932a, "NoSuchAlgorithmException : " + e3.getMessage());
            throw new AesKsParamException("NoSuchAlgorithmException : " + e3.getMessage());
        } catch (BadPaddingException e4) {
            b.b(f8932a, "BadPaddingException : " + e4.getMessage());
            throw new AesKsParamException("BadPaddingException : " + e4.getMessage());
        } catch (IllegalBlockSizeException e5) {
            b.b(f8932a, "IllegalBlockSizeException : " + e5.getMessage());
            throw new AesKsParamException("IllegalBlockSizeException : " + e5.getMessage());
        } catch (NoSuchPaddingException e6) {
            b.b(f8932a, "NoSuchPaddingException : " + e6.getMessage());
            throw new AesKsParamException("NoSuchPaddingException : " + e6.getMessage());
        } catch (Exception e7) {
            b.b(f8932a, "Exception: " + e7.getMessage());
            throw new AesKsParamException("Exception : " + e7.getMessage());
        }
    }

    public static byte[] encryptNew(SecretKey secretKey, byte[] bArr) throws AesKsParamException {
        if (bArr == null) {
            b.b(f8932a, "content is null");
            throw new AesKsParamException("content is null.");
        }
        if (secretKey != null) {
            if (a()) {
                return b(secretKey, bArr);
            }
            b.b(f8932a, "sdk version is too low");
            throw new AesKsParamException("sdk version is too low");
        }
        b.b(f8932a, "secret key is null");
        throw new AesKsParamException("secret key is null.");
    }

    public static byte[] decryptNew(SecretKey secretKey, byte[] bArr) throws AesKsParamException {
        if (secretKey == null) {
            b.b(f8932a, "Decrypt secret key is null");
            throw new AesKsParamException("Decrypt secret key is null");
        }
        if (bArr != null) {
            if (a()) {
                if (bArr.length > 12) {
                    return a(secretKey, bArr);
                }
                b.b(f8932a, "Decrypt source data is invalid.");
                throw new AesKsParamException("Decrypt source data is invalid.");
            }
            b.b(f8932a, "sdk version is too low");
            throw new AesKsParamException("sdk version is too low.");
        }
        b.b(f8932a, "content is null");
        throw new AesKsParamException("content is null");
    }

    public static byte[] encrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            b.b(f8932a, "content is null");
            return bArr2;
        }
        if (secretKey == null) {
            b.b(f8932a, "secret key is null");
            return bArr2;
        }
        if (!a()) {
            b.b(f8932a, "sdk version is too low");
            return bArr2;
        }
        try {
            return b(secretKey, bArr);
        } catch (AesKsParamException e2) {
            b.b(f8932a, "e : " + e2.getMessage());
            return bArr2;
        }
    }

    public static byte[] decrypt(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            b.b(f8932a, "Decrypt secret key is null");
            return bArr2;
        }
        if (bArr == null) {
            b.b(f8932a, "content is null");
            return bArr2;
        }
        if (!a()) {
            b.b(f8932a, "sdk version is too low");
            return bArr2;
        }
        if (bArr.length <= 12) {
            b.b(f8932a, "Decrypt source data is invalid.");
            return bArr2;
        }
        try {
            return a(secretKey, bArr);
        } catch (AesKsParamException e2) {
            b.b(f8932a, "e : " + e2.getMessage());
            return bArr2;
        }
    }

    private static byte[] a(SecretKey secretKey, byte[] bArr) throws AesKsParamException {
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 12);
        try {
            Cipher cipher = Cipher.getInstance(c);
            cipher.init(2, secretKey, new GCMParameterSpec(128, bArrCopyOf));
            return cipher.doFinal(bArr, 12, bArr.length - 12);
        } catch (InvalidAlgorithmParameterException e2) {
            b.b(f8932a, "InvalidAlgorithmParameterException : " + e2.getMessage());
            throw new AesKsParamException("InvalidAlgorithmParameterException : " + e2.getMessage());
        } catch (InvalidKeyException e3) {
            b.b(f8932a, "InvalidKeyException : " + e3.getMessage());
            throw new AesKsParamException("InvalidKeyException : " + e3.getMessage());
        } catch (NoSuchAlgorithmException e4) {
            b.b(f8932a, "NoSuchAlgorithmException : " + e4.getMessage());
            throw new AesKsParamException("NoSuchAlgorithmException : " + e4.getMessage());
        } catch (BadPaddingException e5) {
            b.b(f8932a, "BadPaddingException : " + e5.getMessage());
            throw new AesKsParamException("BadPaddingException : " + e5.getMessage());
        } catch (IllegalBlockSizeException e6) {
            b.b(f8932a, "IllegalBlockSizeException : " + e6.getMessage());
            throw new AesKsParamException("IllegalBlockSizeException : " + e6.getMessage());
        } catch (NoSuchPaddingException e7) {
            b.b(f8932a, "NoSuchPaddingException : " + e7.getMessage());
            throw new AesKsParamException("NoSuchPaddingException : " + e7.getMessage());
        } catch (Exception e8) {
            b.b(f8932a, "Exception: " + e8.getMessage());
            throw new AesKsParamException("Exception: " + e8.getMessage());
        }
    }
}
