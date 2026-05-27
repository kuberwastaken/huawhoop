package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class ggv extends ggw {

    @SerializedName("monthly_rhythm")
    private int b;

    @SerializedName("monthly_problem")
    private int c;

    @SerializedName("monthly_problem_val")
    private int d;

    @SerializedName("monthly_level")
    private int e;

    public void a(int i) {
        this.b = i;
    }

    public void e(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.e = i;
    }

    public void c(int i) {
        this.d = i;
    }

    public String toString() {
        return "QuestionnaireMonthlyResult{monthlyRhythm='" + this.b + "', monthlyProblem='" + this.c + "', monthlyLevel='" + this.e + "', monthlyProblemVal='" + this.d + "'}" + super.toString();
    }
}
