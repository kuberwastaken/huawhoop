package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import com.huawei.wallet.proxy.service.localbroadcastmgr.LocalBroadcastMgr;
import com.huawei.watchface.api.HwWatchFaceApi;
import com.huawei.wear.wallet.proxy.broadcaster.ForegroundStatusChangeReceiver;

/* JADX INFO: loaded from: classes11.dex */
public class wha {
    private static volatile wha b;
    private static final Object d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f18850a = false;
    private final ForegroundStatusChangeReceiver c = new ForegroundStatusChangeReceiver();

    public static wha b() {
        if (b == null) {
            synchronized (d) {
                if (b == null) {
                    b = new wha();
                }
            }
        }
        return b;
    }

    public void d(Context context) {
        if (this.f18850a) {
            vwc.c("BroadcastReceiverRegManager", "hasRegisterForegroundStatusChanged");
        } else {
            if (context == null) {
                vwc.b("BroadcastReceiverRegManager", "invalid context");
                return;
            }
            LocalBroadcastMgr.a().fkq_(this.c, new IntentFilter(HwWatchFaceApi.ACTION_FOREGROUND_STATUS));
            this.f18850a = true;
            vwc.c("BroadcastReceiverRegManager", "registerForegroundStatusChange complete");
        }
    }
}
