package defpackage;

import com.huawei.health.devicemgr.business.entity.downloadresouce.DeviceDownloadSourceInfo;

/* JADX INFO: loaded from: classes3.dex */
class czw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12115a;
    private String b;
    private dse c;
    private String d;
    private DeviceDownloadSourceInfo e;
    private String f;

    public czw() {
    }

    public czw(String str, String str2, String str3, dse dseVar) {
        this.d = str;
        this.f = str2;
        this.b = str3;
        this.c = dseVar;
    }

    public String a() {
        return this.f12115a;
    }

    public void c(String str) {
        this.f12115a = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public String b() {
        return this.d;
    }

    public String j() {
        return this.f;
    }

    public dse e() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public DeviceDownloadSourceInfo d() {
        return this.e;
    }

    public void b(DeviceDownloadSourceInfo deviceDownloadSourceInfo) {
        this.e = deviceDownloadSourceInfo;
    }
}
