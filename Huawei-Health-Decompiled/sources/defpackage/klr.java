package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class klr {
    private byte[] b;
    private int c;
    private boolean d = false;
    private boolean e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14742a = true;

    public boolean b() {
        return this.d;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public int d() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public byte[] c() {
        byte[] bArr = this.b;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public void a(byte[] bArr) {
        this.b = bArr == null ? null : (byte[]) bArr.clone();
    }

    public boolean a() {
        return this.e;
    }

    public void e(boolean z) {
        this.e = z;
    }

    public boolean e() {
        return this.f14742a;
    }

    public void a(boolean z) {
        this.f14742a = z;
    }
}
