package defpackage;

import com.huawei.pluginmgr.hwwear.bean.DeviceDownloadSourceInfo;

/* JADX INFO: loaded from: classes.dex */
public class oea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16315a;
    private String b;
    private oed c;
    private DeviceDownloadSourceInfo d;
    private String e;
    private String j;

    public oea() {
    }

    public oea(String str, String str2, String str3, oed oedVar) {
        this.e = str;
        this.j = str2;
        this.f16315a = str3;
        this.c = oedVar;
    }

    public String c() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }

    public void a(String str) {
        this.e = str;
    }

    public String a() {
        return this.e;
    }

    public String f() {
        return this.j;
    }

    public oed b() {
        return this.c;
    }

    public String e() {
        return this.f16315a;
    }

    public void c(String str) {
        this.f16315a = str;
    }

    public DeviceDownloadSourceInfo d() {
        return this.d;
    }

    public void c(DeviceDownloadSourceInfo deviceDownloadSourceInfo) {
        this.d = deviceDownloadSourceInfo;
    }
}
