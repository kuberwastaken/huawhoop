package com.huawei.health.group.api;

import com.huawei.health.group.constants.GroupActivityBo;
import defpackage.elx;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface GroupApi {
    void enableLocationSharing(boolean z, String str, String str2, long j, String str3);

    List<GroupActivityBo> getMyGrpActivityList(int i);

    boolean isSharing();

    void registerLocationSharingListener(elx elxVar);

    void setMiniBarStatus(boolean z, String str, String str2);

    void showStopSharingDialog();

    void unRegisterLocationSharingListener(elx elxVar);
}
