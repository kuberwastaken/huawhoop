package com.huawei.hms.network.embedded;

import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.network.httpclient.RequestBody;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import org.chromium.net.BidirectionalStream;

/* JADX INFO: loaded from: classes10.dex */
public class b2 extends OutputStream {
    public static final String d = "CronetOutputStream";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BidirectionalStream f5357a;
    public final RequestBody b;
    public LinkedBlockingQueue<Object> c;

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(i2);
            byteBufferAllocateDirect.put(bArr, i, i2).flip();
            this.f5357a.write(byteBufferAllocateDirect, this.b.endOfStream());
            this.f5357a.flush();
            this.c.put(Integer.valueOf(i2));
        } catch (IllegalArgumentException | InterruptedException unused) {
            Logger.w("CronetOutputStream", "stream writing exception or queue put exception");
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(StringUtils.getBytes(String.valueOf(i)));
    }

    public b2(BidirectionalStream bidirectionalStream, RequestBody requestBody, LinkedBlockingQueue<Object> linkedBlockingQueue) {
        this.f5357a = bidirectionalStream;
        this.b = requestBody;
        this.c = linkedBlockingQueue;
    }
}
