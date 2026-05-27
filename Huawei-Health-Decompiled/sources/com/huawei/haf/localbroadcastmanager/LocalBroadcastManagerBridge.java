package com.huawei.haf.localbroadcastmanager;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes.dex */
public interface LocalBroadcastManagerBridge {
    void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter);

    boolean sendBroadcast(Intent intent);

    void sendBroadcastSync(Intent intent);

    void unregisterReceiver(BroadcastReceiver broadcastReceiver);
}
