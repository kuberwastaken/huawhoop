package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class uio {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18321a;
    private int b;
    private boolean c;
    private boolean d;
    private String e;
    private String f;
    private int g;
    private boolean j;

    public int c() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
    }

    public int e() {
        return this.f18321a;
    }

    public void d(int i) {
        this.f18321a = i;
    }

    public String b() {
        String str = this.e;
        return str == null ? "" : str;
    }

    public void a(String str) {
        this.e = str;
    }

    public int a() {
        return this.b;
    }

    public void e(int i) {
        this.b = i;
    }

    public String d() {
        String str = this.f;
        return str == null ? "" : str;
    }

    public void e(String str) {
        this.f = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("DeviceRecordBean{ itemType=");
        stringBuffer.append(this.g);
        stringBuffer.append(", dataType=").append(this.f18321a);
        stringBuffer.append(", content=").append(this.e);
        stringBuffer.append(", imageId=").append(this.b);
        stringBuffer.append(", title=").append(this.f);
        stringBuffer.append(", isActivityStatistics=").append(this.d);
        stringBuffer.append(", isHealthState=").append(this.j);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public boolean g() {
        return this.d;
    }

    public void d(boolean z) {
        this.d = z;
    }

    public boolean f() {
        return this.j;
    }

    public void e(boolean z) {
        this.j = z;
    }

    public boolean j() {
        return this.c;
    }

    public void b(boolean z) {
        this.c = z;
    }
}
