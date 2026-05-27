package defpackage;

import health.compact.a.util.LogUtil;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes6.dex */
public class ljf {
    public static byte[] c(byte[] bArr, lji ljiVar) {
        byte[] bArrF = ljiVar.f();
        if (bArrF == null || bArrF.length == 0) {
            LogUtil.c("BtProxyCommandUtil", "responseData is null");
            return bArr;
        }
        byte[] bArrG = dte.g(9);
        byte[] bArrD = dte.d(bArrF.length);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length + bArrG.length + bArrD.length + bArrF.length);
        byteBufferAllocate.put(bArr).put(bArrG).put(bArrD).put(bArrF);
        return byteBufferAllocate.array();
    }
}
