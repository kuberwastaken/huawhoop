package defpackage;

import com.huawei.health.devicemgr.business.entity.downloadresouce.DeviceDownloadSourceInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class ptc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16865a;
    private String b;
    private String c;
    private int d;
    private int e;
    private String f;
    private Map<String, dsl> g;
    private Map<String, String> h;
    private String i;
    private DeviceDownloadSourceInfo j;
    private List<String> m;
    private String n;
    private int o;

    public int l() {
        return this.o;
    }

    public void e(int i) {
        this.o = i;
    }

    public String d() {
        return this.c;
    }

    public void b(String str) {
        this.c = str;
    }

    public String i() {
        return this.f;
    }

    public void c(String str) {
        this.f = str;
    }

    public List<String> n() {
        return this.m;
    }

    public void c(List<String> list) {
        this.m = list;
    }

    public String g() {
        return this.i;
    }

    public Map<String, dsl> f() {
        return this.g;
    }

    public void a(Map<String, dsl> map) {
        this.g = map;
    }

    public void a(String str) {
        this.i = str;
    }

    public String b() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public Map<String, String> j() {
        return this.h;
    }

    public void b(Map<String, String> map) {
        this.h = map;
    }

    public int e() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public int c() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public String m() {
        return this.n;
    }

    public void d(String str) {
        this.n = str;
    }

    public DeviceDownloadSourceInfo h() {
        return this.j;
    }

    public void e(DeviceDownloadSourceInfo deviceDownloadSourceInfo) {
        this.j = deviceDownloadSourceInfo;
    }

    public int a() {
        return this.f16865a;
    }

    public void b(int i) {
        this.f16865a = i;
    }

    public boolean equals(Object obj) {
        String str;
        if (!(obj instanceof ptc) || (str = this.c) == null) {
            return false;
        }
        return str.equals(((ptc) obj).d());
    }

    public int hashCode() {
        String str = this.c;
        if (str != null) {
            return str.hashCode();
        }
        return super.hashCode();
    }
}
