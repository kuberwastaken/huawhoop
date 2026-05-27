package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ljg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("bloodOxygenStructList")
    private List<lje> f15236a;

    @SerializedName("workoutRecordId")
    private int d;

    @SerializedName("bloodOxygenIndex")
    private int e;

    public void c(int i) {
        this.d = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void a(int i) {
        this.e = ((Integer) kqt.e(Integer.valueOf(i))).intValue();
    }

    public void b(List<lje> list) {
        this.f15236a = (List) kqt.e(list);
    }
}
