package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class pfc implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16668a;
    private float b;
    private String c;
    private int d;

    public pfc(float f, float f2, int i, String str) {
        this.f16668a = f;
        this.b = f2;
        this.d = i;
        this.c = str;
    }

    public float c() {
        return this.f16668a;
    }

    public void c(float f) {
        this.f16668a = f;
    }

    public float d() {
        return this.b;
    }

    public void e(float f) {
        this.b = f;
    }

    public int a() {
        return this.d;
    }

    public String e() {
        return this.c;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public pfc clone() throws CloneNotSupportedException {
        return new pfc(this.f16668a, this.b, this.d, this.c);
    }
}
