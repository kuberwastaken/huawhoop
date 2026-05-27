package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class kpw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f14830a;

    @SerializedName("mIcon")
    private byte[] b;
    private String c;

    @SerializedName("mICCID")
    private String d;
    private int e;

    @SerializedName("mProfieName")
    private String f;
    private String g;
    private byte[] i;

    @SerializedName("mSPN")
    private String j;

    public String b() {
        return (String) kqt.e(this.d);
    }

    public void c(String str) {
        this.d = (String) kqt.e(str);
    }

    public String e() {
        return (String) kqt.e(this.j);
    }

    public void g(String str) {
        this.j = (String) kqt.e(str);
    }

    public String c() {
        return (String) kqt.e(this.f);
    }

    public void a(String str) {
        this.f = (String) kqt.e(str);
    }

    public void b(String str) {
        this.f14830a = (String) kqt.e(str);
    }

    public void a(int i) {
        this.e = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public byte[] a() {
        byte[] bArr = this.b;
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public void d(byte[] bArr) {
        if (bArr == null) {
            this.b = null;
        } else {
            this.b = (byte[]) bArr.clone();
        }
    }

    public void e(String str) {
        this.c = (String) kqt.e(str);
    }

    public void d(String str) {
        this.g = (String) kqt.e(str);
    }

    public byte[] d() {
        return (byte[]) kqt.e(this.i);
    }

    public void a(byte[] bArr) {
        this.i = (byte[]) kqt.e(bArr);
    }

    public String toString() {
        return "EmbeddedSimProfile{mIccid='" + this.d + "', mSpn='" + this.j + "', mProfileName='" + this.f + "', mProfileClass='" + this.f14830a + "', mIconType='" + this.e + "', mConfigurationInfo='" + this.c + "', mProfileOwner='" + this.g + "'}";
    }
}
