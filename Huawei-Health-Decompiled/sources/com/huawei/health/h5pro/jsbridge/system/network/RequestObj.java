package com.huawei.health.h5pro.jsbridge.system.network;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.SerializedName;
import com.huawei.profile.coordinator.ProfileRequestConstants;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public class RequestObj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("url")
    public String f2455a;

    @SerializedName("requestBody")
    public String b;

    @SerializedName(TtmlNode.TAG_BODY)
    public Map<String, Object> c;

    @SerializedName("headers")
    public Map<String, String> d;

    @SerializedName("requestType")
    public String e = RequestType.GET.requestType;

    public void setRequestBody(String str) {
        this.b = str;
    }

    public void setHeaders(Map<String, String> map) {
        this.d = map;
    }

    public void setBody(Map<String, Object> map) {
        this.c = map;
    }

    public String getUrl() {
        return this.f2455a;
    }

    public String getRequestType() {
        return this.e;
    }

    public enum RequestType {
        POST("POST"),
        GET("GET"),
        DELETE(ProfileRequestConstants.DELETE_TYPE),
        PUT(ProfileRequestConstants.PUT_TYPE);

        public final String requestType;

        RequestType(String str) {
            this.requestType = str;
        }
    }

    public String getRequestBody() {
        return this.b;
    }

    public Map<String, String> getHeaders() {
        return this.d;
    }

    public Map<String, Object> getBody() {
        return this.c;
    }
}
