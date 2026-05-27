package defpackage;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
public class gga implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("trans")
    private int f13438a;

    @SerializedName("val")
    private int d;

    public void a(int i) {
        this.d = i;
    }

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.f13438a = i;
    }

    public int b() {
        return this.f13438a;
    }

    public String toString() {
        return "{\"DailyProblemDescInput\": {\"val\":" + this.d + ", \"trans\":" + this.f13438a + "}}";
    }
}
