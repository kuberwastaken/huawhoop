package defpackage;

import android.text.TextUtils;
import com.huawei.operation.utils.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes4.dex */
public class dpb {
    private ArrayList<d> e;

    public ArrayList<d> e() {
        return this.e;
    }

    public static class d {
        private Map<String, c> d;
        private String e;

        public void e(String str) {
            this.e = str;
        }

        public Map<String, c> d() {
            return this.d;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("UserInfoData{dateTime ='");
            stringBuffer.append(this.e).append("'userdata ='");
            Map<String, c> map = this.d;
            stringBuffer.append(map == null ? Constants.NULL : map.toString()).append("'}");
            return stringBuffer.toString();
        }

        public void d(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.has("dateTime")) {
                        e(jSONObject.getString("dateTime"));
                    } else {
                        dna.a(false, "DeviceServiceUser", "UserData toObject not has dateTime");
                    }
                    this.d = new HashMap(16);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (next.contains("id_")) {
                            c cVar = new c();
                            cVar.a(jSONObject.getJSONObject(next));
                            this.d.put(next, cVar);
                        }
                    }
                    if (this.d.size() == 0) {
                        c cVar2 = new c();
                        cVar2.a(jSONObject);
                        this.d.put("id_1", cVar2);
                    }
                } catch (JSONException e) {
                    dna.d(false, "DeviceServiceUser", "UserInfoData toObject JSONException ", e.getMessage());
                }
            }
        }

        public c b(String str) {
            if (TextUtils.isEmpty(str)) {
                dna.a(false, "DeviceServiceUser", "getUserData data accountId is null ");
                return null;
            }
            Map<String, c> mapD = d();
            if (mapD != null) {
                for (c cVar : mapD.values()) {
                    if (cVar != null && str.equals(cVar.a())) {
                        return cVar;
                    }
                }
            } else {
                dna.a(false, "DeviceServiceUser", "UserInfoData getUserData userDataMap is null");
            }
            dna.a(false, "DeviceServiceUser", "UserInfoData getUserData not foung UserData id", str);
            return null;
        }

        public void c(Map<String, String> map) {
            if (map != null) {
                if (map.containsKey("dateTime")) {
                    e(map.get("dateTime"));
                } else {
                    dna.c(false, "DeviceServiceUser", "UserInfoData mapToObject map has not dateTime");
                }
                this.d = new HashMap(16);
                c cVar = new c();
                cVar.e(map);
                this.d.put("id_1", cVar);
                return;
            }
            dna.c(false, "DeviceServiceUser", "UserInfoData mapToObject map is null ");
        }
    }

    public static class c {
        private String c;
        private Map<String, String> e;

        public String a() {
            return this.c;
        }

        public void b(String str) {
            this.c = str;
        }

        public Map<String, String> c() {
            return this.e;
        }

        public void a(JSONObject jSONObject) {
            if (jSONObject != null) {
                try {
                    if (jSONObject.has("id")) {
                        b(jSONObject.getString("id"));
                    } else {
                        dna.a(false, "DeviceServiceUser", "UserData toObject not has id");
                    }
                    this.e = new HashMap(16);
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        if (next.contains("userInfo")) {
                            String string = jSONObject.getString(next);
                            String[] strArrSplit = string.split("\\|");
                            dna.b(false, "DeviceServiceUser", "UserData mapToObject userInfo ", string);
                            c(string, strArrSplit);
                        } else {
                            dna.c(false, "DeviceServiceUser", "UserData toObject keyStr is error ", next);
                        }
                    }
                } catch (JSONException e) {
                    dna.d(false, "DeviceServiceUser", "UserData toObject JSONException ", e.getMessage());
                }
            }
        }

        private void c(String str, String[] strArr) {
            if (strArr != null && strArr.length >= 4) {
                if (String.valueOf(0).equals(strArr[1])) {
                    strArr[1] = a();
                    StringBuffer stringBuffer = new StringBuffer(16);
                    stringBuffer.append("1|");
                    stringBuffer.append(strArr[1]).append("|");
                    stringBuffer.append(strArr[2]).append("|");
                    stringBuffer.append(strArr[3]);
                    this.e.put(strArr[1], stringBuffer.toString());
                    return;
                }
                this.e.put(strArr[1], str);
                return;
            }
            dna.c(false, "DeviceServiceUser", "UserData toObject userInfo size is error ", str);
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer("UserData{id ='");
            stringBuffer.append(this.c).append("'user ='");
            Map<String, String> map = this.e;
            stringBuffer.append(map == null ? Constants.NULL : map.toString()).append("'}");
            return stringBuffer.toString();
        }

        public void e(Map<String, String> map) {
            if (map != null) {
                this.e = new HashMap(16);
                if (map.containsKey("id")) {
                    b(map.get("id"));
                } else {
                    dna.c(false, "DeviceServiceUser", "UserData mapToObject Not carrying id");
                }
                Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
                return;
            }
            dna.c(false, "DeviceServiceUser", "UserData mapToObject map is null ");
        }

        private void a(Map.Entry<String, String> entry) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (TextUtils.isEmpty(key) || TextUtils.isEmpty(value) || !key.contains("userInfo")) {
                return;
            }
            String[] strArrSplit = value.split("\\|");
            dna.b(false, "DeviceServiceUser", "UserData mapToObject userInfo ", value);
            if (strArrSplit != null && strArrSplit.length >= 4) {
                c(value, strArrSplit);
            } else {
                dna.c(false, "DeviceServiceUser", "UserData mapToObject userInfo size is error ", value);
            }
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            dna.d(false, "DeviceServiceUser", "toObject json is null ");
            return;
        }
        try {
            Object objNextValue = new JSONTokener(str).nextValue();
            if (objNextValue instanceof JSONObject) {
                e((JSONObject) objNextValue);
            } else if (objNextValue instanceof JSONArray) {
                a((JSONArray) objNextValue);
            } else {
                dna.c(false, "DeviceServiceUser", "toObject json type is error ", objNextValue.getClass().getSimpleName());
            }
        } catch (JSONException e) {
            dna.d(false, "DeviceServiceUser", "toObject JSONException ", e.getMessage());
        }
    }

    private void e(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (this.e == null) {
                this.e = new ArrayList<>(16);
            }
            d dVar = new d();
            dVar.d(jSONObject);
            this.e.add(dVar);
            return;
        }
        dna.a(false, "DeviceServiceUser", "parserJsonObject jsonObject is null ");
    }

    private void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    e(jSONArray.getJSONObject(i));
                } catch (JSONException e) {
                    dna.d(false, "DeviceServiceUser", "parserJsonArray JSONException ", e.getMessage());
                }
            }
            return;
        }
        dna.a(false, "DeviceServiceUser", "parserJsonArray jsonArray is null ");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("DeviceServiceUser{data ='");
        ArrayList<d> arrayList = this.e;
        stringBuffer.append(arrayList == null ? Constants.NULL : arrayList.toString()).append("'}");
        return stringBuffer.toString();
    }

    public c c(String str) {
        if (TextUtils.isEmpty(str)) {
            dna.a(false, "DeviceServiceUser", "getUserData accountId is null ");
            return null;
        }
        ArrayList<d> arrayListE = e();
        if (arrayListE != null && arrayListE.size() > 0) {
            dna.a(false, "DeviceServiceUser", "getUserData datas ", arrayListE.toString());
            for (d dVar : arrayListE) {
                if (dVar != null) {
                    return dVar.b(str);
                }
            }
        } else {
            dna.a(false, "DeviceServiceUser", "getUserData datas is null");
        }
        dna.a(false, "DeviceServiceUser", "getUserData not found userdata");
        return null;
    }

    public void d(Map<String, String> map) {
        if (map != null) {
            if (this.e == null) {
                this.e = new ArrayList<>(16);
            }
            d dVar = new d();
            dVar.c(map);
            this.e.add(dVar);
            return;
        }
        dna.c(false, "DeviceServiceUser", " mapToObject map is null ");
    }
}
