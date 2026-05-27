package org.apache.commons.io.input;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes11.dex */
public class WindowsLineEndingInputStream extends InputStream {
    private boolean atEos;
    private boolean atSlashCr;
    private boolean atSlashLf;
    private final InputStream in;
    private boolean injectSlashLf;
    private final boolean lineFeedAtEndOfFile;

    public WindowsLineEndingInputStream(InputStream inputStream, boolean z) {
        this.in = inputStream;
        this.lineFeedAtEndOfFile = z;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        this.in.close();
    }

    private int handleEos() {
        if (!this.lineFeedAtEndOfFile) {
            return -1;
        }
        boolean z = this.atSlashLf;
        if (!z && !this.atSlashCr) {
            this.atSlashCr = true;
            return 13;
        }
        if (z) {
            return -1;
        }
        this.atSlashCr = false;
        this.atSlashLf = true;
        return 10;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        synchronized (this) {
            throw UnsupportedOperationExceptions.mark();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.atEos) {
            return handleEos();
        }
        if (this.injectSlashLf) {
            this.injectSlashLf = false;
            return 10;
        }
        boolean z = this.atSlashCr;
        int withUpdate = readWithUpdate();
        if (this.atEos) {
            return handleEos();
        }
        if (withUpdate != 10 || z) {
            return withUpdate;
        }
        this.injectSlashLf = true;
        return 13;
    }

    private int readWithUpdate() throws IOException {
        int i = this.in.read();
        boolean z = i == -1;
        this.atEos = z;
        if (z) {
            return i;
        }
        this.atSlashCr = i == 13;
        this.atSlashLf = i == 10;
        return i;
    }
}
