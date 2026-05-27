package org.eclipse.californium.core.network.interceptors;

import defpackage.ych;
import defpackage.ycj;
import defpackage.ycl;

/* JADX INFO: loaded from: classes8.dex */
public interface MessageInterceptor {
    void receiveEmptyMessage(ych ychVar);

    void receiveRequest(ycl yclVar);

    void receiveResponse(ycj ycjVar);

    void sendEmptyMessage(ych ychVar);

    void sendRequest(ycl yclVar);

    void sendResponse(ycj ycjVar);
}
