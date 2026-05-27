package com.huawei.networkclient;

import com.huawei.hms.framework.network.restclient.hwhttp.ResponseBody;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public interface IDownloadStrategy<Output> extends IRequest {
    Map<String, String> getHeaders();

    ProgressListener<Output> getListener();

    String getRequestBody();

    int getRequestMethod();

    void handleException(Throwable th, int i);

    void handleResponseBody(ResponseBody responseBody, int i);
}
