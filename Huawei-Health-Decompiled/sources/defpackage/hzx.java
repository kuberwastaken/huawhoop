package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class hzx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("caloriesGap")
    private int f14015a;

    @SerializedName("activityCalories")
    private int c;

    @SerializedName(TypedValues.CycleType.S_WAVE_PERIOD)
    private int e;

    public int a() {
        return this.c;
    }

    public int b() {
        return this.f14015a;
    }

    public int c() {
        return this.e;
    }

    public String toString() {
        return "SimpleFatInfo{activityCalories=" + this.c + ", caloriesGap=" + this.f14015a + ", period=" + this.e + '}';
    }
}
