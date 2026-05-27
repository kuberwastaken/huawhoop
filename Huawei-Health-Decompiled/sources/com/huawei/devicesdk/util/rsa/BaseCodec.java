package com.huawei.devicesdk.util.rsa;

import defpackage.chu;
import defpackage.cit;
import defpackage.civ;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseCodec implements BinaryEncoder, BinaryDecoder {
    public static final String BASE_ROOT_INFO = "67CeEsCdM8UbcYpdKUEGhxRdwBmol2/q";
    private static final int DEFAULT_BUFFER_RESIZE_FACTOR = 2;
    private static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final int EOF = -1;
    protected static final int MASK_8BITS = 255;
    public static final int MIME_CHUNK_SIZE = 76;
    protected static final byte PAD = 61;
    private final int chunkSeparatorLength;
    private final int encodedBlockSize;
    protected final int lineLength;
    private final int unencodedBlockSize;

    protected abstract void decode(byte[] bArr, int i, int i2, e eVar);

    protected abstract void encode(byte[] bArr, int i, int i2, e eVar);

    protected int getDefaultBufferSize() {
        return 8192;
    }

    protected abstract boolean isInAlphabet(byte b);

    public BaseCodec(int i, int i2, int i3, int i4) {
        this.unencodedBlockSize = i;
        this.encodedBlockSize = i2;
        this.lineLength = (i3 <= 0 || i4 <= 0 || i2 == 0) ? 0 : (i3 / i2) * i2;
        this.chunkSeparatorLength = i4;
    }

    int available(e eVar) {
        if (eVar.d != null) {
            return eVar.i - eVar.f;
        }
        return 0;
    }

    private byte[] resizeBuffer(e eVar) {
        if (eVar.d == null) {
            eVar.d = new byte[getDefaultBufferSize()];
            eVar.i = 0;
            eVar.f = 0;
        } else {
            byte[] bArr = new byte[eVar.d.length * 2];
            System.arraycopy(eVar.d, 0, bArr, 0, eVar.d.length);
            eVar.d = bArr;
        }
        return eVar.d;
    }

    protected byte[] ensureBufferSize(int i, e eVar) {
        if (eVar.d == null || eVar.d.length < eVar.i + i) {
            return resizeBuffer(eVar);
        }
        return eVar.d;
    }

    int readResults(byte[] bArr, int i, int i2, e eVar) {
        if (eVar.d == null) {
            return eVar.e ? -1 : 0;
        }
        int iMin = Math.min(available(eVar), i2);
        System.arraycopy(eVar.d, eVar.f, bArr, i, iMin);
        eVar.f += iMin;
        if (eVar.f >= eVar.i) {
            eVar.d = null;
        }
        return iMin;
    }

    @Override // com.huawei.devicesdk.util.rsa.BinaryEncoder
    public byte[] encode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        e eVar = new e();
        encode(bArr, 0, bArr.length, eVar);
        encode(bArr, 0, -1, eVar);
        int i = eVar.i - eVar.f;
        byte[] bArr2 = new byte[i];
        readResults(bArr2, 0, i, eVar);
        return bArr2;
    }

    @Override // com.huawei.devicesdk.util.rsa.Encoder
    public Object encode(Object obj) throws civ {
        if (!(obj instanceof byte[])) {
            throw new civ("Parameter supplied to Base-N encode is not a byte[]");
        }
        return encode((byte[]) obj);
    }

    public String encodeToString(byte[] bArr) {
        return chu.a(encode(bArr));
    }

    @Override // com.huawei.devicesdk.util.rsa.Decoder
    public Object decode(Object obj) throws cit {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return decode((String) obj);
        }
        throw new cit("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    public byte[] decode(String str) {
        return decode(chu.b(str));
    }

    @Override // com.huawei.devicesdk.util.rsa.BinaryDecoder
    public byte[] decode(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        e eVar = new e();
        decode(bArr, 0, bArr.length, eVar);
        decode(bArr, 0, -1, eVar);
        int i = eVar.i;
        byte[] bArr2 = new byte[i];
        readResults(bArr2, 0, i, eVar);
        return bArr2;
    }

    protected boolean containsAlphabetOrPad(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b : bArr) {
            if (b == 61 || isInAlphabet(b)) {
                return true;
            }
        }
        return false;
    }

    public long getEncodedLength(byte[] bArr) {
        int i;
        if (bArr == null || (i = this.unencodedBlockSize) == 0) {
            return 0L;
        }
        long length = ((long) (((bArr.length + i) - 1) / i)) * ((long) this.encodedBlockSize);
        int i2 = this.lineLength;
        if (i2 <= 0) {
            return length;
        }
        long j = i2;
        return length + ((((j + length) - 1) / j) * ((long) this.chunkSeparatorLength));
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1992a;
        public int b;
        public int c;
        byte[] d;
        public boolean e;
        int f;
        public int i;

        e() {
        }
    }
}
