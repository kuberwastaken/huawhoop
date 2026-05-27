package ohos.ace.adapter.capability.bridge;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import ohos.ace.adapter.ALog;

/* JADX INFO: loaded from: classes8.dex */
public class BridgeBinaryCodec implements BridgeBaseCodec<Object> {
    private static volatile BridgeBinaryCodec INSTANCE;
    private static final Object INSTANCE_LOCK = new Object();

    public static BridgeBinaryCodec getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        synchronized (INSTANCE_LOCK) {
            if (INSTANCE != null) {
                return INSTANCE;
            }
            INSTANCE = new BridgeBinaryCodec();
            return INSTANCE;
        }
    }

    @Override // ohos.ace.adapter.capability.bridge.BridgeBaseCodec
    public ByteBuffer encodeData(Object obj) {
        ByteBuffer byteBufferAllocateDirect;
        synchronized (this) {
            ByteArrayOutputStreamExposed byteArrayOutputStreamExposed = new ByteArrayOutputStreamExposed();
            BridgeSerializer.writeData(byteArrayOutputStreamExposed, obj);
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(byteArrayOutputStreamExposed.size());
            byteBufferAllocateDirect.put(byteArrayOutputStreamExposed.buffer(), 0, byteArrayOutputStreamExposed.size());
        }
        return byteBufferAllocateDirect;
    }

    @Override // ohos.ace.adapter.capability.bridge.BridgeBaseCodec
    public Object decodeData(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object data = BridgeSerializer.readData(byteBuffer);
        if (!byteBuffer.hasRemaining()) {
            return data;
        }
        ALog.e("BridgeBinaryCodec", "Buffer not fully resolved");
        return null;
    }

    static class ByteArrayOutputStreamExposed extends ByteArrayOutputStream {
        private ByteArrayOutputStreamExposed() {
        }

        public byte[] buffer() {
            return this.buf;
        }
    }
}
