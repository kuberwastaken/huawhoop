package com.alipay.sdk.m.u0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.alipay.sdk.m.t0.a;

/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static String b = "OpenDeviceId library";
    public static boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f797a;
    public ServiceConnection e;
    public Context d = null;
    public InterfaceC0019b f = null;

    /* JADX INFO: renamed from: com.alipay.sdk.m.u0.b$b, reason: collision with other inner class name */
    public interface InterfaceC0019b<T> {
        void a(T t, b bVar);
    }

    public class d implements ServiceConnection {
        public d() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (this) {
                b.this.f797a = a.AbstractBinderC0018a.a(iBinder);
                if (b.this.f != null) {
                    b.this.f.a("Deviceid Service Connected", b.this);
                }
                b.this.e("Service onServiceConnected");
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b.this.f797a = null;
            b.this.e("Service onServiceDisconnected");
        }
    }

    public String c() {
        if (this.d == null) {
            c("Context is null.");
            throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
        }
        try {
            a aVar = this.f797a;
            if (aVar != null) {
                return aVar.a();
            }
            return null;
        } catch (RemoteException e) {
            c("getOAID error, RemoteException!");
            e.printStackTrace();
            return null;
        }
    }

    public boolean d() {
        try {
            if (this.f797a == null) {
                return false;
            }
            e("Device support opendeviceid");
            return this.f797a.c();
        } catch (RemoteException unused) {
            c("isSupport error, RemoteException!");
            return false;
        }
    }

    public int b(Context context, InterfaceC0019b<String> interfaceC0019b) {
        if (context != null) {
            this.d = context;
            this.f = interfaceC0019b;
            this.e = new d();
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.d.bindService(intent, this.e, 1)) {
                e("bindService Successful!");
                return 1;
            }
            e("bindService Failed!");
            return -1;
        }
        throw new NullPointerException("Context can not be null.");
    }

    public final void e(String str) {
        if (c) {
            Log.i(b, str);
        }
    }

    public final void c(String str) {
        if (c) {
            Log.e(b, str);
        }
    }
}
