package ohos.ace.adapter.capability.web;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import ohos.ace.adapter.ALog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebJavascriptProxyCallback {
    private static final String LOG_TAG = "AceWebJavascriptProxyCallback";
    private static final long THREAD_TIME_OUT = 1000;
    private Context mContext;
    private WebView mWebView;

    AceWebJavascriptProxyCallback(Context context, WebView webView) {
        this.mContext = context;
        this.mWebView = webView;
    }

    @JavascriptInterface
    public void callAsyncFunction(final String str, final String str2, String str3) {
        ALog.i(LOG_TAG, "callAsyncFunction className: " + str + ", methodName: " + str2);
        try {
            JSONArray jSONArray = new JSONArray(str3);
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj != null && obj != JSONObject.NULL) {
                    arrayList.add(parseJsonElement(obj));
                }
            }
            this.mWebView.post(new Runnable() { // from class: ohos.ace.adapter.capability.web.AceWebJavascriptProxyCallback$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    AceWebPluginBase.onReceiveJavascriptExecuteCall(str, str2, arrayList.toArray(new Object[0]));
                }
            });
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "callAsyncFunction JSONException error");
        }
    }

    @JavascriptInterface
    public String callSyncFunction(final String str, final String str2, String str3) {
        ALog.i(LOG_TAG, "callSyncFunction className: " + str + ", methodName: " + str2);
        final AtomicReference atomicReference = new AtomicReference("{\"value\": null}");
        try {
            JSONArray jSONArray = new JSONArray(str3);
            final ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj = jSONArray.get(i);
                if (obj != null && obj != JSONObject.NULL) {
                    arrayList.add(parseJsonElement(obj));
                }
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: ohos.ace.adapter.capability.web.AceWebJavascriptProxyCallback$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1452lambda$callSyncFunction$1$ohosaceadaptercapabilitywebAceWebJavascriptProxyCallback(str, str2, arrayList, atomicReference, countDownLatch);
                }
            });
            if (!countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                ALog.e(LOG_TAG, "callSyncFunction timed out waiting for result.");
                atomicReference.set("{\"value\": null}");
            }
        } catch (InterruptedException unused) {
            ALog.e(LOG_TAG, "callSyncFunction InterruptedException error");
            atomicReference.set("{\"value\": null}");
        } catch (JSONException unused2) {
            ALog.e(LOG_TAG, "callSyncFunction JSONException error");
            atomicReference.set("{\"value\": null}");
        }
        return (String) atomicReference.get();
    }

    /* JADX INFO: renamed from: lambda$callSyncFunction$1$ohos-ace-adapter-capability-web-AceWebJavascriptProxyCallback, reason: not valid java name */
    /* synthetic */ void m1452lambda$callSyncFunction$1$ohosaceadaptercapabilitywebAceWebJavascriptProxyCallback(String str, String str2, List list, AtomicReference atomicReference, CountDownLatch countDownLatch) {
        atomicReference.set(splitJsonString(AceWebPluginBase.onReceiveJavascriptExecuteCall(str, str2, list.toArray(new Object[0]))));
        countDownLatch.countDown();
    }

    private String splitJsonString(Object obj) {
        if (obj == null) {
            return String.format("{\"value\": null}", new Object[0]);
        }
        if (obj instanceof String) {
            return String.format("{\"value\": \"%s\"}", (String) obj);
        }
        if ((obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Boolean)) {
            return String.format("{\"value\": %s}", obj.toString());
        }
        if (obj instanceof List) {
            return String.format("{\"value\": %s}", convertListToJson((List) obj));
        }
        if (obj instanceof Map) {
            return String.format("{\"value\": %s}", convertMapToJson((Map) obj));
        }
        return String.format("{\"value\": null}", new Object[0]);
    }

    private Object parseJsonElement(Object obj) {
        if (obj == JSONObject.NULL || obj == null) {
            return null;
        }
        if (obj instanceof JSONArray) {
            return parseJsonArray((JSONArray) obj);
        }
        return obj instanceof JSONObject ? parseJsonObject((JSONObject) obj) : obj;
    }

    private List<Object> parseJsonArray(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(parseJsonElement(jSONArray.get(i)));
            } catch (JSONException unused) {
                ALog.e(LOG_TAG, "parseJsonArray JSONException error");
            }
        }
        return arrayList;
    }

    private Map<String, Object> parseJsonObject(JSONObject jSONObject) {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                map.put(next, parseJsonElement(jSONObject.get(next)));
            } catch (JSONException unused) {
                ALog.e(LOG_TAG, "parseJsonObject JSONException error");
            }
        }
        return map;
    }

    private String convertListToJson(List<?> list) {
        try {
            JSONArray jSONArray = new JSONArray();
            for (Object obj : list) {
                if (obj == null) {
                    jSONArray.put(JSONObject.NULL);
                } else if (obj instanceof List) {
                    jSONArray.put(new JSONArray(convertListToJson((List) obj)));
                } else if (obj instanceof Map) {
                    jSONArray.put(new JSONObject(convertMapToJson((Map) obj)));
                } else {
                    jSONArray.put(obj);
                }
            }
            return jSONArray.toString();
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "convertListToJson error");
            return "[]";
        }
    }

    private String convertMapToJson(Map<?, ?> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                String string = entry.getKey().toString();
                Object value = entry.getValue();
                if (value == null) {
                    jSONObject.put(string, JSONObject.NULL);
                } else if (value instanceof List) {
                    jSONObject.put(string, new JSONArray(convertListToJson((List) value)));
                } else if (value instanceof Map) {
                    jSONObject.put(string, new JSONObject(convertMapToJson((Map) value)));
                } else {
                    jSONObject.put(string, value);
                }
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            ALog.e(LOG_TAG, "convertMapToJson error");
            return "{}";
        }
    }
}
