package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class klp {
    private int b;
    private int c;
    private int d;
    private int e;

    public int d() {
        return ((Integer) chw.d(Integer.valueOf(this.e))).intValue();
    }

    public void b(int i) {
        this.e = ((Integer) chw.d(Integer.valueOf(i))).intValue();
    }

    public int b() {
        return ((Integer) chw.d(Integer.valueOf(this.d))).intValue();
    }

    public void a(int i) {
        this.d = ((Integer) chw.d(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(0);
        stringBuffer.append("BTBindStatus{BT_bind_status=").append(this.e).append(", BT_bind_status_info=").append(this.d).append("}");
        return stringBuffer.toString();
    }

    public int e() {
        return ((Integer) chw.d(Integer.valueOf(this.b))).intValue();
    }

    public void d(int i) {
        this.b = ((Integer) chw.d(Integer.valueOf(i))).intValue();
    }

    public void c(int i) {
        this.c = ((Integer) chw.d(Integer.valueOf(i))).intValue();
    }

    public int c() {
        return ((Integer) chw.d(Integer.valueOf(this.c))).intValue();
    }
}
