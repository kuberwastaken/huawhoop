package com.huawei.hms.framework.network.restclient.websocket;

import com.huawei.hms.framework.network.restclient.hwhttp.Request;
import com.huawei.hms.framework.network.restclient.hwhttp.trans.ByteString;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes10.dex */
@Deprecated
public interface WebSocket {
    void cancel();

    boolean close(int i, @Nonnull String str);

    long queueSize();

    Request request();

    boolean send(ByteString byteString);

    boolean send(String str);
}
