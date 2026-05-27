package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class thb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f17980a;
    private boolean b;
    private double c;
    private CharSequence d;
    private int e;
    private String h;

    public int c() {
        return ((Integer) dne.b(Integer.valueOf(this.f17980a))).intValue();
    }

    public void a(int i) {
        this.f17980a = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public CharSequence b() {
        return (CharSequence) dne.b(this.d);
    }

    public void a(CharSequence charSequence) {
        this.d = (CharSequence) dne.b(charSequence);
    }

    public double e() {
        return ((Double) dne.b(Double.valueOf(this.c))).doubleValue();
    }

    public void d(double d) {
        this.c = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public int d() {
        return ((Integer) dne.b(Integer.valueOf(this.e))).intValue();
    }

    public void e(int i) {
        this.e = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public String a() {
        return (String) dne.b(this.h);
    }

    public void c(String str) {
        this.h = (String) dne.b(str);
    }

    public boolean h() {
        return this.b;
    }

    public void c(boolean z) {
        this.b = z;
    }
}
