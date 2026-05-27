package defpackage;

import health.compact.a.LogUtil;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class chf {
    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                LogUtil.d("IoUtils", "closeQuietly occurIOException.");
            }
        }
    }
}
