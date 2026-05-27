package com.huawei.hms.network.embedded;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes10.dex */
public class b implements Closeable {
    public static final byte f = 13;
    public static final byte g = 10;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InputStream f5353a;
    public final Charset b;
    public byte[] c;
    public int d;
    public int e;

    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String t() throws java.io.IOException {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f5353a
            monitor-enter(r0)
            byte[] r1 = r7.c     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L7f
            int r1 = r7.d     // Catch: java.lang.Throwable -> L87
            int r2 = r7.e     // Catch: java.lang.Throwable -> L87
            if (r1 < r2) goto L10
            r7.u()     // Catch: java.lang.Throwable -> L87
        L10:
            int r1 = r7.d     // Catch: java.lang.Throwable -> L87
        L12:
            int r2 = r7.e     // Catch: java.lang.Throwable -> L87
            r3 = 10
            if (r1 == r2) goto L41
            byte[] r2 = r7.c     // Catch: java.lang.Throwable -> L87
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L87
            if (r4 != r3) goto L3e
            int r3 = r7.d     // Catch: java.lang.Throwable -> L87
            if (r1 == r3) goto L2b
            int r4 = r1 + (-1)
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L87
            r6 = 13
            if (r5 != r6) goto L2b
            goto L2c
        L2b:
            r4 = r1
        L2c:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L87
            int r4 = r4 - r3
            java.nio.charset.Charset r6 = r7.b     // Catch: java.lang.Throwable -> L87
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L87
            r5.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L87
            int r1 = r1 + 1
            r7.d = r1     // Catch: java.lang.Throwable -> L87
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            return r5
        L3e:
            int r1 = r1 + 1
            goto L12
        L41:
            com.huawei.hms.network.embedded.b$a r1 = new com.huawei.hms.network.embedded.b$a     // Catch: java.lang.Throwable -> L87
            int r2 = r7.e     // Catch: java.lang.Throwable -> L87
            int r4 = r7.d     // Catch: java.lang.Throwable -> L87
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
        L4d:
            byte[] r2 = r7.c     // Catch: java.lang.Throwable -> L87
            int r4 = r7.d     // Catch: java.lang.Throwable -> L87
            int r5 = r7.e     // Catch: java.lang.Throwable -> L87
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L87
            r2 = -1
            r7.e = r2     // Catch: java.lang.Throwable -> L87
            r7.u()     // Catch: java.lang.Throwable -> L87
            int r2 = r7.d     // Catch: java.lang.Throwable -> L87
        L5f:
            int r4 = r7.e     // Catch: java.lang.Throwable -> L87
            if (r2 == r4) goto L4d
            byte[] r4 = r7.c     // Catch: java.lang.Throwable -> L87
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L87
            if (r5 != r3) goto L7c
            int r3 = r7.d     // Catch: java.lang.Throwable -> L87
            if (r2 == r3) goto L72
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L87
        L72:
            int r2 = r2 + 1
            r7.d = r2     // Catch: java.lang.Throwable -> L87
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L87
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            return r1
        L7c:
            int r2 = r2 + 1
            goto L5f
        L7f:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L87
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L87
            throw r1     // Catch: java.lang.Throwable -> L87
        L87:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.b.t():java.lang.String");
    }

    public boolean s() {
        return this.e == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.f5353a) {
            if (this.c != null) {
                this.c = null;
                this.f5353a.close();
            }
        }
    }

    private void u() throws IOException {
        InputStream inputStream = this.f5353a;
        byte[] bArr = this.c;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.d = 0;
        this.e = i;
    }

    public class a extends ByteArrayOutputStream {
        /* JADX WARN: Removed duplicated region for block: B:7:0x000f  */
        @Override // java.io.ByteArrayOutputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String toString() {
            /*
                r5 = this;
                int r0 = r5.count
                if (r0 <= 0) goto Lf
                byte[] r1 = r5.buf
                int r0 = r0 + (-1)
                r1 = r1[r0]
                r2 = 13
                if (r1 != r2) goto Lf
                goto L11
            Lf:
                int r0 = r5.count
            L11:
                java.lang.String r1 = new java.lang.String     // Catch: java.io.UnsupportedEncodingException -> L24
                byte[] r2 = r5.buf     // Catch: java.io.UnsupportedEncodingException -> L24
                com.huawei.hms.network.embedded.b r3 = com.huawei.hms.network.embedded.b.this     // Catch: java.io.UnsupportedEncodingException -> L24
                java.nio.charset.Charset r3 = com.huawei.hms.network.embedded.b.a(r3)     // Catch: java.io.UnsupportedEncodingException -> L24
                java.lang.String r3 = r3.name()     // Catch: java.io.UnsupportedEncodingException -> L24
                r4 = 0
                r1.<init>(r2, r4, r0, r3)     // Catch: java.io.UnsupportedEncodingException -> L24
                return r1
            L24:
                r0 = move-exception
                java.lang.AssertionError r1 = new java.lang.AssertionError
                r1.<init>(r0)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.network.embedded.b.a.toString():java.lang.String");
        }

        public a(int i) {
            super(i);
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f5383a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f5353a = inputStream;
        this.b = charset;
        this.c = new byte[i];
    }
}
