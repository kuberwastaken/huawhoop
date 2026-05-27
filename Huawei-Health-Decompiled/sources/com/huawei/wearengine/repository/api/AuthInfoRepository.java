package com.huawei.wearengine.repository.api;

import com.huawei.wearengine.auth.AuthInfo;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public interface AuthInfoRepository {
    boolean deleteAuth(int i, String str, int i2);

    boolean deleteAuth(String str);

    void deleteAuthFromCache(String str);

    List<AuthInfo> getAuth(int i, String str, int i2);

    boolean insertAuth(AuthInfo authInfo);

    boolean updateAuth(AuthInfo authInfo);

    void updateCache(String str);
}
