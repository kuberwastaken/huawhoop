package ohos.ace.adapter;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class WantParams {
    private static final String LOG_TAG = "WantParams";
    private static final int VALUE_TYPE_ARRAY = 102;
    private static final int VALUE_TYPE_BOOLEAN = 1;
    private static final int VALUE_TYPE_DOUBLE = 9;
    private static final int VALUE_TYPE_INT = 5;
    private static final int VALUE_TYPE_STRING = 10;
    private static final int VALUE_TYPE_WANT_PARAMS = 101;
    private static final int VALUE_TYPE_WANT_PARAMS_ARRAY = 24;
    private static final String WANT_PARAMS_KEY = "key";
    private static final String WANT_PARAMS_PARAMS = "params";
    private static final String WANT_PARAMS_TYPE = "type";
    private static final String WANT_PARAMS_VALUE = "value";
    private final Map<String, WantValue> wantParamsMap = new HashMap();

    public WantParams() {
    }

    public WantParams(String str) {
        try {
            parseWantParams(new JSONObject(str), "params");
        } catch (JSONException e) {
            Log.e(LOG_TAG, "WantParams parse error.");
            e.printStackTrace();
        }
    }

    static class WantValue {
        public int type;
        public Object value;

        public WantValue(int i, Object obj) {
            this.type = i;
            this.value = obj;
        }
    }

    private boolean parse(JSONArray jSONArray) throws JSONException {
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (!jSONObject.has("key") || !jSONObject.has("type") || !jSONObject.has("value")) {
                Log.e(LOG_TAG, "WantParams data format error.");
                return false;
            }
            int i2 = jSONObject.getInt("type");
            String string = jSONObject.getString("key");
            if (i2 == 1) {
                this.wantParamsMap.put(string, new WantValue(i2, Boolean.valueOf(jSONObject.getBoolean("value"))));
            } else if (i2 == 5) {
                this.wantParamsMap.put(string, new WantValue(i2, Integer.valueOf(jSONObject.getInt("value"))));
            } else if (i2 == 9) {
                this.wantParamsMap.put(string, new WantValue(i2, Double.valueOf(jSONObject.getDouble("value"))));
            } else if (i2 == 10) {
                this.wantParamsMap.put(string, new WantValue(i2, jSONObject.getString("value")));
            } else if (i2 == 101) {
                WantParams wantParams = new WantParams();
                wantParams.parse(jSONObject.getJSONArray("value"));
                this.wantParamsMap.put(string, new WantValue(i2, wantParams));
            } else if (i2 == 102) {
                parseWantArray(jSONObject);
            } else {
                Log.e(LOG_TAG, "Not supported data type");
            }
        }
        return true;
    }

    private void parseWantArray(JSONObject jSONObject) throws JSONException {
        WantValue wantValue;
        JSONArray jSONArray = jSONObject.getJSONArray("value");
        String string = jSONObject.getString("key");
        if (jSONArray.length() < 1) {
            this.wantParamsMap.put(string, new WantValue(102, new Object()));
            return;
        }
        int i = 0;
        if (jSONArray.get(0) instanceof Integer) {
            int[] iArr = new int[jSONArray.length()];
            while (i < jSONArray.length()) {
                iArr[i] = jSONArray.getInt(i);
                i++;
            }
            wantValue = new WantValue(102, iArr);
        } else if (jSONArray.get(0) instanceof Boolean) {
            boolean[] zArr = new boolean[jSONArray.length()];
            while (i < jSONArray.length()) {
                zArr[i] = jSONArray.getBoolean(i);
                i++;
            }
            wantValue = new WantValue(102, zArr);
        } else if (jSONArray.get(0) instanceof Double) {
            double[] dArr = new double[jSONArray.length()];
            while (i < jSONArray.length()) {
                dArr[i] = jSONArray.getDouble(i);
                i++;
            }
            wantValue = new WantValue(102, dArr);
        } else if (jSONArray.get(0) instanceof String) {
            String[] strArr = new String[jSONArray.length()];
            while (i < jSONArray.length()) {
                strArr[i] = jSONArray.getString(i);
                i++;
            }
            wantValue = new WantValue(102, strArr);
        } else if (jSONArray.get(0) instanceof JSONObject) {
            WantParams[] wantParamsArr = new WantParams[jSONArray.length()];
            while (i < jSONArray.length()) {
                WantParams wantParams = new WantParams();
                wantParams.parseWantParams(jSONArray.getJSONObject(i), "value");
                wantParamsArr[i] = wantParams;
                i++;
            }
            wantValue = new WantValue(24, wantParamsArr);
        } else {
            Log.e(LOG_TAG, "Not supported data type");
            return;
        }
        this.wantParamsMap.put(string, wantValue);
    }

    private void parseWantParams(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str) && (jSONObject.get(str) instanceof JSONArray) && !parse((JSONArray) jSONObject.get(str))) {
            Log.e(LOG_TAG, "WantParams data format error.");
        }
    }

    public WantParams addValue(String str, boolean z) {
        innerAddValue(str, Boolean.valueOf(z), 1);
        return this;
    }

    private void innerAddValue(String str, Object obj, int i) {
        if (str == null || str.isEmpty()) {
            return;
        }
        this.wantParamsMap.put(str, new WantValue(i, obj));
    }

    public WantParams addValue(String str, int i) {
        innerAddValue(str, Integer.valueOf(i), 5);
        return this;
    }

    public WantParams addValue(String str, float f) {
        innerAddValue(str, Float.valueOf(f), 9);
        return this;
    }

    public WantParams addValue(String str, double d) {
        innerAddValue(str, Double.valueOf(d), 9);
        return this;
    }

    public WantParams addValue(String str, String str2) {
        innerAddValue(str, str2, 10);
        return this;
    }

    public WantParams addValue(String str, boolean[] zArr) {
        innerAddArrayValue(str, zArr);
        return this;
    }

    public WantParams addValue(String str, int[] iArr) {
        innerAddArrayValue(str, iArr);
        return this;
    }

    public WantParams addValue(String str, float[] fArr) {
        innerAddArrayValue(str, fArr);
        return this;
    }

    public WantParams addValue(String str, double[] dArr) {
        innerAddArrayValue(str, dArr);
        return this;
    }

    public WantParams addValue(String str, String[] strArr) {
        innerAddArrayValue(str, strArr);
        return this;
    }

    private void innerAddArrayValue(String str, Object obj) {
        if (str == null || str.isEmpty() || obj == null) {
            return;
        }
        this.wantParamsMap.put(str, new WantValue(102, obj));
    }

    public WantParams addValue(String str, WantParams wantParams) {
        innerAddValue(str, wantParams, 101);
        return this;
    }

    public Object getValue(String str) {
        if (str == null || str.isEmpty() || !this.wantParamsMap.containsKey(str)) {
            return null;
        }
        return ((WantValue) Objects.requireNonNull(this.wantParamsMap.get(str))).value;
    }

    private String replaceSpecialChars(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\f') {
                if (cCharAt != '\r') {
                    if (cCharAt != '\"') {
                        if (cCharAt == '\\') {
                            sb.append("\\\\");
                        } else {
                            switch (cCharAt) {
                                case '\b':
                                    sb.append("\\b");
                                    break;
                                case '\t':
                                    sb.append("\\t");
                                    break;
                                case '\n':
                                    sb.append("\\n");
                                    break;
                                default:
                                    sb.append(cCharAt);
                                    break;
                            }
                        }
                    } else {
                        sb.append("\\\"");
                    }
                } else {
                    sb.append("\\r");
                }
            } else {
                sb.append("\\f");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String innerToWantParamsString() {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ohos.ace.adapter.WantParams.innerToWantParamsString():java.lang.String");
    }

    private static String wantArrayToString(Map.Entry<String, WantValue> entry) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (WantParams wantParams : (WantParams[]) entry.getValue().value) {
            sb.append("{\"key\":\"params\",\"type\":101,\"value\":");
            sb.append(wantParams.innerToWantParamsString());
            sb.append("},");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public String toWantParamsString() {
        return "{\"params\":" + innerToWantParamsString() + "}";
    }
}
