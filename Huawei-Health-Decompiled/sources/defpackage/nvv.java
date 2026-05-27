package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class nvv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16200a;
    private nvy b;
    private String d;
    private String j;
    private boolean c = false;
    private boolean e = false;

    public int b() {
        return this.f16200a;
    }

    public void e(int i) {
        this.f16200a = i;
    }

    public String a() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public String c() {
        return this.j;
    }

    public void d(String str) {
        this.j = str;
    }

    public nvy e() {
        return this.b;
    }

    public void e(nvy nvyVar) {
        this.b = nvyVar;
    }

    public boolean d() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean g() {
        return this.e;
    }

    public void e(boolean z) {
        this.e = z;
    }

    public String toString() {
        return "KakaLocationRelationShipData{contentTag=" + this.f16200a + ", contentTitle='" + this.d + "', taskId='" + this.j + "', kakaTaskRecord=" + this.b + '}';
    }
}
