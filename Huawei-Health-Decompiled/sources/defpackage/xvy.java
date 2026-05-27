package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class xvy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected byte[] f19167a;
    protected String b;
    protected byte[] c;
    protected String d;
    protected int e;

    public xvy() {
        this.d = null;
        this.b = "UTF-8";
        this.f19167a = null;
        this.e = 1000;
        this.c = null;
    }

    public xvy(String str, String str2, byte[] bArr, int i) {
        this(str, str2, bArr, i, null);
    }

    public xvy(String str, String str2, byte[] bArr, int i, byte[] bArr2) {
        this.d = str;
        this.b = str2;
        this.f19167a = bArr;
        this.e = i;
        this.c = bArr2;
    }

    public int b() {
        return this.e;
    }

    public byte[] c() {
        return this.f19167a;
    }

    public String d() {
        return this.d;
    }
}
