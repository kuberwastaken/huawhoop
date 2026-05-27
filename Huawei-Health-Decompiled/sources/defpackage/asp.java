package defpackage;

import android.app.Activity;
import android.content.Context;
import com.huawei.android.bundlecore.download.Downloader;
import com.huawei.android.bundlecore.install.remote.ModuleInstallSupervisor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes10.dex */
public final class asp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference<ModuleInstallSupervisor> f304a = new AtomicReference<>();

    public static void a(Context context, Downloader downloader, Class<? extends Activity> cls) {
        if (e() == null) {
            atd atdVar = new atd(context, downloader, cls);
            f304a.set(atdVar);
            atdVar.initialize(context);
        }
    }

    public static ModuleInstallSupervisor e() {
        return f304a.get();
    }
}
