package defpackage;

import android.net.Uri;
import com.huawei.operation.utils.WebViewHelp;
import health.compact.a.LogUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
class ekc {
    private static final Map<String, String> b = new ConcurrentHashMap();

    ekc() {
    }

    static void b(String str) {
        Map<String, String> map = b;
        map.clear();
        try {
            Uri uri = Uri.parse(str);
            String queryParameter = uri.getQueryParameter(WebViewHelp.BI_KEY_PULL_FROM);
            String str2 = "";
            if (queryParameter == null) {
                queryParameter = "";
            }
            map.put(WebViewHelp.BI_KEY_PULL_FROM, queryParameter);
            String queryParameter2 = uri.getQueryParameter("fromPageTitle");
            if (queryParameter2 == null) {
                queryParameter2 = "";
            }
            map.put("fromPageTitle", queryParameter2);
            String queryParameter3 = uri.getQueryParameter("pullOrder");
            if (queryParameter3 == null) {
                queryParameter3 = "";
            }
            map.put("pullOrder", queryParameter3);
            String queryParameter4 = uri.getQueryParameter("itemId");
            if (queryParameter4 == null) {
                queryParameter4 = "";
            }
            map.put("itemId", queryParameter4);
            String queryParameter5 = uri.getQueryParameter("resourceName");
            if (queryParameter5 == null) {
                queryParameter5 = "";
            }
            map.put("resourceName", queryParameter5);
            String queryParameter6 = uri.getQueryParameter("resourceId");
            if (queryParameter6 != null) {
                str2 = queryParameter6;
            }
            map.put("resourceId", str2);
        } catch (Exception unused) {
            LogUtil.b("MarketingSourceRecorder", "uri parse failed, will clear record, url: " + str);
        }
    }

    static Map<String, String> a() {
        return new HashMap(b);
    }
}
