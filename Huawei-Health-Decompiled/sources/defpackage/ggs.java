package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class ggs {

    @SerializedName("monthly_problem")
    private int b;

    @SerializedName("monthly_level")
    private int c;

    @SerializedName("monthly_rhythm")
    private int d;

    @SerializedName("monthly_problem_val")
    private int e;

    public int c() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public int d() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public int e() {
        return this.c;
    }

    public void e(int i) {
        this.c = i;
    }

    public int a() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public String toString() {
        return "QuestionnaireMonthlyResult{monthlyRhythm='" + this.d + "', monthlyProblem='" + this.b + "', monthlyLevel='" + this.c + "', monthlyProblemVal='" + this.e + "'}";
    }
}
