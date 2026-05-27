package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class ggd implements Serializable {

    @SerializedName("val")
    private int b;

    @SerializedName("trans")
    private int d;

    public void a(int i) {
        this.b = i;
    }

    public int b() {
        return this.b;
    }

    public void d(int i) {
        this.d = i;
    }

    public int e() {
        return this.d;
    }

    public String toString() {
        return "{\"DailyFactorDescInput\": {\"val\":" + this.b + ", \"trans\":" + this.d + "}}";
    }
}
