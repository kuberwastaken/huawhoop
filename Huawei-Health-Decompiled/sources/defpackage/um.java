package defpackage;

import android.text.TextUtils;
import com.huawei.hms.network.embedded.n0;
import com.huawei.openalliance.ad.constant.UrlConstant;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004BS\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/braintreepayments/api/PayPalConfiguration;", "", "jsonObject", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "directBaseUrl", "", "displayName", "clientId", UrlConstant.PRIVACY_URL, "userAgreementUrl", "environment", "isTouchDisabled", "", "currencyIsoCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getClientId", "()Ljava/lang/String;", "getCurrencyIsoCode", "getDirectBaseUrl", "getDisplayName", "getEnvironment", "()Z", "getPrivacyUrl", "getUserAgreementUrl", "Companion", "BraintreeCore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class um {
    public static final e d = new e(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f18377a;
    private final String b;
    private final String c;
    private final String e;
    private final boolean f;
    private final String g;
    private final String h;
    private final String i;

    public um(String str, String str2, String str3, String str4, String str5, String str6, boolean z, String str7) {
        this.e = str;
        this.c = str2;
        this.b = str3;
        this.h = str4;
        this.i = str5;
        this.g = str6;
        this.f = z;
        this.f18377a = str7;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getE() {
        return this.e;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final String getC() {
        return this.c;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getB() {
        return this.b;
    }

    /* JADX INFO: renamed from: i, reason: from getter */
    public final String getH() {
        return this.h;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final String getI() {
        return this.i;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getG() {
        return this.g;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final boolean getF() {
        return this.f;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getF18377a() {
        return this.f18377a;
    }

    public um(JSONObject jSONObject) {
        this(d.b(ua.e(jSONObject, "directBaseUrl", null)), ua.e(jSONObject, "displayName", null), ua.e(jSONObject, "clientId", null), ua.e(jSONObject, UrlConstant.PRIVACY_URL, null), ua.e(jSONObject, "userAgreementUrl", null), ua.e(jSONObject, "environment", null), jSONObject != null ? jSONObject.optBoolean("touchDisabled", true) : true, ua.e(jSONObject, "currencyIsoCode", null));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/braintreepayments/api/PayPalConfiguration$Companion;", "", "()V", "CLIENT_ID_KEY", "", "CURRENCY_ISO_CODE_KEY", "DIRECT_BASE_URL_KEY", "DISPLAY_NAME_KEY", "ENVIRONMENT_KEY", "PRIVACY_URL_KEY", "TOUCH_DISABLED_KEY", "USER_AGREEMENT_URL_KEY", "parseBaseUrl", "url", "BraintreeCore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e {
        private e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return str + n0.e;
        }

        public /* synthetic */ e(xka xkaVar) {
            this();
        }
    }
}
