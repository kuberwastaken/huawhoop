package defpackage;

import com.huawei.networkclient.ProgressListener;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes11.dex */
public class nbg extends InputStream {
    private ProgressListener b;
    private long c;
    private InputStream d;
    private long e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f15995a = 0;

    public nbg(InputStream inputStream, long j, ProgressListener progressListener) {
        this.d = inputStream;
        this.b = progressListener;
        this.c = j;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        return this.d.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.d.read(bArr, i, i2);
        long j = this.e + (i3 != -1 ? i3 : 0L);
        this.e = j;
        if (i3 == -1) {
            this.b.onProgress(j, this.c, true);
        } else {
            long j2 = this.c;
            if (j2 <= 1048576 || j - this.f15995a >= 1048576) {
                this.b.onProgress(j, j2, false);
                this.f15995a = this.e;
            }
        }
        return i3;
    }
}
