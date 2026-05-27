package health.compact.a;

import com.huawei.haf.common.os.FileUtils;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class IoUtils {
    private IoUtils() {
    }

    public static void a(Closeable closeable) {
        FileUtils.a(closeable);
    }

    public static InputStream b(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }
}
