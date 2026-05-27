package com.huawei.pluginsocialshare.activity;

import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import defpackage.ghy;

/* JADX INFO: loaded from: classes7.dex */
public interface SportDownloadInterface {
    void downloadedAllShareDataCallback(ghy ghyVar);

    void downloadedSingleCallback(ShareDataInfo shareDataInfo);
}
