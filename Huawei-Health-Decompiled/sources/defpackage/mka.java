package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class mka {
    private int b;
    private String c;
    private String d;

    public mka(String str, int i, String str2) {
        this.c = str;
        this.b = i;
        this.d = str2;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.d;
    }

    public String toString() {
        return "QrInfoReq{qrCode='" + this.c + "', qrSiteId=" + this.b + ", qrCodeSource='" + this.d + "'}";
    }
}
