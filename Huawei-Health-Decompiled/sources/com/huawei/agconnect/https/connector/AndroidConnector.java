package com.huawei.agconnect.https.connector;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* JADX INFO: loaded from: classes3.dex */
public class AndroidConnector implements Connector {
    public static final Object b = new Object();
    public static AndroidConnector c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1840a;

    @Override // com.huawei.agconnect.https.connector.Connector
    public void logger(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // com.huawei.agconnect.https.connector.Connector
    public boolean hasActiveNetwork() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        Context context = this.f1840a;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static AndroidConnector a(Context context) {
        AndroidConnector androidConnector;
        synchronized (b) {
            if (c == null) {
                c = new AndroidConnector(context);
            }
            androidConnector = c;
        }
        return androidConnector;
    }

    public AndroidConnector(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f1840a = applicationContext != null ? applicationContext : context;
    }
}
