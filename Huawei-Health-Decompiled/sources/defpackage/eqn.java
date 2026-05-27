package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class eqn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("interventionTarget")
    private eqq f12738a;

    @SerializedName("symptom")
    private String c;

    @SerializedName("interventionDimensions")
    private List<eqp> e;

    public String toString() {
        return "HealthInterventionPlan{mSymptom=" + this.c + ", mHealthInterventionTarget=" + this.f12738a + ", mHealthInterventionDimensionList=" + this.e + "}";
    }
}
