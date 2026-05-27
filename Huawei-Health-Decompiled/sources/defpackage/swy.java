package defpackage;

import com.huawei.hihealth.ResultUtils;

/* JADX INFO: loaded from: classes8.dex */
public class swy extends pgo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f17901a;
    private swy b;
    private swy c;
    private String d;
    private int e;
    private long f;
    private int g;
    private boolean h;
    private boolean i;
    private int j;
    private long l;
    private int n;

    public swy(float f, int i, int i2) {
        super(f);
        this.n = i;
        this.j = i2;
    }

    public int i() {
        return this.j;
    }

    public int l() {
        return this.n;
    }

    public long k() {
        return this.l;
    }

    public String b() {
        return this.d;
    }

    public swy e() {
        return this.b;
    }

    public void b(swy swyVar) {
        this.b = swyVar;
    }

    public swy d() {
        return this.c;
    }

    public void a(swy swyVar) {
        this.c = swyVar;
    }

    public void b(String str) {
        this.d = (String) ResultUtils.d(str);
    }

    public void d(long j) {
        this.l = j;
    }

    public boolean m() {
        return this.i;
    }

    public int g() {
        return this.g;
    }

    public void d(boolean z) {
        this.i = z;
    }

    public void a(int i) {
        this.g = i;
    }

    public void c(String str) {
        this.f17901a = str;
    }

    public String a() {
        return this.f17901a;
    }

    public int c() {
        return this.e;
    }

    public void d(int i) {
        this.e = i;
    }

    public long h() {
        return this.f;
    }

    public void e(long j) {
        this.f = j;
    }

    public boolean j() {
        return this.h;
    }

    public void a(boolean z) {
        this.h = z;
    }

    public String toString() {
        return "BloodSugarStorageModel{mTimePeriod=" + this.n + ", mStatusLevel=" + this.j + ", mIsNeedConfirm=" + this.i + ", mStatusLevelColor=" + this.g + ", mTime=" + this.l + ", mDeviceUuid='" + this.d + "', mBeforeMealData=" + this.b + ", mAfterMealData=" + this.c + ", mDataType='" + this.f17901a + "'}";
    }
}
