package defpackage;

import com.huawei.android.appbundle.splitinstall.SplitSessionLoader;
import com.huawei.operation.view.CustomWebView$$ExternalSyntheticBackport0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes10.dex */
public final class asg {
    private static final AtomicReference<SplitSessionLoader> c = new AtomicReference<>();

    static SplitSessionLoader d() {
        return c.get();
    }

    public static void a(SplitSessionLoader splitSessionLoader) {
        CustomWebView$$ExternalSyntheticBackport0.m(c, null, splitSessionLoader);
    }
}
