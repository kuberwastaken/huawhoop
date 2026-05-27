package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.healthmodel.bean.HealthLifeStatistic;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class bpi extends bot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("statisticList")
    private List<HealthLifeStatistic> f445a;

    @SerializedName("maxDays")
    private int c;

    public int e() {
        return this.c;
    }

    public List<HealthLifeStatistic> d() {
        return this.f445a;
    }

    @Override // defpackage.bot
    public String toString() {
        return "HealthModelStatResponse{mMaxDays=" + this.c + "mHealthLiftStatisticList=" + this.f445a + "}";
    }
}
