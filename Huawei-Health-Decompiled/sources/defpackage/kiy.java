package defpackage;

/* JADX INFO: loaded from: classes9.dex */
public class kiy extends Exception {
    private static final long serialVersionUID = 1726426141039183018L;
    private boolean c;

    public kiy(String str) {
        super(str);
    }

    public kiy(String str, boolean z) {
        super(str);
        this.c = z;
    }

    public boolean c() {
        return this.c;
    }
}
