package com.huawei.updatesdk.service.otaupdate;

import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<CheckUpdateCallBack> f11378a;

    public void b(Intent intent) {
        String str;
        WeakReference<CheckUpdateCallBack> weakReference = this.f11378a;
        if (weakReference != null) {
            CheckUpdateCallBack checkUpdateCallBack = weakReference.get();
            if (checkUpdateCallBack != null) {
                checkUpdateCallBack.onUpdateInfo(intent);
                return;
            }
            str = "setUpdateCallBackMsg callBack is null";
        } else {
            str = "setUpdateCallBackMsg updateCallBack is null";
        }
        com.huawei.updatesdk.a.a.a.c("CallbackManager", str);
    }

    public void a(CheckUpdateCallBack checkUpdateCallBack) {
        this.f11378a = new WeakReference<>(checkUpdateCallBack);
    }

    public void a(Intent intent) {
        CheckUpdateCallBack checkUpdateCallBack;
        WeakReference<CheckUpdateCallBack> weakReference = this.f11378a;
        if (weakReference == null || (checkUpdateCallBack = weakReference.get()) == null) {
            return;
        }
        checkUpdateCallBack.onMarketInstallInfo(intent);
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f11379a = new d();
    }

    public void a(int i) {
        String str;
        WeakReference<CheckUpdateCallBack> weakReference = this.f11378a;
        if (weakReference != null) {
            CheckUpdateCallBack checkUpdateCallBack = weakReference.get();
            if (checkUpdateCallBack != null) {
                checkUpdateCallBack.onMarketStoreError(i);
                return;
            }
            str = "setGetMarketInfoCallBack callBack is null";
        } else {
            str = "setGetMarketInfoCallBack updateCallBack is null";
        }
        com.huawei.updatesdk.a.a.a.c("CallbackManager", str);
    }

    public static d a() {
        return a.f11379a;
    }
}
