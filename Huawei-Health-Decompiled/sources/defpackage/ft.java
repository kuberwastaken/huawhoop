package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class ft {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f13153a;
    private final String b;
    public final float e;

    public ft(String str, float f, float f2) {
        this.b = str;
        this.e = f2;
        this.f13153a = f;
    }

    public boolean b(String str) {
        if (this.b.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.b.endsWith("\r")) {
            String str2 = this.b;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
