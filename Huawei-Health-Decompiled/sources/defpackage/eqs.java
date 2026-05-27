package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.healthmodel.bean.HealthLifeStatistic;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class eqs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("maxDays")
    private int f12742a;

    @SerializedName("currentDay")
    private int c;

    @SerializedName("statisticList")
    private List<HealthLifeStatistic> e;

    public int a() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public void e(int i) {
        this.f12742a = i;
    }

    public int b() {
        return this.f12742a;
    }

    public void c(List<HealthLifeStatistic> list) {
        this.e = list;
    }

    public List<HealthLifeStatistic> d() {
        return this.e;
    }

    public String toString() {
        return "HealthTaskConsInfo{mMaxDays=" + this.f12742a + " mHealthLiftStatisticList" + this.e + "}";
    }
}
