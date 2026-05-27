package net.lingala.zip4j.io.outputstream;

import java.io.IOException;

/* JADX INFO: loaded from: classes8.dex */
public interface OutputStreamWithSplitZipSupport {
    int getCurrentSplitFileCounter();

    long getFilePointer() throws IOException;
}
