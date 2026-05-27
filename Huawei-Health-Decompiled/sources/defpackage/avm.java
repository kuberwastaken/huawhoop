package defpackage;

import android.os.Looper;
import android.os.Process;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public class avm {
    public static String a(String str) {
        return a("local_update_unstruct_data", 0, str, "json");
    }

    private static String a(String str, int i, String str2, String str3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("business_id", str);
            jSONObject.put("returnCode", i);
            jSONObject.put("syncInfo", str2);
            jSONObject.put("syncInfoType", str3);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException unused) {
            avi.c("ReportUtil", "parseReportInfo " + str + " error: JSONException");
            return "";
        }
    }

    public static String b(String str) {
        return a("local_update_sync_result", 0, str, "json");
    }

    public static String d(String str) {
        return a("local_update_struct_data", 0, str, "json");
    }

    public static String a(String str, String str2, String str3) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("syncType", str);
            jSONObject.put("dataTypeList", str2);
            jSONObject.put("dataTypeResultList", str3);
            a(jSONObject);
            string = jSONObject.toString();
        } catch (JSONException unused) {
            avi.c("ReportUtil", "parseEndSyncReportInfo error: JSONException");
            string = "";
        }
        return a("local_end_sync_result", 0, string, "json");
    }

    public static String a(String str, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("syncType", str);
            jSONObject.put("syncRsn", i);
        } catch (Exception e) {
            avi.c("ReportUtil", "reportSyncRsn err " + e.getMessage());
        }
        a(jSONObject);
        return a("local_syncRsn", 0, jSONObject.toString(), "");
    }

    public static String d(String str, String str2, String str3) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dataType", str);
            jSONObject.put("localCtag", str2);
            jSONObject.put("cloudCtag", str3);
            a(jSONObject);
            string = jSONObject.toString();
        } catch (JSONException unused) {
            avi.c("ReportUtil", "parseCtagInfoReportInfo error: JSONException");
            string = "";
        }
        return a("local_ctag_info", 0, string, "json");
    }

    public static String d(String str, String str2, boolean z, boolean z2, boolean z3, int i, int i2, int i3, int i4, int i5) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dataType", str);
            jSONObject.put("syncToken", str2);
            jSONObject.put("isExpired", z);
            jSONObject.put("isIncrementallyQuery", z2);
            jSONObject.put("isRecycle", z3);
            jSONObject.put("localEtag", i);
            jSONObject.put("cloudEtag", i2);
            jSONObject.put("cloudAdded", i3);
            jSONObject.put("cloudModified", i4);
            jSONObject.put("cloudDeleted", i5);
            a(jSONObject);
            string = jSONObject.toString();
        } catch (JSONException unused) {
            avi.c("ReportUtil", "parseCloudChangesReportInfo error: JSONException");
            string = "";
        }
        return a("local_cloud_changes", 0, string, "json");
    }

    public static String a(String str, boolean z, int i, int i2) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dataType", str);
            jSONObject.put("isSyncRecycleOn", z);
            jSONObject.put("cloudDeletedId", i);
            jSONObject.put("deleteResult", i2);
            a(jSONObject);
            string = jSONObject.toString();
        } catch (JSONException unused) {
            avi.c("ReportUtil", "parseCloudDeleteReportInfo error: JSONException");
            string = "";
        }
        return a("local_cloud_delete", 0, string, "json");
    }

    public static String c(String str) {
        return a("local_local_changes", 0, str, "json");
    }

    public static String a(String str, List<Object> list) {
        String string = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("syncType", str);
            if (list == null) {
                jSONObject.put("updateDataResultList", "");
            } else {
                jSONObject.put("updateDataResultList", list.toString());
            }
            a(jSONObject);
            string = jSONObject.toString();
        } catch (JSONException unused) {
            avi.c("ReportUtil", "parseUpdateDataResultsReportInfo error: JSONException");
        }
        return a("local_update_data_results", 0, string, "json");
    }

    public static String c(String str, String str2, String str3, String str4) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("syncType", str);
            jSONObject.put("dataType", str2);
            jSONObject.put("serviceDisconnectedTime", str3);
            jSONObject.put("traceId", str4);
            a(jSONObject);
            string = jSONObject.toString();
        } catch (JSONException unused) {
            avi.c("ReportUtil", "parseServiceDisconnectedTimeReportInfo error: JSONException");
            string = "";
        }
        return a("local_service_disconnected_time", 5, string, "json");
    }

    public static String c(String str, String str2, int i, String str3) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dataType", str);
            jSONObject.put("interfacesName", str2);
            jSONObject.put("errorCode", i);
            jSONObject.put("errorMsg", str3);
            a(jSONObject);
            string = jSONObject.toString();
        } catch (Exception e) {
            avi.c("ReportUtil", "parseAppExceptionReportInfo error: " + e.getMessage());
            string = "";
        }
        return a("local_app_exception", 23, string, "json");
    }

    public static String c(String str, String str2, String str3, int i) {
        String string;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dataType", str);
            jSONObject.put("interfacesName", str2);
            jSONObject.put("errorMsg", str3);
            jSONObject.put("errorCode", i);
            a(jSONObject);
            string = jSONObject.toString();
        } catch (JSONException unused) {
            avi.c("ReportUtil", "parseAppExceptionReportInfo error: JSONException");
            string = "";
        }
        return a("sdk_inner_exception", 25, string, "json");
    }

    public static void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("3dAppTid", String.valueOf(Process.myTid()));
            jSONObject.put("3dAppPid", String.valueOf(Process.myPid()));
            jSONObject.put("is3dAppMainTid", String.valueOf(Thread.currentThread() == Looper.getMainLooper().getThread()));
        } catch (Exception e) {
            avi.c("ReportUtil", "appendProcessId err " + e.getMessage());
        }
    }
}
