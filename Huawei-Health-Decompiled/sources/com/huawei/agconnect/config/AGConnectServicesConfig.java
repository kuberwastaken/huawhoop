package com.huawei.agconnect.config;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.config.impl.AGConnectServicesConfigImpl;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public abstract class AGConnectServicesConfig implements AGConnectOptions {
    private static final Map<String, AGConnectServicesConfig> INSTANCES = new HashMap();
    private static final Object INSTANCES_LOCK = new Object();
    private static final String TAG = "AGConnectServicesConfig";

    public abstract void overlayWith(LazyInputStream lazyInputStream);

    public abstract void overlayWith(InputStream inputStream);

    public abstract void setParam(String str, String str2);

    public abstract void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy);

    public static AGConnectServicesConfig fromContext(Context context, String str) {
        AGConnectServicesConfig aGConnectServicesConfigImpl;
        synchronized (INSTANCES_LOCK) {
            Map<String, AGConnectServicesConfig> map = INSTANCES;
            aGConnectServicesConfigImpl = map.get(str);
            if (aGConnectServicesConfigImpl == null) {
                aGConnectServicesConfigImpl = new AGConnectServicesConfigImpl(context, str);
                map.put(str, aGConnectServicesConfigImpl);
                Log.w(TAG, "config is null, create new config");
            }
        }
        return aGConnectServicesConfigImpl;
    }

    public static AGConnectServicesConfig fromContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return fromContext(context, context.getPackageName());
    }
}
