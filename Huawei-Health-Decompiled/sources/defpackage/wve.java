package defpackage;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class wve {
    public static String b(String str, String str2, String str3, Object obj) {
        JSONObject jSONObject;
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject(str);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put(str3, obj);
            return jSONObject.toString();
        } catch (JSONException unused) {
            wrm.e("ClientJsonUtil", str2 + " catch JSONException");
            return "";
        }
    }

    public static boolean c(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            wrm.e("ClientJsonUtil", str2 + " jsonString is empty");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str3)) {
                return jSONObject.getBoolean(str3);
            }
            wrm.e("ClientJsonUtil", str2 + " input json not has key");
            return false;
        } catch (JSONException unused) {
            wrm.e("ClientJsonUtil", str2 + " catch JSONException");
            return false;
        }
    }

    public static String b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            wrm.e("ClientJsonUtil", str2 + " jsonString is empty");
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str3)) {
                return jSONObject.getString(str3);
            }
            wrm.e("ClientJsonUtil", str2 + " input json not has key");
            return "";
        } catch (JSONException unused) {
            wrm.e("ClientJsonUtil", str2 + " catch JSONException");
            return "";
        }
    }

    public static int c(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str)) {
            wrm.e("ClientJsonUtil", str2 + " jsonString is empty");
            return i;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str3)) {
                return jSONObject.getInt(str3);
            }
            wrm.e("ClientJsonUtil", str2 + " input json not has key");
            return i;
        } catch (JSONException unused) {
            wrm.e("ClientJsonUtil", str2 + " catch JSONException");
            return i;
        }
    }

    public static long b(String str, String str2, String str3, long j) {
        if (TextUtils.isEmpty(str)) {
            wrm.e("ClientJsonUtil", str2 + " jsonString is empty");
            return j;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(str3)) {
                return jSONObject.getLong(str3);
            }
            wrm.e("ClientJsonUtil", str2 + " input json not has key");
            return j;
        } catch (JSONException unused) {
            wrm.e("ClientJsonUtil", str2 + " catch JSONException");
            return j;
        }
    }
}
