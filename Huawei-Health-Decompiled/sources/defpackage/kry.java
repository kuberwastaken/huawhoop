package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class kry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14861a;
    private boolean b;
    private boolean c;
    private String d;
    private int e;
    private String f;
    private String i;
    private String j;

    public String b() {
        return this.d;
    }

    public void d(String str) {
        this.d = str;
    }

    public String e() {
        return this.f;
    }

    public void c(String str) {
        this.f = str;
    }

    public String c() {
        return this.j;
    }

    public void a(String str) {
        this.j = str;
    }

    public String a() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public boolean f() {
        return this.c;
    }

    public boolean d() {
        return this.c;
    }

    public void e(boolean z) {
        this.c = z;
    }

    public boolean h() {
        return this.f14861a;
    }

    public void a(boolean z) {
        this.f14861a = z;
    }

    public boolean j() {
        return this.b;
    }

    public void b(boolean z) {
        this.b = z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("MigrateTable{mId=");
        stringBuffer.append(this.e).append(", mOriginalHuid='").append(this.d).append("', mToHuid='").append(this.f).append("', mOriginalSt='").append(this.j).append("', mTime='").append(this.i).append("', mIsSendCommandFinished=").append(this.c).append(", mIsCloudFinished=").append(this.f14861a).append(", mIsLocalFinished=").append(this.b).append('}');
        return stringBuffer.toString();
    }
}
