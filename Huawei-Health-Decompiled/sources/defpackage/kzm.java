package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class kzm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15023a;
    private String d;
    private String c = "";
    private String i = "";
    private int g = 0;
    private int f = 0;
    private int b = 0;
    private int e = 0;

    public void d(String str) {
        this.c = str;
    }

    public void a(String str) {
        this.i = e(str);
    }

    private String e(String str) {
        return (str == null || !str.contains("t_vfc_xian")) ? str : str.concat("|t_vfc_changan");
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.f = i;
    }

    public void d(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.b = i;
    }

    public void c(String str) {
        this.f15023a = str;
    }

    public void b(String str) {
        this.d = str;
    }

    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("supportBusiness", this.c);
            jSONObject.put("supportIssuers", this.i);
            jSONObject.put("supportDefautcard", this.g);
            jSONObject.put("supportDecouple", this.f);
            jSONObject.put("pictureWidth", this.b);
            jSONObject.put("pictureHeight", this.e);
            String str = this.f15023a;
            if (str != null) {
                jSONObject.put("supportBlankCardSak", str);
            }
            String str2 = this.d;
            if (str2 != null) {
                jSONObject.put("payVersion", str2);
            }
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }
}
