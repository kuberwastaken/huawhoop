package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ggy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("monthly_problem")
    private int f13453a;

    @SerializedName("monthly_rhythm")
    private int b;

    @SerializedName("monthly_problem_val")
    private int c;

    @SerializedName("monthly_level")
    private int d;

    @SerializedName("questionnaire")
    private List<String> e;

    @SerializedName("result_code")
    private int i;

    public int c() {
        return this.i;
    }

    public List<String> e() {
        return this.e;
    }

    public String toString() {
        return "QuestionnaireResultBean{resultCode=" + this.i + ", questionnaire=" + this.e + ", monthlyRhythm='" + this.b + "', monthlyProblem='" + this.f13453a + "', monthlyLevel='" + this.d + "', monthlyProblemVal='" + this.c + "'}";
    }
}
