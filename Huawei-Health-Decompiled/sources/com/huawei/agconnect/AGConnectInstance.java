package com.huawei.agconnect;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.core.impl.AGConnectInstanceImpl;

/* JADX INFO: loaded from: classes.dex */
public abstract class AGConnectInstance {
    public abstract Context getContext();

    public abstract String getIdentifier();

    public abstract AGConnectOptions getOptions();

    public abstract <T> T getService(Class<? super T> cls);

    public static void initialize(Context context, AGConnectOptionsBuilder aGConnectOptionsBuilder) {
        Log.i("AGConnectInstance", "AGConnectInstance#initialize with options");
        AGConnectInstanceImpl.initialize(context, aGConnectOptionsBuilder);
    }

    public static void initialize(Context context) {
        Log.i("AGConnectInstance", "AGConnectInstance#initialize");
        AGConnectInstanceImpl.initialize(context);
    }

    public static AGConnectInstance getInstance(String str) {
        return AGConnectInstanceImpl.getInstance(str);
    }

    public static AGConnectInstance getInstance() {
        return AGConnectInstanceImpl.getInstance();
    }

    public static AGConnectInstance buildInstance(AGConnectOptions aGConnectOptions) {
        return AGConnectInstanceImpl.buildInstance(aGConnectOptions);
    }
}
