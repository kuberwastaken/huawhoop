package defpackage;

import android.text.TextUtils;
import health.compact.a.LogUtil;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes10.dex */
public class cep {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static cep f615a;
    private static final Object d = new Object();

    public static cep b() {
        cep cepVar;
        synchronized (d) {
            if (f615a == null) {
                f615a = new cep();
            }
            cepVar = f615a;
        }
        return cepVar;
    }

    public cdz c(byte[] bArr) {
        LogUtil.a("ParseDeviceLocalName", "enter parseBroadcastData");
        if (bArr == null) {
            return new cdz(null, 0);
        }
        return b(bArr);
    }

    private cdz b(byte[] bArr) {
        byte b;
        String str = null;
        if (bArr == null) {
            return null;
        }
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
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
                            LogUtil.b("ParseDeviceLocalName", "parseBroadcastData BufferUnderflowException");
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
        return new cdz(str, i);
    }
}
