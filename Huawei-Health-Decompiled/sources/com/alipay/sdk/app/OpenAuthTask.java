package com.alipay.sdk.app;

import android.os.Bundle;
import defpackage.ov;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes9.dex */
public final class OpenAuthTask {
    public static final Map<String, Callback> c = new ConcurrentHashMap();
    public static long d = -1;

    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");

        private String appId;

        BizType(String str) {
            this.appId = str;
        }
    }

    public interface Callback {
        void onResult(int i, String str, Bundle bundle);
    }

    public static void bb_(String str, int i, String str2, Bundle bundle) {
        Callback callbackRemove = c.remove(str);
        if (callbackRemove != null) {
            try {
                callbackRemove.onResult(i, str2, bundle);
            } catch (Throwable th) {
                ov.b(th);
            }
        }
    }
}
