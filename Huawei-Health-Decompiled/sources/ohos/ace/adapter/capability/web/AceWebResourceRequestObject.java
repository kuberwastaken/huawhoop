package ohos.ace.adapter.capability.web;

import android.webkit.WebResourceRequest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebResourceRequestObject {
    private WebResourceRequest request;

    public AceWebResourceRequestObject(WebResourceRequest webResourceRequest) {
        this.request = webResourceRequest;
    }

    public String getRequestUrl() {
        return this.request.getUrl() != null ? this.request.getUrl().toString() : "";
    }

    public String getMethod() {
        return this.request.getMethod() != null ? this.request.getMethod().toString() : "";
    }

    public boolean isRequestGesture() {
        return this.request.hasGesture();
    }

    public boolean isMainFrame() {
        return this.request.isForMainFrame();
    }

    public boolean isRedirect() {
        return this.request.isRedirect();
    }

    public Map<String, String> getRequestHeader() {
        if (this.request.getRequestHeaders() != null) {
            return this.request.getRequestHeaders();
        }
        return new HashMap();
    }
}
