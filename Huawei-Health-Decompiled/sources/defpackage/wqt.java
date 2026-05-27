package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class wqt extends RuntimeException {
    private int e;

    public wqt(int i) {
        super(wrn.c(i));
        this.e = i;
    }

    public int a() {
        return this.e;
    }

    public static wqt d(IllegalStateException illegalStateException) {
        if (illegalStateException == null) {
            wrm.b("WearEngineException", "convertIllegalStateException IllegalStateException is null");
            return new wqt(1);
        }
        return new wqt(wrn.d(illegalStateException.getMessage()));
    }
}
