package com.huawei.watchface;

import android.text.TextUtils;
import com.huawei.watchface.utils.HwLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ah {
    private static final int SUCCESS_CODE = 0;
    public static final String SUCCESS_CODE_STRING = "0";
    private static final String TAG = "BaseResp";
    private ai result;
    public String retCode = "";

    public void parseResult(String str) {
        ai aiVar = new ai(-1);
        setResult(aiVar);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("result");
            if (jSONObjectOptJSONObject != null) {
                aiVar.a(jSONObjectOptJSONObject.optInt("resultCode", -1));
                aiVar.a(jSONObjectOptJSONObject.optString("resultInfo"));
            }
        } catch (JSONException unused) {
            HwLog.i(TAG, "parseResult error");
        }
    }

    public ai getResult() {
        return this.result;
    }

    public void setResult(ai aiVar) {
        this.result = aiVar;
    }

    public boolean isSuccess() {
        ai aiVar = this.result;
        return aiVar != null && aiVar.a() == 0;
    }
}
