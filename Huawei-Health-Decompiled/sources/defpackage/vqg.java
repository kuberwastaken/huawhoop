package defpackage;

import com.huawei.unitedevice.config.IwearLinkConfig;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public class vqg {
    private static volatile IwearLinkConfig e;

    public static IwearLinkConfig e() {
        if (Objects.nonNull(e)) {
            return e;
        }
        return e.d;
    }

    public static void a(IwearLinkConfig iwearLinkConfig) {
        e = iwearLinkConfig;
    }

    static class e implements IwearLinkConfig {
        private static IwearLinkConfig d = new e();

        private e() {
        }
    }
}
