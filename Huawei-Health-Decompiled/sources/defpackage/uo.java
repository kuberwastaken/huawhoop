package defpackage;

import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class uo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f18405a;

    uo() {
    }

    private void c(String str) {
        this.f18405a = str;
    }

    String a() {
        return this.f18405a;
    }

    static uo d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        uo uoVar = new uo();
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("paymentResource");
        if (jSONObjectOptJSONObject != null) {
            uoVar.c(ua.e(jSONObjectOptJSONObject, CommonPickerConstant.RequestParams.KEY_REDIRECT_URL, ""));
        } else {
            uoVar.c(ua.e(jSONObject.optJSONObject("agreementSetup"), "approvalUrl", ""));
        }
        return uoVar;
    }
}
