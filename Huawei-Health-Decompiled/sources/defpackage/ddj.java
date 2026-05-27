package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class ddj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f12187a;
    private int b;
    private int c;
    private int d;
    private String e;
    private float i;

    public void e(byte[] bArr) {
        this.f12187a = bArr == null ? null : (byte[]) bArr.clone();
    }

    public void e(int i) {
        this.d = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public String b() {
        return (String) dne.b(this.e);
    }

    public void c(String str) {
        this.e = (String) dne.b(str);
    }

    public void a(int i) {
        this.b = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public void b(int i) {
        this.c = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public void b(float f) {
        this.i = ((Float) dne.b(Float.valueOf(f))).floatValue();
    }

    public byte[] d() {
        int i = this.b;
        if (this.d == 1) {
            i |= 128;
        }
        int i2 = (int) (this.i * 10.0f);
        byte[] bArr = this.f12187a;
        return new byte[]{-37, 14, 9, bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], (byte) i, (byte) this.c, 0, (byte) (i2 & 255), (byte) ((i2 >> 8) & 255), -1, -1};
    }
}
