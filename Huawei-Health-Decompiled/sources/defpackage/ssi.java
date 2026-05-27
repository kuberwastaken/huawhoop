package defpackage;

import java.io.Serializable;

/* JADX INFO: loaded from: classes11.dex */
public class ssi implements Serializable {
    private static final long serialVersionUID = -9040197766300913173L;
    private boolean b;
    private int c;
    private int d;

    public ssi(int i, boolean z) {
        this.c = i;
        this.b = z;
    }

    public int b() {
        return this.c;
    }

    public void d(int i) {
        this.c = i;
    }

    public boolean e() {
        return this.b;
    }

    public void c(int i) {
        this.d = i;
    }

    public String toString() {
        return "FoodType [mType=" + this.c + ", mCanBeModified=" + this.b + "]";
    }

    public int c() {
        return this.d;
    }
}
