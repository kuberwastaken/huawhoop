package defpackage;

import com.huawei.hihealth.dictionary.utils.DicDataTypeUtil;
import com.huawei.hwfoundationmodel.trackmodel.MotionPathSimplify;
import com.huawei.hwlogsmodel.LogUtil;
import health.compact.a.UnitUtil;
import java.io.Serializable;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class gjr implements Serializable, Cloneable {
    private static final long serialVersionUID = -1353400425254333543L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13497a;
    private int b;
    private LinkedHashMap<String, String> c;
    private float d;
    private int e;
    private int f;
    private int g;
    private int h;
    private float i;
    private int j;
    private long k;
    private int l;
    private float m;
    private int n;
    private int o;
    private float q;
    private int r;
    private float t;

    public gjr() {
        this.g = -1;
        this.j = -1;
        this.o = -1;
        this.f13497a = -101;
        this.e = -1;
        this.r = -1;
        this.f = -1;
        this.h = -1;
        this.n = -1;
        this.b = -1;
        this.d = -1.0f;
        this.m = -1.0f;
        this.t = -1.0f;
        this.i = -1.0f;
        this.q = -1.0f;
        this.l = -1;
        this.c = new LinkedHashMap<>();
    }

    public gjr(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.g = -1;
        this.j = -1;
        this.o = -1;
        this.f13497a = -101;
        this.e = -1;
        this.r = -1;
        this.f = -1;
        this.h = -1;
        this.n = -1;
        this.b = -1;
        this.d = -1.0f;
        this.m = -1.0f;
        this.t = -1.0f;
        this.i = -1.0f;
        this.q = -1.0f;
        this.l = -1;
        this.c = new LinkedHashMap<>();
        this.k = j;
        this.g = i;
        this.j = i2;
        this.o = i3;
        this.f13497a = i4;
        this.e = i5;
        this.r = i6;
        this.f = i7;
    }

    public long f() {
        return this.k;
    }

    public void b(long j) {
        this.k = j;
    }

    public int a() {
        return this.g;
    }

    public void d(int i) {
        this.g = i;
    }

    public int b() {
        return this.j;
    }

    public void e(int i) {
        this.j = i;
    }

    public int j() {
        return this.o;
    }

    public void f(int i) {
        this.o = i;
    }

    public int c() {
        return this.f13497a;
    }

    public void b(int i) {
        this.f13497a = i;
    }

    public int e() {
        return this.e;
    }

    public void c(int i) {
        this.e = i;
    }

    public int g() {
        return this.r;
    }

    public void i(int i) {
        this.r = i;
    }

    public int d() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public int o() {
        return this.h;
    }

    public void h(int i) {
        this.h = i;
    }

    public int k() {
        return this.n;
    }

    public void g(int i) {
        this.n = i;
    }

    public float h() {
        return this.d;
    }

    public void a(float f) {
        this.d = f;
    }

    public float n() {
        return this.m;
    }

    public void e(float f) {
        this.m = f;
    }

    public float s() {
        return this.t;
    }

    public void b(float f) {
        this.t = f;
    }

    public float l() {
        return this.i;
    }

    public void d(float f) {
        this.i = f;
    }

    public float q() {
        return this.q;
    }

    public void c(float f) {
        this.q = f;
    }

    public void j(int i) {
        this.l = i;
    }

    public int m() {
        return this.l;
    }

    public LinkedHashMap<String, String> i() {
        return this.c;
    }

    public void d(LinkedHashMap<String, String> linkedHashMap) {
        this.c = linkedHashMap;
    }

    public String toString() {
        return "RunningPosture { mTime = " + this.k + ", mGroundContactTime = " + this.g + ", mGroundImpactAcceleration = " + this.j + ", mSwingAngle = " + this.o + ", mEversionExcursion = " + this.f13497a + ", mForeFootStrikePattern = " + this.e + ", mWholeFootStrikePattern = " + this.r + ", mHindFootStrikePattern = " + this.f + ", mHangTime = " + this.h + ", mImpactHangRate = " + this.n + ", mCircleCadence = " + this.b + ", mStepLength = " + this.l + ", mAverageVerticalImpactRate = " + this.d + ", mImpactPeak = " + this.m + " mVerticalOscillation = " + this.t + ", mGcTimeBalance = " + this.i + ", mVerticalRatio = " + this.q + ", mExtraDataMap = " + this.c + "}";
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean r() {
        return ((float) this.g) <= -1.0f && ((float) this.j) <= -1.0f && ((float) this.o) <= -1.0f && this.f13497a <= -101 && ((float) this.e) <= -1.0f && ((float) this.r) <= -1.0f && ((float) this.f) <= -1.0f && ((float) this.h) <= -1.0f && ((float) this.n) <= -1.0f && Float.compare(this.d, -1.0f) <= 0 && Float.compare(this.m, -1.0f) <= 0 && Float.compare(this.t, -1.0f) <= 0 && Float.compare(this.i, -1.0f) <= 0 && Float.compare(this.q, -1.0f) <= 0 && ((float) this.l) <= -1.0f;
    }

    public static boolean c(MotionPathSimplify motionPathSimplify) {
        if (motionPathSimplify == null) {
            return true;
        }
        int iRequestAvgGroundContactTime = motionPathSimplify.requestAvgGroundContactTime();
        int iRequestAverageHangTime = motionPathSimplify.requestAverageHangTime();
        float fRequestGroundHangTimeRate = motionPathSimplify.requestGroundHangTimeRate();
        int iRequestAvgGroundImpactAcceleration = motionPathSimplify.requestAvgGroundImpactAcceleration();
        int iRequestAvgEversionExcursion = motionPathSimplify.requestAvgEversionExcursion();
        int iRequestAvgSwingAngle = motionPathSimplify.requestAvgSwingAngle();
        float fC = (float) UnitUtil.c(motionPathSimplify.getExtendDataFloat("avg_gc_tb"), 1);
        float extendDataFloat = motionPathSimplify.getExtendDataFloat("avg_v_osc");
        float extendDataFloat2 = motionPathSimplify.getExtendDataFloat("avg_v_s_r");
        int extendDataInt = motionPathSimplify.getExtendDataInt("avg_i_p");
        float extendDataFloat3 = motionPathSimplify.getExtendDataFloat("avg_v_i_r");
        LogUtil.b("Track_RunningPosture", "isAllDataZero contactTime = ", Integer.valueOf(iRequestAvgGroundContactTime), " impactAcceleration = ", Integer.valueOf(iRequestAvgGroundImpactAcceleration), " avgEversionExcursion = ", Integer.valueOf(iRequestAvgEversionExcursion), " avgSwingAngle = ", Integer.valueOf(iRequestAvgSwingAngle), " hangTime = ", Integer.valueOf(iRequestAverageHangTime), " groundHangTimeRate = ", Float.valueOf(fRequestGroundHangTimeRate), " avgTimeBalance = ", Float.valueOf(fC), " avgVerticalOscillation = ", Float.valueOf(extendDataFloat), " avgVerticalStrideRatio = ", Float.valueOf(extendDataFloat2), " avgImpactPeak = ", Integer.valueOf(extendDataInt), " averageVerticalImpactRate = ", Float.valueOf(extendDataFloat3));
        return iRequestAvgGroundContactTime <= 0 && iRequestAvgGroundImpactAcceleration <= 0 && iRequestAvgEversionExcursion <= 0 && iRequestAvgSwingAngle <= 0 && iRequestAverageHangTime <= 0 && Float.compare(fRequestGroundHangTimeRate, 0.0f) <= 0 && Float.compare(fC, 0.0f) <= 0 && Float.compare(extendDataFloat, 0.0f) <= 0 && Float.compare(extendDataFloat2, 0.0f) <= 0 && extendDataInt <= 0 && Float.compare(extendDataFloat3, 0.0f) <= 0;
    }

    public void c(int i, double d) {
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_GROUND_CONTACT_TIME.value()) {
            d((int) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_SWING_ANGLE.value()) {
            f((int) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_EVERSION.value()) {
            b((int) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_FORE_STEPS.value()) {
            c((int) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_WHOLE_STEPS.value()) {
            i((int) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_HIND_STEPS.value()) {
            a((int) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_HANG_TIME.value()) {
            h((int) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_GROUND_IMPACT_ACCELERATION.value()) {
            e((int) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_FLIGHT_RATIO.value()) {
            g((int) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_VERTICAL_LOADING_RATE.value()) {
            a((float) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_ACTIVE_PEAK.value()) {
            e((float) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_VERTICAL_RATIO.value()) {
            c((float) d);
            return;
        }
        if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_STRIDE.value()) {
            j((int) d);
        } else if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_VERTICAL_OSCILLATION.value()) {
            b((float) d);
        } else if (i == DicDataTypeUtil.DataType.REALTIME_SPORT_DATA_GC_TIME_BALANCE.value()) {
            d((float) d);
        }
    }
}
