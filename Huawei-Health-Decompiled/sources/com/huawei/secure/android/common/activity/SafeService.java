package com.huawei.secure.android.common.activity;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import com.huawei.secure.android.common.intent.IntentUtils;
import com.huawei.secure.android.common.intent.SafeIntent;

/* JADX INFO: loaded from: classes7.dex */
public abstract class SafeService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8899a = "SafeService";

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        try {
            return super.bindService(intent, serviceConnection, i);
        } catch (Exception e) {
            a.a(f8899a, "bindService: " + e.getMessage(), true);
            return false;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        try {
            super.onCreate();
        } catch (Exception e) {
            a.a(f8899a, "onCreate: " + e.getMessage(), true);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            super.onDestroy();
        } catch (Exception e) {
            a.a(f8899a, "onDestroy: " + e.getMessage(), true);
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        try {
            super.onRebind(new SafeIntent(intent));
        } catch (Exception e) {
            a.a(f8899a, "onRebind: " + e.getMessage(), true);
        }
    }

    @Override // android.app.Service
    @Deprecated
    public void onStart(Intent intent, int i) {
        if (IntentUtils.hasIntentBomb(intent)) {
            a.a(f8899a, "onStart : hasIntentBomb");
        }
        try {
            super.onStart(new SafeIntent(intent), i);
        } catch (Exception e) {
            a.a(f8899a, "onStart: " + e.getMessage(), true);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (IntentUtils.hasIntentBomb(intent)) {
            a.a(f8899a, "onStartCommand : hasIntentBomb");
        }
        try {
            return super.onStartCommand(new SafeIntent(intent), i, i2);
        } catch (Exception e) {
            a.a(f8899a, "onStartCommand: " + e.getMessage(), true);
            return 0;
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        try {
            return super.onUnbind(new SafeIntent(intent));
        } catch (Exception e) {
            a.a(f8899a, "onUnbind: " + e.getMessage(), true);
            return false;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        try {
            super.startActivities(intentArr);
        } catch (Exception e) {
            a.a(f8899a, "startActivities: " + e.getMessage(), true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        try {
            super.startActivity(new SafeIntent(intent));
        } catch (Exception e) {
            a.a(f8899a, "startActivity: " + e.getMessage(), true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startForegroundService(Intent intent) {
        try {
            return super.startForegroundService(new SafeIntent(intent));
        } catch (Exception e) {
            a.a(f8899a, "startForegroundService: " + e.getMessage(), true);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        try {
            return super.startService(intent);
        } catch (Exception e) {
            a.a(f8899a, "startService: " + e.getMessage(), true);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        try {
            return super.stopService(intent);
        } catch (Exception e) {
            a.a(f8899a, "stopService: " + e.getMessage(), true);
            return false;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        try {
            super.unbindService(serviceConnection);
        } catch (Exception e) {
            a.a(f8899a, "unbindService: " + e.getMessage(), true);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        try {
            super.unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            a.a(f8899a, "unregisterReceiver: " + e.getMessage(), true);
        }
    }
}
