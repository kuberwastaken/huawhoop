package com.huawei.hms.scankit.p;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.mlsdk.common.AgConnectInfo;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public abstract class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6112a = "y3";
    private static volatile Bundle b = null;
    public static String c = "";
    public static HashSet d = new HashSet();

    public static String b(Context context) {
        if (c.length() == 0) {
            c = context.getPackageName();
        }
        return c;
    }

    public static boolean a(String str, HashSet hashSet) {
        if (str.length() == 0) {
            return true;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (str.contains((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static Bundle a(Context context) {
        if (context == null) {
            return new Bundle();
        }
        if (b == null) {
            Bundle bundle = new Bundle();
            try {
                String string = AGConnectServicesConfig.fromContext(context).getString(AgConnectInfo.AgConnectKey.APPLICATION_ID);
                if (string == null) {
                    string = context.getPackageName();
                }
                bundle.putString("appid", string);
            } catch (RuntimeException unused) {
                Log.e(f6112a, "getAppInfo: RuntimeException");
            } catch (Exception unused2) {
                Log.e(f6112a, "getAppInfo: Exception");
            }
            b = bundle;
        }
        return b;
    }

    public static HashSet a() {
        if (d.size() == 0) {
            d.add("com.huawei.scanner");
            d.add("com.huawei.hitouch");
        }
        return d;
    }
}
