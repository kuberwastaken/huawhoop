package com.huawei.health.socialshare.api;

import com.huawei.health.socialshare.model.EditShareCommonView;
import com.huawei.health.socialshare.model.socialsharebean.ShareDataInfo;
import defpackage.ght;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface WatermarkViewBase {
    void constructDownloadWatermarkViewList(List<ShareDataInfo> list);

    void constructLocalDefaultWatermarkViewList(List<ght> list);

    List<EditShareCommonView> getEditShareCommonViewList();

    void setDoMainColor(int i);

    void setTopWidgetColor(int i);

    void setWidgetColor(int i);
}
