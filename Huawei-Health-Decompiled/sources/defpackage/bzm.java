package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class bzm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f551a;
    private int b;
    private float c;

    public bzm(c cVar) {
        this.f551a = -1.0f;
        this.c = -1.0f;
        this.b = -1;
        this.f551a = cVar.c;
        this.c = cVar.e;
        this.b = cVar.d;
    }

    public float b() {
        return this.f551a;
    }

    public float d() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    /* JADX INFO: loaded from: classes.dex */
    public static class c {
        private float c = -1.0f;
        private float e = -1.0f;
        private int d = -1;

        public c c(float f) {
            this.c = f;
            return this;
        }

        public c d(float f) {
            this.e = f;
            return this;
        }

        public bzm c() {
            return new bzm(this);
        }
    }
}
