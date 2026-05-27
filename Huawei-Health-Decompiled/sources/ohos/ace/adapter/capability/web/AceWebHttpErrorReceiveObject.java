package ohos.ace.adapter.capability.web;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebHttpErrorReceiveObject extends AceWebResourceRequestObject {
    private static final String LOG_TAG = "AceWebHttpErrorReceiveObject";
    private WebResourceResponse response;

    public AceWebHttpErrorReceiveObject(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super(webResourceRequest);
        this.response = webResourceResponse;
    }

    public String getResponseMimeType() {
        return this.response.getMimeType() != null ? this.response.getMimeType().toString() : "";
    }

    public String getResponseEncoding() {
        return this.response.getEncoding() != null ? this.response.getEncoding().toString() : "";
    }

    public int getResponseCode() {
        return this.response.getStatusCode();
    }

    public String getResponseData() {
        return this.response.getData() != null ? this.response.getData().toString() : "";
    }

    public String getReason() {
        return this.response.getReasonPhrase() != null ? this.response.getReasonPhrase() : "";
    }

    public Map<String, String> getResponseHeader() {
        if (this.response.getResponseHeaders() != null) {
            return this.response.getResponseHeaders();
        }
        return new HashMap();
    }
}
