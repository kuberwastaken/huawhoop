package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class hzs implements Serializable {
    private static final long serialVersionUID = 7505480085796770578L;

    @SerializedName("breakfast")
    private int b;

    @SerializedName("lunch")
    private int d;

    @SerializedName("dinner")
    private int e;

    public int a() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public int e() {
        return this.d;
    }

    public void e(int i) {
        this.d = i;
    }

    public int d() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public String toString() {
        return "OnePointFull{breakfast=" + this.b + ", lunch=" + this.d + ", dinner=" + this.e + '}';
    }
}
