package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class gha {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("monthly_daily_tasks")
    private List<List<ggo>> f13455a;

    @SerializedName("monthly_impact_desc")
    private String b;

    @SerializedName("monthly_daily_advices")
    private List<ggl> c;

    @SerializedName("monthly_major_reason")
    private List<Integer> d;

    @SerializedName("monthly_prob_desc")
    private String e;

    @SerializedName("monthly_prob_val")
    private List<Integer> f;

    @SerializedName("monthly_recomd")
    private ggp g;

    @SerializedName("monthly_tasks")
    private List<Integer> h;

    @SerializedName("monthly_prob_level")
    private int i;

    @SerializedName("monthly_problem")
    private int j;

    @SerializedName("rhythm_desc")
    private String k;

    @SerializedName("rhythm")
    private int m;

    @SerializedName("result_code")
    private int o;

    public int o() {
        return this.o;
    }

    public int m() {
        return this.m;
    }

    public int j() {
        return this.j;
    }

    public int h() {
        return this.i;
    }

    public String a() {
        return this.e;
    }

    public List<Integer> f() {
        return this.f;
    }

    public List<Integer> c() {
        return this.d;
    }

    public String b() {
        return this.b;
    }

    public ggp i() {
        return this.g;
    }

    public List<Integer> g() {
        return this.h;
    }

    public List<List<ggo>> e() {
        return this.f13455a;
    }

    public List<ggl> d() {
        return this.c;
    }
}
