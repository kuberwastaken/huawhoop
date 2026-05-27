package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class cxm {

    @SerializedName("reminderPlans")
    private List<cxj> d;

    public List<cxj> e() {
        return this.d;
    }

    public void d(List<cxj> list) {
        this.d = list;
    }

    public String toString() {
        return "BloodPressureMeasurePlan{mBloodPressureAlarmInfoCloudList=" + this.d + "}";
    }
}
