package com.huawei.hwcloudjs.service.hms;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import java.io.Serializable;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6456a = "JsonCodec";
    protected static final String b = "_val_type_";
    protected static final int c = -1;
    protected static final int d = 0;
    protected static final int e = 1;
    private static final String f = "_list_size_";
    private static final String g = "_list_item_";

    protected void a(String str, JSONArray jSONArray, Bundle bundle) throws JSONException {
        int i = bundle.getInt(f);
        for (int i2 = 0; i2 < i; i2++) {
            Object obj = bundle.get(g + i2);
            if (obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Serializable)) {
                jSONArray.put(obj);
            } else if (obj instanceof Bundle) {
                Bundle bundle2 = (Bundle) obj;
                if (bundle2.getInt(b, -1) == 0) {
                    JSONObject jSONObject = new JSONObject();
                    a(str, bundle2, jSONObject);
                    jSONArray.put(jSONObject);
                }
            }
        }
    }

    protected void a(String str, String str2, JSONObject jSONObject, Bundle bundle) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null) {
            return;
        }
        if ("String".equals(str2)) {
            bundle.putString(str, jSONObject.optString("value"));
            return;
        }
        if ("Integer".equals(str2)) {
            bundle.putInt(str, jSONObject.optInt("value"));
            return;
        }
        if ("Short".equals(str2)) {
            Short shC = c(jSONObject);
            if (shC != null) {
                bundle.putShort(str, shC.shortValue());
                return;
            }
            return;
        }
        if ("Long".equals(str2)) {
            Long lB = b(jSONObject);
            if (lB != null) {
                bundle.putLong(str, lB.longValue());
                return;
            }
            return;
        }
        if ("Float".equals(str2)) {
            Float fA = a(jSONObject);
            if (fA != null) {
                bundle.putFloat(str, fA.floatValue());
                return;
            }
            return;
        }
        if ("Double".equals(str2)) {
            bundle.putDouble(str, jSONObject.optDouble("value"));
            return;
        }
        if ("Boolean".equals(str2)) {
            bundle.putBoolean(str, jSONObject.optBoolean("value"));
            return;
        }
        if ("List".equals(str2)) {
            a(str, jSONObject, bundle);
        } else {
            if (!"entity".equals(str2) || (jSONObjectOptJSONObject = jSONObject.optJSONObject("value")) == null) {
                return;
            }
            Bundle bundleA = a(jSONObjectOptJSONObject, new Bundle());
            bundleA.putInt(b, 0);
            bundle.putBundle(str, bundleA);
        }
    }

    public void a(String str, Bundle bundle, JSONObject jSONObject) {
        Object obj;
        for (String str2 : bundle.keySet()) {
            Object obj2 = bundle.get(str2);
            if (obj2 != null) {
                try {
                    if (obj2 instanceof Bundle) {
                        Bundle bundle2 = (Bundle) obj2;
                        int i = bundle2.getInt(b, -1);
                        if (i == 1) {
                            JSONArray jSONArray = new JSONArray();
                            a(str, jSONArray, bundle2);
                            obj = jSONArray;
                        } else if (i == 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            a(str, bundle2, jSONObject2);
                            obj = jSONObject2;
                        }
                        jSONObject.put(str2, obj);
                    } else {
                        if (obj2 instanceof Intent) {
                            String str3 = str + "_" + UUID.randomUUID().toString() + "";
                            s.a().a(str3, (Intent) obj2);
                            obj = str3;
                        } else if (obj2 instanceof PendingIntent) {
                            String str4 = str + "_" + UUID.randomUUID().toString() + "";
                            s.a().a(str4, (PendingIntent) obj2);
                            obj = str4;
                        } else {
                            jSONObject.put(str2, obj2);
                        }
                        jSONObject.put(str2, obj);
                    }
                } catch (JSONException unused) {
                    com.huawei.hwcloudjs.f.d.b(f6456a, "signInRes2Json put json error", true);
                }
            }
        }
    }

    public Bundle a(JSONObject jSONObject, Bundle bundle) {
        String str;
        JSONObject jSONObjectOptJSONObject;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (next != null && (next instanceof String) && (jSONObjectOptJSONObject = jSONObject.optJSONObject((str = next))) != null) {
                a(str, jSONObjectOptJSONObject.optString("type"), jSONObjectOptJSONObject, bundle);
            }
        }
        return bundle;
    }

    private Short c(JSONObject jSONObject) {
        Object objOpt = jSONObject.opt("value");
        if (objOpt == null) {
            return null;
        }
        if (objOpt instanceof Number) {
            return Short.valueOf(((Number) objOpt).shortValue());
        }
        if (objOpt instanceof String) {
            try {
                return Short.valueOf(Short.parseShort((String) objOpt));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    private Long b(JSONObject jSONObject) {
        Object objOpt = jSONObject.opt("value");
        if (objOpt == null) {
            return null;
        }
        if (objOpt instanceof Number) {
            return Long.valueOf(((Number) objOpt).longValue());
        }
        if (objOpt instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) objOpt));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }

        public a() {
        }
    }

    private void a(String str, JSONObject jSONObject, Bundle bundle) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("value");
        if (jSONArrayOptJSONArray != null) {
            String strOptString = jSONObject.optString("subType");
            Bundle bundle2 = new Bundle();
            bundle2.putInt(b, 1);
            bundle2.putInt(f, jSONArrayOptJSONArray.length());
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                Object objOpt = jSONArrayOptJSONArray.opt(i);
                if (objOpt != null) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("value", objOpt);
                        jSONObject2.put("type", strOptString);
                        a(g + i, strOptString, jSONObject2, bundle2);
                    } catch (JSONException unused) {
                        com.huawei.hwcloudjs.f.d.b(f6456a, "writeList put json error", true);
                    }
                }
            }
            bundle.putBundle(str, bundle2);
        }
    }

    private Float a(JSONObject jSONObject) {
        Object objOpt = jSONObject.opt("value");
        if (objOpt == null) {
            return null;
        }
        if (objOpt instanceof Number) {
            return Float.valueOf(((Number) objOpt).floatValue());
        }
        if (objOpt instanceof String) {
            try {
                return Float.valueOf(Float.parseFloat((String) objOpt));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }
}
