package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12218a;
    private byte[] b;
    private String c;

    public dga(byte[] bArr, String str, String str2) {
        if (bArr == null) {
            this.b = null;
        } else {
            this.b = (byte[]) bArr.clone();
        }
        this.f12218a = str;
        this.c = str2;
    }

    public byte[] d() {
        byte[] bArr = this.b;
        if (bArr != null) {
            return (byte[]) bArr.clone();
        }
        return null;
    }

    public String e() {
        return this.c;
    }

    public String c() {
        return this.f12218a;
    }
}
