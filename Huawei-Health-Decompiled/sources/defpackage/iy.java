package defpackage;

import com.airbnb.lottie.LottieLogger;

/* JADX INFO: loaded from: classes3.dex */
public class iy {
    private static LottieLogger d = new ix();

    public static void d(String str) {
        d.debug(str);
    }

    public static void c(String str) {
        d.warning(str);
    }

    public static void e(String str, Throwable th) {
        d.warning(str, th);
    }

    public static void d(String str, Throwable th) {
        d.error(str, th);
    }
}
