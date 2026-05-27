package defpackage;

import com.huawei.pluginmgr.hwwear.bean.DeviceDownloadSourceInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class odz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f16314a;
    private String b;
    private String c;
    private DeviceDownloadSourceInfo d;
    private String e;
    private String f;
    private String g;
    private String h = "3";
    private int i;
    private Map<String, String> j;
    private String k;
    private oep m;
    private String n;
    private String o;

    public String g() {
        return (String) kqt.e(this.h);
    }

    public void i(String str) {
        this.h = (String) kqt.e(str);
    }

    public String l() {
        return (String) kqt.e(this.k);
    }

    public void f(String str) {
        this.k = (String) kqt.e(str);
    }

    public String c() {
        return (String) kqt.e(this.n);
    }

    public void d(String str) {
        this.n = (String) kqt.e(str);
    }

    public String j() {
        return (String) kqt.e(this.o);
    }

    public void b(String str) {
        this.o = (String) kqt.e(str);
    }

    public long b() {
        return ((Long) kqt.e(Long.valueOf(this.f16314a))).longValue();
    }

    public void d(long j) {
        this.f16314a = ((Long) kqt.e(Long.valueOf(j))).longValue();
    }

    public String a() {
        return (String) kqt.e(this.c);
    }

    public void e(String str) {
        this.c = (String) kqt.e(str);
    }

    public String d() {
        return (String) kqt.e(this.e);
    }

    public void c(String str) {
        this.e = (String) kqt.e(str);
    }

    public int e() {
        return ((Integer) kqt.e(Integer.valueOf(this.i))).intValue();
    }

    public void e(int i) {
        this.i = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void a(String str) {
        this.b = (String) kqt.e(str);
    }

    public oep f() {
        return (oep) kqt.e(this.m);
    }

    public void b(oep oepVar) {
        this.m = (oep) kqt.e(oepVar);
    }

    public String i() {
        return this.g;
    }

    public void h(String str) {
        this.g = str;
    }

    public String n() {
        return this.f;
    }

    public void j(String str) {
        this.f = str;
    }

    public Map<String, String> h() {
        return (Map) kqt.e(this.j);
    }

    public void d(Map<String, String> map) {
        this.j = (Map) kqt.e(map);
    }

    public void c(DeviceDownloadSourceInfo deviceDownloadSourceInfo) {
        this.d = (DeviceDownloadSourceInfo) kqt.e(deviceDownloadSourceInfo);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("PluginIndexFilePlugins{, uuid='");
        stringBuffer.append(this.n);
        stringBuffer.append("', version='");
        stringBuffer.append(this.o);
        stringBuffer.append("', digest='");
        stringBuffer.append(this.c);
        stringBuffer.append("', descUrl='");
        stringBuffer.append(this.b);
        stringBuffer.append("', protocol='");
        stringBuffer.append(this.g);
        stringBuffer.append("', supportMode='");
        stringBuffer.append(this.f);
        stringBuffer.append("', versionRule='");
        oep oepVar = this.m;
        if (oepVar != null) {
            stringBuffer.append(oepVar.toString());
        }
        stringBuffer.append(", downloadSource='");
        DeviceDownloadSourceInfo deviceDownloadSourceInfo = this.d;
        if (deviceDownloadSourceInfo != null) {
            stringBuffer.append(deviceDownloadSourceInfo.toString());
        }
        stringBuffer.append("'}");
        return stringBuffer.toString();
    }
}
