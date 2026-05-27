package defpackage;

import android.text.TextUtils;
import health.compact.a.LogUtil;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes5.dex */
public class klk {
    private static klk d;
    private static final Object e = new Object();

    public static klk b() {
        klk klkVar;
        synchronized (e) {
            if (d == null) {
                d = new klk();
            }
            klkVar = d;
        }
        return klkVar;
    }

    public kkz d(byte[] bArr) {
        LogUtil.a("ParseDeviceLocalName", "enter parseBroadcastData");
        if (bArr == null) {
            return new kkz(null, 0);
        }
        return e(bArr);
    }

    private kkz e(byte[] bArr) {
        byte b;
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        String str = null;
        int i = 0;
        while (byteBufferOrder.remaining() > 2 && (b = byteBufferOrder.get()) > 0) {
            byte b2 = byteBufferOrder.get();
            if (b2 != 1) {
                if (b2 != 9) {
                    int iPosition = (byteBufferOrder.position() + b) - 1;
                    if (iPosition <= byteBufferOrder.limit() && iPosition >= 0) {
                        byteBufferOrder.position(iPosition);
                    }
                } else {
                    int i2 = b - 1;
                    if (i2 > 0) {
                        byte[] bArr2 = new byte[i2];
                        if (i2 > byteBufferOrder.remaining()) {
                            LogUtil.d("ParseDeviceLocalName", "parseBroadcastData BufferUnderflowException");
                        } else {
                            byteBufferOrder.get(bArr2);
                            try {
                                str = new String(bArr2, "utf-8");
                            } catch (UnsupportedEncodingException unused) {
                                LogUtil.d("ParseDeviceLocalName", "parseBroadcastData UnsupportedEncodingException");
                            }
                        }
                    }
                }
            } else if ((byteBufferOrder.get() & 4) == 0) {
                i = 3;
            }
            if (!TextUtils.isEmpty(str)) {
                break;
            }
        }
        return new kkz(str, i);
    }
}
