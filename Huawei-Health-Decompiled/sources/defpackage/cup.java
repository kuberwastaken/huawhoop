package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class cup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12030a;
    private int c;
    private final boolean d;
    private boolean e;

    public cup(c cVar) {
        this.c = cVar.d;
        this.e = cVar.b;
        this.f12030a = cVar.f12031a;
        this.d = cVar.e;
    }

    public int b() {
        return this.c;
    }

    public boolean d() {
        return this.e;
    }

    public boolean a() {
        return this.f12030a;
    }

    public boolean e() {
        return this.d;
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f12031a;
        private boolean b;
        private int d = -1;
        private boolean e;

        public c a(int i) {
            this.d = i;
            return this;
        }

        public c c(boolean z) {
            this.b = z;
            return this;
        }

        public c b(boolean z) {
            this.f12031a = z;
            return this;
        }

        public c a(boolean z) {
            this.e = z;
            return this;
        }

        public cup d() {
            return new cup(this);
        }
    }
}
