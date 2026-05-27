package com.huawei.pluginsocialshare.shareconfig.handler;

import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import defpackage.oiv;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public interface ShareDataHandlerInterface {
    void deleteData(oiv oivVar, ShareDataInfo shareDataInfo);

    ShareDataInfo getShareDataById(int i);

    List<ShareDataInfo> getShareDataByIdList(List<Integer> list);

    void updateData(oiv oivVar, ShareDataInfo shareDataInfo);

    void writeJson();
}
