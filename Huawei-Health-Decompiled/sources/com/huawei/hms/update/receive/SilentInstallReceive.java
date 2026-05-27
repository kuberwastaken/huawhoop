package com.huawei.hms.update.receive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ui.SafeIntent;
import com.huawei.hms.update.UpdateConstants;

/* JADX INFO: loaded from: classes10.dex */
public class SilentInstallReceive extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f6257a;

    public SilentInstallReceive(Handler handler) {
        this.f6257a = handler;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        SafeIntent safeIntent = new SafeIntent(intent);
        String action = null;
        try {
            extras = safeIntent.getExtras();
        } catch (Throwable unused) {
            extras = null;
        }
        try {
            action = safeIntent.getAction();
        } catch (Throwable unused2) {
            Log.w("SilentInstallReceive", "onReceive, throwable occur.");
        }
        if (extras == null || TextUtils.isEmpty(action)) {
            Log.w("SilentInstallReceive", "bundle or action is empty. ");
            return;
        }
        if (UpdateConstants.DOWNLOAD_STATUS_ACTION.equals(action)) {
            Message message = new Message();
            message.what = 101;
            message.obj = extras;
            this.f6257a.sendMessage(message);
            return;
        }
        if (UpdateConstants.DOWNLOAD_PROGRESS_ACTION.equals(action)) {
            Message message2 = new Message();
            message2.what = 102;
            message2.obj = extras;
            this.f6257a.sendMessage(message2);
            return;
        }
        if (UpdateConstants.INSTALL_ACTION.equals(action)) {
            Message message3 = new Message();
            message3.what = 103;
            message3.obj = extras;
            this.f6257a.sendMessage(message3);
        }
    }
}
