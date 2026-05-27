package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class vws implements Serializable {
    private static final long serialVersionUID = -217188557650814492L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("displayOverview")
    private String f18818a;

    @SerializedName("displayDetail")
    private String b;

    @SerializedName("hwReturnCode")
    private String d;

    @SerializedName("codeMsg")
    private String e;

    @SerializedName("originalCode")
    private String g;

    @SerializedName("supportRetry")
    private boolean h;
    private String i;

    @SerializedName("suggestion")
    private String j;
    private String f = null;
    private int c = 0;

    public void e(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.b = str;
    }

    public void d(String str) {
        this.f18818a = str;
    }

    public void h(String str) {
        this.j = str;
    }

    public void b(String str) {
        this.g = str;
    }

    public void a(String str) {
        this.d = str;
    }

    public void c(boolean z) {
        this.h = z;
    }

    public void j(String str) {
        this.i = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public static vws c(JSONObject jSONObject) throws JSONException {
        vws vwsVar = new vws();
        if (jSONObject.has("codeMsg")) {
            vwsVar.e(jSONObject.getString("codeMsg"));
        }
        if (jSONObject.has("displayDetail")) {
            vwsVar.c(jSONObject.getString("displayDetail"));
        }
        if (jSONObject.has("displayOverview")) {
            vwsVar.d(jSONObject.getString("displayOverview"));
        }
        if (jSONObject.has("originalCode")) {
            vwsVar.b(jSONObject.getString("originalCode"));
        }
        if (jSONObject.has("suggestion")) {
            vwsVar.h(jSONObject.getString("suggestion"));
        }
        if (jSONObject.has("supportRetry")) {
            vwsVar.c(jSONObject.getBoolean("supportRetry"));
        }
        if (jSONObject.has("tempAccessSec")) {
            vwsVar.j(jSONObject.getString("tempAccessSec"));
        }
        if (jSONObject.has("deal")) {
            vwsVar.a(jSONObject.getInt("deal"));
        }
        if (jSONObject.has("hwReturnCode")) {
            vwsVar.a(jSONObject.getString("hwReturnCode"));
        }
        return vwsVar;
    }

    public String toString() {
        return "ErrorInfo{codeMsg='" + this.e + "', displayDetail='" + this.b + "', displayOverview='" + this.f18818a + "', suggestion='" + this.j + "', originalCode='" + this.g + "', hwReturnCode='" + this.d + "', supportRetry=" + this.h + ", tempAccessSec=" + this.i + '}';
    }
}
