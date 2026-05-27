package ohos.ace.adapter.capability.web;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;

/* JADX INFO: loaded from: classes11.dex */
public class AceWebErrorReceiveObject extends AceWebResourceRequestObject implements IAceWebErrorReceiveObject {
    private static final String LOG_TAG = "AceWebErrorReceiveObject";
    private WebResourceError error;

    public AceWebErrorReceiveObject(WebResourceError webResourceError, WebResourceRequest webResourceRequest) {
        super(webResourceRequest);
        this.error = webResourceError;
    }

    @Override // ohos.ace.adapter.capability.web.IAceWebErrorReceiveObject
    public String getErrorInfo() {
        return this.error.getDescription() != null ? this.error.getDescription().toString() : "";
    }

    @Override // ohos.ace.adapter.capability.web.IAceWebErrorReceiveObject
    public int getErrorCode() {
        return this.error.getErrorCode();
    }
}
