package defpackage;

import com.huawei.wisesecurity.kfs.crypto.signer.SignAlg;

/* JADX INFO: loaded from: classes8.dex */
public class wwo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SignAlg f18957a = SignAlg.UNKNOWN;
    private byte[] c;
    private byte[] e;

    public byte[] e() {
        return wwv.d(this.c);
    }

    public void d(byte[] bArr) {
        this.c = wwv.d(bArr);
    }

    public byte[] a() {
        return wwv.d(this.e);
    }

    public void c(byte[] bArr) {
        this.e = wwv.d(bArr);
    }

    public SignAlg b() {
        return this.f18957a;
    }

    public void a(SignAlg signAlg) {
        this.f18957a = signAlg;
    }
}
