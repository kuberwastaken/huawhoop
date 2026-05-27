package ohos.ace.adapter.capability.bridge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ohos.ace.adapter.ALog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class ParameterHelper {
    private static final int HASH_CODE = 1;
    private static final long JS_MAX_VALUE = 9007199254740991L;
    private static final long JS_MIN_VALUE = -9007199254740991L;
    private static final String LOG_TAG = "ParameterHelper";
    private static final long[] LONG_ARRAY;
    private static final String LONG_ARRAY_CLASS_NAME;

    static {
        long[] jArr = new long[0];
        LONG_ARRAY = jArr;
        LONG_ARRAY_CLASS_NAME = jArr.getClass().getName().toString();
    }

    public ParameterHelper() {
        ALog.i(LOG_TAG, "ParameterHelper construction");
    }

    public static boolean isExceedJsSafeInteger(Object obj) {
        if (!(obj instanceof Long)) {
            return true;
        }
        Long l = (Long) obj;
        if (l.longValue() <= JS_MAX_VALUE && l.longValue() >= JS_MIN_VALUE) {
            return true;
        }
        ALog.e(LOG_TAG, "Data exceeds JavaScript safe integer.");
        return false;
    }

    public static Object[] binaryTransformObject(Object obj) {
        if (obj instanceof List) {
            return ((List) obj).toArray();
        }
        return null;
    }

    public static Object[] jsonTransformObject(JSONObject jSONObject) {
        try {
            ArrayList arrayList = new ArrayList();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (jSONObject.get(next) instanceof JSONArray) {
                    addArraysObject((JSONArray) jSONObject.get(next), arrayList);
                } else {
                    arrayList.add(jSONObject.get(next));
                }
            }
            return arrayList.toArray();
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "jsonTransformObject failed, JSONException.");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void addArraysObject(org.json.JSONArray r2, java.util.List<java.lang.Object> r3) {
        /*
            r0 = 0
            if (r2 == 0) goto Lf
            java.lang.Object r1 = r2.get(r0)     // Catch: org.json.JSONException -> L55
            boolean r1 = r1 instanceof java.lang.String     // Catch: org.json.JSONException -> L55
            if (r1 == 0) goto Lf
            addArraysString(r2, r3, r0)     // Catch: org.json.JSONException -> L55
            goto L5c
        Lf:
            if (r2 == 0) goto L1d
            java.lang.Object r1 = r2.get(r0)     // Catch: org.json.JSONException -> L55
            boolean r1 = r1 instanceof java.lang.Integer     // Catch: org.json.JSONException -> L55
            if (r1 == 0) goto L1d
            addArraysInteger(r2, r3, r0)     // Catch: org.json.JSONException -> L55
            goto L5c
        L1d:
            if (r2 == 0) goto L2b
            java.lang.Object r1 = r2.get(r0)     // Catch: org.json.JSONException -> L55
            boolean r1 = r1 instanceof java.lang.Boolean     // Catch: org.json.JSONException -> L55
            if (r1 == 0) goto L2b
            addArraysBoolean(r2, r3, r0)     // Catch: org.json.JSONException -> L55
            goto L5c
        L2b:
            if (r2 == 0) goto L39
            java.lang.Object r1 = r2.get(r0)     // Catch: org.json.JSONException -> L55
            boolean r1 = r1 instanceof java.lang.Character     // Catch: org.json.JSONException -> L55
            if (r1 == 0) goto L39
            addArraysCharacter(r2, r3, r0)     // Catch: org.json.JSONException -> L55
            goto L5c
        L39:
            if (r2 == 0) goto L47
            java.lang.Object r1 = r2.get(r0)     // Catch: org.json.JSONException -> L55
            boolean r1 = r1 instanceof java.lang.Double     // Catch: org.json.JSONException -> L55
            if (r1 == 0) goto L47
            addArraysDouble(r2, r3, r0)     // Catch: org.json.JSONException -> L55
            goto L5c
        L47:
            if (r2 == 0) goto L5c
            java.lang.Object r1 = r2.get(r0)     // Catch: org.json.JSONException -> L55
            boolean r1 = r1 instanceof java.lang.Float     // Catch: org.json.JSONException -> L55
            if (r1 == 0) goto L5c
            addArraysFloat(r2, r3, r0)     // Catch: org.json.JSONException -> L55
            goto L5c
        L55:
            java.lang.String r2 = "ParameterHelper"
            java.lang.String r3 = "addArraysObject failed, JSONException."
            ohos.ace.adapter.ALog.e(r2, r3)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ohos.ace.adapter.capability.bridge.ParameterHelper.addArraysObject(org.json.JSONArray, java.util.List):void");
    }

    private static void addArraysString(JSONArray jSONArray, List<Object> list, int i) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jSONArray.hashCode() != 1) {
                arrayList.add((String) jSONArray.get(i));
                jSONArray.remove(i);
            }
            String[] strArr = new String[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                strArr[i2] = (String) arrayList.get(i2);
            }
            list.add(strArr);
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "addArraysString failed, JSONException.");
        }
    }

    private static void addArraysInteger(JSONArray jSONArray, List<Object> list, int i) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jSONArray.hashCode() != 1) {
                arrayList.add(Integer.valueOf(((Integer) jSONArray.get(i)).intValue()));
                jSONArray.remove(i);
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            list.add(iArr);
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "addArraysInteger failed, JSONException.");
        }
    }

    private static void addArraysBoolean(JSONArray jSONArray, List<Object> list, int i) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jSONArray.hashCode() != 1) {
                arrayList.add(Boolean.valueOf(((Boolean) jSONArray.get(i)).booleanValue()));
                jSONArray.remove(i);
            }
            boolean[] zArr = new boolean[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                zArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue();
            }
            list.add(zArr);
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "addArraysBoolean failed, JSONException.");
        }
    }

    private static void addArraysCharacter(JSONArray jSONArray, List<Object> list, int i) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jSONArray.hashCode() != 1) {
                arrayList.add(Character.valueOf(((Character) jSONArray.get(i)).charValue()));
                jSONArray.remove(i);
            }
            char[] cArr = new char[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                cArr[i2] = ((Character) arrayList.get(i2)).charValue();
            }
            list.add(cArr);
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "addArraysCharacter failed, JSONException.");
        }
    }

    private static void addArraysDouble(JSONArray jSONArray, List<Object> list, int i) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jSONArray.hashCode() != 1) {
                arrayList.add(Double.valueOf(((Double) jSONArray.get(i)).doubleValue()));
                jSONArray.remove(i);
            }
            double[] dArr = new double[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                dArr[i2] = ((Double) arrayList.get(i2)).doubleValue();
            }
            list.add(dArr);
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "addArraysDouble failed, JSONException.");
        }
    }

    private static void addArraysFloat(JSONArray jSONArray, List<Object> list, int i) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jSONArray.hashCode() != 1) {
                arrayList.add(Float.valueOf(((Float) jSONArray.get(i)).floatValue()));
                jSONArray.remove(i);
            }
            float[] fArr = new float[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                fArr[i2] = ((Float) arrayList.get(i2)).floatValue();
            }
            list.add(fArr);
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "addArraysFloat failed, JSONException.");
        }
    }

    public static JSONObject objectTransformJson(Object[] objArr) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            for (Object obj : objArr) {
                if (obj == null) {
                    return null;
                }
                if (obj.getClass().isArray()) {
                    JSONArray jSONArrayObjectTransformJsonArray = objectTransformJsonArray(obj);
                    if (jSONArrayObjectTransformJsonArray == null) {
                        return null;
                    }
                    jSONObject.put(String.valueOf(i), jSONArrayObjectTransformJsonArray);
                } else {
                    if (!isExceedJsSafeInteger(obj)) {
                        return null;
                    }
                    jSONObject.put(String.valueOf(i), obj);
                }
                i++;
            }
            return jSONObject;
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "objectTransformJson failed, JSONException.");
            return null;
        }
    }

    public static JSONArray objectTransformJsonArray(Object obj) {
        JSONArray jSONArray = new JSONArray();
        try {
            int i = 0;
            if (obj instanceof String[]) {
                String[] strArr = (String[]) obj;
                int length = strArr.length;
                while (i < length) {
                    jSONArray.put(strArr[i]);
                    i++;
                }
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                int length2 = cArr.length;
                while (i < length2) {
                    jSONArray.put((int) cArr[i]);
                    i++;
                }
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length;
                while (i < length3) {
                    jSONArray.put(iArr[i]);
                    i++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length4 = dArr.length;
                while (i < length4) {
                    jSONArray.put(dArr[i]);
                    i++;
                }
            } else if (obj instanceof float[]) {
                int length5 = ((float[]) obj).length;
                while (i < length5) {
                    jSONArray.put(r7[i]);
                    i++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length6 = zArr.length;
                while (i < length6) {
                    jSONArray.put(zArr[i]);
                    i++;
                }
            } else if (LONG_ARRAY_CLASS_NAME.equals(obj.getClass().getName().toString())) {
                long[] jArr = (long[]) obj;
                int length7 = jArr.length;
                while (i < length7) {
                    long j = jArr[i];
                    if (!isExceedJsSafeInteger(Long.valueOf(j))) {
                        return null;
                    }
                    jSONArray.put(j);
                    i++;
                }
            } else {
                if (!(obj instanceof Object[])) {
                    return null;
                }
                Object[] objArr = (Object[]) obj;
                int length8 = objArr.length;
                while (i < length8) {
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return null;
                    }
                    jSONArray.put(obj2);
                    i++;
                }
            }
            return jSONArray;
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "objectTransformJsonArray failed, JSONException.");
            return null;
        }
    }
}
