package defpackage;

/* JADX INFO: loaded from: classes10.dex */
public class aun extends Exception {
    private int d;

    public aun() {
        this.d = 0;
    }

    public int a() {
        return this.d;
    }

    public aun(int i, String str) {
        super(str);
        this.d = i;
    }
}
