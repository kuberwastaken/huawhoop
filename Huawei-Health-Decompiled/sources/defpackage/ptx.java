package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class ptx extends ptv {
    private static final long serialVersionUID = 1069953673580218483L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ptq f16877a;
    private String b;
    private String c;

    public String d() {
        return this.c;
    }

    public String c() {
        return this.b;
    }

    public ptq b() {
        return this.f16877a;
    }

    public void c(String str) {
        this.c = str;
    }

    public void a(String str) {
        this.b = str;
    }

    public void c(ptq ptqVar) {
        this.f16877a = ptqVar;
    }

    public String toString() {
        return "Checkbox{name=" + this.c + ", description='" + this.b + ", config= " + this.f16877a + '}';
    }
}
