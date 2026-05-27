package defpackage;

/* JADX INFO: loaded from: classes11.dex */
public class nmo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16039a;
    private String b;
    private String d;

    public nmo(String str, int i, String str2) {
        this.b = str;
        this.f16039a = i;
        this.d = str2;
    }

    public nmo() {
    }

    public String d() {
        return (String) nmq.b(this.b);
    }

    public int c() {
        return ((Integer) nmq.b(Integer.valueOf(this.f16039a))).intValue();
    }

    public String a() {
        return (String) nmq.b(this.d);
    }
}
