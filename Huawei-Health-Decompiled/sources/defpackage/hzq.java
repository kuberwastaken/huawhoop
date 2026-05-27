package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.knit.ui.KnitFragment;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public class hzq implements Serializable {
    private static final long serialVersionUID = 7505480085796770549L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("lunch")
    private int f14010a;

    @SerializedName("breakfast")
    private int c;

    @SerializedName(KnitFragment.KEY_EXTRA)
    private int d;

    @SerializedName("dinner")
    private int e;

    public void c(int i) {
        this.c = i;
    }

    public void d(int i) {
        this.f14010a = i;
    }

    public void e(int i) {
        this.e = i;
    }

    public void b(int i) {
        this.d = i;
    }

    public String toString() {
        return "ProportionMeal{mBreakfast=" + this.c + ", mLunch=" + this.f14010a + ", mDinner=" + this.e + ", mExtra=" + this.d + '}';
    }
}
