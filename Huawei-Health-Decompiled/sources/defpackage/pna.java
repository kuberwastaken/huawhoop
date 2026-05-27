package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class pna {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f16789a;
    private final int[] b;
    private final int e;

    public pna(a aVar) {
        this.b = aVar.d;
        this.f16789a = aVar.b;
        this.e = aVar.e;
    }

    public static class a {
        private int[] b;
        private int[] d;
        private int e;

        public a b(int i) {
            this.e = i;
            return this;
        }

        public a a(int[] iArr) {
            this.d = iArr;
            return this;
        }

        public a e(int[] iArr) {
            this.b = iArr;
            return this;
        }

        public pna d() {
            return new pna(this);
        }
    }

    public int a() {
        return this.e;
    }

    public int[] d() {
        return this.b;
    }

    public int[] c() {
        return this.f16789a;
    }
}
