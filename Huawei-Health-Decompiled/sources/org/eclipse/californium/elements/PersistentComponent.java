package org.eclipse.californium.elements;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes8.dex */
public interface PersistentComponent {
    String getLabel();

    int load(InputStream inputStream, long j) throws IOException;

    int save(OutputStream outputStream, long j) throws IOException;
}
