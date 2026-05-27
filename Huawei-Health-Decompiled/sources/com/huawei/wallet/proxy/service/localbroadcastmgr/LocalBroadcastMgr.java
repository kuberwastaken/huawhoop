package com.huawei.wallet.proxy.service.localbroadcastmgr;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes11.dex */
public class LocalBroadcastMgr {
    private static final String d = "LocalBroadcastMgr";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f11384a;

    private LocalBroadcastMgr() {
        try {
            this.f11384a = Class.forName("com.huawei.haf.localbroadcastmanager.LocalBroadcastManager").getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException unused) {
            Log.e(d, "catch ClassNotFoundException on new LocalBroadcastMgr");
        } catch (IllegalAccessException | InvocationTargetException unused2) {
            Log.e(d, "catch IllegalAccessException | InvocationTargetException on new LocalBroadcastMgr");
        } catch (NoSuchMethodException unused3) {
            Log.e(d, "catch NoSuchMethodException on new LocalBroadcastMgr");
        }
    }

    public static LocalBroadcastMgr a() {
        return Singleton.b;
    }

    public void fkq_(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        try {
            this.f11384a.getClass().getMethod("registerReceiver", BroadcastReceiver.class, IntentFilter.class).invoke(this.f11384a, broadcastReceiver, intentFilter);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e(d, "catch IllegalAccessException | InvocationTargetException on registerReceiver");
        } catch (NoSuchMethodException unused2) {
            Log.e(d, "catch NoSuchMethodException on registerReceiver");
        }
    }

    public void fkt_(BroadcastReceiver broadcastReceiver) {
        try {
            this.f11384a.getClass().getMethod("unregisterReceiver", BroadcastReceiver.class).invoke(this.f11384a, broadcastReceiver);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e(d, "catch IllegalAccessException | InvocationTargetException on unregisterReceiver");
        } catch (NoSuchMethodException unused2) {
            Log.e(d, "catch NoSuchMethodException on unregisterReceiver");
        }
    }

    public boolean fkr_(Intent intent) {
        try {
            Object objInvoke = this.f11384a.getClass().getMethod("sendBroadcast", Intent.class).invoke(this.f11384a, intent);
            if (objInvoke != null) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e(d, "catch IllegalAccessException | InvocationTargetException on sendBroadcast");
            return false;
        } catch (NoSuchMethodException unused2) {
            Log.e(d, "catch NoSuchMethodException on sendBroadcast");
            return false;
        }
    }

    public void fks_(Intent intent) {
        try {
            this.f11384a.getClass().getMethod("sendBroadcastSync", Intent.class).invoke(this.f11384a, intent);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            Log.e(d, "catch IllegalAccessException | InvocationTargetException on sendBroadcastSync");
        } catch (NoSuchMethodException unused2) {
            Log.e(d, "catch NoSuchMethodException on sendBroadcastSync");
        }
    }

    static class Singleton {
        private static final LocalBroadcastMgr b = new LocalBroadcastMgr();

        private Singleton() {
        }
    }
}
