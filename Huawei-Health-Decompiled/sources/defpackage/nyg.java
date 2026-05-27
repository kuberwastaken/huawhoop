package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;

/* JADX INFO: loaded from: classes7.dex */
public class nyg {

    @SerializedName("resourceID")
    private String aa;

    @SerializedName("topicName")
    private String ab;

    @SerializedName("resourceType")
    private String ac;

    @SerializedName("subtitleUrl")
    private String ad;

    @SerializedName("trackTarget")
    private int ae;

    @SerializedName("trackTargetValue")
    private float af;

    @SerializedName("userDefinedType")
    private int ag;

    @SerializedName("version")
    private String ah;

    @SerializedName("trackType")
    private int ai;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String ak;

    @SerializedName("workoutPackageId")
    private String al;

    @SerializedName("weekNumber")
    private int an;

    @SerializedName("entrance")
    private String b;

    @SerializedName("hasNextTrain")
    private boolean c;

    @SerializedName("abInfo")
    private String d;

    @SerializedName("algId")
    private String e;

    @SerializedName("entranceType")
    private String g;

    @SerializedName("isAfterRun")
    private boolean h;

    @SerializedName("isDeviceTraining")
    private boolean i;

    @SerializedName("isFromScheme")
    private boolean k;

    @SerializedName("isImmediateStart")
    private boolean l;

    @SerializedName("isSendCourseDevice")
    private boolean m;

    @SerializedName("isPlanFit")
    private boolean n;

    @SerializedName("isNeedExecuteDown")
    private boolean o;

    @SerializedName("isShowButton")
    private boolean p;

    @SerializedName("planExecuteTime")
    private long q;

    @SerializedName("itemId")
    private String r;

    @SerializedName("moveTaskToBack")
    private boolean s;

    @SerializedName("longCoachUrl")
    private String t;

    @SerializedName("planTempId")
    private String u;

    @SerializedName("planId")
    private String v;

    @SerializedName("pullOrder")
    private String w;

    @SerializedName("pullFrom")
    private String x;

    @SerializedName("promoteTag")
    private String y;

    @SerializedName("resourceName")
    private String z;

    @SerializedName("workoutOrder")
    private int am = 1;

    @SerializedName("executeImmediateErrorType")
    private int j = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("enterAnim")
    private int f16230a = -1;

    @SerializedName("exitAnim")
    private int f = -1;

    public nyg(String str) {
        this.ak = str;
    }

    public boolean ae() {
        return this.k;
    }

    public void d(boolean z) {
        this.k = z;
    }

    public String ab() {
        return this.ak;
    }

    public void r(String str) {
        this.ak = str;
    }

    public String y() {
        return this.ah;
    }

    public void s(String str) {
        this.ah = str;
    }

    public String c() {
        return this.g;
    }

    public void d(String str) {
        this.g = str;
    }

    public String d() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String z() {
        return this.al;
    }

    public void t(String str) {
        this.al = str;
    }

    public String p() {
        return this.ac;
    }

    public String o() {
        return this.u;
    }

    public void h(String str) {
        this.u = str;
    }

    public String l() {
        return this.x;
    }

    public void g(String str) {
        this.x = str;
    }

    public String q() {
        return this.aa;
    }

    public void m(String str) {
        this.aa = str;
    }

    public String r() {
        return this.z;
    }

    public void l(String str) {
        this.z = str;
    }

    public String m() {
        return this.w;
    }

    public void o(String str) {
        this.w = str;
    }

    public String b() {
        return this.e;
    }

    public void c(String str) {
        this.e = str;
    }

    public String k() {
        return this.y;
    }

    public void j(String str) {
        this.y = str;
    }

    public String f() {
        return this.r;
    }

    public void e(String str) {
        this.r = str;
    }

    public String n() {
        return this.v;
    }

    public void i(String str) {
        this.v = str;
    }

    public String a() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public int w() {
        return this.ag;
    }

    public void g(int i) {
        this.ag = i;
    }

    public boolean al() {
        return this.m;
    }

    public void f(boolean z) {
        this.m = z;
    }

    public boolean ah() {
        return this.s;
    }

    public void j(boolean z) {
        this.s = z;
    }

    public long h() {
        return this.q;
    }

    public void c(long j) {
        this.q = j;
    }

    public String i() {
        return this.t;
    }

    public void f(String str) {
        this.t = str;
    }

    public String t() {
        return this.ad;
    }

    public void k(String str) {
        this.ad = str;
    }

    public int ac() {
        return this.am;
    }

    public void h(int i) {
        this.am = i;
    }

    public int ad() {
        return this.an;
    }

    public void j(int i) {
        this.an = i;
    }

    public boolean aj() {
        return this.n;
    }

    public void h(boolean z) {
        this.n = z;
    }

    public boolean aa() {
        return this.h;
    }

    public void b(boolean z) {
        this.h = z;
    }

    public int g() {
        return this.j;
    }

    public void e(int i) {
        this.j = i;
    }

    public boolean am() {
        return this.o;
    }

    public void g(boolean z) {
        this.o = z;
    }

    public boolean an() {
        return this.p;
    }

    public void i(boolean z) {
        this.p = z;
    }

    public int v() {
        return this.ai;
    }

    public void d(int i) {
        this.ai = i;
    }

    public int x() {
        return this.ae;
    }

    public void c(int i) {
        this.ae = i;
    }

    public float u() {
        return this.af;
    }

    public void c(float f) {
        this.af = f;
    }

    public boolean af() {
        return this.l;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public int e() {
        return this.f16230a;
    }

    public void a(int i) {
        this.f16230a = i;
    }

    public int j() {
        return this.f;
    }

    public void b(int i) {
        this.f = i;
    }

    public boolean ai() {
        return this.i;
    }

    public void e(boolean z) {
        this.i = z;
    }

    public String s() {
        return this.ab;
    }

    public void n(String str) {
        this.ab = str;
    }

    public boolean ag() {
        return this.c;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public String toString() {
        return "CourseJumpParameter{mIsFromScheme=" + this.k + ", mWorkoutId='" + this.ak + "', mVersion='" + this.ah + "', mEntranceType='" + this.g + "', mEntrance='" + this.b + "', mWorkoutPackageId='" + this.al + "', mResourceType='" + this.ac + "', mPlanTempId='" + this.u + "', mPullFrom='" + this.x + "', mResourceID='" + this.aa + "', mResourceName='" + this.z + "', mPullOrder='" + this.w + "', mAlgId='" + this.e + "', mPromoteTag='" + this.y + "', mItemId='" + this.r + "', mPlanId='" + this.v + "', mAbInfo='" + this.d + "', mUserDefinedType=" + this.ag + ", mIsSendCourseDevice=" + this.m + ", mMoveTaskToBack=" + this.s + ", mPlanExecuteTime=" + this.q + ", mLongCoachUrl='" + this.t + "', mSubtitleUrl='" + this.ad + "', mWorkoutOrder=" + this.am + ", mWeekNumber=" + this.an + ", mIsPlanFit=" + this.n + ", mIsAfterRun=" + this.h + ", mIsNeedExecuteDown=" + this.o + ", mExecuteImmediateErrorType=" + this.j + ", mIsShowButton=" + this.p + ", mTrackType=" + this.ai + ", mTrackTarget=" + this.ae + ", mTrackTargetValue=" + this.af + ", mIsImmediateStart=" + this.l + ", mEnterAnim=" + this.f16230a + ", mExitAnim=" + this.f + ", mIsDeviceTraining=" + this.i + ", mTopicName='" + this.ab + "', hasNextTrain=" + this.c + '}';
    }
}
