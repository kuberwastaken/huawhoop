package com.huawei.hwcloudjs.service.auth.bean;

import android.text.TextUtils;
import com.huawei.hwcloudjs.d.b.a.c;
import com.huawei.hwcloudjs.f.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class b extends c {
    private static final String c = "AuthResponseBean";
    private static final String d = "NSP_STATUS";
    private int e = -1;
    private List<String> f;
    private List<String> g;

    public List<String> f() {
        return this.g;
    }

    public int e() {
        return this.e;
    }

    public List<String> d() {
        return this.f;
    }

    public void c(int i) {
        this.e = i;
    }

    public void b(List<String> list) {
        this.g = list;
    }

    @Override // com.huawei.hwcloudjs.d.b.a.c
    public String[] a() {
        return new String[]{d};
    }

    public void a(List<String> list) {
        this.f = list;
    }

    @Override // com.huawei.hwcloudjs.d.b.a.c
    public void a(String str, Map<String, String> map) {
        JSONArray jSONArrayOptJSONArray;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String str2 = map.get(d);
            if (!TextUtils.isEmpty(str2) && !"0".equals(str2)) {
                try {
                    c(Integer.parseInt(str2));
                    return;
                } catch (NumberFormatException unused) {
                    c(-1);
                    return;
                }
            }
            c(0);
            JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("scopes");
            if (jSONArrayOptJSONArray2 != null) {
                try {
                    ArrayList arrayList = new ArrayList();
                    int length = jSONArrayOptJSONArray2.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray2.optJSONObject(i);
                        if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions")) != null) {
                            int length2 = jSONArrayOptJSONArray.length();
                            for (int i2 = 0; i2 < length2; i2++) {
                                arrayList.add(jSONArrayOptJSONArray.getString(i2));
                            }
                        }
                    }
                    a(arrayList);
                } catch (JSONException unused2) {
                    d.b(c, "jsonArray JSONException", true);
                    return;
                }
            }
            JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("appAttr");
            if (jSONObjectOptJSONObject2 != null) {
                String strOptString = jSONObjectOptJSONObject2.optString("securityUrl");
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                b(Arrays.asList(strOptString.split("\\,")));
            }
        } catch (JSONException unused3) {
            d.b(c, "resultObj JSONException", true);
        }
    }
}
