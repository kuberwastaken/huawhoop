package com.huawei.hms.framework.network.restclient.config;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class BaseConfig {
    private static final String TAG = "BaseConfig";
    public JSONObject configObj;

    public BaseConfig(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                this.configObj = new JSONObject();
            } else {
                this.configObj = new JSONObject(str);
            }
        } catch (JSONException unused) {
            Logger.w("BaseConfig", "call method set options occur JSONException");
        }
    }

    public int getInt(String str, int i) {
        try {
            return this.configObj.has(str) ? this.configObj.getInt(str) : i;
        } catch (JSONException unused) {
            return i;
        }
    }

    public boolean getBoolean(String str, boolean z) {
        try {
            return this.configObj.has(str) ? this.configObj.getBoolean(str) : z;
        } catch (JSONException unused) {
            return z;
        }
    }

    public double getDouble(String str, double d) {
        try {
            return this.configObj.has(str) ? this.configObj.getDouble(str) : d;
        } catch (JSONException unused) {
            return d;
        }
    }

    public long getLong(String str, long j) {
        try {
            return this.configObj.has(str) ? this.configObj.getLong(str) : j;
        } catch (JSONException unused) {
            return j;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.configObj.has(str) ? this.configObj.getString(str) : str2;
        } catch (JSONException unused) {
            return str2;
        }
    }

    public Map<String, String> getMap(String str) {
        HashMap map = new HashMap();
        try {
            if (this.configObj.has(str)) {
                JSONObject jSONObject = this.configObj.getJSONObject(str);
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
            }
        } catch (JSONException unused) {
            Logger.i("BaseConfig", "get map error " + str);
        }
        return map;
    }

    public void setValue(String str, int i) {
        try {
            this.configObj.put(str, i);
        } catch (JSONException unused) {
            Logger.w("BaseConfig", "setValue error " + str);
        }
    }

    public void setValue(String str, double d) {
        try {
            this.configObj.put(str, d);
        } catch (JSONException unused) {
            Logger.w("BaseConfig", "setValue error " + str);
        }
    }

    public void setValue(String str, boolean z) {
        try {
            this.configObj.put(str, z);
        } catch (JSONException unused) {
            Logger.w("BaseConfig", "setValue error " + str);
        }
    }

    public void setValue(String str, long j) {
        try {
            this.configObj.put(str, j);
        } catch (JSONException unused) {
            Logger.w("BaseConfig", "setValue error " + str);
        }
    }

    public void setValue(String str, Object obj) {
        try {
            this.configObj.put(str, obj);
        } catch (JSONException unused) {
            Logger.w("BaseConfig", "setValue error " + str);
        }
    }

    public void setOption(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                this.configObj.put(next, jSONObject.getString(next));
            }
        } catch (JSONException unused) {
            Logger.w("BaseConfig", "setOption error " + str);
        }
    }

    public String toString() {
        return this.configObj.toString();
    }
}
