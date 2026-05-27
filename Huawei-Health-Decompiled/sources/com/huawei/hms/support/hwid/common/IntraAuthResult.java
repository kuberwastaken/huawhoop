package com.huawei.hms.support.hwid.common;

import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.feature.result.AccountPickerCommonConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public abstract class IntraAuthResult extends Result {
    public boolean isSuccess() {
        return getStatus().isSuccess();
    }

    protected void jsonToSuper(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        setStatus(new Status(jSONObjectOptJSONObject.optInt("statusCode"), jSONObjectOptJSONObject.optString(AccountPickerCommonConstant.KEY_STATUS_MESSAGE, null)));
    }
}
