package defpackage;

import org.eclipse.californium.scandium.dtls.ContentType;
import org.eclipse.californium.scandium.dtls.DTLSMessage;

/* JADX INFO: loaded from: classes8.dex */
public final class ygx implements DTLSMessage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f19313a;

    public ygx(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("data must not be null!");
        }
        this.f19313a = bArr;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public ContentType getContentType() {
        return ContentType.APPLICATION_DATA;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public String toString(int i) {
        return ygp.a(i) + "Application Data: " + ygp.b(this.f19313a, (char) 0, 32) + ygp.b();
    }

    public String toString() {
        return toString();
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public int size() {
        return this.f19313a.length;
    }

    @Override // org.eclipse.californium.scandium.dtls.DTLSMessage
    public byte[] toByteArray() {
        return this.f19313a;
    }

    public static DTLSMessage d(byte[] bArr) {
        return new ygx(bArr);
    }

    public byte[] b() {
        return this.f19313a;
    }
}
