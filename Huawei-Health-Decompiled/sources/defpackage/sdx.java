package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class sdx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("accumPerfectGoalAchievedDays")
    private e f17671a;

    public e b() {
        return this.f17671a;
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("latestDate")
        private int f17672a;

        @SerializedName("latestPerfect")
        private int c;

        @SerializedName("value")
        private int d;

        public int a() {
            return this.d;
        }

        public int d() {
            return this.f17672a;
        }

        public int c() {
            return this.c;
        }

        public String toString() {
            return "PD{value=" + this.d + ", lD=" + this.f17672a + ", lP=" + this.c + '}';
        }
    }
}
