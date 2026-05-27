package defpackage;

import android.os.Build;
import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import com.huawei.hidatamanager.util.Const;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class wzx {
    public static Map<String, String> b(String str, String str2, String str3) {
        String string;
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json");
        if (!TextUtils.isEmpty(str)) {
            map.put("X-App-ID", str);
        }
        map.put("X-Client-Version", "1.0.4.320");
        String str4 = Build.MODEL;
        map.put("terminalType", str4);
        map.put(HttpHeaders.X_REQUEST_ID, str3);
        map.put("X-Credential-Terminal", "aucs");
        HashMap map2 = new HashMap();
        map2.put("terminalType", str4);
        map2.put("appPkgName", str2);
        map2.put("callTime", String.valueOf(System.currentTimeMillis()));
        if (map2.size() == 0) {
            string = "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : map2.entrySet()) {
                sb.append((String) entry.getKey());
                sb.append("=");
                sb.append((String) entry.getValue());
                sb.append(",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            string = sb.toString();
        }
        map.put("X-RequestContext", string);
        return map;
    }

    public static String b(String str) throws wzb {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("request", str);
            return jSONObject.toString();
        } catch (JSONException e) {
            StringBuilder sbB = wzk.b("getReqBody error : ");
            sbB.append(e.getMessage());
            throw new wzb(Const.RawDataType.HEALTH_SLEEP_RECORD, sbB.toString());
        }
    }
}
