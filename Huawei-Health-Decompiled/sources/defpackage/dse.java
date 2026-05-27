package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class dse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12394a;
    private String b;
    private String c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private dsr l;
    private List<dss> m;
    private String n;

    public dsr f() {
        return (dsr) kqt.e(this.l);
    }

    public void a(dsr dsrVar) {
        this.l = (dsr) kqt.e(dsrVar);
    }

    public void g(String str) {
        this.i = (String) kqt.e(str);
    }

    public String a() {
        return (String) kqt.e(this.j);
    }

    public void j(String str) {
        this.j = (String) kqt.e(str);
    }

    public String d() {
        return (String) kqt.e(this.n);
    }

    public void i(String str) {
        this.n = (String) kqt.e(str);
    }

    public void h(String str) {
        this.f = (String) kqt.e(str);
    }

    public int b() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue();
    }

    public void c(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String c() {
        return (String) kqt.e(this.b);
    }

    public void b(String str) {
        this.b = (String) kqt.e(str);
    }

    public void d(String str) {
        this.h = (String) kqt.e(str);
    }

    public void e(String str) {
        this.c = (String) kqt.e(str);
    }

    public void f(String str) {
        this.g = (String) kqt.e(str);
    }

    public void c(String str) {
        this.f12394a = (String) kqt.e(str);
    }

    public String e() {
        return (String) kqt.e(this.e);
    }

    public void a(String str) {
        this.e = (String) kqt.e(str);
    }

    public List<dss> h() {
        return this.m;
    }

    public void e(List<dss> list) {
        this.m = list;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("DescriptionInfo{, pluginName='");
        sb.append(this.i);
        sb.append("', pluginUuid='");
        sb.append(this.j);
        sb.append("', version='");
        sb.append(this.n);
        sb.append("', modifyDate='");
        sb.append(this.f);
        sb.append("', fileSize='");
        sb.append(this.d);
        sb.append("', digest='");
        sb.append(this.b);
        sb.append("', form='");
        sb.append(this.h);
        sb.append("', description='");
        sb.append(this.c);
        sb.append("', prompt='");
        sb.append(this.g);
        sb.append("', fileName='");
        sb.append(this.f12394a);
        sb.append("', fileType='");
        sb.append(this.e);
        sb.append("'}");
        return sb.toString();
    }
}
