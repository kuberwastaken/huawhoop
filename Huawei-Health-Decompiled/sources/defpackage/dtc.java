package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dtc {
    private long d = -1;
    private byte[] b = null;

    public long a() {
        return this.d;
    }

    public void e(long j) {
        this.d = j;
    }

    public byte[] d() {
        return this.b;
    }

    public void d(byte[] bArr) {
        this.b = bArr;
    }

    public String toString() {
        return "SamplePointInfo{mKey=" + this.d + ", mByteValue=" + chk.e(chj.b(this.b)) + '}';
    }
}
