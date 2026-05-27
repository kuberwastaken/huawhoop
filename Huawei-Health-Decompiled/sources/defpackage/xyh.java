package defpackage;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.regex.Pattern;
import net.openid.appauth.internal.Logger;

/* JADX INFO: loaded from: classes8.dex */
public final class xyh {
    private static final Pattern c = Pattern.compile("^[0-9a-zA-Z\\-\\.\\_\\~]{43,128}$");

    public static void e(String str) {
        xym.c(43 <= str.length(), "codeVerifier length is shorter than allowed by the PKCE specification");
        xym.c(str.length() <= 128, "codeVerifier length is longer than allowed by the PKCE specification");
        xym.c(c.matcher(str).matches(), "codeVerifier string contains illegal characters");
    }

    public static String c() {
        return c(new SecureRandom(), 64);
    }

    public static String c(SecureRandom secureRandom, int i) {
        xym.c(secureRandom, "entropySource cannot be null");
        xym.c(32 <= i, "entropyBytes is less than the minimum permitted");
        xym.c(i <= 96, "entropyBytes is greater than the maximum permitted");
        byte[] bArr = new byte[i];
        secureRandom.nextBytes(bArr);
        return Base64.encodeToString(bArr, 11);
    }

    public static String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("ISO_8859_1"));
            return Base64.encodeToString(messageDigest.digest(), 11);
        } catch (UnsupportedEncodingException e) {
            Logger.a("ISO-8859-1 encoding not supported on this device!", e);
            throw new IllegalStateException("ISO-8859-1 encoding not supported", e);
        } catch (NoSuchAlgorithmException e2) {
            Logger.e("SHA-256 is not supported on this device! Using plain challenge", e2);
            return str;
        }
    }

    public static String a() {
        try {
            MessageDigest.getInstance("SHA-256");
            return "S256";
        } catch (NoSuchAlgorithmException unused) {
            return "plain";
        }
    }
}
