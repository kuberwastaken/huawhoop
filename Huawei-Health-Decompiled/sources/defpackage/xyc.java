package defpackage;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.openid.appauth.JsonUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class xyc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final JsonUtil.a f19205a;
    static final JsonUtil.c aa;
    static final JsonUtil.a ab;
    static final JsonUtil.a ac;
    static final JsonUtil.a ad;
    static final JsonUtil.a ae;
    static final JsonUtil.a af;
    static final JsonUtil.a ag;
    static final JsonUtil.c ah;
    static final JsonUtil.a ai;
    static final JsonUtil.a ak;
    private static final List<String> al;
    static final JsonUtil.c b;
    static final JsonUtil.e c;
    static final JsonUtil.a d;
    static final JsonUtil.a e;
    static final JsonUtil.a f;
    static final JsonUtil.a g;
    static final JsonUtil.a h;
    static final JsonUtil.a i;
    static final JsonUtil.c j;
    static final JsonUtil.b k;
    static final JsonUtil.c l;
    static final JsonUtil.a m;
    static final JsonUtil.c n;
    static final JsonUtil.a o;
    static final JsonUtil.a p;
    static final JsonUtil.c q;
    static final JsonUtil.c r;
    static final JsonUtil.a s;
    static final JsonUtil.a t;
    static final JsonUtil.e u;
    static final JsonUtil.e v;
    static final JsonUtil.e w;
    static final JsonUtil.a x;
    static final JsonUtil.a y;
    static final JsonUtil.c z;
    public final JSONObject am;

    static {
        JsonUtil.b bVarA = a("issuer");
        k = bVarA;
        JsonUtil.c cVarD = d("authorization_endpoint");
        b = cVarD;
        aa = d("token_endpoint");
        j = d("end_session_endpoint");
        ah = d("userinfo_endpoint");
        JsonUtil.c cVarD2 = d("jwks_uri");
        n = cVarD2;
        q = d("registration_endpoint");
        ac = e("scopes_supported");
        JsonUtil.a aVarE = e("response_types_supported");
        y = aVarE;
        x = e("response_modes_supported");
        g = d("grant_types_supported", Arrays.asList("authorization_code", "implicit"));
        d = e("acr_values_supported");
        JsonUtil.a aVarE2 = e("subject_types_supported");
        ab = aVarE2;
        JsonUtil.a aVarE3 = e("id_token_signing_alg_values_supported");
        m = aVarE3;
        h = e("id_token_encryption_enc_values_supported");
        o = e("id_token_encryption_enc_values_supported");
        ak = e("userinfo_signing_alg_values_supported");
        af = e("userinfo_encryption_alg_values_supported");
        ai = e("userinfo_encryption_enc_values_supported");
        s = e("request_object_signing_alg_values_supported");
        p = e("request_object_encryption_alg_values_supported");
        t = e("request_object_encryption_enc_values_supported");
        ad = d("token_endpoint_auth_methods_supported", Collections.singletonList("client_secret_basic"));
        ae = e("token_endpoint_auth_signing_alg_values_supported");
        i = e("display_values_supported");
        f = d("claim_types_supported", Collections.singletonList("normal"));
        e = e("claims_supported");
        z = d("service_documentation");
        f19205a = e("claims_locales_supported");
        ag = e("ui_locales_supported");
        c = a("claims_parameter_supported", false);
        u = a("request_parameter_supported", false);
        w = a("request_uri_parameter_supported", true);
        v = a("require_request_uri_registration", false);
        l = d("op_policy_uri");
        r = d("op_tos_uri");
        al = Arrays.asList(bVarA.key, cVarD.key, cVarD2.key, aVarE.key, aVarE2.key, aVarE3.key);
    }

    public xyc(JSONObject jSONObject) throws JSONException, b {
        this.am = (JSONObject) xym.d(jSONObject);
        for (String str : al) {
            if (!this.am.has(str) || this.am.get(str) == null) {
                throw new b(str);
            }
        }
    }

    public static class b extends Exception {
        private String e;

        public b(String str) {
            super("Missing mandatory configuration field: " + str);
            this.e = str;
        }

        public String e() {
            return this.e;
        }
    }

    private <T> T e(JsonUtil.Field<T> field) {
        return (T) JsonUtil.b(this.am, field);
    }

    public String a() {
        return (String) e(k);
    }

    public Uri fFl_() {
        return (Uri) e(b);
    }

    public Uri fFo_() {
        return (Uri) e(aa);
    }

    public Uri fFm_() {
        return (Uri) e(j);
    }

    public Uri fFn_() {
        return (Uri) e(q);
    }

    private static JsonUtil.b a(String str) {
        return new JsonUtil.b(str);
    }

    private static JsonUtil.c d(String str) {
        return new JsonUtil.c(str);
    }

    private static JsonUtil.a e(String str) {
        return new JsonUtil.a(str);
    }

    private static JsonUtil.a d(String str, List<String> list) {
        return new JsonUtil.a(str, list);
    }

    private static JsonUtil.e a(String str, boolean z2) {
        return new JsonUtil.e(str, z2);
    }
}
