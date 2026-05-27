package defpackage;

import android.text.TextUtils;
import com.huawei.haf.common.exception.ExceptionUtils;
import health.compact.a.util.LogUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes7.dex */
public final class oam {
    public static byte[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] bArrDigest = messageDigest.digest();
            if (bArrDigest != null) {
                return bArrDigest;
            }
        } catch (UnsupportedEncodingException e) {
            LogUtil.d("Sha256", "UnsupportedEncodingException", ExceptionUtils.a(e));
        } catch (NoSuchAlgorithmException e2) {
            LogUtil.d("Sha256", "NoSuchAlgorithmException", ExceptionUtils.a(e2));
        }
        return new byte[0];
    }

    public static byte[] e(InputStream inputStream) {
        MessageDigest messageDigest;
        if (inputStream == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[4096];
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (IOException e) {
            LogUtil.d("Sha256", "IOException", ExceptionUtils.a(e));
        } catch (NoSuchAlgorithmException e2) {
            LogUtil.d("Sha256", "NoSuchAlgorithmException", ExceptionUtils.a(e2));
        }
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                break;
            }
            messageDigest.update(bArr, 0, i);
            return new byte[0];
        }
        byte[] bArrDigest = messageDigest.digest();
        if (bArrDigest != null) {
            return bArrDigest;
        }
        return new byte[0];
    }

    public static String c(String str) {
        return oah.e(a(str));
    }

    public static String b(InputStream inputStream) {
        return oah.e(e(inputStream));
    }
}
