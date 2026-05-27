package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes10.dex */
public class eqp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("comment")
    private String f12740a;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String b;

    @SerializedName("id")
    private String c;

    @SerializedName("extend")
    private String d;

    @SerializedName("effect")
    private String e;

    @SerializedName("targetDataType")
    private String f;

    @SerializedName("targetDataExp")
    private String g;

    @SerializedName("name")
    private String h;

    @SerializedName("target")
    private String i;

    @SerializedName(TypedValues.CycleType.S_WAVE_PERIOD)
    private String j;

    public String toString() {
        return "HealthInterventionDimension{mId=" + this.c + ", mName=" + this.h + ", mTarget=" + this.i + ", mDesc=" + this.b + ", mEffect=" + this.e + ", mComment=" + this.f12740a + ", mTargetDataType=" + this.f + ", mTargetDataExp=" + this.g + ", mPeriod=" + this.j + ", mExtend=" + this.d + "}";
    }
}
