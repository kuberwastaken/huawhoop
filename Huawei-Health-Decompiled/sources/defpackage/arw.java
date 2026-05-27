package defpackage;

import com.huawei.android.appbundle.splitinstall.LoadedSplitFetcher;
import com.huawei.operation.view.CustomWebView$$ExternalSyntheticBackport0;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes10.dex */
public final class arw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<LoadedSplitFetcher> f289a = new AtomicReference<>(null);

    static LoadedSplitFetcher a() {
        return f289a.get();
    }

    public static void b(LoadedSplitFetcher loadedSplitFetcher) {
        CustomWebView$$ExternalSyntheticBackport0.m(f289a, null, loadedSplitFetcher);
    }
}
