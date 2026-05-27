package com.huawei.wearengine.scope.cache;

import com.huawei.wearengine.scope.ScopeInfoResponse;

/* JADX INFO: loaded from: classes9.dex */
public interface ScopeCache {
    void deleteScope(String str);

    ScopeInfoResponse getScope(String str);

    void saveScope(String str, ScopeInfoResponse scopeInfoResponse);

    void updateScope(String str, ScopeInfoResponse scopeInfoResponse);
}
