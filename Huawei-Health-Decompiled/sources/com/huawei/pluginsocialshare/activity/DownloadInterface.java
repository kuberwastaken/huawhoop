package com.huawei.pluginsocialshare.activity;

import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import defpackage.ghv;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface DownloadInterface {
    void notifyBackgroudChanged(ghv ghvVar);

    void notifyBackgroudFail();

    void notifyDownloadDataFail();

    void notifyShareDataChanged(ghv ghvVar);

    void refreshDataMark(List<ShareDataInfo> list);

    void refreshShareLayoutNoRecommend();

    void showDownloadError();

    void updateAllFragment(boolean z);
}
