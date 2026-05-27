package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class dss {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12407a;
    private List<String> b;
    private String e;

    public String c() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public String e() {
        return this.f12407a;
    }

    public void e(String str) {
        this.f12407a = str;
    }

    public List<String> d() {
        return this.b;
    }

    public void a(List<String> list) {
        this.b = list;
    }

    public String toString() {
        return "UserLicenseInfo{url='" + this.e + "', userLicenseName='" + this.f12407a + "'}";
    }
}
