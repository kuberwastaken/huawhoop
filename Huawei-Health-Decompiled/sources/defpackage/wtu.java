package defpackage;

import android.text.TextUtils;
import com.huawei.hms.network.embedded.x2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class wtu {
    public static String b(String str) {
        JSONObject jSONObjectD = d(str);
        if (jSONObjectD == null) {
            wro.e("RequestJsonParser", "getRequestType requestHeaderObject is null");
            return "";
        }
        if (!jSONObjectD.has(x2.REQUEST_TYPE)) {
            wro.e("RequestJsonParser", "getRequestType requestHeaderObject not has request_type");
            return "";
        }
        try {
            return jSONObjectD.getString(x2.REQUEST_TYPE);
        } catch (JSONException unused) {
            wro.e("RequestJsonParser", "getRequestType JSONException");
            return "";
        }
    }

    public static String[] c(String str) {
        JSONObject jSONObjectA = a(str);
        String[] strArr = new String[0];
        if (jSONObjectA == null) {
            wro.e("RequestJsonParser", "getRequestBodyPermission requestBodyObject is null");
            return strArr;
        }
        if (!jSONObjectA.has("permissions")) {
            wro.e("RequestJsonParser", "getRequestBodyPermission requestBodyObject not has permissions");
            return strArr;
        }
        try {
            JSONArray jSONArray = jSONObjectA.getJSONArray("permissions");
            strArr = new String[jSONArray.length()];
            for (int i = 0; i < jSONArray.length(); i++) {
                strArr[i] = jSONArray.getString(i);
            }
        } catch (JSONException unused) {
            wro.d("RequestJsonParser", "getRequestBodyPermission JSONException");
        }
        return strArr;
    }

    public static String e(String str) {
        JSONObject jSONObjectA = a(str);
        if (jSONObjectA == null) {
            wro.e("RequestJsonParser", "getRequestBodyPackageName requestBodyObject is null");
            return "";
        }
        if (!jSONObjectA.has("package_name")) {
            wro.e("RequestJsonParser", "getRequestBodyPackageName requestBodyObject not has package_name");
            return "";
        }
        try {
            return jSONObjectA.getString("package_name");
        } catch (JSONException unused) {
            wro.d("RequestJsonParser", "getRequestBodyPackageName JSONException");
            return "";
        }
    }

    private static JSONObject d(String str) {
        if (TextUtils.isEmpty(str)) {
            wro.e("RequestJsonParser", "getRequestHeader requestJson is empty");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("request_header")) {
                wro.e("RequestJsonParser", "getRequestHeader not has request_header");
                return null;
            }
            return jSONObject.getJSONObject("request_header");
        } catch (JSONException unused) {
            wro.d("RequestJsonParser", "getRequestHeader JSONException");
            return null;
        }
    }

    private static JSONObject a(String str) {
        if (TextUtils.isEmpty(str)) {
            wro.e("RequestJsonParser", "getRequestBody requestJson is empty");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("request_body")) {
                wro.e("RequestJsonParser", "getRequestBody not has request_body");
                return null;
            }
            return jSONObject.getJSONObject("request_body");
        } catch (JSONException unused) {
            wro.d("RequestJsonParser", "getRequestBody JSONException");
            return null;
        }
    }
}
