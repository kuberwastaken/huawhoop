package com.huawei.haf.localbroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.huawei.haf.application.BaseApplication;
import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes.dex */
public final class LocalBroadcastManager implements LocalBroadcastManagerBridge {
    private static final String TAG = "HAF_LocalBroadcastManager";
    private static LocalBroadcastManagerBridge sDefaultBridge;
    private static volatile LocalBroadcastManager sInstance;
    private final LocalBroadcastManagerBridge mBridge;

    private LocalBroadcastManager() {
        LocalBroadcastManagerBridge localBroadcastManagerBridge = sDefaultBridge;
        if (localBroadcastManagerBridge != null) {
            this.mBridge = localBroadcastManagerBridge;
        } else {
            this.mBridge = new LocalBroadcastManagerImpl(BaseApplication.a());
        }
    }

    public static void setLocalBroadcastManagerBridge(LocalBroadcastManagerBridge localBroadcastManagerBridge) {
        if (localBroadcastManagerBridge != null && sInstance != null) {
            LogUtil.b(TAG, "The setLocalBroadcastManagerBridge needs to be initialized before business use");
        } else {
            sDefaultBridge = localBroadcastManagerBridge;
            LogUtil.a(TAG, "setLocalBroadcastManagerBridge bridge=", localBroadcastManagerBridge);
        }
    }

    public static LocalBroadcastManager getInstance() {
        if (sInstance == null) {
            synchronized (LocalBroadcastManager.class) {
                if (sInstance == null) {
                    sInstance = new LocalBroadcastManager();
                }
            }
        }
        return sInstance;
    }

    @Override // com.huawei.haf.localbroadcastmanager.LocalBroadcastManagerBridge
    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        this.mBridge.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // com.huawei.haf.localbroadcastmanager.LocalBroadcastManagerBridge
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.mBridge.unregisterReceiver(broadcastReceiver);
    }

    @Override // com.huawei.haf.localbroadcastmanager.LocalBroadcastManagerBridge
    public boolean sendBroadcast(Intent intent) {
        return this.mBridge.sendBroadcast(intent);
    }

    @Override // com.huawei.haf.localbroadcastmanager.LocalBroadcastManagerBridge
    public void sendBroadcastSync(Intent intent) {
        this.mBridge.sendBroadcastSync(intent);
    }
}
