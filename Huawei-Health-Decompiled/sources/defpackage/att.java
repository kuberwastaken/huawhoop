package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public class att extends ats {
    private final int d;
    private final Throwable e;

    public att(ats atsVar, int i, Throwable th) {
        super(atsVar.b, atsVar.c, atsVar.f320a);
        this.d = i;
        this.e = th;
    }

    public int b() {
        return this.d;
    }

    @Override // defpackage.ats
    protected StringBuilder e(StringBuilder sb) {
        super.e(sb);
        sb.append(", errorCode:");
        sb.append(this.d);
        sb.append(", errorMsg:");
        sb.append(this.e.getMessage());
        return sb;
    }
}
