package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class wws extends Exception {
    private final int d;

    public wws(String str) {
        super(str);
        this.d = 100001;
    }

    public int a() {
        return this.d;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "[errorCode:" + this.d + " message:" + getMessage() + "]";
    }
}
