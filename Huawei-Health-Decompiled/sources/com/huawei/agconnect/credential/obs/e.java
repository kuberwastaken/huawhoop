package com.huawei.agconnect.credential.obs;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, d> f1819a = new HashMap();

    static c a(Context context, f fVar) {
        String str;
        synchronized (e.class) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                str = "init must be called in the main thread";
            } else if (context == null) {
                str = "context cannot be null to init HiAnalyticsInstanceEx.";
            } else if (TextUtils.isEmpty(fVar.f1820a) || fVar.f1820a.length() > 256) {
                str = "serviceTag check failed";
            } else {
                if (!TextUtils.isEmpty(fVar.b) && fVar.b.length() <= 256) {
                    Map<String, d> map = f1819a;
                    d dVar = map.get(fVar.f1820a);
                    if (dVar == null) {
                        d dVar2 = new d(context, fVar);
                        map.put(fVar.f1820a, dVar2);
                        return dVar2;
                    }
                    if (fVar.c.equals(dVar.b.c)) {
                        return dVar;
                    }
                    dVar.a(context, fVar);
                    return dVar;
                }
                str = "httpheader check failed";
            }
            Log.e("HAInstanceManager", str);
            return null;
        }
    }
}
