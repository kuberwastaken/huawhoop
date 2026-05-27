package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dpc {
    private String b;
    private String d;
    private String e;

    public dpc(String str, String str2, String str3) {
        this.b = str;
        this.e = str2;
        this.d = str3;
    }

    public String e() {
        return this.d;
    }

    public String d() {
        return this.b;
    }

    public String c() {
        return this.e;
    }

    public String toString() {
        return "DeviceModeInfo{mDeviceModel='" + this.b + ", mDeviceId='" + this.e + ", mDeviceType='" + this.d + '}';
    }
}
