package com.huawei.hms.network.embedded;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* JADX INFO: loaded from: classes10.dex */
public interface yb extends Closeable, Flushable {
    void close() throws IOException;

    @Override // java.io.Flushable
    void flush() throws IOException;

    ac timeout();

    void write(bb bbVar, long j) throws IOException;
}
