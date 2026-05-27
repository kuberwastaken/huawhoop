package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dcg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12161a;
    private int b;
    private int c;
    private int d;
    private byte[] e;

    public int b() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public int e() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int c() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public byte[] a() {
        byte[] bArr = this.e;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public void e(byte[] bArr) {
        if (bArr != null) {
            this.e = (byte[]) bArr.clone();
        }
    }

    public int d() {
        return this.f12161a;
    }

    public void e(int i) {
        this.f12161a = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("WspFileCommand{mServiceId=");
        stringBuffer.append(dte.a(this.b));
        stringBuffer.append(", mCommandId=");
        stringBuffer.append(dte.a(this.d));
        stringBuffer.append(", mDataLength=");
        stringBuffer.append(this.c);
        stringBuffer.append(", mDataContents=");
        stringBuffer.append(dte.b(this.e));
        stringBuffer.append(", mErrorCode=");
        stringBuffer.append(this.f12161a);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
