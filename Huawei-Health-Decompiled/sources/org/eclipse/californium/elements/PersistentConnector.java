package org.eclipse.californium.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes8.dex */
@Deprecated
public interface PersistentConnector {
    int loadConnections(InputStream inputStream, long j) throws IOException;

    int saveConnections(OutputStream outputStream, long j) throws IOException;
}
