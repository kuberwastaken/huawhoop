package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class eqq {

    @SerializedName("mainTarget")
    private List<eqk> b;

    @SerializedName("version")
    private String c;

    public String toString() {
        return "HealthInterventionTarget{mVersion=" + this.c + ", mDataRuleList=" + this.b + "}";
    }
}
