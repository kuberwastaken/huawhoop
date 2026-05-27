package com.huawei.health.baseapi.pluginlocation;

import defpackage.gbh;
import defpackage.gbm;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public interface EphemerisExtApi {
    gbh getEphRequest(List<String> list);

    Map<String, String> getEphResponse(gbm gbmVar);
}
