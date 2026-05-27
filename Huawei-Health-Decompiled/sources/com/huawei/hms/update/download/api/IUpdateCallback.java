package com.huawei.hms.update.download.api;

import java.io.File;

/* JADX INFO: loaded from: classes10.dex */
public interface IUpdateCallback {
    void onCheckUpdate(int i, UpdateInfo updateInfo);

    void onDownloadPackage(int i, int i2, int i3, File file);
}
