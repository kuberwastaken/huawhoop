package com.huawei.health.h5pro.vengine;

import com.huawei.health.h5pro.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class H5ProVersionMeta {
    public String b;
    public String c;
    public String e;

    public String getMinH5Version() {
        return this.c;
    }

    public String getMinAppVersion() {
        return this.e;
    }

    public String getLatestVersion() {
        return this.b;
    }

    public H5ProVersionMeta(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optString("latest");
            this.e = jSONObject.optString("adMinAppVersion");
            this.c = jSONObject.optString("minH5Version", "");
        } catch (JSONException e) {
            LogUtil.e("H5PRO_VersionMeta", "parse err: " + e.getMessage());
        }
    }
}
