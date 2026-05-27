package net.lingala.zip4j.io.inputstream;

import defpackage.xwz;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes11.dex */
public abstract class SplitFileInputStream extends InputStream {
    public abstract void prepareExtractionForFileHeader(xwz xwzVar) throws IOException;
}
