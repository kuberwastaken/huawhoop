package com.huawei.pluginhealthzone.cloud;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public abstract class HttpDataCallback {
    public abstract void onFailure(int i, String str);

    public abstract void onSuccess(JSONObject jSONObject);
}
