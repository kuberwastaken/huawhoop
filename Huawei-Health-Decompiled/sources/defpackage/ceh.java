package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class ceh {
    private int b;
    private byte[] d;

    public byte[] a() {
        byte[] bArr = this.d;
        return bArr != null ? bArr : new byte[0];
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.d = bArr;
        }
    }

    public int b() {
        return this.b;
    }

    public void e(int i) {
        this.b = i;
    }
}
