package defpackage;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public class xbj {
    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
