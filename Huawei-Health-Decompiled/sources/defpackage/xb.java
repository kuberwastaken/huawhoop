package defpackage;

import com.fasterxml.jackson.core.JsonEncoding;

/* JADX INFO: loaded from: classes9.dex */
public class xb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final yd f18993a;
    protected final boolean b;
    protected char[] c;
    protected JsonEncoding d;
    protected byte[] e;
    protected byte[] f;
    protected byte[] g;
    protected char[] h;
    protected final Object i;
    protected char[] j;

    public xb(yd ydVar, Object obj, boolean z) {
        this.f18993a = ydVar;
        this.i = obj;
        this.b = z;
    }

    public void e(JsonEncoding jsonEncoding) {
        this.d = jsonEncoding;
    }

    public Object j() {
        return this.i;
    }

    public JsonEncoding g() {
        return this.d;
    }

    public boolean h() {
        return this.b;
    }

    public yk f() {
        return new yk(this.f18993a);
    }

    public byte[] a() {
        e(this.g);
        byte[] bArrA = this.f18993a.a(0);
        this.g = bArrA;
        return bArrA;
    }

    public byte[] b() {
        e(this.f);
        byte[] bArrA = this.f18993a.a(1);
        this.f = bArrA;
        return bArrA;
    }

    public byte[] c() {
        e(this.e);
        byte[] bArrA = this.f18993a.a(3);
        this.e = bArrA;
        return bArrA;
    }

    public char[] d() {
        e((Object) this.h);
        char[] cArrC = this.f18993a.c(0);
        this.h = cArrC;
        return cArrC;
    }

    public char[] c(int i) {
        e((Object) this.h);
        char[] cArrA = this.f18993a.a(0, i);
        this.h = cArrA;
        return cArrA;
    }

    public char[] e() {
        e((Object) this.c);
        char[] cArrC = this.f18993a.c(1);
        this.c = cArrC;
        return cArrC;
    }

    public char[] e(int i) {
        e((Object) this.j);
        char[] cArrA = this.f18993a.a(3, i);
        this.j = cArrA;
        return cArrA;
    }

    public void b(byte[] bArr) {
        if (bArr != null) {
            e(bArr, this.g);
            this.g = null;
            this.f18993a.c(0, bArr);
        }
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            e(bArr, this.f);
            this.f = null;
            this.f18993a.c(1, bArr);
        }
    }

    public void d(byte[] bArr) {
        if (bArr != null) {
            e(bArr, this.e);
            this.e = null;
            this.f18993a.c(3, bArr);
        }
    }

    public void b(char[] cArr) {
        if (cArr != null) {
            d(cArr, this.h);
            this.h = null;
            this.f18993a.c(0, cArr);
        }
    }

    public void e(char[] cArr) {
        if (cArr != null) {
            d(cArr, this.c);
            this.c = null;
            this.f18993a.c(1, cArr);
        }
    }

    public void a(char[] cArr) {
        if (cArr != null) {
            d(cArr, this.j);
            this.j = null;
            this.f18993a.c(3, cArr);
        }
    }

    protected final void e(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    protected final void e(byte[] bArr, byte[] bArr2) {
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw i();
        }
    }

    protected final void d(char[] cArr, char[] cArr2) {
        if (cArr != cArr2 && cArr.length < cArr2.length) {
            throw i();
        }
    }

    private IllegalArgumentException i() {
        return new IllegalArgumentException("Trying to release buffer smaller than original");
    }
}
