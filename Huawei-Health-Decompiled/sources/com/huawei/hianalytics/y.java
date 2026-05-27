package com.huawei.hianalytics;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f111a;
    public String b;
    public String c;
    public String d;

    public y(String str) {
        JSONObject jSONObject = new JSONObject(str);
        this.f111a = jSONObject.optString("_id", "");
        this.b = jSONObject.optString("item_id", "");
        this.c = jSONObject.optString("metric_tag", "");
        this.f4105a = jSONObject.optLong("event_time", 0L);
        this.d = jSONObject.optString("content_code", "");
    }
}
