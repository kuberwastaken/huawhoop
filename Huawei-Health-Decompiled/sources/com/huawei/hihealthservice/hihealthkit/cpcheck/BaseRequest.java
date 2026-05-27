package com.huawei.hihealthservice.hihealthkit.cpcheck;

import defpackage.kbd;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseRequest<T> {
    protected Map<String, Object> mParams = new HashMap(10);
    protected String mUrl;

    public kbd.b<T> getRequestParamsBuilder() {
        return new kbd.b(this.mUrl).e("GET").e(this.mParams);
    }
}
