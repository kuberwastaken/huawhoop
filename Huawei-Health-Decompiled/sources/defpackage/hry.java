package defpackage;

/* JADX INFO: loaded from: classes5.dex */
public class hry {
    private transient long d;

    protected hry(long j, boolean z) {
        this.d = j;
    }

    protected hry() {
        this.d = 0L;
    }

    protected static long e(hry hryVar) {
        if (hryVar == null) {
            return 0L;
        }
        return hryVar.d;
    }
}
