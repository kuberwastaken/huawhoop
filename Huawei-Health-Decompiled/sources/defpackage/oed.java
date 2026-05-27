package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class oed {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f16318a;
    private int b;
    private String c;
    private odx d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String l;
    private String m;
    private odu n;

    public odx f() {
        return this.d;
    }

    public void e(odx odxVar) {
        this.d = odxVar;
    }

    public odu g() {
        return (odu) kqt.e(this.n);
    }

    public void d(odu oduVar) {
        this.n = (odu) kqt.e(oduVar);
    }

    public void f(String str) {
        this.j = (String) kqt.e(str);
    }

    public String c() {
        return (String) kqt.e(this.i);
    }

    public void i(String str) {
        this.i = (String) kqt.e(str);
    }

    public String j() {
        return (String) kqt.e(this.l);
    }

    public void h(String str) {
        this.l = (String) kqt.e(str);
    }

    public void j(String str) {
        this.f = (String) kqt.e(str);
    }

    public int e() {
        return ((Integer) kqt.e(Integer.valueOf(this.b))).intValue();
    }

    public void d(int i) {
        this.b = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String d() {
        return (String) kqt.e(this.e);
    }

    public void c(String str) {
        this.e = (String) kqt.e(str);
    }

    public void e(String str) {
        this.g = (String) kqt.e(str);
    }

    public void b(String str) {
        this.f16318a = (String) kqt.e(str);
    }

    public void g(String str) {
        this.m = (String) kqt.e(str);
    }

    public String a() {
        return (String) kqt.e(this.c);
    }

    public void d(String str) {
        this.c = (String) kqt.e(str);
    }

    public String b() {
        return (String) kqt.e(this.h);
    }

    public void a(String str) {
        this.h = (String) kqt.e(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(16);
        sb.append("EzPluginInfo{, pluginName='");
        sb.append(this.j);
        sb.append("', pluginUuid='");
        sb.append(this.i);
        sb.append("', version='");
        sb.append(this.l);
        sb.append("', modifyDate='");
        sb.append(this.f);
        sb.append("', fileSize='");
        sb.append(this.b);
        sb.append("', digest='");
        sb.append(this.e);
        sb.append("', form='");
        sb.append(this.g);
        sb.append("', description='");
        sb.append(this.f16318a);
        sb.append("', prompt='");
        sb.append(this.m);
        sb.append("', fileName='");
        sb.append(this.c);
        sb.append("', fileType='");
        sb.append(this.h);
        sb.append("'}");
        return sb.toString();
    }
}
