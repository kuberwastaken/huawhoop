package com.unicom.online.account.kernel;

import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.network.embedded.c0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class am {
    public static List<d> b(Context context, String str) {
        try {
            String string = context.getSharedPreferences("cu_auth", 0).getString(str, null);
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                d dVar = new d();
                dVar.f11945a = jSONObject.optString("domain");
                dVar.b = jSONObject.optString(c0.h);
                dVar.c = jSONObject.optLong("expire");
                arrayList.add(dVar);
            }
            return arrayList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList();
        }
    }

    public static void a(Context context, String str, List<d> list) {
        if (list.size() == 0) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                d dVar = list.get(i);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("domain", dVar.f11945a);
                jSONObject.put(c0.h, dVar.b);
                jSONObject.put("expire", dVar.c);
                jSONArray.put(jSONObject);
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("cu_auth", 0).edit();
            editorEdit.putString(str, jSONArray.toString());
            editorEdit.apply();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String a(Context context, String str) {
        try {
            return context.getSharedPreferences("cu_auth", 0).getString(str, "");
        } catch (Exception e) {
            aj.a(e);
            return "";
        }
    }
}
