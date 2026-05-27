package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class pmp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("abnormalContinuousDay")
    private int f16779a;

    @SerializedName("abnormalStepTipsPeriod")
    private int b;

    @SerializedName("abnormalStepSupportType")
    private String c;

    @SerializedName("courseDetailStyle")
    private int d;

    @SerializedName("afterProcessSwitch")
    private int e;

    @SerializedName("disableUpdateHealthLifeModel")
    private List<String> f;

    @SerializedName("sleepManagementDefaultSupportDeviceType")
    private String g;

    @SerializedName("supportShowStepTipDeviceList")
    private List<String> h;

    @SerializedName("sleepManagementReleaseSupportDeviceType")
    private String i;

    @SerializedName("sleepManagementSupportVersions")
    private List<String> j;

    public int a() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.f16779a;
    }

    public String b() {
        return this.c;
    }

    public List<String> i() {
        return this.h;
    }

    public List<String> j() {
        return this.f;
    }

    public String toString() {
        return "TemporaryConfigContent{mSupportVersions=" + this.j + ", mReleaseSupportDeviceType='" + this.i + ", mDefaultSupportDeviceType='" + this.g + ", mCourseDetailStyle=" + this.d + ", mAfterProcessSwitch=" + this.e + ", mAbnormalStepSupportType='" + this.c + ", mAbnormalStepTipsPeriod=" + this.b + ", mAbnormalContinuousDay=" + this.f16779a + ", mSupportShowStepTipDeviceList=" + this.h + ", mDisableUpdateHealthLifeModel=" + this.f + '}';
    }
}
