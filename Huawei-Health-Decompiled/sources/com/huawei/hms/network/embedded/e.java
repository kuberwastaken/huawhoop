package com.huawei.hms.network.embedded;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.inner.api.PolicyNetworkService;
import com.huawei.hms.network.inner.utils.CheckConfigUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5411a = "BaseConfig";
    public JSONObject configObj;

    public String toString() {
        return this.configObj.toString();
    }

    public void setValue(String str, boolean z) {
        a(str, Boolean.valueOf(z));
    }

    public void setValue(String str, Object obj) {
        a(str, obj);
    }

    public void setValue(String str, long j) {
        a(str, Long.valueOf(j));
    }

    public void setValue(String str, int i) {
        a(str, Integer.valueOf(i));
    }

    public void setValue(String str, double d) {
        a(str, Double.valueOf(d));
    }

    public void setOption(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                a(next.trim(), jSONObject.get(next));
            }
        } catch (JSONException unused) {
            Logger.w(f5411a, "setOption error " + str);
        }
    }

    public String getString(String str) {
        try {
            return this.configObj.has(str) ? this.configObj.getString(str) : "";
        } catch (JSONException unused) {
            Logger.w(f5411a, "getString error " + str);
            return "";
        }
    }

    public Map<String, String> getMap(String str) {
        HashMap map = new HashMap();
        try {
            if (this.configObj.has(str)) {
                JSONObject jSONObject = new JSONObject(this.configObj.getString(str));
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            }
        } catch (JSONException unused) {
            Logger.w(f5411a, "getmap error " + StringUtils.anonymizeMessage(str));
        }
        return map;
    }

    public long getLong(String str) {
        try {
            if (this.configObj.has(str)) {
                return this.configObj.getLong(str);
            }
            return 0L;
        } catch (JSONException unused) {
            Logger.w(f5411a, "getLong error " + str);
            return 0L;
        }
    }

    public int getInt(String str) {
        try {
            if (this.configObj.has(str)) {
                return this.configObj.getInt(str);
            }
            return 0;
        } catch (JSONException unused) {
            Logger.w(f5411a, "getInt error " + str);
            return 0;
        }
    }

    public double getDouble(String str) {
        try {
            if (this.configObj.has(str)) {
                return this.configObj.getDouble(str);
            }
            return 0.0d;
        } catch (JSONException unused) {
            Logger.w(f5411a, "getDouble error " + str);
            return 0.0d;
        }
    }

    public boolean getBoolean(String str) {
        try {
            if (this.configObj.has(str)) {
                return this.configObj.getBoolean(str);
            }
            return false;
        } catch (JSONException unused) {
            Logger.w(f5411a, "getBoolean error " + str);
            return false;
        }
    }

    public String get(String str) {
        try {
            if (!this.configObj.has(str)) {
                return "";
            }
            Object obj = this.configObj.get(str);
            return obj instanceof String ? (String) obj : String.valueOf(obj);
        } catch (JSONException unused) {
            Logger.w(f5411a, "getInt error " + str);
            return "";
        }
    }

    public void appendOption(String str) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(f5411a, "appendOption options == null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!this.configObj.has(next)) {
                    this.configObj.put(next, jSONObject.get(next));
                }
            }
        } catch (JSONException unused) {
            Logger.w(f5411a, "appendOption error " + str);
        }
    }

    private void a(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            Logger.w(f5411a, "network config key : %s is null", str);
            return;
        }
        try {
            if (!str.startsWith("core_")) {
                str = "core_" + str;
            }
            if (TextUtils.equals(str, PolicyNetworkService.GlobalConstants.ENABLE_IPV6)) {
                str = "core_enable_ipv6_preferred";
            }
            if (CheckConfigUtils.checkIsCorrect(str, obj)) {
                this.configObj.put(str, obj);
                return;
            }
            Logger.w(f5411a, "Set value error, value of " + str + " is out of range.");
        } catch (JSONException unused) {
            Logger.w(f5411a, "Set value error " + str);
        }
    }

    public e(String str) {
        try {
            this.configObj = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
        } catch (JSONException unused) {
            Logger.w(f5411a, "call method set options occur JSONException");
        }
    }
}
