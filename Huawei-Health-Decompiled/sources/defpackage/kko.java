package defpackage;

import com.huawei.haf.common.exception.ExceptionUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hwbtsdk.btcommon.EncryptionBase;
import health.compact.a.LogUtil;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes5.dex */
public class kko extends EncryptionBase {
    private String e;

    public kko(int i) {
        c(i);
    }

    private void c(int i) {
        if (i == 1) {
            this.e = "AES/CBC/PKCS5Padding";
        } else {
            this.e = "AES/CBC/PKCS5Padding";
        }
    }

    @Override // com.huawei.hwbtsdk.btcommon.EncryptionBase
    public byte[] encrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr2 == null || bArr3 == null) {
            return (byte[]) new byte[0].clone();
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr3);
        try {
            Cipher cipher = Cipher.getInstance(this.e);
            cipher.init(1, secretKeySpec, ivParameterSpec);
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "encrypt InvalidAlgorithmParameterException is:", ExceptionUtils.a(e));
            return (byte[]) new byte[0].clone();
        } catch (IllegalBlockSizeException e2) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "encrypt IllegalBlockSizeException is:", ExceptionUtils.a(e2));
            return (byte[]) new byte[0].clone();
        } catch (NoSuchAlgorithmException e3) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "encrypt NoSuchAlgorithmException is:", ExceptionUtils.a(e3));
            return (byte[]) new byte[0].clone();
        } catch (BadPaddingException e4) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "encrypt BadPaddingException is:", ExceptionUtils.a(e4));
            return (byte[]) new byte[0].clone();
        } catch (InvalidKeyException e5) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "encrypt InvalidKeyException is:", ExceptionUtils.a(e5));
            return (byte[]) new byte[0].clone();
        } catch (NoSuchPaddingException e6) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "encrypt NoSuchPaddingException is:", ExceptionUtils.a(e6));
            return (byte[]) new byte[0].clone();
        } finally {
            LogUtil.b(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "encrypt finally");
        }
    }

    @Override // com.huawei.hwbtsdk.btcommon.EncryptionBase
    public byte[] desEncrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null || bArr2 == null || bArr3 == null) {
            return (byte[]) new byte[0].clone();
        }
        try {
            Cipher cipher = Cipher.getInstance(this.e);
            cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(bArr3));
            return cipher.doFinal(bArr);
        } catch (InvalidAlgorithmParameterException e) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "desEncrypt InvalidAlgorithmParameterException is:", ExceptionUtils.a(e));
            return (byte[]) new byte[0].clone();
        } catch (BadPaddingException e2) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "desEncrypt BadPaddingException is:", ExceptionUtils.a(e2));
            return (byte[]) new byte[0].clone();
        } catch (NoSuchAlgorithmException e3) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "desEncrypt NoSuchAlgorithmException is:", ExceptionUtils.a(e3));
            return (byte[]) new byte[0].clone();
        } catch (IllegalBlockSizeException e4) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "desEncrypt IllegalBlockSizeException is:", ExceptionUtils.a(e4));
            return (byte[]) new byte[0].clone();
        } catch (InvalidKeyException e5) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "desEncrypt InvalidKeyException is:", ExceptionUtils.a(e5));
            return (byte[]) new byte[0].clone();
        } catch (NoSuchPaddingException e6) {
            LogUtil.d(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "desEncrypt NoSuchPaddingException is:", ExceptionUtils.a(e6));
            return (byte[]) new byte[0].clone();
        } finally {
            LogUtil.b(HiAnalyticsConstant.KeyAndValue.NUMBER_01, 1, "AesCbcPkCS5Padding", "desEncrypt finally");
        }
    }
}
