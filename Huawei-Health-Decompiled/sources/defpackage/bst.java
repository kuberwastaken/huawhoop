package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public class bst {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f485a;
    private final float b;
    private final int c;
    private final int d;

    public bst(int i, float f, int i2, int i3) {
        this.c = i;
        this.b = f;
        this.d = i2;
        this.f485a = i3;
    }

    public int d() {
        return this.c;
    }

    public float c() {
        return this.b;
    }

    public int e() {
        return this.d;
    }

    public int b() {
        return this.f485a;
    }

    public String toString() {
        return "DayTaskStatus{mType=" + this.c + ", mCloverScale=" + this.b + ", mCompleted=" + this.d + ", mCloverStatus=" + this.f485a + '}';
    }
}
