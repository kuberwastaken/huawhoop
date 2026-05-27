package ohos.ace.plugin.webviewplugin.webstorage;

import android.content.Context;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class WebStoragePlugin {
    private static final String FILE = "file:///";
    private static final String LOG_TAG = "WebStoragePlugin";
    private static final String REPLACEMENT = "resource://rawfile/";

    protected static native void onReceiveStorageUsageValue(long j, long j2);

    protected static native void onReceiveStorageValue(long j, long j2);

    protected static native void onReceiveStorageValue(ArrayList<JSONObject> arrayList, long j);

    protected native void nativeInit();

    public WebStoragePlugin(Context context) {
        nativeInit();
    }

    public void getOriginQuota(String str, final long j) {
        WebStorage.getInstance().getQuotaForOrigin(str, new ValueCallback<Long>() { // from class: ohos.ace.plugin.webviewplugin.webstorage.WebStoragePlugin.1
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Long l) {
                WebStoragePlugin.onReceiveStorageValue(l.longValue(), j);
            }
        });
    }

    public void getOriginUsage(String str, final long j) {
        WebStorage.getInstance().getUsageForOrigin(str, new ValueCallback<Long>() { // from class: ohos.ace.plugin.webviewplugin.webstorage.WebStoragePlugin.2
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Long l) {
                WebStoragePlugin.onReceiveStorageUsageValue(l.longValue(), j);
            }
        });
    }

    public void getOrigins(final long j) {
        WebStorage.getInstance().getOrigins(new ValueCallback<Map>() { // from class: ohos.ace.plugin.webviewplugin.webstorage.WebStoragePlugin.3
            @Override // android.webkit.ValueCallback
            public void onReceiveValue(Map map) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : map.keySet()) {
                    if (map.get(obj) instanceof WebStorage.Origin) {
                        WebStorage.Origin origin = (WebStorage.Origin) map.get(obj);
                        String origin2 = origin.getOrigin();
                        long quota = origin.getQuota();
                        long usage = origin.getUsage();
                        if (WebStoragePlugin.FILE.equals(origin2)) {
                            origin2 = WebStoragePlugin.REPLACEMENT;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("origin", origin2);
                            jSONObject.put("quota", Long.toString(quota));
                            jSONObject.put("usage", Long.toString(usage));
                            arrayList.add(jSONObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                arrayList.toString();
                WebStoragePlugin.onReceiveStorageValue((ArrayList<JSONObject>) arrayList, j);
            }
        });
    }

    public void deleteAllData() {
        WebStorage.getInstance().deleteAllData();
    }

    public void deleteOrigin(String str) {
        WebStorage.getInstance().deleteOrigin(str);
    }
}
