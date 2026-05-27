package defpackage;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes8.dex */
public class vyo {
    public static SecureRandom d() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException unused) {
            vwc.e("SecureCommonUtil", "can't get strong secureRandom", false);
            try {
                return SecureRandom.getInstance("SHA1PRNG");
            } catch (NoSuchAlgorithmException unused2) {
                vwc.e("SecureCommonUtil", "can't get SHA1PRNG secureRandom", false);
                return new SecureRandom();
            }
        }
    }
}
