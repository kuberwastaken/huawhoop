package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ForegroundBusResponseMgr {
    private static final ForegroundBusResponseMgr b = new ForegroundBusResponseMgr();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, BusResponseCallback> f4444a = new HashMap();

    public static ForegroundBusResponseMgr getInstance() {
        return b;
    }

    public BusResponseCallback get(String str) {
        BusResponseCallback busResponseCallback;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f4444a) {
            busResponseCallback = this.f4444a.get(str);
        }
        return busResponseCallback;
    }

    public void registerObserver(String str, BusResponseCallback busResponseCallback) {
        if (TextUtils.isEmpty(str) || busResponseCallback == null) {
            return;
        }
        synchronized (this.f4444a) {
            if (!this.f4444a.containsKey(str)) {
                this.f4444a.put(str, busResponseCallback);
            }
        }
    }

    public void unRegisterObserver(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f4444a) {
            this.f4444a.remove(str);
        }
    }
}
