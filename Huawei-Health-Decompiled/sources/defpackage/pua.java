package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class pua extends puc {
    private static final long serialVersionUID = -1573149602936045007L;
    private String b;
    private String c;
    private String e;

    public pua(String str, String str2, String str3) {
        this.e = str;
        this.c = str2;
        this.b = str3;
    }

    public String a() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public String c() {
        return this.c;
    }

    public String e() {
        return this.b;
    }

    @Override // defpackage.puc
    public String toString() {
        return "UrlPlaceholder{mUrl='" + this.e + "', mFlag='" + this.c + "', mBranchId='" + this.b + "', mValue='" + this.d + "', mPlaceholderType=" + this.f16881a + '}';
    }
}
