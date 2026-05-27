package com.huawei.wallet.proxy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.IBinder;

/* JADX INFO: loaded from: classes11.dex */
public class InitWalletProxy implements InitWalletApi {
    private static volatile InitWalletProxy e;
    private InitWalletApi d = d();

    private InitWalletProxy() throws ClassNotFoundException {
    }

    private InitWalletApi e() {
        try {
            if (this.d == null) {
                this.d = d();
            }
        } catch (ClassNotFoundException unused) {
            this.d = null;
        }
        return this.d;
    }

    private InitWalletApi d() throws ClassNotFoundException {
        return (InitWalletApi) a("com.huawei.nfc.carrera.wear.InitWalletApiImpl");
    }

    private static Object a(String str) throws ClassNotFoundException {
        try {
            return d(str).newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    private static Class<?> d(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    public static InitWalletProxy a() throws ClassNotFoundException {
        InitWalletProxy initWalletProxy;
        if (e == null) {
            synchronized (InitWalletProxy.class) {
                if (e == null) {
                    e = new InitWalletProxy();
                }
                initWalletProxy = e;
            }
            return initWalletProxy;
        }
        return e;
    }

    @Override // com.huawei.wallet.proxy.InitWalletApi
    public void initBaseConfig(Context context) {
        if (e() != null) {
            this.d.initBaseConfig(context);
        }
    }

    @Override // com.huawei.wallet.proxy.InitWalletApi
    public boolean isInitBaseCommonContext() {
        if (e() != null) {
            return this.d.isInitBaseCommonContext();
        }
        return true;
    }

    @Override // com.huawei.wallet.proxy.InitWalletApi
    public void receiverData(String str, String str2) {
        if (e() != null) {
            this.d.receiverData(str, str2);
        }
    }

    @Override // com.huawei.wallet.proxy.InitWalletApi
    public void initWearWallet(Context context) {
        if (e() != null) {
            this.d.initWearWallet(context);
        }
    }

    @Override // com.huawei.wallet.proxy.InitWalletApi
    public void reverseWalletStartDeepLink(String str) {
        if (e() != null) {
            this.d.reverseWalletStartDeepLink(str);
        }
    }

    @Override // com.huawei.wallet.proxy.InitWalletApi
    public void walletAccountRemove(Context context, Intent intent) {
        if (e() != null) {
            this.d.walletAccountRemove(context, intent);
        }
    }

    @Override // com.huawei.wallet.proxy.InitWalletApi
    public IBinder getServiceBinder(Context context, String str, Intent intent) {
        if (e() != null) {
            return this.d.getServiceBinder(context, str, intent);
        }
        return null;
    }

    @Override // com.huawei.wallet.proxy.InitWalletApi
    public void serviceOnCreate(Context context, String str) {
        if (e() != null) {
            this.d.serviceOnCreate(context, str);
        }
    }

    @Override // com.huawei.wallet.proxy.InitWalletApi
    public void serviceOnDestroy(Context context, String str) {
        if (e() != null) {
            this.d.serviceOnDestroy(context, str);
        }
    }

    @Override // com.huawei.wallet.proxy.InitWalletApi
    public Object getContentProvider(Context context, String str, Uri uri) {
        if (e() != null) {
            return this.d.getContentProvider(context, str, uri);
        }
        return new Object();
    }
}
