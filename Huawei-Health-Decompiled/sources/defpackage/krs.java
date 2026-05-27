package defpackage;

import android.content.Context;
import com.huawei.haf.common.exception.ExceptionUtils;
import health.compact.a.ReleaseLogUtil;

/* JADX INFO: loaded from: classes.dex */
public class krs {
    private static final Object e = new Object();

    public static void a(Context context) {
        synchronized (e) {
            try {
                try {
                    System.loadLibrary("sqlcipher");
                } catch (UnsatisfiedLinkError e2) {
                    ReleaseLogUtil.a("R_DatabaseLoadUtils", "loadLibs exception ", ExceptionUtils.a(e2));
                    throw new UnsatisfiedLinkError("loadLib：libsqlcipher.so throw exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
