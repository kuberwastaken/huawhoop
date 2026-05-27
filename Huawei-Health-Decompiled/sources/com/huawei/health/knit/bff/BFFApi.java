package com.huawei.health.knit.bff;

import com.huawei.health.knit.bff.impl.IResourceRequestCallback;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface BFFApi {
    void getPageResource(List<Integer> list, boolean z, IResourceRequestCallback iResourceRequestCallback);

    void setExtraRequestArgs(JSONObject jSONObject);
}
