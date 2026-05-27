package defpackage;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes9.dex */
public class yd {
    private static final int[] b = {8000, 8000, 2000, 2000};
    private static final int[] c = {4000, 4000, 200, 200};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final AtomicReferenceArray<byte[]> f19247a;
    protected final AtomicReferenceArray<char[]> e;

    public yd() {
        this(4, 4);
    }

    protected yd(int i, int i2) {
        this.f19247a = new AtomicReferenceArray<>(i);
        this.e = new AtomicReferenceArray<>(i2);
    }

    public final byte[] a(int i) {
        return b(i, 0);
    }

    public byte[] b(int i, int i2) {
        int iD = d(i);
        if (i2 < iD) {
            i2 = iD;
        }
        byte[] andSet = this.f19247a.getAndSet(i, null);
        return (andSet == null || andSet.length < i2) ? b(i2) : andSet;
    }

    public void c(int i, byte[] bArr) {
        this.f19247a.set(i, bArr);
    }

    public final char[] c(int i) {
        return a(i, 0);
    }

    public char[] a(int i, int i2) {
        int iH = h(i);
        if (i2 < iH) {
            i2 = iH;
        }
        char[] andSet = this.e.getAndSet(i, null);
        return (andSet == null || andSet.length < i2) ? e(i2) : andSet;
    }

    public void c(int i, char[] cArr) {
        this.e.set(i, cArr);
    }

    protected int d(int i) {
        return b[i];
    }

    protected int h(int i) {
        return c[i];
    }

    protected byte[] b(int i) {
        return new byte[i];
    }

    protected char[] e(int i) {
        return new char[i];
    }
}
