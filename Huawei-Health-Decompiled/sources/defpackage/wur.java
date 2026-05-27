package defpackage;

import android.content.Context;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import org.eclipse.californium.elements.util.JceNames;

/* JADX INFO: loaded from: classes9.dex */
public class wur {
    private wur() {
    }

    private static KeyStore e() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            return keyStore;
        } catch (IOException unused) {
            wro.d("KeystoreUtil", "getKeyStore IOException");
            return null;
        } catch (KeyStoreException unused2) {
            wro.d("KeystoreUtil", "getKeyStore KeyStoreException");
            return null;
        } catch (NoSuchAlgorithmException unused3) {
            wro.d("KeystoreUtil", "getKeyStore NoSuchAlgorithmException");
            return null;
        } catch (CertificateException unused4) {
            wro.d("KeystoreUtil", "getKeyStore CertificateException");
            return null;
        }
    }

    private static KeyStore a(Context context, String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        KeyStore keyStore;
        synchronized (wur.class) {
            keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            if (!keyStore.containsAlias(str)) {
                d(context, str);
            }
        }
        return keyStore;
    }

    private static void d(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(JceNames.RSA, "AndroidKeyStore");
            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 3).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("PKCS1Padding").build());
            keyPairGenerator.generateKeyPair();
            wro.b("KeystoreUtil", "AboveApi23 generateKeyStoreKey success!");
        } catch (InvalidAlgorithmParameterException unused) {
            wro.d("KeystoreUtil", "createNewKeys InvalidAlgorithmParameterException");
        } catch (NoSuchAlgorithmException unused2) {
            wro.d("KeystoreUtil", "createNewKeys NoSuchAlgorithmException");
        } catch (NoSuchProviderException unused3) {
            wro.d("KeystoreUtil", "createNewKeys NoSuchProviderException");
        }
    }

    public static String c(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                Key key = a(context, str2).getKey(str2, null);
                if (key instanceof PrivateKey) {
                    Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                    cipher.init(2, (PrivateKey) key);
                    return new String(cipher.doFinal(wuk.b(str)), "UTF-8");
                }
            } catch (IOException unused) {
                wro.d("KeystoreUtil", "decryptString IOException");
            } catch (InvalidKeyException unused2) {
                wro.d("KeystoreUtil", "decryptString InvalidKeyException");
            } catch (KeyStoreException unused3) {
                wro.d("KeystoreUtil", "decryptString KeyStoreException");
            } catch (NoSuchAlgorithmException unused4) {
                wro.d("KeystoreUtil", "decryptString NoSuchAlgorithmException");
            } catch (UnrecoverableKeyException unused5) {
                wro.d("KeystoreUtil", "decryptString UnrecoverableKeyException");
            } catch (CertificateException unused6) {
                wro.d("KeystoreUtil", "decryptString CertificateException");
            } catch (BadPaddingException unused7) {
                wro.d("KeystoreUtil", "decryptString BadPaddingException");
            } catch (IllegalBlockSizeException unused8) {
                wro.d("KeystoreUtil", "decryptString IllegalBlockSizeException");
            } catch (NoSuchPaddingException unused9) {
                wro.d("KeystoreUtil", "decryptString NoSuchPaddingException");
            }
        }
        return "";
    }

    public static SecretKey d() {
        KeyStore keyStoreE = e();
        if (keyStoreE == null) {
            wro.e("KeystoreUtil", "getSecretKeyInternal:keyStore is null");
            return null;
        }
        try {
            if (keyStoreE.containsAlias("com.huawei.wearengine.repository.sign")) {
                Key key = keyStoreE.getKey("com.huawei.wearengine.repository.sign", null);
                if (key instanceof SecretKey) {
                    wro.a("KeystoreUtil", "getSecretKeyForRepositorySign: from keyStore ");
                    return (SecretKey) key;
                }
            }
            return a();
        } catch (InvalidAlgorithmParameterException unused) {
            wro.d("KeystoreUtil", "getSecretKeyForRepositorySign InvalidAlgorithmParameterException");
            return null;
        } catch (KeyStoreException unused2) {
            wro.d("KeystoreUtil", "getSecretKeyForRepositorySign KeyStoreException");
            return null;
        } catch (NoSuchAlgorithmException unused3) {
            wro.d("KeystoreUtil", "getSecretKeyForRepositorySign NoSuchAlgorithmException");
            return null;
        } catch (NoSuchProviderException unused4) {
            wro.d("KeystoreUtil", "getSecretKeyForRepositorySign NoSuchProviderException");
            return null;
        } catch (UnrecoverableKeyException unused5) {
            wro.d("KeystoreUtil", "getSecretKeyForRepositorySign UnrecoverableKeyException");
            return null;
        }
    }

    private static SecretKey a() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256", "AndroidKeyStore");
        keyGenerator.init(new KeyGenParameterSpec.Builder("com.huawei.wearengine.repository.sign", 4).build());
        SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
        wro.a("KeystoreUtil", "getSecretKeyForRepositorySign: from KeyGenerator ");
        return secretKeyGenerateKey;
    }
}
