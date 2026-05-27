package com.huawei.hmf.orb.aidl;

import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.orb.aidl.client.ApiClient;

/* JADX INFO: loaded from: classes10.dex */
public interface DatagramTransport {

    public interface CallBack {
        void onCallback(int i, IMessageEntity iMessageEntity);
    }

    void post(ApiClient apiClient, CallBack callBack);

    void send(ApiClient apiClient, CallBack callBack);
}
