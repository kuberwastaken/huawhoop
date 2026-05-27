package defpackage;

import health.compact.a.ReleaseLogUtil;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class kqu {
    public static SecureRandom c() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            ReleaseLogUtil.a("R_SecureRandomUtil", "getSecureRandom exception ", e);
            return new SecureRandom();
        }
    }

    public static int a(int i) {
        if (i <= 0) {
            ReleaseLogUtil.b("R_SecureRandomUtil", "getSecureRandomForInt bound ", Integer.valueOf(i));
            return 0;
        }
        return c().nextInt(i);
    }

    public static int b(long j, int i, int i2) {
        if (j <= i) {
            return a(i2);
        }
        return 0;
    }

    public static int c(int i, int i2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        return b(jCurrentTimeMillis - kql.r(jCurrentTimeMillis), i, i2);
    }
}
