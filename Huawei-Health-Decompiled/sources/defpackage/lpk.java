package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class lpk {
    private int c;
    private boolean d;

    lpk(int i, boolean z) {
        this.c = i;
        this.d = z;
    }

    public int d() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public String toString() {
        return "SyncState{errorCode=" + this.c + ", isNeedSync=" + this.d + '}';
    }
}
