package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public class ats {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final boolean f320a;
    protected final String b;
    protected final String c;

    public ats(String str, String str2, boolean z) {
        this.b = str;
        this.c = str2;
        this.f320a = z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("{");
        e(sb);
        sb.append("}");
        return sb.toString();
    }

    protected StringBuilder e(StringBuilder sb) {
        sb.append("moduleName:");
        sb.append(this.b);
        sb.append('_');
        sb.append(this.c);
        sb.append(", builtIn:");
        sb.append(this.f320a);
        return sb;
    }
}
