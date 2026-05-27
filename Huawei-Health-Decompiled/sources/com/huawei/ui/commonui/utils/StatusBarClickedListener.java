package com.huawei.ui.commonui.utils;

import android.content.BroadcastReceiver;
import com.huawei.haf.application.BroadcastManager;

/* JADX INFO: loaded from: classes7.dex */
public abstract class StatusBarClickedListener extends BroadcastReceiver {
    public StatusBarClickedListener() {
        BroadcastManager.xL_(this);
    }

    public void unregister() {
        BroadcastManager.xZ_(this);
    }
}
