package com.huawei.updatesdk.b.e;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
class d {
    public static String a(Context context, String str, String str2) {
        String string = "";
        try {
            JSONArray jSONArray = new JSONObject(a(context, str)).getJSONArray("services");
            JSONArray jSONArray2 = jSONArray.getJSONObject(0).getJSONArray("servings");
            for (int i = 0; i < jSONArray2.length(); i++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                if (TextUtils.equals(str2, jSONObject.getString("countryOrAreaGroup"))) {
                    string = jSONObject.getJSONObject("addresses").getString("ROOT");
                }
            }
        } catch (Exception unused) {
            com.huawei.updatesdk.a.a.a.a("JsonPareUrl", "Failed to obtain the default url.");
        }
        return string;
    }

    private static String a(Context context, String str) throws IOException {
        InputStream inputStreamOpen = context.getAssets().open(str);
        byte[] bArr = new byte[inputStreamOpen.available()];
        com.huawei.updatesdk.a.a.a.b("JsonPareUrl", "loadJSONFromAsset code: " + inputStreamOpen.read(bArr));
        inputStreamOpen.close();
        return new String(bArr, "UTF-8");
    }
}
