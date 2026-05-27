package com.huawei.health.sportservice.download.listener;

import android.content.Context;

/* JADX INFO: loaded from: classes9.dex */
public interface AudioResDownloadInterface {
    void downAudioResource(Context context, String str, String str2, String str3, ResDownloadCallback resDownloadCallback);

    default void startDownload() {
    }
}
