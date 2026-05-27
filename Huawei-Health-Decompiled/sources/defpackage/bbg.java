package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes3.dex */
public class bbg {
    private static ConnectivityManager c;

    public static boolean a(Context context) {
        ConnectivityManager connectivityManagerIO_;
        NetworkInfo activeNetworkInfo;
        return (context == null || (connectivityManagerIO_ = iO_(context)) == null || (activeNetworkInfo = connectivityManagerIO_.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }

    public static int d(Context context) {
        return a(iN_(context));
    }

    private static ConnectivityManager iO_(Context context) {
        if (c == null) {
            c = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        }
        return c;
    }

    public static NetworkInfo iN_(Context context) {
        ConnectivityManager connectivityManagerIO_ = iO_(context);
        if (connectivityManagerIO_ != null) {
            return connectivityManagerIO_.getActiveNetworkInfo();
        }
        return null;
    }

    public static int a(NetworkInfo networkInfo) {
        if (networkInfo != null && networkInfo.isConnected()) {
            int type = networkInfo.getType();
            if (1 == type || 13 == type) {
                return 1;
            }
            if (type == 0) {
                switch (networkInfo.getSubtype()) {
                }
                return 1;
            }
        }
        return 0;
    }
}
