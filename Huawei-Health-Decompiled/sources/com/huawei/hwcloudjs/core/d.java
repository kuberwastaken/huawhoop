package com.huawei.hwcloudjs.core;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6396a = "JsListenerCenter";
    private static d b = new d();
    private final List<Class<? extends c>> c = new ArrayList();

    public void a(String str) {
        String str2;
        com.huawei.hwcloudjs.f.d.c(f6396a, "onDestroy begin", true);
        synchronized (this.c) {
            Iterator<Class<? extends c>> it = this.c.iterator();
            while (it.hasNext()) {
                try {
                    it.next().newInstance().onDestroy(str);
                } catch (IllegalAccessException unused) {
                    str2 = "IllegalAccessException";
                    com.huawei.hwcloudjs.f.d.b(f6396a, str2, true);
                } catch (InstantiationException unused2) {
                    str2 = "InstantiationException";
                    com.huawei.hwcloudjs.f.d.b(f6396a, str2, true);
                }
            }
        }
    }

    public void a(Class<? extends c> cls) {
        synchronized (this.c) {
            this.c.add(cls);
        }
    }

    public void a(Context context, String str, String str2, String str3, List<String> list, JSONObject jSONObject) {
        String str4;
        c cVarNewInstance;
        com.huawei.hwcloudjs.f.d.c(f6396a, "onCompletedConfig begin", true);
        synchronized (this.c) {
            Iterator<Class<? extends c>> it = this.c.iterator();
            while (it.hasNext()) {
                try {
                    cVarNewInstance = it.next().newInstance();
                } catch (IllegalAccessException unused) {
                } catch (InstantiationException unused2) {
                }
                try {
                    if (list.contains(cVarNewInstance.getApi())) {
                        cVarNewInstance.onCompletedConfig(context, str, str2, str3, jSONObject);
                    }
                } catch (IllegalAccessException unused3) {
                    str4 = "IllegalAccessException";
                    com.huawei.hwcloudjs.f.d.b(f6396a, str4, true);
                } catch (InstantiationException unused4) {
                    str4 = "InstantiationException";
                    com.huawei.hwcloudjs.f.d.b(f6396a, str4, true);
                }
            }
        }
    }

    public static d a() {
        return b;
    }
}
