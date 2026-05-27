package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class mkj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15691a;
    private boolean d;
    private String e;

    static class a {
        public static mkj d = new mkj();
    }

    private mkj() {
        this.d = false;
    }

    public static mkj d() {
        return a.d;
    }

    public boolean a() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String b() {
        return this.f15691a;
    }
}
