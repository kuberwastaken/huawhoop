package defpackage;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.network.embedded.x2;
import com.huawei.wearengine.ClientHubActivity;
import com.huawei.wearengine.auth.Permission;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class wuz {
    public static Intent fDT_(Context context, String str, Permission[] permissionArr) {
        if (context == null) {
            wrm.e("WearEngineAuthUtil", "getAuthIntent appContext is null");
            return null;
        }
        if (permissionArr == null) {
            wrm.e("WearEngineAuthUtil", "getAuthIntent permissions is null");
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("target_package_name") || !jSONObject.has("target_activity_name")) {
                wrm.e("WearEngineAuthUtil", "getAuthIntent targetActivityJson is invalid");
                return null;
            }
            String packageName = context.getPackageName();
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setClass(context, ClientHubActivity.class);
            intent.setFlags(268435456);
            String strE = e(packageName, permissionArr);
            if (strE != null) {
                intent.putExtra("start_request_json", strE);
            }
            intent.putExtra("target_json", str);
            return intent;
        } catch (JSONException unused) {
            wrm.b("WearEngineAuthUtil", "getAuthIntent JSONException");
            return null;
        }
    }

    private static String e(String str, Permission[] permissionArr) {
        HashSet hashSet = new HashSet(permissionArr.length);
        for (Permission permission : permissionArr) {
            hashSet.add(permission.getName());
        }
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        JSONArray jSONArray = new JSONArray();
        for (String str2 : strArr) {
            jSONArray.put(str2);
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("package_name", str);
            jSONObject3.put("permissions", jSONArray);
            jSONObject2.put(x2.REQUEST_TYPE, "request_auth");
            jSONObject.put("request_header", jSONObject2);
            jSONObject.put("request_body", jSONObject3);
            return jSONObject.toString();
        } catch (JSONException unused) {
            wrm.b("WearEngineAuthUtil", "requestDataToJsonString JSONException");
            return null;
        }
    }
}
