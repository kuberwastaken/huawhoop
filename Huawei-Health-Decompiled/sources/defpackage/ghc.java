package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ghc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("latest_problem")
    private List<Integer> f13457a;

    @SerializedName("monthly_problem")
    private int b;

    @SerializedName("age")
    private int c;

    @SerializedName("advice_to_do")
    private List<ggc> d;

    @SerializedName(CommonConstant.KEY_GENDER)
    private int e;

    @SerializedName("task_to_do")
    private List<ghb> h;

    @SerializedName("rhythm")
    private int i;

    @SerializedName("time_zone")
    private int j;

    public void c(int i) {
        this.c = i;
    }

    public void a(int i) {
        this.e = i;
    }

    public void d(int i) {
        this.i = i;
    }

    public void b(int i) {
        this.b = i;
    }

    public void e(int i) {
        this.j = i;
    }

    public void d(List<ggc> list) {
        this.d = list;
    }

    public void c(List<ghb> list) {
        this.h = list;
    }

    public void b(List<Integer> list) {
        this.f13457a = list;
    }
}
