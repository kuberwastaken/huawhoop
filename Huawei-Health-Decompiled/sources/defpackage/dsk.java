package defpackage;

import com.huawei.health.devicemgr.business.entity.downloadresouce.DeviceDownloadSourceInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class dsk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12400a;
    private String b;
    private DeviceDownloadSourceInfo c;
    private long d;
    private String e;
    private String f;
    private String g = "3";
    private String h;
    private Map<String, String> i;
    private int j;
    private dsm k;
    private String l;
    private String m;
    private String n;
    private String o;

    public String c() {
        return this.h;
    }

    public void g(String str) {
        this.h = str;
    }

    public String g() {
        return (String) kqt.e(this.g);
    }

    public void f(String str) {
        this.g = (String) kqt.e(str);
    }

    public String j() {
        return (String) kqt.e(this.l);
    }

    public void h(String str) {
        this.l = (String) kqt.e(str);
    }

    public String d() {
        return (String) kqt.e(this.m);
    }

    public void a(String str) {
        this.m = (String) kqt.e(str);
    }

    public String a() {
        return (String) kqt.e(this.n);
    }

    public void b(String str) {
        this.n = (String) kqt.e(str);
    }

    public void b(long j) {
        this.d = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public void d(String str) {
        this.b = (String) kqt.e(str);
    }

    public void e(String str) {
        this.f12400a = (String) kqt.e(str);
    }

    public void c(int i) {
        this.j = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void c(String str) {
        this.e = (String) kqt.e(str);
    }

    public dsm e() {
        return (dsm) kqt.e(this.k);
    }

    public void c(dsm dsmVar) {
        this.k = (dsm) kqt.e(dsmVar);
    }

    public void j(String str) {
        this.f = str;
    }

    public void i(String str) {
        this.o = str;
    }

    public Map<String, String> i() {
        return (Map) kqt.e(this.i);
    }

    public void c(Map<String, String> map) {
        this.i = (Map) kqt.e(map);
    }

    public DeviceDownloadSourceInfo b() {
        return (DeviceDownloadSourceInfo) kqt.e(this.c);
    }

    public void b(DeviceDownloadSourceInfo deviceDownloadSourceInfo) {
        this.c = (DeviceDownloadSourceInfo) kqt.e(deviceDownloadSourceInfo);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PluginIndexFilePlugins{, uuid='");
        stringBuffer.append(this.m);
        stringBuffer.append("', version='");
        stringBuffer.append(this.n);
        stringBuffer.append("', digest='");
        stringBuffer.append(this.b);
        stringBuffer.append("', descUrl='");
        stringBuffer.append(this.e);
        stringBuffer.append("', protocol='");
        stringBuffer.append(this.f);
        stringBuffer.append("', supportMode='");
        stringBuffer.append(this.o);
        stringBuffer.append("', versionRule='");
        stringBuffer.append(this.k.toString());
        stringBuffer.append(", downloadSource='");
        stringBuffer.append(this.c.toString());
        stringBuffer.append("'}");
        return stringBuffer.toString();
    }
}
