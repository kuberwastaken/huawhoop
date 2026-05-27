package com.huawei.health.sportservice.download.common;

import android.view.View;
import com.huawei.health.sportservice.download.listener.ResDownloadCallback;

/* JADX INFO: loaded from: classes9.dex */
public abstract class BaseDownloader {
    public abstract View.OnClickListener cancelListener();

    public abstract View.OnClickListener confirmListener();

    public abstract int getMaxNumberOfDownload();

    public abstract void onCancelDownload();

    public abstract void onStartDownload();

    public abstract void setDownloadListener(ResDownloadCallback resDownloadCallback);

    public abstract void setProgressRatio(String str, float f);

    public abstract void startQueryState();
}
