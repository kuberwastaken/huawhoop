package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.device.fatscale.datatypes.BaseViewBeanApi;
import com.huawei.hwcommonmodel.application.BaseApplication;
import health.compact.a.LanguageUtil;
import health.compact.a.UnitUtil;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public class dbt implements Serializable, BaseViewBeanApi {
    private static final long serialVersionUID = 7211266658293312319L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mBodyMassIndex")
    private double f12151a;

    @SerializedName("mLeftUpperLimbMuscleMass")
    private double aa;

    @SerializedName("mMuscleBalance")
    private double ab;

    @SerializedName("mModifyTime")
    private long ac;

    @SerializedName("mMuscleMass")
    private double ad;

    @SerializedName("mRasm")
    private double ae;

    @SerializedName("mProtein")
    private double af;

    @SerializedName("mRightFootFatRate")
    private double ah;

    @SerializedName("mPressureIndex")
    private double ai;

    @SerializedName("mRightLowerLimbMuscleMass")
    private double aj;

    @SerializedName("mRightUpperLimbMuscleMass")
    private double ak;

    @SerializedName("mRightLowerLimbFatMass")
    private double al;

    @SerializedName("mRightHandFatRate")
    private double am;

    @SerializedName("mRightUpperLimbFatMass")
    private double an;

    @SerializedName("mTrunkFatMass")
    private double ao;

    @SerializedName("mTotalWaterRate")
    private double ap;

    @SerializedName("mSex")
    private byte aq;

    @SerializedName("mSkeletalMuscle")
    private double ar;

    @SerializedName("mTotalWater")
    private double as;

    @SerializedName("mWaistToHipRatio")
    private double at;

    @SerializedName("mTrunkMuscleMass")
    private double au;

    @SerializedName("mTrunkFatRate")
    private double av;

    @SerializedName("mWaistToHipRatioUser")
    private double aw;

    @SerializedName("mVisceraFatLevel")
    private double ax;

    @SerializedName("mWeight")
    private double az;

    @SerializedName("mBodyAge")
    private double b;

    @SerializedName("resistance")
    private double ba;

    @SerializedName("mWeighTime")
    private long bb;

    @SerializedName("mWeightEndTime")
    private long bc;

    @SerializedName("mAge")
    private int c;

    @SerializedName("mBasalMetabolicRate")
    private double d;

    @SerializedName("mBodyScore")
    private double e;

    @SerializedName("mClientId")
    private int f;

    @SerializedName("mDeviceName")
    private String g;

    @SerializedName("mBodyType")
    private double h;

    @SerializedName("mDataType")
    private int i;

    @SerializedName("mBodyShape")
    private double j;

    @SerializedName("mFatMass")
    private double k;

    @SerializedName("mFatBalance")
    private double l;

    @SerializedName("mFatRate")
    private double m;

    @SerializedName("mDeviceUuid")
    private String n;

    @SerializedName("mHeartRate")
    private double p;

    @SerializedName("mIsManual")
    private boolean q;

    @SerializedName("mInorganicSalt")
    private double r;

    @SerializedName("mHeight")
    private int t;

    @SerializedName("mLeftHandFatRate")
    private double u;

    @SerializedName("mLeftLowerLimbMuscleMass")
    private double v;

    @SerializedName("mLeftUpperLimbFatMass")
    private double w;

    @SerializedName("mLeftFootFatRate")
    private double x;

    @SerializedName("mLeftLowerLimbFatMass")
    private double y;

    @SerializedName("mPole")
    private int z;

    @SerializedName("mResistanceArray")
    private double[] ag = new double[6];

    @SerializedName("mHfResistanceArray")
    private double[] s = new double[6];

    @SerializedName("mFreq")
    private int o = 1;

    @Override // com.huawei.health.device.fatscale.datatypes.BaseViewBeanApi
    public double getDoubleOrIntLevelByType(int i) {
        return -1.0d;
    }

    @Override // com.huawei.health.device.fatscale.datatypes.BaseViewBeanApi
    public int getFractionDigitByType(int i) {
        return 1;
    }

    @Override // com.huawei.health.device.fatscale.datatypes.BaseViewBeanApi
    public boolean isNewScaleType() {
        return false;
    }

    public String l() {
        return this.g;
    }

    public void d(String str) {
        this.g = str;
    }

    public String o() {
        return this.n;
    }

    public void b(String str) {
        this.n = str;
    }

    public double at() {
        if (Double.isNaN(this.az) || Double.isInfinite(this.az)) {
            return 0.0d;
        }
        return ((Double) dne.b(Double.valueOf(this.az))).doubleValue();
    }

    public void af(double d) {
        this.az = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double a() {
        return ((Double) dne.b(Double.valueOf(this.m))).doubleValue();
    }

    public void a(double d) {
        this.m = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double c() {
        return UnitUtil.c((UnitUtil.c(this.az, 1) * this.m) / 100.0d, 1);
    }

    public void b(double d) {
        this.k = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double ah() {
        return ((Double) dne.b(Double.valueOf(this.ba))).doubleValue();
    }

    public void w(double d) {
        this.ba = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double am() {
        return ((Double) dne.b(Double.valueOf(this.as))).doubleValue();
    }

    public void ad(double d) {
        this.as = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double ao() {
        return this.ap;
    }

    public void ag(double d) {
        this.ap = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double p() {
        return ((Double) dne.b(Double.valueOf(this.ax))).doubleValue();
    }

    public void k(double d) {
        this.ax = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double h() {
        return ((Double) dne.b(Double.valueOf(this.r))).doubleValue();
    }

    public void g(double d) {
        this.r = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double f() {
        return ((Double) dne.b(Double.valueOf(this.f12151a))).doubleValue();
    }

    public void d(double d) {
        this.f12151a = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double d() {
        return ((Double) dne.b(Double.valueOf(this.d))).doubleValue();
    }

    public void e(double d) {
        this.d = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double z() {
        return ((Double) dne.b(Double.valueOf(this.ad))).doubleValue();
    }

    public void r(double d) {
        this.ad = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double ac() {
        return ((Double) dne.b(Double.valueOf(this.af))).doubleValue();
    }

    public void s(double d) {
        this.af = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double i() {
        return ((Double) dne.b(Double.valueOf(this.e))).doubleValue();
    }

    public void j(double d) {
        this.e = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double b() {
        return ((Double) dne.b(Double.valueOf(this.b))).doubleValue();
    }

    public void c(double d) {
        this.b = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double r() {
        return this.p;
    }

    public void l(double d) {
        this.p = d;
    }

    public double ad() {
        return this.ai;
    }

    public void q(double d) {
        this.ai = d;
    }

    public long av() {
        return ((Long) dne.b(Long.valueOf(this.bb))).longValue();
    }

    public void a(long j) {
        this.bb = ((Long) dne.b(Long.valueOf(j))).longValue();
    }

    public long au() {
        return ((Long) dne.b(Long.valueOf(this.bc))).longValue();
    }

    public void c(long j) {
        this.bc = ((Long) dne.b(Long.valueOf(j))).longValue();
    }

    public int k() {
        return this.i;
    }

    public void b(int i) {
        this.i = i;
    }

    public double al() {
        return ((Double) dne.b(Double.valueOf(this.ar))).doubleValue();
    }

    public void ab(double d) {
        this.ar = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public int aa() {
        return this.z;
    }

    public void i(int i) {
        this.z = i;
    }

    public double af() {
        return this.aj;
    }

    public void x(double d) {
        this.aj = d;
    }

    public double x() {
        return this.v;
    }

    public void o(double d) {
        this.v = d;
    }

    public double an() {
        return this.ak;
    }

    public void aa(double d) {
        this.ak = d;
    }

    public double u() {
        return this.aa;
    }

    public void t(double d) {
        this.aa = d;
    }

    public double ap() {
        return this.au;
    }

    public void z(double d) {
        this.au = d;
    }

    public double ag() {
        return this.al;
    }

    public void y(double d) {
        this.al = d;
    }

    public double y() {
        return this.y;
    }

    public void n(double d) {
        this.y = d;
    }

    public double aj() {
        return this.an;
    }

    public void v(double d) {
        this.an = d;
    }

    public double v() {
        return this.w;
    }

    public void m(double d) {
        this.w = d;
    }

    public double aq() {
        return this.ao;
    }

    public void ac(double d) {
        this.ao = d;
    }

    public double as() {
        return this.at;
    }

    public void ai(double d) {
        this.at = d;
    }

    public void ah(double d) {
        this.aw = d;
    }

    public double ar() {
        return this.aw;
    }

    public void a(int i) {
        this.o = i;
    }

    public double[] q() {
        double[] dArr = this.s;
        return dArr != null ? (double[]) dArr.clone() : new double[6];
    }

    public void e(double[] dArr) {
        if (dArr != null) {
            this.s = (double[]) dArr.clone();
        }
    }

    public double[] ae() {
        double[] dArr = this.ag;
        return dArr != null ? (double[]) dArr.clone() : new double[6];
    }

    public void c(double[] dArr) {
        if (dArr != null) {
            this.ag = (double[]) dArr.clone();
        }
    }

    public double ai() {
        return this.ae;
    }

    public void u(double d) {
        this.ae = d;
    }

    public double g() {
        return this.h;
    }

    public void f(double d) {
        this.h = d;
    }

    public double j() {
        return this.j;
    }

    public void i(double d) {
        this.j = d;
    }

    public double n() {
        return this.l;
    }

    public void h(double d) {
        this.l = d;
    }

    public double ab() {
        return this.ab;
    }

    public void p(double d) {
        this.ab = d;
    }

    public int e() {
        return ((Integer) dne.b(Integer.valueOf(this.c))).intValue();
    }

    public void e(int i) {
        this.c = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public int s() {
        return ((Integer) dne.b(Integer.valueOf(this.t))).intValue();
    }

    public void c(int i) {
        this.t = ((Integer) dne.b(Integer.valueOf(i))).intValue();
    }

    public byte ak() {
        return ((Byte) dne.b(Byte.valueOf(this.aq))).byteValue();
    }

    public void e(byte b) {
        this.aq = ((Byte) dne.b(Byte.valueOf(b))).byteValue();
    }

    public int m() {
        return this.f;
    }

    public void d(int i) {
        this.f = i;
    }

    public long w() {
        return this.ac;
    }

    public void d(long j) {
        this.ac = j;
    }

    public boolean t() {
        return this.q;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public boolean equals(Object obj) {
        return (obj instanceof dbt) && ((dbt) obj).av() == this.bb;
    }

    @Override // com.huawei.health.device.fatscale.datatypes.BaseViewBeanApi
    public boolean isVisible(int i, boolean z) {
        if (i != 31) {
            return true;
        }
        if (z || !eid.e(this.e)) {
            return false;
        }
        return LanguageUtil.o(BaseApplication.getContext()) || LanguageUtil.t(BaseApplication.getContext());
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "WeightBean{mWeight=" + this.az + ", mFatRate=" + this.m + ", mFatMass=" + this.k + ", mTotalWater=" + this.as + ", mTotalWaterRate=" + this.ap + ", mVisceraFatLevel=" + this.ax + ", mInorganicSalt=" + this.r + ", mBodyMassIndex=" + this.f12151a + ", mBasalMetabolicRate=" + this.d + ", mMuscleMass=" + this.ad + ", mProtein=" + this.af + ", mSkeletalMuscle=" + this.ar + ", mHeartRate=" + this.p + ", mPressureIndex=" + this.ai + ", mRightLowerLimbMuscleMass=" + this.aj + ", mLeftLowerLimbMuscleMass=" + this.v + ", mRightUpperLimbMuscleMass=" + this.ak + ", mLeftUpperLimbMuscleMass=" + this.aa + ", mTrunkMuscleMass=" + this.au + ", mRightLowerLimbFatMass=" + this.al + ", mLeftLowerLimbFatMass=" + this.y + ", mRightUpperLimbFatMass=" + this.an + ", mLeftUpperLimbFatMass=" + this.w + ", mTrunkFatMass=" + this.ao + ", mRasm=" + this.ae + ", mWaistToHipRatio=" + this.at + ", mWaistToHipRatioUser=" + this.aw + ", mFatBalance=" + this.l + ", mMuscleBalance=" + this.ab + ", mBodyAge=" + this.b + ", mBodyScore=" + this.e + ", mBodyType=" + this.h + ", mBodyShape=" + this.j + ", mAge=" + this.c + ", mHeight=" + this.t + ", mSex=" + ((int) this.aq) + ", mPole=" + this.z + ", resistance=" + this.ba + ", mWeighTime=" + this.bb + ", mRightHandFatRate=" + this.am + ", mLeftHandFatRate=" + this.u + ", mRightFootFatRate=" + this.ah + ", mLeftFootFatRate=" + this.x + ", mTrunkFatRate=" + this.av + ", mResistanceArray=" + Arrays.toString(this.ag) + ", mHfResistanceArray=" + Arrays.toString(this.s) + ", mFreq=" + this.o + ", mWeightEndTime=" + this.bc + ", mDataType=" + this.i + ", mDeviceUuid='" + this.n + "', mClientId=" + this.f + ", mIsManual=" + this.q + ", mModifyTime=" + this.ac + ", mDeviceName='" + this.g + "'}";
    }

    @Override // com.huawei.health.device.fatscale.datatypes.BaseViewBeanApi
    public String getWeightScaleProductId() {
        return "";
    }

    @Override // com.huawei.health.device.fatscale.datatypes.BaseViewBeanApi
    public String getStringLevelByType(int i) {
        return "";
    }

    @Override // com.huawei.health.device.fatscale.datatypes.BaseViewBeanApi
    public String[] getStringArrayLevelByType(int i) {
        return new String[0];
    }

    @Override // com.huawei.health.device.fatscale.datatypes.BaseViewBeanApi
    public double[] getDoubleArrayLevelByType(int i) {
        return new double[0];
    }
}
