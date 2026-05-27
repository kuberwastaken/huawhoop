package com.huawei.common.scope;

import com.huawei.hms.framework.network.restclient.Submit;
import com.huawei.hms.framework.network.restclient.annotate.Url;
import com.huawei.hms.network.restclient.anno.POST;

/* JADX INFO: loaded from: classes9.dex */
public interface LoginApi {
    @POST
    Submit<GetAccessScopeRsp> getScopes(@Url String str);
}
