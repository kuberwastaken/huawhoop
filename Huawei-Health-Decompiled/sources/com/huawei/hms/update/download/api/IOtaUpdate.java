package com.huawei.hms.update.download.api;

import android.content.Context;

/* JADX INFO: loaded from: classes10.dex */
public interface IOtaUpdate {
    void cancel();

    void downloadPackage(IUpdateCallback iUpdateCallback, UpdateInfo updateInfo);

    Context getContext();
}
