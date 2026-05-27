package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class jd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14387a;
    private int c;

    public void c(float f) {
        float f2 = this.f14387a + f;
        this.f14387a = f2;
        int i = this.c + 1;
        this.c = i;
        if (i == Integer.MAX_VALUE) {
            this.f14387a = f2 / 2.0f;
            this.c = i / 2;
        }
    }
}
