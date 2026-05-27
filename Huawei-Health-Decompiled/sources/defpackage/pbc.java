package defpackage;

/* JADX INFO: loaded from: classes7.dex */
public class pbc {
    private int b;
    private int c;
    private int d;
    private String e;

    public void d(String str) {
        this.e = str;
    }

    public int b() {
        return this.b;
    }

    public void d(int i) {
        this.b = i;
    }

    public int d() {
        return this.c;
    }

    public void b(int i) {
        this.c = i;
    }

    public void e(int i) {
        this.d = i;
    }

    public String toString() {
        return "RecommendGoalModel{mRecommendGoalType='" + this.e + ", mRecommendGoalState=" + this.b + ", mEffectiveGoalValue=" + this.d + ", mRecommendGoalValue=" + this.c + '}';
    }
}
