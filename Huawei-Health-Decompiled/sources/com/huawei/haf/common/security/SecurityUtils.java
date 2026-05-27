package com.huawei.haf.common.security;

import android.util.Base64;
import com.huawei.haf.common.utils.CommonConstant;
import com.huawei.haf.common.utils.HexUtils;
import health.compact.a.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class SecurityUtils {
    private SecurityUtils() {
    }

    public static String c(String str) {
        if (str == null) {
            return "";
        }
        try {
            return HexUtils.c(e(str.getBytes(StandardCharsets.UTF_8), "SHA-256"));
        } catch (NoSuchAlgorithmException e) {
            LogUtil.d("HAF_SecurityUtils", "getSha256ForHex ex=", LogUtil.c(e));
            return "";
        }
    }

    public static String c(File file) {
        return b(file, (byte[]) null, false);
    }

    public static String b(File file, byte[] bArr, boolean z) {
        if (file == null || !file.exists()) {
            return "";
        }
        try {
            return HexUtils.b(b(file, bArr, "SHA-256"), z);
        } catch (IOException | NoSuchAlgorithmException e) {
            LogUtil.d("HAF_SecurityUtils", "getSha256ForHex ex=", LogUtil.c(e));
            return "";
        }
    }

    public static String a(String str) {
        return e(str, 10);
    }

    public static String b(String str) {
        return e(str, 2);
    }

    private static String e(String str, int i) {
        if (str == null) {
            return "";
        }
        try {
            return Base64.encodeToString(e(str.getBytes(StandardCharsets.UTF_8), "SHA-256"), i);
        } catch (NoSuchAlgorithmException e) {
            LogUtil.d("HAF_SecurityUtils", "getSha256ForBase64 ex=", LogUtil.c(e));
            return "";
        }
    }

    public static byte[] e(String str) {
        if (str != null) {
            try {
                return e(str.getBytes(StandardCharsets.UTF_8), "SHA-256");
            } catch (NoSuchAlgorithmException e) {
                LogUtil.d("HAF_SecurityUtils", "getSha256 ex=", LogUtil.c(e));
            }
        }
        return CommonConstant.e;
    }

    public static byte[] e(byte[] bArr, String str) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(str).digest(bArr);
    }

    public static byte[] b(File file, byte[] bArr, String str) throws NoSuchAlgorithmException, IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArrB = b(fileInputStream, bArr, str);
            fileInputStream.close();
            return bArrB;
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private static byte[] b(InputStream inputStream, byte[] bArr, String str) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        DigestInputStream digestInputStream = new DigestInputStream(inputStream, messageDigest);
        try {
            do {
            } while (digestInputStream.read(new byte[8192]) != -1);
            digestInputStream.close();
            if (bArr != null && bArr.length > 0) {
                messageDigest.update(bArr);
            }
            return messageDigest.digest();
        } catch (Throwable th) {
            try {
                digestInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
