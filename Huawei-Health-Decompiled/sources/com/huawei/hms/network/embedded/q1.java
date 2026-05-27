package com.huawei.hms.network.embedded;

import com.huawei.hms.network.httpclient.ResponseBody;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class q1 extends InputStream {
    public static final String h = "CacheInputStream";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f5615a;
    public final o1 b;
    public int f;
    public byte[] c = new byte[8192];
    public int d = 0;
    public int e = 0;
    public int g = 0;

    @Override // java.io.InputStream
    public int read() throws IOException {
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.b == null) {
            return this.f5615a.read(bArr, 0, bArr.length);
        }
        int i = this.f5615a.read(bArr, 0, bArr.length);
        this.f = i;
        if (i == -1) {
            int i2 = this.d;
            if (i2 > 0) {
                write(y1.encryptBody(Arrays.copyOfRange(this.c, 0, i2)));
                this.d = 0;
            }
            return this.f;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, i);
        int i3 = this.g + this.f;
        this.g = i3;
        if (i3 > 16777216) {
            this.b.abort();
            this.g = 0;
        }
        int i4 = this.d;
        int i5 = 8192 - i4;
        this.e = i5;
        int i6 = this.f;
        if (i6 < i5) {
            System.arraycopy(bArrCopyOfRange, 0, this.c, i4, i6);
            this.d += this.f;
        } else {
            System.arraycopy(bArrCopyOfRange, 0, this.c, i4, i5);
            write(y1.encryptBody(this.c));
            int i7 = this.f;
            int i8 = this.e;
            int i9 = i7 - i8;
            System.arraycopy(bArrCopyOfRange, i8, this.c, 0, i9);
            this.d = i9;
        }
        return this.f;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5615a.close();
        o1 o1Var = this.b;
        if (o1Var != null) {
            o1Var.close();
        }
    }

    private void write(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        try {
            this.b.write(bArr);
        } catch (IOException e) {
            this.b.abort();
            throw e;
        }
    }

    public q1(ResponseBody responseBody, o1 o1Var) {
        if (responseBody == null || responseBody.getInputStream() == null) {
            throw new IllegalArgumentException("ResponseBody delegrate == null");
        }
        this.f5615a = responseBody.getInputStream();
        this.b = o1Var;
    }
}
