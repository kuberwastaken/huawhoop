package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class cva {
    private int[] i;
    private int b = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f12035a = 0;
    private int d = -1;
    private boolean e = false;
    private int c = 1;

    public int d() {
        return this.c;
    }

    public void a(int i) {
        this.c = i;
    }

    public int c() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public int e() {
        return this.f12035a;
    }

    public void d(int i) {
        this.f12035a = i;
    }

    public int a() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public int[] b() {
        int[] iArr = this.i;
        return iArr == null ? new int[0] : (int[]) iArr.clone();
    }

    public void c(int[] iArr) {
        if (iArr == null) {
            this.i = new int[0];
        } else {
            this.i = (int[]) iArr.clone();
        }
    }

    public boolean f() {
        return this.e;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Option{type=");
        sb.append(this.b);
        sb.append(", duration=");
        sb.append(this.f12035a);
        sb.append(", isSupportDevice=");
        sb.append(this.c);
        sb.append(", rhythm=");
        sb.append(this.d);
        int[] iArr = this.i;
        if (iArr == null || iArr.length < 1) {
            sb.append(", vibrateDuration=[]");
        } else {
            sb.append(", vibrateDuration=[");
            for (int i : this.i) {
                sb.append(i);
                sb.append(", ");
            }
            sb.append("]");
        }
        sb.append(", screenOn=");
        sb.append(this.e);
        sb.append('}');
        return sb.toString();
    }
}
