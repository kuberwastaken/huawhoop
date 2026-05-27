package defpackage;

import com.fasterxml.jackson.core.SerializableString;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes9.dex */
public class xi implements SerializableString, Serializable {
    private static final xc h = xc.d();
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected byte[] f19012a;
    protected char[] b;
    protected transient String c;
    protected byte[] d;
    protected final String e;

    public xi(String str) {
        if (str == null) {
            throw new IllegalStateException("Null String illegal for SerializedString");
        }
        this.e = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        this.c = objectInputStream.readUTF();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(this.e);
    }

    protected Object readResolve() {
        return new xi(this.c);
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public final String getValue() {
        return this.e;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public final int charLength() {
        return this.e.length();
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public final char[] asQuotedChars() {
        char[] cArr = this.b;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrB = h.b(this.e);
        this.b = cArrB;
        return cArrB;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public final byte[] asQuotedUTF8() {
        byte[] bArr = this.d;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArrC = h.c(this.e);
        this.d = bArrC;
        return bArrC;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public final byte[] asUnquotedUTF8() {
        byte[] bArr = this.f19012a;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArrA = h.a(this.e);
        this.f19012a = bArrA;
        return bArrA;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public int appendQuoted(char[] cArr, int i) {
        char[] cArrB = this.b;
        if (cArrB == null) {
            cArrB = h.b(this.e);
            this.b = cArrB;
        }
        int length = cArrB.length;
        if (i + length > cArr.length) {
            return -1;
        }
        System.arraycopy(cArrB, 0, cArr, i, length);
        return length;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public int appendQuotedUTF8(byte[] bArr, int i) {
        byte[] bArrC = this.d;
        if (bArrC == null) {
            bArrC = h.c(this.e);
            this.d = bArrC;
        }
        int length = bArrC.length;
        if (i + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArrC, 0, bArr, i, length);
        return length;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public int appendUnquoted(char[] cArr, int i) {
        String str = this.e;
        int length = str.length();
        if (i + length > cArr.length) {
            return -1;
        }
        str.getChars(0, length, cArr, i);
        return length;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public int appendUnquotedUTF8(byte[] bArr, int i) {
        byte[] bArrA = this.f19012a;
        if (bArrA == null) {
            bArrA = h.a(this.e);
            this.f19012a = bArrA;
        }
        int length = bArrA.length;
        if (i + length > bArr.length) {
            return -1;
        }
        System.arraycopy(bArrA, 0, bArr, i, length);
        return length;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public int writeQuotedUTF8(OutputStream outputStream) throws IOException {
        byte[] bArrC = this.d;
        if (bArrC == null) {
            bArrC = h.c(this.e);
            this.d = bArrC;
        }
        int length = bArrC.length;
        outputStream.write(bArrC, 0, length);
        return length;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public int writeUnquotedUTF8(OutputStream outputStream) throws IOException {
        byte[] bArrA = this.f19012a;
        if (bArrA == null) {
            bArrA = h.a(this.e);
            this.f19012a = bArrA;
        }
        int length = bArrA.length;
        outputStream.write(bArrA, 0, length);
        return length;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public int putQuotedUTF8(ByteBuffer byteBuffer) {
        byte[] bArrC = this.d;
        if (bArrC == null) {
            bArrC = h.c(this.e);
            this.d = bArrC;
        }
        int length = bArrC.length;
        if (length > byteBuffer.remaining()) {
            return -1;
        }
        byteBuffer.put(bArrC, 0, length);
        return length;
    }

    @Override // com.fasterxml.jackson.core.SerializableString
    public int putUnquotedUTF8(ByteBuffer byteBuffer) {
        byte[] bArrA = this.f19012a;
        if (bArrA == null) {
            bArrA = h.a(this.e);
            this.f19012a = bArrA;
        }
        int length = bArrA.length;
        if (length > byteBuffer.remaining()) {
            return -1;
        }
        byteBuffer.put(bArrA, 0, length);
        return length;
    }

    public final String toString() {
        return this.e;
    }

    public final int hashCode() {
        return this.e.hashCode();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return this.e.equals(((xi) obj).e);
    }
}
