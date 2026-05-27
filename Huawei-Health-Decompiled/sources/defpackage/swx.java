package defpackage;

/* JADX INFO: loaded from: classes8.dex */
public class swx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f17900a;
    private float b;
    private int c;
    private String d;
    private float e;
    private String f;
    private String g;
    private long h;
    private int i;
    private int j;
    private int l;
    private float m;
    private long o;

    public void c(long j) {
        this.o = j;
    }

    public long m() {
        return this.o;
    }

    public int g() {
        return this.i;
    }

    public void a(int i) {
        this.i = i;
    }

    public int a() {
        return this.c;
    }

    public void e(int i) {
        this.c = i;
    }

    public float d() {
        return this.b;
    }

    public void a(float f) {
        this.b = f;
    }

    public int f() {
        return this.j;
    }

    public void d(int i) {
        this.j = i;
    }

    public float b() {
        return this.e;
    }

    public void c(float f) {
        this.e = f;
    }

    public float e() {
        return this.f17900a;
    }

    public void e(float f) {
        this.f17900a = f;
    }

    public String c() {
        return this.d;
    }

    public void b(String str) {
        this.d = str;
    }

    public String h() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public int n() {
        return this.l;
    }

    public void c(int i) {
        this.l = i;
    }

    public long j() {
        return this.h;
    }

    public void e(long j) {
        if (String.valueOf(j).matches("\\d{13}")) {
            this.h = j / 1000;
        } else {
            this.h = j;
        }
    }

    public float i() {
        return this.m;
    }

    public void d(float f) {
        this.m = f;
    }

    public String toString() {
        return "BloodSugarDietBean{mDietType=" + this.c + ", mDiffNum=" + this.b + ", mDiffStatus=" + this.j + ", mDietCalorie=" + this.e + ", mDietCarbohydrates=" + this.f17900a + ", mDietDescription='" + this.d + "', mHighGiTitle='" + this.g + "', mHighGiFood='" + this.f + "', mWhichMeal=" + this.l + ", mEatTime=" + this.h + '}';
    }
}
