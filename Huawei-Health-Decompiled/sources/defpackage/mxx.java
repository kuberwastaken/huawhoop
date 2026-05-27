package defpackage;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class mxx {
    private static final String b = "MultiSIMServiceInfo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    mxz f15924a;
    ArrayList<mya> c = new ArrayList<>();

    public void c(String str) {
        JSONObject jSONObject;
        try {
            if (str == null) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("PairedDeviceList");
            if (jSONArrayOptJSONArray != null) {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    mya myaVar = new mya();
                    myaVar.e(jSONArrayOptJSONArray.get(i).toString());
                    this.c.add(myaVar);
                }
            }
            mxz mxzVar = new mxz();
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("PrimaryDevice");
            if (jSONObjectOptJSONObject != null) {
                mxzVar.e(jSONObjectOptJSONObject.toString());
            }
            this.f15924a = mxzVar;
            if (mza.e.booleanValue()) {
                mza.e(b, "PrimaryDevice to json string = " + jSONObject.toString());
            }
        } catch (JSONException unused) {
            mza.e(b, "Parse response information occured JSONException");
        }
    }

    public ArrayList<mya> c() {
        return this.c;
    }

    public mxz d() {
        return this.f15924a;
    }
}
