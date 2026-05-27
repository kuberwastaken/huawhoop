package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class ycn extends ygc {
    public static final ycn b = new ycn(ygc.d);

    public ycn(byte[] bArr) {
        this(bArr, true);
    }

    private ycn(byte[] bArr, boolean z) {
        super(bArr, 8, z);
    }

    @Override // defpackage.ygc
    public String toString() {
        return "Token=" + d();
    }

    public static ycn b(byte[] bArr) {
        return new ycn(bArr, false);
    }
}
