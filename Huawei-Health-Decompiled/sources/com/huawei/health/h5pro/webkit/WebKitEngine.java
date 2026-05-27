package com.huawei.health.h5pro.webkit;

import android.content.Context;
import android.webkit.WebView;
import com.huawei.health.h5pro.vengine.H5ProAppLoadListener;
import com.huawei.health.h5pro.vengine.H5ProInstance;
import com.huawei.health.h5pro.vengine.H5ProVirtualEngine;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class WebKitEngine implements H5ProVirtualEngine {
    public Map<String, Object> b = new HashMap();

    @Override // com.huawei.health.h5pro.vengine.H5ProVirtualEngine
    public void registerJsModule(String str, Object obj) {
        this.b.put(str, obj);
    }

    @Override // com.huawei.health.h5pro.vengine.H5ProVirtualEngine
    public H5ProInstance createInstance(WebView webView, H5ProAppLoadListener h5ProAppLoadListener) {
        WebKitInstance webKitInstance = new WebKitInstance(webView, h5ProAppLoadListener);
        d(webKitInstance);
        return webKitInstance;
    }

    @Override // com.huawei.health.h5pro.vengine.H5ProVirtualEngine
    public H5ProInstance createInstance(Context context, H5ProAppLoadListener h5ProAppLoadListener) {
        WebKitInstance webKitInstance = new WebKitInstance(context, h5ProAppLoadListener);
        d(webKitInstance);
        return webKitInstance;
    }

    private void d(WebKitInstance webKitInstance) {
        for (Map.Entry<String, Object> entry : this.b.entrySet()) {
            webKitInstance.registerJsModule(entry.getKey(), entry.getValue());
        }
    }
}
