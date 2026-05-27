package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class kye {
    private String e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f14996a = -1;
    private int c = -1;
    private int b = -1;
    private int d = -1;

    public int c() {
        return ((Integer) kqt.e(Integer.valueOf(this.f14996a))).intValue();
    }

    public void c(int i) {
        this.f14996a = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public String d() {
        return (String) kqt.e(this.e);
    }

    public void b(String str) {
        this.e = (String) kqt.e(str);
    }

    public int a() {
        return ((Integer) kqt.e(Integer.valueOf(this.c))).intValue();
    }

    public void b(int i) {
        this.c = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public int b() {
        return ((Integer) kqt.e(Integer.valueOf(this.b))).intValue();
    }

    public int e() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue();
    }

    public void a(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }
}
