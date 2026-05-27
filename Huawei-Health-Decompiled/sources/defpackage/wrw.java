package defpackage;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.huawei.wearengine.connect.ServiceConnectCallback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes11.dex */
public class wrw {
    private RemoteCallbackList<ServiceConnectCallback> b;
    private ExecutorService d;
    private RemoteCallbackList<ServiceConnectCallback> e;

    private wrw() {
        this.d = Executors.newSingleThreadExecutor();
        this.e = new RemoteCallbackList<>();
        this.b = new RemoteCallbackList<>();
    }

    static class b {
        private static final wrw b = new wrw();
    }

    public static wrw c() {
        return b.b;
    }

    public int c(ServiceConnectCallback serviceConnectCallback) {
        if (serviceConnectCallback == null) {
            wro.d("ServiceConnectionCallbackManager", "registerOtaServiceConnectCallback connectCallback is null");
            return 5;
        }
        if (!this.e.register(serviceConnectCallback)) {
            wro.d("ServiceConnectionCallbackManager", "registerOtaServiceConnectCallback register failed");
            return 12;
        }
        wro.a("ServiceConnectionCallbackManager", "after registerOtaServiceConnectCallback, size:" + this.e.getRegisteredCallbackCount());
        return 0;
    }

    public int e(ServiceConnectCallback serviceConnectCallback) {
        if (serviceConnectCallback == null) {
            wro.d("ServiceConnectionCallbackManager", "registerConnectCallback connectCallback is null");
            return 5;
        }
        if (!this.b.register(serviceConnectCallback)) {
            wro.d("ServiceConnectionCallbackManager", "registerConnectCallback register failed");
            return 12;
        }
        wro.a("ServiceConnectionCallbackManager", "after registerConnectCallback, size:" + this.b.getRegisteredCallbackCount());
        return 0;
    }

    public int b(ServiceConnectCallback serviceConnectCallback) {
        if (serviceConnectCallback == null) {
            wro.d("ServiceConnectionCallbackManager", "unregisterOtaServiceConnectCallback connectCallback is null");
            return 5;
        }
        if (!this.e.unregister(serviceConnectCallback)) {
            wro.a("ServiceConnectionCallbackManager", "unregisterOtaServiceConnectCallback connectCallback is not registered, still success");
        }
        wro.a("ServiceConnectionCallbackManager", "after unregisterOtaServiceConnectCallback, size:" + this.e.getRegisteredCallbackCount());
        return 0;
    }

    public int d(ServiceConnectCallback serviceConnectCallback) {
        if (serviceConnectCallback == null) {
            wro.d("ServiceConnectionCallbackManager", "unregisterConnectCallback connectCallback is null");
            return 5;
        }
        if (!this.b.unregister(serviceConnectCallback)) {
            wro.a("ServiceConnectionCallbackManager", "unregisterConnectCallback connectCallback is not registered, still success");
        }
        wro.a("ServiceConnectionCallbackManager", "after unregisterConnectCallback, size:" + this.b.getRegisteredCallbackCount());
        return 0;
    }

    public void d() {
        fBI_("executeOtaServiceConnectCallback", this.e);
    }

    public void a() {
        fBI_("executePhoneServiceConnectCallback", this.b);
    }

    private void fBI_(final String str, final RemoteCallbackList<ServiceConnectCallback> remoteCallbackList) {
        this.d.submit(new Runnable() { // from class: wrw.5
            @Override // java.lang.Runnable
            public void run() {
                wrw.this.fBJ_(str, remoteCallbackList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fBJ_(String str, RemoteCallbackList<ServiceConnectCallback> remoteCallbackList) {
        StringBuilder sb;
        int iBeginBroadcast = remoteCallbackList.beginBroadcast();
        wro.a("ServiceConnectionCallbackManager", str + " callbackNum:" + iBeginBroadcast);
        for (int i = 0; i < iBeginBroadcast; i++) {
            try {
                try {
                    ServiceConnectCallback serviceConnectCallback = (ServiceConnectCallback) remoteCallbackList.getBroadcastItem(i);
                    if (serviceConnectCallback == null) {
                        wro.d("ServiceConnectionCallbackManager", str + " callback is null, index:" + i);
                    } else {
                        serviceConnectCallback.onServiceDisconnect();
                        wro.a("ServiceConnectionCallbackManager", str + " callback ok");
                    }
                } catch (RemoteException unused) {
                    wro.d("ServiceConnectionCallbackManager", str + " RemoteException");
                    try {
                        remoteCallbackList.finishBroadcast();
                        return;
                    } catch (IllegalStateException unused2) {
                        sb = new StringBuilder();
                        sb.append(str);
                        sb.append(" finishBroadcast IllegalStateException");
                        wro.d("ServiceConnectionCallbackManager", sb.toString());
                    }
                }
            } catch (Throwable th) {
                try {
                    remoteCallbackList.finishBroadcast();
                } catch (IllegalStateException unused3) {
                    wro.d("ServiceConnectionCallbackManager", str + " finishBroadcast IllegalStateException");
                }
                throw th;
            }
        }
        try {
            remoteCallbackList.finishBroadcast();
        } catch (IllegalStateException unused4) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append(" finishBroadcast IllegalStateException");
            wro.d("ServiceConnectionCallbackManager", sb.toString());
        }
    }
}
