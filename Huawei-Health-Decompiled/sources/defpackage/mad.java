package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class mad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f15564a = new Object();
    private static int c;
    private static mad e;
    private byte[] b;
    private int d;
    private mad i;

    public byte[] a() {
        return (byte[]) kqt.e(this.b);
    }

    public int b() {
        return ((Integer) kqt.e(Integer.valueOf(this.d))).intValue();
    }

    public void c(int i) {
        this.d = i;
    }

    public void a(byte[] bArr) {
        this.b = bArr;
    }

    public static mad c() {
        synchronized (f15564a) {
            mad madVar = e;
            if (madVar != null) {
                e = madVar.i;
                madVar.i = null;
                c--;
                return madVar;
            }
            return new mad();
        }
    }

    public void e() {
        this.d = 0;
        this.b = null;
        synchronized (f15564a) {
            int i = c;
            if (i < 4) {
                this.i = e;
                e = this;
                c = i + 1;
            }
        }
    }
}
