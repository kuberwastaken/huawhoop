package com.huawei.maps.offlinedata.health.init;

import com.huawei.maps.offlinedata.handler.dto.persist.MapOfflineDataItemEntity;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface OnCheckUpdatesListListener {
    void onOfflineMapsInfoResult(List<MapOfflineDataItemEntity> list);
}
