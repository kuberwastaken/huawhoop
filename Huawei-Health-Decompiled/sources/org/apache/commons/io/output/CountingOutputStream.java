package org.apache.commons.io.output;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes11.dex */
public class CountingOutputStream extends ProxyOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // org.apache.commons.io.output.ProxyOutputStream
    protected void beforeWrite(int i) {
        synchronized (this) {
            this.count += (long) i;
        }
    }

    public long getByteCount() {
        long j;
        synchronized (this) {
            j = this.count;
        }
        return j;
    }

    public int getCount() {
        long byteCount = getByteCount();
        if (byteCount <= 2147483647L) {
            return (int) byteCount;
        }
        throw new ArithmeticException("The byte count " + byteCount + " is too large to be converted to an int");
    }

    public long resetByteCount() {
        long j;
        synchronized (this) {
            j = this.count;
            this.count = 0L;
        }
        return j;
    }

    public int resetCount() {
        long jResetByteCount = resetByteCount();
        if (jResetByteCount <= 2147483647L) {
            return (int) jResetByteCount;
        }
        throw new ArithmeticException("The byte count " + jResetByteCount + " is too large to be converted to an int");
    }
}
