package defpackage;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.res.Resources;
import com.huawei.haf.bundle.AppBundleResources;

/* JADX INFO: loaded from: classes10.dex */
public final class atv implements AppBundleResources {
    @Override // com.huawei.haf.bundle.AppBundleResources
    public void loadResources(Context context) {
        ary.a(context);
    }

    @Override // com.huawei.haf.bundle.AppBundleResources
    public void loadResources(Activity activity, Resources resources) {
        ary.fo_(activity, resources);
    }

    @Override // com.huawei.haf.bundle.AppBundleResources
    public void loadResources(Service service) {
        ary.fp_(service);
    }

    @Override // com.huawei.haf.bundle.AppBundleResources
    public void loadResources(BroadcastReceiver broadcastReceiver, Context context) {
        ary.fq_(broadcastReceiver, context);
    }

    @Override // com.huawei.haf.bundle.AppBundleResources
    public void loadLibrary(Context context, String str) {
        ary.b(context, str);
    }
}
