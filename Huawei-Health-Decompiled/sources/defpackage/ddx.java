package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class ddx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f12201a;
    private int b;

    public ddx(int i, byte[] bArr) {
        this.b = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
        this.f12201a = (byte[]) kqt.e(bArr);
    }

    public byte[] d() {
        return (byte[]) kqt.e(this.f12201a);
    }

    public int b() {
        return ((Integer) kqt.e(Integer.valueOf(this.b))).intValue();
    }
}
