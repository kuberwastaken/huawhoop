package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class mnr extends mnq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("count")
    private int f15746a;

    @SerializedName("sortOrder")
    private int c;

    @SerializedName(TypedValues.CycleType.S_WAVE_OFFSET)
    private int e;

    public int i() {
        return this.f15746a;
    }

    public int h() {
        return this.c;
    }

    public Map j() {
        return new HashMap();
    }

    @Override // defpackage.mnq
    public String toString() {
        return "ReadDataRequest{mCount=" + this.f15746a + ", mOffset=" + this.e + ", mSortOrder=" + this.c + '}';
    }
}
