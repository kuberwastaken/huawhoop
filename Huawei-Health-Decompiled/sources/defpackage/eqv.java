package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class eqv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("challengeId")
    private String f12744a;

    @SerializedName("commentStatus")
    private int b;

    @SerializedName("customTaskListDetails")
    private List<eql> c;

    @SerializedName("dimensionListDetails")
    private List<eqi> d;

    @SerializedName("commentInfo")
    private eqg e;

    @SerializedName("mainTargetDetails")
    private List<eqt> f;

    @SerializedName("version")
    private String g;

    @SerializedName("interventionPlan")
    private eqn h;

    public String d() {
        return this.f12744a;
    }

    public eqg a() {
        return this.e;
    }

    public int c() {
        return this.b;
    }

    public String toString() {
        return "HealthWeekReport{mVersion=" + this.g + ", mChallengeId=" + this.f12744a + ", mInterventionPlan=" + this.h + ", mCommentInfo=" + this.e + ", mCommentStatus=" + this.b + ", mMainTargetSubDataDetailList=" + this.f + ", mDimensionDetailList=" + this.d + ", mCustomTaskDetailList=" + this.c + "}";
    }
}
