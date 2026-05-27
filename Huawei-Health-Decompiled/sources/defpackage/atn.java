package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public final class atn extends Exception {
    private static final long serialVersionUID = 398957975986243915L;
    private final int c;

    public atn(int i, Throwable th) {
        super("Module Load Error: " + i, th);
        this.c = i;
    }

    int c() {
        return this.c;
    }
}
