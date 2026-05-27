package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes10.dex */
public class dzv implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12498a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private int h;

    public void e(int i) {
        this.h = i;
    }

    public void i(String str) {
        this.f = str;
    }

    public void c(String str) {
        this.e = str;
    }

    public void a(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.b = str;
    }

    public void b(String str) {
        this.f12498a = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public String toString() {
        return "NemoDeviceInfo{deviceType=" + this.h + ", deviceVersion='" + this.f + "', deviceSoftVersion='" + this.e + "', deviceSn='" + this.c + "', deviceModel='" + this.b + "', deviceOtaPackageName='" + this.f12498a + "', deviceSubModelId='" + this.d + "'}";
    }
}
