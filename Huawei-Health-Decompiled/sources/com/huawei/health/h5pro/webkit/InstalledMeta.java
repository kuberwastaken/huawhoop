package com.huawei.health.h5pro.webkit;

import com.huawei.health.h5pro.utils.EnvironmentHelper;
import com.huawei.health.h5pro.utils.LogUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class InstalledMeta {
    public long b;
    public EnvironmentHelper.BuildType e;

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installTime", this.b);
            jSONObject.put("buildType", this.e);
        } catch (JSONException e) {
            LogUtil.e("H5PRO_InstalledMeta", "toJSON err: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public long getInstallTime() {
        return this.b;
    }

    public EnvironmentHelper.BuildType getBuildType() {
        return this.e;
    }

    public InstalledMeta(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = jSONObject.optLong("installTime");
            String strOptString = jSONObject.optString("buildType");
            for (EnvironmentHelper.BuildType buildType : EnvironmentHelper.BuildType.values()) {
                if (buildType.name().equals(strOptString)) {
                    this.e = buildType;
                }
            }
        } catch (JSONException e) {
            LogUtil.e("H5PRO_InstalledMeta", "parse err: " + e.getMessage());
        }
    }

    public InstalledMeta(long j, EnvironmentHelper.BuildType buildType) {
        this.b = j;
        this.e = buildType;
    }
}
