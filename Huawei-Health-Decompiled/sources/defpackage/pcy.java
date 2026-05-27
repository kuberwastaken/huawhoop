package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes11.dex */
public class pcy {
    public static FloatBuffer b(float[] fArr) {
        if (fArr == null) {
            pcj.b("ArrayToBufferHelper", "floatArrayToBuffer arrays should not be null.");
            throw new RuntimeException("ArrayToBufferHelper floatArrayToBuffer arrays should not be null");
        }
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }
}
