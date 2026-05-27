package defpackage;

import defpackage.ygh;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: classes8.dex */
public final class ygg extends ygh {
    private int b;
    private byte e;

    public ygg(byte[] bArr) {
        this(bArr, true);
    }

    public ygg(byte[] bArr, boolean z) {
        this(z ? Arrays.copyOf(bArr, bArr.length) : bArr, 0, bArr.length);
    }

    public ygg(byte[] bArr, int i, int i2) {
        this(new ygh.a(bArr, i, i2));
    }

    public ygg(ByteArrayInputStream byteArrayInputStream) {
        super(byteArrayInputStream);
        this.e = this.f19295a;
        this.b = this.d;
    }

    public void c() {
        this.e = this.f19295a;
        this.b = this.d;
        this.c.mark(0);
    }

    public void f() {
        try {
            this.c.reset();
        } catch (IOException unused) {
        }
        this.f19295a = this.e;
        this.d = this.b;
    }

    @Override // defpackage.ygh
    public void e() {
        try {
            this.c.skip(this.c.available());
        } catch (IOException unused) {
        }
        super.e();
    }

    @Override // defpackage.ygh
    public byte[] d(int i) {
        int iJ = j();
        if (i < 0) {
            i = iJ;
        } else if (i > iJ) {
            throw new IllegalArgumentException("requested " + i + " bytes exceeds available " + iJ + " bytes.");
        }
        return super.d(i);
    }

    public byte[] h() {
        return d(-1);
    }

    public void c(String str) {
        int iA = a();
        if (iA <= 0) {
            return;
        }
        throw new IllegalArgumentException(str + " not finished! " + iA + " bits left.");
    }

    public boolean d() {
        return j() > 0;
    }

    public boolean f(int i) {
        return j() >= i;
    }

    public int a() {
        return (j() * 8) + this.d + 1;
    }

    private int j() {
        try {
            return this.c.available();
        } catch (IOException unused) {
            return -1;
        }
    }
}
