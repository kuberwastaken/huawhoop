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
import javax.crypto.spec.IvParameterSpec;

/* JADX INFO: loaded from: classes7.dex */
public class AesCbcKS {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8931a = "CBCKS";
    private static final String b = "AndroidKeyStore";
    private static final String c = "AES/CBC/PKCS7Padding";
    private static final String d = "";
    private static final int e = 16;
    private static final int f = 256;
    private static Map<String, SecretKey> g = new ConcurrentHashMap();

    private static SecretKey a(String str, Boolean bool) {
        b.c(f8931a, "load key");
        SecretKey secretKeyGenerateKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(b);
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key != null && (key instanceof SecretKey)) {
                secretKeyGenerateKey = (SecretKey) key;
            } else if (bool.booleanValue()) {
                b.c(f8931a, "generate key");
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", b);
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setKeySize(256).build());
                secretKeyGenerateKey = keyGenerator.generateKey();
            }
        } catch (IOException e2) {
            b.b(f8931a, "IOException: " + e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            b.b(f8931a, "InvalidAlgorithmParameterException: " + e3.getMessage());
        } catch (KeyStoreException e4) {
            b.b(f8931a, "KeyStoreException: " + e4.getMessage());
        } catch (NoSuchAlgorithmException e5) {
            b.b(f8931a, "NoSuchAlgorithmException: " + e5.getMessage());
        } catch (NoSuchProviderException e6) {
            b.b(f8931a, "NoSuchProviderException: " + e6.getMessage());
        } catch (UnrecoverableKeyException e7) {
            b.b(f8931a, "UnrecoverableKeyException: " + e7.getMessage());
        } catch (CertificateException e8) {
            b.b(f8931a, "CertificateException: " + e8.getMessage());
        } catch (Exception e9) {
            b.b(f8931a, "Exception: " + e9.getMessage());
        }
        return secretKeyGenerateKey;
    }

    private static boolean a() {
        return true;
    }

    private static SecretKey b(String str, Boolean bool) throws AesKsParamException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (g.get(str) == null) {
            synchronized (AesCbcKS.class) {
                if (g.get(str) == null) {
                    SecretKey secretKeyA = a(str, bool);
                    if (secretKeyA == null) {
                        throw new AesKsParamException("AES CBC current is decrypt,but alias is null");
                    }
                    g.put(str, secretKeyA);
                }
            }
        }
        return g.get(str);
    }

    public static String decrypt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b.b(f8931a, "alias or encrypt content is null");
            return "";
        }
        try {
            return new String(decrypt(str, HexUtil.hexStr2ByteArray(str2)), "UTF-8");
        } catch (AesKsParamException e2) {
            b.b(f8931a, "encrypt: AesKsParamException : " + e2.getMessage());
            return "";
        } catch (UnsupportedEncodingException e3) {
            b.b(f8931a, "encrypt: UnsupportedEncodingException : " + e3.getMessage());
            return "";
        }
    }

    public static String encrypt(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            b.b(f8931a, "encrypt 1 content is null");
            return "";
        }
        try {
            return HexUtil.byteArray2HexStr(encrypt(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            b.b(f8931a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] encrypt(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f8931a, "sdk version is too low");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(c);
                SecretKey secretKeyB = b(str, Boolean.TRUE);
                if (secretKeyB == null) {
                    b.b(f8931a, "encrypt secret key is null");
                    return bArr2;
                }
                cipher.init(1, secretKeyB);
                byte[] bArrDoFinal = cipher.doFinal(bArr);
                byte[] iv = cipher.getIV();
                if (iv != null && iv.length == 16) {
                    byte[] bArrCopyOf = Arrays.copyOf(iv, iv.length + bArrDoFinal.length);
                    System.arraycopy(bArrDoFinal, 0, bArrCopyOf, iv.length, bArrDoFinal.length);
                    return bArrCopyOf;
                }
                b.b(f8931a, "IV is invalid.");
                return bArr2;
            } catch (InvalidKeyException e2) {
                b.b(f8931a, "InvalidKeyException: " + e2.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e3) {
                b.b(f8931a, "NoSuchAlgorithmException: " + e3.getMessage());
                return bArr2;
            } catch (BadPaddingException e4) {
                b.b(f8931a, "BadPaddingException: " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                b.b(f8931a, "IllegalBlockSizeException: " + e5.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e6) {
                b.b(f8931a, "NoSuchPaddingException: " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                b.b(f8931a, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
        b.b(f8931a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] decrypt(String str, byte[] bArr) throws AesKsParamException {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!a()) {
                b.b(f8931a, "sdk version is too low");
                return bArr2;
            }
            if (bArr.length <= 16) {
                b.b(f8931a, "Decrypt source data is invalid.");
                return bArr2;
            }
            SecretKey secretKeyB = b(str, Boolean.FALSE);
            if (secretKeyB == null) {
                b.b(f8931a, "decrypt secret key is null");
                return bArr2;
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArr, 16);
            try {
                Cipher cipher = Cipher.getInstance(c);
                cipher.init(2, secretKeyB, new IvParameterSpec(bArrCopyOf));
                return cipher.doFinal(bArr, 16, bArr.length - 16);
            } catch (InvalidAlgorithmParameterException e2) {
                b.b(f8931a, "InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                b.b(f8931a, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                b.b(f8931a, "NoSuchAlgorithmException: " + e4.getMessage());
                return bArr2;
            } catch (BadPaddingException e5) {
                b.b(f8931a, "BadPaddingException: " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                b.b(f8931a, "IllegalBlockSizeException: " + e6.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e7) {
                b.b(f8931a, "NoSuchPaddingException: " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                b.b(f8931a, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
        b.b(f8931a, "alias or encrypt content is null");
        return bArr2;
    }
}
