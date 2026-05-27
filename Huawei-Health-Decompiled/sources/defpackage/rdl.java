package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class rdl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("workoutHistoryList")
    private List<rdo> f17301a;

    @SerializedName("resultCode")
    private String b;

    @SerializedName("resultDesc")
    private String d;

    public List<rdo> a() {
        return this.f17301a;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    public String toString() {
        return "AudioWorkoutListHistoryRsp{workoutHistoryList=" + this.f17301a + ", resultCode='" + this.b + "', resultDesc='" + this.d + "'}";
    }
}
