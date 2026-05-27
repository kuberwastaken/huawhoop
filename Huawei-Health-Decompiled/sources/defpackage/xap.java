package defpackage;

import android.text.TextUtils;
import io.jsonwebtoken.JwsHeader;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class xap {
    public byte[] b;
    public c c;
    public String d;
    public e e;

    public static class c {
        public int b;
        public String c;
    }

    public static class e {
        public String[] b;
        public String e;
    }

    public void b(String[] strArr) throws wzb {
        try {
            JSONObject jSONObject = new JSONObject(new String(wzm.e(strArr[0], 8), StandardCharsets.UTF_8));
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(JwsHeader.X509_CERT_CHAIN);
            String[] strArr2 = {jSONArrayOptJSONArray.optString(0), jSONArrayOptJSONArray.optString(1)};
            e eVar = new e();
            this.e = eVar;
            eVar.e = jSONObject.getString("alg");
            this.e.b = strArr2;
        } catch (RuntimeException | JSONException e2) {
            StringBuilder sbB = wzk.b("Fail to convert jws string to header, ");
            sbB.append(e2.getMessage());
            throw new wzb(1012L, sbB.toString());
        }
    }

    public void d(String[] strArr) throws wzb {
        try {
            JSONObject jSONObject = new JSONObject(new String(wzm.e(strArr[1], 8), StandardCharsets.UTF_8));
            c cVar = new c();
            this.c = cVar;
            cVar.c = jSONObject.getString("component");
            this.c.b = jSONObject.getInt("version");
        } catch (RuntimeException | JSONException e2) {
            StringBuilder sbB = wzk.b("Fail to convert jws string to payload, ");
            sbB.append(e2.getMessage());
            throw new wzb(1012L, sbB.toString());
        }
    }

    public void d(String str, String[] strArr) throws wzb {
        try {
            this.b = wzm.e(strArr[2], 8);
            this.d = str.substring(0, str.lastIndexOf("."));
        } catch (wzb e2) {
            StringBuilder sbB = wzk.b("Fail to convert jws string to Content, ");
            sbB.append(e2.getMessage());
            throw new wzb(1012L, sbB.toString());
        }
    }

    public final void e(String str) throws wzb {
        if (TextUtils.isEmpty(str)) {
            throw new wzb(1012L, "ComponentJws is empty.");
        }
    }

    public xap(String str) throws wzb {
        e(str);
        String[] strArrSplit = str.split("\\.");
        b(strArrSplit);
        d(strArrSplit);
        d(str, strArrSplit);
    }
}
