package com.huawei.wearengine.repository.api;

import com.huawei.wearengine.scope.ScopeInfo;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface ScopeInfoRepository {
    boolean deleteScope(String str);

    List<ScopeInfo> getScopes(String str);

    boolean insertScope(ScopeInfo scopeInfo, String str);

    boolean updateScope(ScopeInfo scopeInfo, String str);
}
