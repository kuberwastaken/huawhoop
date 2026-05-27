package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes7.dex */
public class rdq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String f17305a;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String b;

    @SerializedName("subTitle")
    private String c;

    @SerializedName("title")
    private String d;

    @SerializedName("createTime")
    private long e;

    public String a() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.f17305a;
    }

    public long e() {
        return this.e;
    }

    public String b() {
        return this.c;
    }

    public String toString() {
        return "AudioWorkoutRestBean{title='" + this.d + "', desc='" + this.b + "', createTime=" + this.e + ", workoutId='" + this.f17305a + "', subTitle='" + this.c + "'}";
    }
}
