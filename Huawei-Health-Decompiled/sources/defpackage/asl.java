package defpackage;

import android.text.TextUtils;
import health.compact.a.LogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class asl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f301a;
    private final Map<String, ask> b;
    private final String d;
    private final String e;

    private asl(String str, String str2, Map<String, ask> map, List<String> list) {
        this.d = str;
        this.e = str2;
        this.b = map;
        this.f301a = list;
    }

    public String e() {
        return this.d;
    }

    String a() {
        return this.e;
    }

    public List<String> c() {
        return this.f301a;
    }

    Collection<ask> d() {
        return this.b.values();
    }

    ask c(String str) {
        return this.b.get(str);
    }

    public boolean b() {
        Iterator<ask> it = d().iterator();
        while (it.hasNext()) {
            if (!it.next().q()) {
                return false;
            }
        }
        return true;
    }

    static asl a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("appBundleId");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        String strOptString2 = jSONObject.optString("appVersionName");
        if (TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new asl(strOptString, strOptString2, d(strOptString2, jSONObject), c(jSONObject));
    }

    private static List<String> e(JSONObject jSONObject) throws JSONException {
        List<String> listEmptyList = Collections.emptyList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("abiFilters");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            listEmptyList = new ArrayList<>(jSONArrayOptJSONArray.length());
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String string = jSONArrayOptJSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    listEmptyList.add(string);
                }
            }
        }
        return listEmptyList;
    }

    private static List<String> c(JSONObject jSONObject) throws JSONException {
        List<String> listEmptyList = Collections.emptyList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("updateModules");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            listEmptyList = new ArrayList<>(jSONArrayOptJSONArray.length());
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String string = jSONArrayOptJSONArray.getString(i);
                if (!TextUtils.isEmpty(string)) {
                    listEmptyList.add(string);
                }
            }
        }
        return listEmptyList;
    }

    private static Map<String, ask> d(String str, JSONObject jSONObject) throws JSONException {
        Map<String, ask> mapEmptyMap = Collections.emptyMap();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("modules");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            List<String> listE = e(jSONObject);
            mapEmptyMap = new HashMap<>(jSONArrayOptJSONArray.length());
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                String strOptString = jSONObject2.optString("moduleName");
                if (!TextUtils.isEmpty(strOptString)) {
                    ask askVarE = ask.e(str, strOptString, listE, jSONObject2);
                    LogUtil.a("Bundle_ModuleDetails", askVarE.toString());
                    mapEmptyMap.put(strOptString, askVarE);
                }
            }
        }
        return mapEmptyMap;
    }
}
