package defpackage;

import com.huawei.hihealth.HiHealthData;
import health.compact.a.util.LogUtil;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: loaded from: classes8.dex */
public class thv implements Serializable {
    private static final long serialVersionUID = 7048918815967562789L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f17991a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private double g;
    private double h;
    private double i;
    private double j;
    private double m;
    private long n;
    private double o;

    public thv(HiHealthData hiHealthData) {
        if (hiHealthData == null) {
            LogUtil.d("AiBodyShapeBean", "hiHealthData is null, return");
            return;
        }
        this.e = hiHealthData.getDouble("bustGirth");
        this.o = hiHealthData.getDouble("waistGirth");
        this.g = hiHealthData.getDouble("hipline");
        this.i = hiHealthData.getDouble("thighGirth");
        this.b = hiHealthData.getDouble("calves");
        this.c = hiHealthData.getDouble("armCircumference");
        this.h = hiHealthData.getDouble("headCircumference");
        this.f = hiHealthData.getDouble("legLength");
        this.f17991a = hiHealthData.getDouble("armLength");
        this.j = hiHealthData.getDouble("shoulderWidth");
        this.m = hiHealthData.getDouble("waistHipRatio");
        this.d = hiHealthData.getDouble("bodyForm");
        this.n = hiHealthData.getStartTime();
    }

    public double d() {
        return this.d;
    }

    public double h() {
        return this.m;
    }

    public double e() {
        return this.c;
    }

    public double c() {
        return this.b;
    }

    public double f() {
        return this.i;
    }

    public double b() {
        return this.g;
    }

    public double j() {
        return this.o;
    }

    public double a() {
        return this.e;
    }

    public long i() {
        return this.n;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        thv thvVar = (thv) obj;
        return this.n == thvVar.n && Double.compare(thvVar.e, this.e) == 0 && Double.compare(thvVar.o, this.o) == 0 && Double.compare(thvVar.g, this.g) == 0 && Double.compare(thvVar.i, this.i) == 0 && Double.compare(thvVar.b, this.b) == 0 && Double.compare(thvVar.c, this.c) == 0 && Double.compare(thvVar.h, this.h) == 0 && Double.compare(thvVar.f, this.f) == 0 && Double.compare(thvVar.f17991a, this.f17991a) == 0 && Double.compare(thvVar.j, this.j) == 0 && Double.compare(thvVar.m, this.m) == 0 && Double.compare(thvVar.d, this.d) == 0;
    }

    public int hashCode() {
        return Objects.hash(Long.valueOf(this.n), Double.valueOf(this.e), Double.valueOf(this.o), Double.valueOf(this.g), Double.valueOf(this.i), Double.valueOf(this.b), Double.valueOf(this.c), Double.valueOf(this.h), Double.valueOf(this.f), Double.valueOf(this.f17991a), Double.valueOf(this.j), Double.valueOf(this.m), Double.valueOf(this.d));
    }

    public String toString() {
        return "AiBodyShapeBean{mTime=" + this.n + ", mBustGirth=" + this.e + ", mWaistGirth=" + this.o + ", mHipLine=" + this.g + ", mThighGirth=" + this.i + ", mCalves=" + this.b + ", mArmCircumference=" + this.c + ", mHeadCircumference=" + this.h + ", mLegLength=" + this.f + ", mArmLength=" + this.f17991a + ", mShoulderWidth=" + this.j + ", mWaistHipRatio=" + this.m + ", mBodyForm=" + this.d + '}';
    }
}
