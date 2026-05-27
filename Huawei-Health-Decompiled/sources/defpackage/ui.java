package defpackage;

import com.braintreepayments.api.PaymentMethod;
import com.huawei.hms.support.api.entity.core.CommonCode;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
class ui extends PaymentMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f18313a = new JSONObject();
    private String b;
    private String c;
    private String d;
    private String e;

    ui() {
    }

    @Override // com.braintreepayments.api.PaymentMethod
    public JSONObject buildJSON() throws JSONException {
        JSONObject jSONObjectBuildJSON = super.buildJSON();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("correlationId", this.c);
        jSONObject.put(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, this.e);
        if ("single-payment".equalsIgnoreCase(this.d)) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(PaymentMethod.VALIDATE_KEY, false);
            jSONObject.put(PaymentMethod.OPTIONS_KEY, jSONObject2);
        }
        Iterator<String> itKeys = this.f18313a.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject.put(next, this.f18313a.get(next));
        }
        Object obj = this.b;
        if (obj != null) {
            jSONObjectBuildJSON.put("merchant_account_id", obj);
        }
        jSONObjectBuildJSON.put("paypalAccount", jSONObject);
        return jSONObjectBuildJSON;
    }

    void a(String str) {
        this.c = str;
    }

    void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f18313a = jSONObject;
        }
    }

    void b(String str) {
        this.e = str;
    }

    void d(String str) {
        this.b = str;
    }

    void e(String str) {
        this.d = str;
    }

    @Override // com.braintreepayments.api.PaymentMethod
    public String getApiPath() {
        return "paypal_accounts";
    }
}
