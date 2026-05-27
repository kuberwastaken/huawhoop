package net.openid.appauth;

import android.net.Uri;
import defpackage.xym;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class JsonUtil {
    public static void a(JSONObject jSONObject, String str, int i) {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        xym.c(Integer.valueOf(i), "value must not be null");
        try {
            jSONObject.put(str, i);
        } catch (JSONException unused) {
            throw new IllegalStateException("JSONException thrown in violation of contract, ex");
        }
    }

    public static void d(JSONObject jSONObject, String str, String str2) {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        xym.c(str2, (Object) "value must not be null");
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e2) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e2);
        }
    }

    public static void b(JSONObject jSONObject, String str, JSONArray jSONArray) {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        xym.c(jSONArray, "value must not be null");
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException e2) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e2);
        }
    }

    public static void a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        xym.c(jSONObject2, "value must not be null");
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e2) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e2);
        }
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (str2 == null) {
            return;
        }
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e2) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e2);
        }
    }

    public static void fFs_(JSONObject jSONObject, String str, Uri uri) {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (uri == null) {
            return;
        }
        try {
            jSONObject.put(str, uri.toString());
        } catch (JSONException e2) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e2);
        }
    }

    public static void e(JSONObject jSONObject, String str, Long l) {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (l == null) {
            return;
        }
        try {
            jSONObject.put(str, l);
        } catch (JSONException e2) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e2);
        }
    }

    public static void b(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (jSONObject2 == null) {
            return;
        }
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e2) {
            throw new IllegalStateException("JSONException thrown in violation of contract", e2);
        }
    }

    public static String d(JSONObject jSONObject, String str) throws JSONException {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            throw new JSONException("field \"" + str + "\" not found in json object");
        }
        String string = jSONObject.getString(str);
        if (string != null) {
            return string;
        }
        throw new JSONException("field \"" + str + "\" is mapped to a null value");
    }

    public static String e(JSONObject jSONObject, String str) throws JSONException {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        String string = jSONObject.getString(str);
        if (string != null) {
            return string;
        }
        throw new JSONException("field \"" + str + "\" is mapped to a null value");
    }

    public static List<String> h(JSONObject jSONObject, String str) throws JSONException {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        JSONArray jSONArray = jSONObject.getJSONArray(str);
        if (jSONArray == null) {
            throw new JSONException("field \"" + str + "\" is mapped to a null value");
        }
        return d(jSONArray);
    }

    public static Uri fFq_(JSONObject jSONObject, String str) throws JSONException {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        String string = jSONObject.getString(str);
        if (string == null) {
            throw new JSONException("field \"" + str + "\" is mapped to a null value");
        }
        return Uri.parse(string);
    }

    public static Uri fFr_(JSONObject jSONObject, String str) throws JSONException {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        String string = jSONObject.getString(str);
        if (string == null) {
            throw new JSONException("field \"" + str + "\" is mapped to a null value");
        }
        return Uri.parse(string);
    }

    public static Long b(JSONObject jSONObject, String str) throws JSONException {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        try {
            return Long.valueOf(jSONObject.getLong(str));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<String> a(JSONObject jSONObject, String str) throws JSONException {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            throw new JSONException("field \"" + str + "\" not found in json object");
        }
        return d(jSONObject.getJSONArray(str));
    }

    public static List<Uri> f(JSONObject jSONObject, String str) throws JSONException {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            throw new JSONException("field \"" + str + "\" not found in json object");
        }
        return b(jSONObject.getJSONArray(str));
    }

    public static Map<String, String> j(JSONObject jSONObject, String str) throws JSONException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            return linkedHashMap;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            linkedHashMap.put(next, (String) xym.c(jSONObject2.getString(next), (Object) "additional parameter values must not be null"));
        }
        return linkedHashMap;
    }

    public static JSONObject c(JSONObject jSONObject, String str) throws JSONException {
        xym.c(jSONObject, "json must not be null");
        xym.c(str, (Object) "field must not be null");
        if (!jSONObject.has(str)) {
            return null;
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject != null) {
            return jSONObjectOptJSONObject;
        }
        throw new JSONException("field \"" + str + "\" is mapped to a null value");
    }

    public static List<String> d(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(xym.d(jSONArray.get(i)).toString());
            }
        }
        return arrayList;
    }

    public static Map<String, Object> e(JSONObject jSONObject) throws JSONException {
        xym.c(jSONObject, "json must not be null");
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objE = jSONObject.get(next);
            if (objE instanceof JSONArray) {
                objE = a((JSONArray) objE);
            } else if (objE instanceof JSONObject) {
                objE = e((JSONObject) objE);
            }
            map.put(next, objE);
        }
        return map;
    }

    public static List<Object> a(JSONArray jSONArray) throws JSONException {
        xym.c(jSONArray, "jsonArray must not be null");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object objE = jSONArray.get(i);
            if (objE instanceof JSONArray) {
                objE = a((JSONArray) objE);
            } else if (objE instanceof JSONObject) {
                objE = e((JSONObject) objE);
            }
            arrayList.add(objE);
        }
        return arrayList;
    }

    public static List<Uri> b(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(Uri.parse(xym.d(jSONArray.get(i)).toString()));
            }
        }
        return arrayList;
    }

    public static JSONArray b(Iterable<?> iterable) {
        xym.c(iterable, "objects cannot be null");
        JSONArray jSONArray = new JSONArray();
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().toString());
        }
        return jSONArray;
    }

    public static JSONObject d(Map<String, String> map) {
        xym.d(map);
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            xym.c(entry.getKey(), (Object) "map entries must not have null keys");
            xym.c(entry.getValue(), (Object) "map entries must not have null values");
            d(jSONObject, entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }

    public static <T> T b(JSONObject jSONObject, Field<T> field) {
        try {
            if (!jSONObject.has(field.key)) {
                return field.defaultValue;
            }
            return field.convert(jSONObject.getString(field.key));
        } catch (JSONException e2) {
            throw new IllegalStateException("unexpected JSONException", e2);
        }
    }

    public static abstract class Field<T> {
        public final T defaultValue;
        public final String key;

        abstract T convert(String str);

        Field(String str, T t) {
            this.key = str;
            this.defaultValue = t;
        }
    }

    public static final class c extends Field<Uri> {
        c(String str, Uri uri) {
            super(str, uri);
        }

        public c(String str) {
            this(str, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // net.openid.appauth.JsonUtil.Field
        /* JADX INFO: renamed from: fFt_, reason: merged with bridge method [inline-methods] */
        public Uri convert(String str) {
            return Uri.parse(str);
        }
    }

    public static final class b extends Field<String> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // net.openid.appauth.JsonUtil.Field
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public String convert(String str) {
            return str;
        }

        b(String str, String str2) {
            super(str, str2);
        }

        public b(String str) {
            this(str, null);
        }
    }

    public static final class e extends Field<Boolean> {
        public e(String str, boolean z) {
            super(str, Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // net.openid.appauth.JsonUtil.Field
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean convert(String str) {
            return Boolean.valueOf(Boolean.parseBoolean(str));
        }
    }

    public static abstract class ListField<T> {
        public final List<T> defaultValue;
        public final String key;

        abstract T convert(String str);

        ListField(String str, List<T> list) {
            this.key = str;
            this.defaultValue = list;
        }
    }

    public static final class a extends ListField<String> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // net.openid.appauth.JsonUtil.ListField
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String convert(String str) {
            return str;
        }

        public a(String str) {
            super(str, null);
        }

        public a(String str, List<String> list) {
            super(str, list);
        }
    }
}
