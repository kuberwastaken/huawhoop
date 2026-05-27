package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dcv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f12174a;
    private int b;
    private int c;
    private byte[] d;
    private int e;

    public int a() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int d() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int e() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public byte[] b() {
        byte[] bArr = this.d;
        return bArr != null ? (byte[]) bArr.clone() : new byte[0];
    }

    public void e(byte[] bArr) {
        if (bArr != null) {
            this.d = (byte[]) bArr.clone();
        } else {
            this.d = null;
        }
    }

    public byte c() {
        return this.f12174a;
    }

    public void b(byte b) {
        this.f12174a = b;
    }
}
