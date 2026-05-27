package defpackage;

import com.google.common.primitives.UnsignedBytes;
import java.io.Serializable;
import okio.Utf8;

/* JADX INFO: loaded from: classes4.dex */
public class dyh implements Serializable {
    private static final long serialVersionUID = -204623211515444595L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private dye f12487a;
    private int b;
    private int c;
    private boolean d = true;
    private int e;
    private int i;

    public dyh(byte[] bArr) {
        a(bArr);
    }

    private void a(byte[] bArr) {
        byte b;
        Boolean boolB;
        Boolean boolB2;
        if (bArr == null || bArr.length <= 9 || (boolB = dyi.b((b = bArr[2]), 7)) == null || (boolB2 = dyi.b(b, 6)) == null) {
            return;
        }
        if (boolB.booleanValue()) {
            this.c = ((bArr[3] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[4] & UnsignedBytes.MAX_VALUE);
            return;
        }
        byte b2 = (byte) (b & Utf8.REPLACEMENT_BYTE);
        byte b3 = bArr[5];
        byte b4 = bArr[6];
        byte b5 = bArr[7];
        byte b6 = bArr[8];
        byte b7 = bArr[9];
        byte b8 = bArr[10];
        if (b2 != 0) {
            this.f12487a = new dye(b2);
            return;
        }
        if (boolB2.booleanValue()) {
            this.i = ((b3 & UnsignedBytes.MAX_VALUE) << 8) + (b4 & UnsignedBytes.MAX_VALUE);
            this.e = ((b5 & UnsignedBytes.MAX_VALUE) << 8) + (b6 & UnsignedBytes.MAX_VALUE);
            this.b = ((b7 & UnsignedBytes.MAX_VALUE) << 8) + (b8 & UnsignedBytes.MAX_VALUE);
            this.d = false;
            return;
        }
        this.c = ((bArr[3] & UnsignedBytes.MAX_VALUE) << 8) + (bArr[4] & UnsignedBytes.MAX_VALUE);
    }

    public int c() {
        return this.i;
    }

    public int b() {
        return this.e;
    }

    public int e() {
        return this.b;
    }

    public int d() {
        return this.c;
    }

    public boolean g() {
        return this.d;
    }

    public dye a() {
        return this.f12487a;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("pressure:" + this.c).append(System.lineSeparator());
        stringBuffer.append("dbpValue:" + this.e).append(System.lineSeparator());
        stringBuffer.append("hhValue:" + this.b).append(System.lineSeparator());
        stringBuffer.append("sbpValue:" + this.i).append(System.lineSeparator());
        return stringBuffer.toString();
    }
}
