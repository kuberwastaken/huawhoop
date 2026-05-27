package defpackage;

import com.huawei.hwbtsdk.btcommon.BTDeviceMgrUtil;

/* JADX INFO: loaded from: classes5.dex */
public class kuw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14926a;
    private int b;
    private int c;
    private String d;
    private String e;
    private String g;
    private int i;
    private long j;

    public void c(long j) {
        this.j = j;
    }

    public void d(int i) {
        this.i = i;
    }

    public void a(String str) {
        this.g = str;
    }

    public void d(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public void b(int i) {
        this.b = i;
    }

    public void e(int i) {
        this.f14926a = i;
    }

    public void c(int i) {
        this.c = i;
    }

    public String toString() {
        return "EventInfo{ts=" + this.j + ", tokenType=" + this.i + ", token='" + this.g + "', appId='" + this.d + "', deviceId='" + BTDeviceMgrUtil.a().d(this.e) + "', siteId='" + this.b + "', iversion='" + this.f14926a + "', source='" + this.c + "'}";
    }
}
