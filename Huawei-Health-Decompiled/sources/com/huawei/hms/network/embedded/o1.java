package com.huawei.hms.network.embedded;

import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public interface o1 {
    void abort();

    void close() throws IOException;

    void write(byte[] bArr) throws IOException;
}
