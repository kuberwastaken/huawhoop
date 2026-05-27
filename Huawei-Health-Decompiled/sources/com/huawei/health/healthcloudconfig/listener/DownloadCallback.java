package com.huawei.health.healthcloudconfig.listener;

/* JADX INFO: loaded from: classes.dex */
public interface DownloadCallback<T> {
    void onFail(int i, Throwable th);

    void onFinish(T t);

    void onProgress(long j, long j2, boolean z, String str);
}
