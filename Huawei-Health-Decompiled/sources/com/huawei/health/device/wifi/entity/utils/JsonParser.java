package com.huawei.health.device.wifi.entity.utils;

import android.text.TextUtils;
import defpackage.dna;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class JsonParser {

    public enum JsonType {
        JSON_TYPE_OBJECT,
        JSON_TYPE_ARRAY,
        JSON_TYPE_ERROR
    }

    public static Map<String, Object> e(String str) {
        HashMap map = new HashMap(16);
        String strD = d(str);
        if (!TextUtils.isEmpty(strD) && c(strD) == JsonType.JSON_TYPE_OBJECT) {
            try {
                JSONObject jSONObject = new JSONObject(strD.trim());
                JSONArray jSONArrayNames = jSONObject.names();
                if (jSONArrayNames != null && jSONArrayNames.length() > 0) {
                    for (int i = 0; i < jSONArrayNames.length(); i++) {
                        map.put(jSONArrayNames.getString(i), d(jSONObject.get(jSONArrayNames.getString(i))));
                    }
                }
            } catch (JSONException e) {
                dna.d(true, "JsonParser", "Error Json Parse: ", e.getMessage());
            }
        }
        return map;
    }

    private static Object d(Object obj) {
        Object obj2 = new Object();
        if (obj != null) {
            if (obj instanceof JSONObject) {
                return e(obj.toString());
            }
            return obj instanceof JSONArray ? b(obj.toString()) : obj;
        }
        dna.d(false, "JsonParser", "fromJson json is null.");
        return obj2;
    }

    private static List<Object> b(String str) {
        String strD;
        ArrayList arrayList = new ArrayList(16);
        if (!TextUtils.isEmpty(str) && (strD = d(str)) != null && c(strD) == JsonType.JSON_TYPE_ARRAY) {
            try {
                JSONArray jSONArray = new JSONArray(strD.trim());
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(d(jSONArray.get(i)));
                }
            } catch (JSONException e) {
                dna.d(true, "JsonParser", "Error Json Parse: ", e.getMessage());
            }
        }
        return arrayList;
    }

    public static JsonType c(String str) {
        String strD = d(str);
        dna.b(true, "JsonParser", "getJsonType jsonStr: ", strD);
        if (TextUtils.isEmpty(strD)) {
            return JsonType.JSON_TYPE_ERROR;
        }
        try {
            new JSONObject(strD);
            return JsonType.JSON_TYPE_OBJECT;
        } catch (JSONException e) {
            dna.d(true, "JsonParser", "Not is JsonObject Type: ", e.getMessage());
            try {
                new JSONArray(strD);
                return JsonType.JSON_TYPE_ARRAY;
            } catch (JSONException e2) {
                dna.d(true, "JsonParser", "Not is JsonArray Type: ", e2.getMessage());
                return JsonType.JSON_TYPE_ERROR;
            }
        }
    }

    private static String d(String str) {
        if (str == null) {
            dna.b(false, "JsonParser", " json == null !!!");
            return null;
        }
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFKC);
        if (strNormalize.contains("{") && strNormalize.contains("[")) {
            if (strNormalize.indexOf("{") > strNormalize.indexOf("[")) {
                return strNormalize.substring(strNormalize.indexOf("["), strNormalize.lastIndexOf("]") + 1);
            }
            return strNormalize.substring(strNormalize.indexOf("{"), strNormalize.lastIndexOf("}") + 1);
        }
        if (!strNormalize.contains("{") && strNormalize.contains("[")) {
            return strNormalize.substring(strNormalize.indexOf("["), strNormalize.lastIndexOf("]") + 1);
        }
        if (strNormalize.contains("[") || !strNormalize.contains("{")) {
            return null;
        }
        return strNormalize.substring(strNormalize.indexOf("{"), strNormalize.lastIndexOf("}") + 1);
    }

    public static JSONObject b(Map<?, ?> map) {
        Object objB;
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    if (map.containsKey(entry.getKey()) && (objB = b(entry.getValue())) != null) {
                        jSONObject.put(entry.getKey().toString(), objB);
                    }
                }
            } catch (JSONException e) {
                dna.d(true, "JsonParser", "Error Map Package Into Json: ", e.getMessage());
            }
        } else {
            dna.d(true, "JsonParser", "toJsonObject jsonMap is null.");
        }
        return jSONObject;
    }

    private static JSONArray a(List<?> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                try {
                    Object objB = b(list.get(i));
                    if (objB != null) {
                        jSONArray.put(i, objB);
                    }
                } catch (JSONException e) {
                    dna.d(true, "JsonParser", "Error List Package Into Json: ", e.getMessage());
                }
            }
        } else {
            dna.d(true, "JsonParser", "toJsonArray jsonList is null.");
        }
        return jSONArray;
    }

    private static Object b(Object obj) {
        if (obj instanceof Map) {
            return b((Map<?, ?>) obj);
        }
        return obj instanceof List ? a((List) obj) : obj;
    }
}
