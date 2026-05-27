package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class lca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15065a;
    private String b;
    private String e;

    public lca(String str, String str2, String str3) {
        this.e = str;
        this.b = str2;
        this.f15065a = str3;
    }

    public String e() {
        return this.f15065a;
    }

    public String a() {
        return this.e;
    }

    public String c() {
        return this.b;
    }

    public String toString() {
        return "DeviceModeInfo{mDeviceModel='" + this.e + ", mDeviceId='" + this.b + ", mDeviceType='" + this.f15065a + '}';
    }
}
