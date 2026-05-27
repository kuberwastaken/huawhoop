package com.huawei.wear.wallet.proxy.broadcaster;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.wallet.proxy.InitWalletProxy;
import defpackage.vwc;

/* JADX INFO: loaded from: classes11.dex */
public class ForegroundStatusChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        b();
    }

    private void b() {
        try {
            vwc.c("ForegroundStatusChangeReceiver", "doReceiver");
            try {
                InitWalletProxy initWalletProxyA = InitWalletProxy.a();
                if (initWalletProxyA != null) {
                    initWalletProxyA.receiverData("101", HiAnalyticsConstant.KeyAndValue.NUMBER_01);
                }
            } catch (ClassNotFoundException unused) {
                vwc.c("ForegroundStatusChangeReceiver", "onBind, not PluginAvailable");
            }
        } catch (Exception unused2) {
            vwc.b("ForegroundStatusChangeReceiver", "onReceive exception");
        }
    }
}
