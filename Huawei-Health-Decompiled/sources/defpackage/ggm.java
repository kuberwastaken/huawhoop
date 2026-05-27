package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ggm {

    @SerializedName("monthlyDailyTasks")
    private List<List<ggn>> d;

    @SerializedName("monthlyDailyAdvices")
    private List<ggk> e;

    public List<ggk> c() {
        return this.e;
    }

    public List<List<ggn>> d() {
        return this.d;
    }
}
