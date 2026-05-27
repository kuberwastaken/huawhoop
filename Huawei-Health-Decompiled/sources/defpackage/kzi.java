package defpackage;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class kzi {
    private String d;
    private int i;
    private String j = "";
    private int f = 0;
    private int h = 0;
    private int g = 0;
    private String l = "";
    private String c = "";
    private String e = "";
    private int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15021a = "";

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("techlist", this.j);
            jSONObject.put("ntfType", this.f);
            jSONObject.put("supportMifareClassic", this.h);
            jSONObject.put("supprotIsodep", this.g);
            jSONObject.put("uid", this.l);
            jSONObject.put("atqa", this.c);
            jSONObject.put("sak", this.i);
            jSONObject.put("isodepHistoryBytes", this.e);
            jSONObject.put("errCode", this.b);
            jSONObject.put("ats", this.f15021a);
            String str = this.d;
            if (str != null) {
                jSONObject.put("newSak", str);
            }
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            return null;
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "NfcTagInfo{nfcType='" + this.f + "', supportMifareClassic=" + this.h + ", supprotIsodep=" + this.g + "', uid=" + c() + ", atqa=" + this.c + ", sak=" + this.i + ", isodepHistoryBytes=" + this.e + ", errCode=" + this.b + ", ats=" + this.f15021a + '}';
    }

    public void d(String str) {
        this.j = str;
    }

    public void d(int i) {
        this.f = i;
    }

    public void b(int i) {
        this.h = i;
    }

    public void c(int i) {
        this.g = i;
    }

    public void f(String str) {
        this.l = str;
    }

    public void c(String str) {
        this.c = str;
    }

    public void e(int i) {
        this.i = i;
    }

    public void e(String str) {
        this.d = str;
    }

    public void a(String str) {
        this.e = str;
    }

    public void a(int i) {
        this.b = i;
    }

    public void b(String str) {
        this.f15021a = str;
    }

    private String c() {
        String str = this.l;
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(str.length());
        for (int i = 0; i < this.l.length(); i++) {
            stringBuffer.append("*");
        }
        return stringBuffer.toString();
    }
}
