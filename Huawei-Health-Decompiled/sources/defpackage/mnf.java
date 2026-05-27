package defpackage;

import com.huawei.hwnetworkmodel.TrafficMonitoringService;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class mnf extends InputStream {
    private InputStream d;
    private final Object e = new Object();

    public mnf(InputStream inputStream) {
        this.d = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        InputStream inputStream = this.d;
        if (inputStream == null) {
            throw new IOException("read no param on a null InputStream");
        }
        int i = inputStream.read();
        if (i > 0) {
            TrafficMonitoringService.d(i);
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        InputStream inputStream = this.d;
        if (inputStream == null) {
            throw new IOException("read one param on a null InputStream");
        }
        int i = inputStream.read(bArr);
        if (i > 0) {
            TrafficMonitoringService.d(i);
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        InputStream inputStream = this.d;
        if (inputStream == null) {
            throw new IOException("read three params on a null InputStream");
        }
        int i3 = inputStream.read(bArr, i, i2);
        if (i3 > 0) {
            TrafficMonitoringService.d(i3);
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.d;
        if (inputStream == null) {
            throw new IOException("available on a null InputStream");
        }
        return inputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.d;
        if (inputStream == null) {
            throw new IOException("close on a null InputStream");
        }
        inputStream.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        InputStream inputStream = this.d;
        if (inputStream == null) {
            return;
        }
        inputStream.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        InputStream inputStream = this.d;
        if (inputStream == null) {
            return false;
        }
        return inputStream.markSupported();
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        synchronized (this.e) {
            InputStream inputStream = this.d;
            if (inputStream == null) {
                throw new IOException("reset on a null InputStream");
            }
            inputStream.reset();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        InputStream inputStream = this.d;
        if (inputStream == null) {
            throw new IOException("skip on a null InputStream");
        }
        return inputStream.skip(j);
    }
}
