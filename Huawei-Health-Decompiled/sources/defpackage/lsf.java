package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class lsf {
    private int c = 0;
    private byte[] e = null;

    public int a() {
        return ((Integer) kqt.e(Integer.valueOf(this.c))).intValue();
    }

    public void e(int i) {
        this.c = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public byte[] d() {
        byte[] bArr = this.e;
        return bArr != null ? (byte[]) kqt.e((byte[]) bArr.clone()) : bArr;
    }

    public void e(byte[] bArr) {
        if (bArr != null) {
            this.e = (byte[]) kqt.e((byte[]) bArr.clone());
        }
    }
}
