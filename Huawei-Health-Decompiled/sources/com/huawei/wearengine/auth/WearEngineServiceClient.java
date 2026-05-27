package com.huawei.wearengine.auth;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.huawei.wearengine.auth.AuthListenerManager;
import defpackage.wro;
import defpackage.wru;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class WearEngineServiceClient {
    private Context c;
    private static final Object d = new Object();
    private static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AuthListenerManager f11754a = null;
    private AtomicBoolean h = new AtomicBoolean(false);
    private boolean e = false;
    private ServiceConnection f = new ServiceConnection() { // from class: com.huawei.wearengine.auth.WearEngineServiceClient.4
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            wro.a("WearEngineServiceClient", "onServiceConnected success!");
            WearEngineServiceClient.this.f11754a = AuthListenerManager.Stub.asInterface(iBinder);
            WearEngineServiceClient.this.h.getAndSet(true);
            synchronized (WearEngineServiceClient.b) {
                WearEngineServiceClient.this.e = true;
                WearEngineServiceClient.b.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            wro.a("WearEngineServiceClient", "onServiceDisconnected success!");
            WearEngineServiceClient.this.f11754a = null;
            WearEngineServiceClient.this.h.getAndSet(false);
            synchronized (WearEngineServiceClient.b) {
                WearEngineServiceClient.this.e = true;
                WearEngineServiceClient.b.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName componentName) {
            wro.b("WearEngineServiceClient", "onBindingDied!");
            WearEngineServiceClient.this.f11754a = null;
            WearEngineServiceClient.this.h.getAndSet(false);
            synchronized (WearEngineServiceClient.b) {
                WearEngineServiceClient.this.e = true;
                WearEngineServiceClient.b.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName componentName) {
            wro.b("WearEngineServiceClient", "onNullBinding!");
            WearEngineServiceClient.this.f11754a = null;
            WearEngineServiceClient.this.h.getAndSet(false);
            synchronized (WearEngineServiceClient.b) {
                WearEngineServiceClient.this.e = true;
                WearEngineServiceClient.b.notifyAll();
            }
        }
    };

    public WearEngineServiceClient(Context context) {
        this.c = context;
    }

    public void c() {
        synchronized (d) {
            if (this.f11754a != null) {
                wro.b("WearEngineServiceClient", "Already binder the WearEngineService.");
            } else {
                wro.a("WearEngineServiceClient", "Start to bind service.");
                d();
            }
        }
    }

    public AuthListenerManager e() {
        return this.f11754a;
    }

    private void d() {
        synchronized (d) {
            Intent intent = new Intent();
            intent.setPackage("com.huawei.health");
            intent.setClassName("com.huawei.health", "com.huawei.wearengine.service.WearEngineExtendService");
            intent.setAction("com.huawei.wearengine.action.AUTH_LISTENER_MANAGER");
            Intent intentFBF_ = wru.fBF_(intent);
            if (intentFBF_ == null) {
                return;
            }
            wro.a("WearEngineServiceClient", "explicitIntent != null, bindService");
            this.c.bindService(intentFBF_, this.f, 1);
            f();
        }
    }

    private void f() {
        synchronized (b) {
            wro.b("WearEngineServiceClient", "binder Lock enter!");
            while (!this.e) {
                try {
                    wro.b("WearEngineServiceClient", "start Wait");
                    b.wait(30000L);
                    this.e = true;
                    wro.b("WearEngineServiceClient", "wait end");
                } catch (InterruptedException unused) {
                    wro.d("WearEngineServiceClient", "QUERY_LOCK wait error");
                }
            }
        }
    }

    public void a() {
        if (this.h.get()) {
            this.h.getAndSet(false);
            synchronized (d) {
                try {
                    this.c.unbindService(this.f);
                } catch (IllegalArgumentException unused) {
                    wro.d("WearEngineServiceClient", "unBindService IllegalArgumentException");
                }
            }
        }
    }
}
