package com.huawei.maps.offlinedata.service.persist.dao;

import com.huawei.maps.offlinedata.handler.dto.persist.MapOfflineDataItemEntity;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface a {
    MapOfflineDataItemEntity a(String str, String str2, String str3);

    List<MapOfflineDataItemEntity> a();

    void a(String str);

    void a(List<MapOfflineDataItemEntity> list);

    void b();
}
