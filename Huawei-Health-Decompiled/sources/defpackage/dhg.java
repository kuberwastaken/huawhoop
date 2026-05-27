package defpackage;

import com.huawei.health.device.open.data.model.HealthData;
import com.huawei.health.device.open.data.model.IWeightAndFatRateData;

/* JADX INFO: loaded from: classes4.dex */
public class dhg extends HealthData implements IWeightAndFatRateData {
    private static final long serialVersionUID = 191744998741984175L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f12249a;
    private double c;
    private double d;
    private float e;
    private double g;
    private double h;
    private boolean k;
    private double l;
    private boolean o;
    private float p;
    private double q;
    private double s;
    private double t;
    private double[] n = new double[6];
    private int f = 1;
    private double[] j = new double[6];
    private String r = "";
    private String b = "";
    private boolean m = false;
    private boolean i = false;

    public double i() {
        return this.g;
    }

    public void f(double d) {
        this.g = d;
    }

    public boolean p() {
        return ((Boolean) dne.b(Boolean.valueOf(this.m))).booleanValue();
    }

    public void c(boolean z) {
        this.m = ((Boolean) dne.b(Boolean.valueOf(z))).booleanValue();
    }

    public boolean t() {
        return ((Boolean) dne.b(Boolean.valueOf(this.o))).booleanValue();
    }

    public void b(boolean z) {
        this.o = ((Boolean) dne.b(Boolean.valueOf(z))).booleanValue();
    }

    @Override // com.huawei.health.device.open.data.model.IWeightAndFatRateData
    public float getWeight() {
        return ((Float) dne.b(Float.valueOf(this.p))).floatValue();
    }

    @Override // com.huawei.health.device.open.data.model.IWeightAndFatRateData
    public void setWeight(float f) {
        this.p = ((Float) dne.b(Float.valueOf(f))).floatValue();
    }

    @Override // com.huawei.health.device.open.data.model.IWeightAndFatRateData
    public float getBodyFatRat() {
        return ((Float) dne.b(Float.valueOf(this.e))).floatValue();
    }

    public double k() {
        return ((Double) dne.b(Double.valueOf(this.q))).doubleValue();
    }

    public void i(double d) {
        this.q = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    @Override // com.huawei.health.device.open.data.model.IWeightAndFatRateData
    public void setBodyFatRat(float f) {
        this.e = ((Float) dne.b(Float.valueOf(f))).floatValue();
    }

    public double[] o() {
        return (double[]) dne.b(this.n);
    }

    public int j() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public double[] g() {
        return (double[]) dne.b(this.j);
    }

    public double e(int i) {
        double[] dArr = this.n;
        if (dArr.length <= 0 || i >= dArr.length) {
            return 0.0d;
        }
        return ((Double) dne.b(Double.valueOf(dArr[i]))).doubleValue();
    }

    public void d(int i, double d) {
        if (i >= 0) {
            double[] dArr = this.n;
            if (dArr.length > i) {
                dArr[i] = ((Double) dne.b(Double.valueOf(d))).doubleValue();
            }
        }
    }

    public double c(int i) {
        double[] dArr = this.j;
        if (dArr.length <= 0 || i >= dArr.length) {
            return 0.0d;
        }
        return ((Double) dne.b(Double.valueOf(dArr[i]))).doubleValue();
    }

    public void e(int i, double d) {
        if (i >= 0) {
            double[] dArr = this.j;
            if (dArr.length > i) {
                dArr[i] = ((Double) dne.b(Double.valueOf(d))).doubleValue();
            }
        }
    }

    public boolean s() {
        return ((Boolean) dne.b(Boolean.valueOf(this.k))).booleanValue();
    }

    public void d(boolean z) {
        this.k = ((Boolean) dne.b(Boolean.valueOf(z))).booleanValue();
    }

    public String m() {
        return this.r;
    }

    public void b(String str) {
        this.r = str;
    }

    public String f() {
        return this.b;
    }

    public void e(String str) {
        this.b = str;
    }

    public double e() {
        return ((Double) dne.b(Double.valueOf(this.d))).doubleValue();
    }

    public void b(double d) {
        this.d = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double h() {
        return ((Double) dne.b(Double.valueOf(this.t))).doubleValue();
    }

    public void a(double d) {
        this.t = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double d() {
        return ((Double) dne.b(Double.valueOf(this.f12249a))).doubleValue();
    }

    public void d(double d) {
        this.f12249a = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double n() {
        return this.s;
    }

    public void j(double d) {
        this.s = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double a() {
        return ((Double) dne.b(Double.valueOf(this.h))).doubleValue();
    }

    public void e(double d) {
        this.h = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double l() {
        return ((Double) dne.b(Double.valueOf(this.l))).doubleValue();
    }

    public void h(double d) {
        this.l = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public double b() {
        return ((Double) dne.b(Double.valueOf(this.c))).doubleValue();
    }

    public void c(double d) {
        this.c = ((Double) dne.b(Double.valueOf(d))).doubleValue();
    }

    public void e(boolean z) {
        this.i = ((Boolean) dne.b(Boolean.valueOf(z))).booleanValue();
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    public String toString() {
        return "WeightAndFatRateData [ weight=" + this.p + "body_fat_rate=" + this.e + "]";
    }

    @Override // com.huawei.health.device.open.data.model.HealthData
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public dhg mo394clone() {
        if (super.mo394clone() instanceof dhg) {
            return (dhg) super.mo394clone();
        }
        return new dhg();
    }
}
