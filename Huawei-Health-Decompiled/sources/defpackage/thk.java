package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class thk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17986a;
    private String b;
    private boolean d;

    public thk(String str, String str2, boolean z) {
        this.b = str;
        this.f17986a = str2;
        this.d = z;
    }

    public String c() {
        return this.b;
    }

    public String e() {
        return this.f17986a;
    }

    public boolean b() {
        return this.d;
    }

    public void c(boolean z) {
        this.d = z;
    }

    public String toString() {
        return "StateIndexItem{mStateItem='" + this.b + "', mStateValue='" + this.f17986a + "', mChangeBg=" + this.d + '}';
    }
}
