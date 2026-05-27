package defpackage;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import com.huawei.wearengine.core.callback.ServiceConnectStateCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes11.dex */
public class wva {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18942a;
    private final String h;
    private final String j;
    private final ExecutorService g = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private final Object e = new Object();
    private final Object d = new Object();
    private ServiceConnectStateCallback f = null;
    private volatile IBinder b = null;
    private volatile boolean c = false;
    private final ServiceConnection i = new ServiceConnection() { // from class: wva.4
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            wro.a("ServiceBindingHelper", "onServiceConnected success!");
            synchronized (wva.this.d) {
                wva.this.b = iBinder;
                wva.this.c = true;
                wro.b("ServiceBindingHelper", "onServiceConnected BINDER_LOCK notifyAll");
                wva.this.d.notifyAll();
            }
            wva.this.fDP_(componentName, iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            wro.a("ServiceBindingHelper", "onServiceDisconnected success!");
            synchronized (wva.this.d) {
                wva.this.b = null;
                wva.this.c = true;
                wro.b("ServiceBindingHelper", "onServiceDisconnected BINDER_LOCK notifyAll");
                wva.this.d.notifyAll();
            }
            wva.this.fDQ_(componentName);
        }
    };

    public wva(String str, String str2) {
        this.h = str;
        this.j = str2;
    }

    public void b(String str) {
        this.f18942a = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fDP_(final ComponentName componentName, final IBinder iBinder) {
        if (this.f == null) {
            wro.e("ServiceBindingHelper", this.j + ", mServiceConnectStateCallback is null");
            return;
        }
        this.g.execute(new Runnable() { // from class: wva.1
            @Override // java.lang.Runnable
            public void run() {
                wva.this.f.onConnectChanged(componentName, iBinder, true);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fDQ_(final ComponentName componentName) {
        if (this.f == null) {
            wro.e("ServiceBindingHelper", this.j + ", mServiceConnectStateCallback is null");
            return;
        }
        this.g.execute(new Runnable() { // from class: wva.3
            @Override // java.lang.Runnable
            public void run() {
                wva.this.f.onConnectChanged(componentName, null, false);
            }
        });
    }

    public void a(ServiceConnectStateCallback serviceConnectStateCallback) {
        wro.a("ServiceBindingHelper", "registerOnServiceConnectStateCallback:" + this.j);
        this.f = serviceConnectStateCallback;
    }

    private void c() {
        wro.a("ServiceBindingHelper", "start bindService service : " + this.j);
        synchronized (this.e) {
            wro.a("ServiceBindingHelper", "bindService locked");
            if (this.b != null) {
                wro.a("ServiceBindingHelper", "mBinder is not null");
                return;
            }
            if (TextUtils.isEmpty(this.h) || TextUtils.isEmpty(this.j)) {
                wro.d("ServiceBindingHelper", "packageName or className is empty");
                throw new IllegalStateException(String.valueOf(12));
            }
            Intent intent = new Intent();
            intent.setPackage(this.h);
            intent.setClassName(this.h, this.j);
            if (!TextUtils.isEmpty(this.f18942a)) {
                intent.setAction(this.f18942a);
            }
            Intent intentFBF_ = wru.fBF_(intent);
            if (intentFBF_ == null) {
                throw new IllegalStateException(String.valueOf(12));
            }
            synchronized (this.d) {
                this.c = false;
                if (!wru.e().bindService(intentFBF_, this.i, 37)) {
                    wro.d("ServiceBindingHelper", "bindService do not has permission");
                    throw new IllegalStateException(String.valueOf(15));
                }
                b();
            }
        }
    }

    private void b() {
        while (!this.c) {
            try {
                wro.a("ServiceBindingHelper", "bindService BINDER_LOCK wait");
                this.d.wait(30000L);
                wro.a("ServiceBindingHelper", "bindService BINDER_LOCK continue");
                this.c = true;
            } catch (InterruptedException unused) {
                wro.d("ServiceBindingHelper", "bindService wait error");
                return;
            }
        }
        wro.a("ServiceBindingHelper", "bindService finish");
    }

    public void e() {
        synchronized (this.e) {
            if (this.b != null) {
                wro.a("ServiceBindingHelper", "begin unBindService");
                try {
                    wru.e().unbindService(this.i);
                } catch (Exception unused) {
                    wro.d("ServiceBindingHelper", "unBindService has exception");
                }
                this.b = null;
            }
        }
        wro.a("ServiceBindingHelper", "unBindService success");
    }

    public IBinder fDR_() {
        return this.b;
    }

    public IBinder fDS_() {
        if (this.b == null) {
            c();
        }
        return this.b;
    }
}
