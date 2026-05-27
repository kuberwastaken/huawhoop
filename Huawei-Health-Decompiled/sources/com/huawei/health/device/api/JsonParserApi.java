package com.huawei.health.device.api;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface JsonParserApi {
    Map<String, Object> fromJsonObject(String str);

    JSONObject toJsonObject(Map<?, ?> map);
}
