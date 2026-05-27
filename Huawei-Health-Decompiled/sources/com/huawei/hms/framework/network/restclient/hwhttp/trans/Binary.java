package com.huawei.hms.framework.network.restclient.hwhttp.trans;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface Binary {
    long getLength();

    void onWriteBinary(OutputStream outputStream) throws IOException;
}
