package com.huawei.dnurse.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
class a extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DnurseDeviceTest f1997a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Log.i("HWHealthSDK", "Get event");
        if (intent.getAction().equals("android.intent.action.HEADSET_PLUG")) {
            if (intent.getIntExtra("state", 0) == 0 || intent.getIntExtra("microphone", 0) != 1) {
                if (this.f1997a.B) {
                    if (this.f1997a.f != 0) {
                        this.f1997a.c();
                        this.f1997a.K.postDelayed(this.f1997a.b, this.f1997a.q);
                    }
                    this.f1997a.B = false;
                    Log.i("HWHealthSDK", "Headset removed");
                    return;
                }
                return;
            }
            if (this.f1997a.B) {
                return;
            }
            Log.i("HWHealthSDK", "Model: " + Build.MODEL);
            Log.i("HWHealthSDK", "Ver: " + Build.VERSION.RELEASE);
            this.f1997a.B = true;
            this.f1997a.wakeupDevice();
        }
    }

    a(DnurseDeviceTest dnurseDeviceTest) {
        this.f1997a = dnurseDeviceTest;
    }
}
