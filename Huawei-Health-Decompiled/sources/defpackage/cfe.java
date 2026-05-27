package defpackage;

import health.compact.a.LogUtil;

/* JADX INFO: loaded from: classes3.dex */
public class cfe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f624a;
    private int c;
    private byte[] d;
    private long e;

    public int c() {
        return this.f624a;
    }

    public void e(int i) {
        this.f624a = i;
    }

    public byte[] a() {
        byte[] bArr = this.d;
        if (bArr != null) {
            return bArr;
        }
        LogUtil.b("getHiChainData", "mHiChainData is null.");
        return new byte[0];
    }

    public void c(byte[] bArr) {
        this.d = bArr;
    }

    public long e() {
        return this.e;
    }

    public void d(long j) {
        this.e = j;
    }

    public int d() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }
}
