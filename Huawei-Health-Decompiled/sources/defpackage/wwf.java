package defpackage;

import com.huawei.wisesecurity.kfs.crypto.cipher.CipherAlg;

/* JADX INFO: loaded from: classes8.dex */
public class wwf {
    private CipherAlg b = CipherAlg.UNKNOWN;
    private byte[] c;
    private byte[] e;

    public byte[] c() {
        return wwv.d(this.c);
    }

    public void e(byte[] bArr) {
        this.c = wwv.d(bArr);
    }

    public byte[] e() {
        return wwv.d(this.e);
    }

    public void b(byte[] bArr) {
        this.e = wwv.d(bArr);
    }

    public CipherAlg a() {
        return this.b;
    }

    public void a(CipherAlg cipherAlg) {
        this.b = cipherAlg;
    }
}
