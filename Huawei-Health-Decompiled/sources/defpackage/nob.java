package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class nob extends nof implements Comparable<nob> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16060a;
    private int aa;
    private int ab;
    private String ac;
    private String ad;
    private int ae;
    private long af;
    private int ag;
    private long ah;
    private long ai;
    private int an;
    private int b;
    private String c;
    private int d;
    private long e;
    private int f;
    private String g;
    private long h;
    private int i;
    private int j;
    private String k;
    private String l;
    private int m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private int s;
    private long t;
    private int u;
    private int v;
    private int w;
    private String x;
    private int y;
    private long z;

    public nob() {
        super(12);
    }

    public String h() {
        return this.p;
    }

    public void c(String str) {
        this.p = str;
    }

    public String g() {
        return this.x;
    }

    public void f(String str) {
        this.x = str;
    }

    public String b() {
        return this.k;
    }

    public void b(String str) {
        this.k = str;
    }

    public String k() {
        return this.ac;
    }

    public void g(String str) {
        this.ac = str;
    }

    public String d() {
        return this.q;
    }

    public void e(String str) {
        this.q = str;
    }

    public int f() {
        return this.s;
    }

    public void d(int i) {
        this.s = i;
    }

    public int o() {
        return this.w;
    }

    public void b(int i) {
        this.w = i;
    }

    public int l() {
        return this.y;
    }

    public void e(int i) {
        this.y = i;
    }

    public int p() {
        return this.ag;
    }

    public void j(int i) {
        this.ag = i;
    }

    public String e() {
        return this.o;
    }

    public void d(String str) {
        this.o = str;
    }

    public long a() {
        return this.e;
    }

    public void a(long j) {
        this.e = j;
    }

    public long r() {
        return this.ai;
    }

    public void e(long j) {
        this.ai = j;
    }

    public long m() {
        return this.z;
    }

    public void c(long j) {
        this.z = j;
    }

    public void d(long j) {
        this.t = j;
    }

    public String q() {
        return this.ad;
    }

    public void j(String str) {
        this.ad = str;
    }

    public int n() {
        return this.u;
    }

    public void c(int i) {
        this.u = i;
    }

    public String j() {
        return this.r;
    }

    public void a(String str) {
        this.r = str;
    }

    public int t() {
        return this.ae;
    }

    public void i(int i) {
        this.ae = i;
    }

    public int i() {
        return this.v;
    }

    public void a(int i) {
        this.v = i;
    }

    public long c() {
        return this.h;
    }

    public void b(long j) {
        this.h = j;
    }

    public int s() {
        return this.ab;
    }

    public void f(int i) {
        this.ab = i;
    }

    public void l(int i) {
        this.b = i;
    }

    public int y() {
        return this.i;
    }

    public void n(int i) {
        this.i = i;
    }

    public String ab() {
        return this.l;
    }

    public void l(String str) {
        this.l = str;
    }

    public String z() {
        return this.n;
    }

    public void o(String str) {
        this.n = str;
    }

    public int x() {
        return this.f16060a;
    }

    public void h(int i) {
        this.f16060a = i;
    }

    public int ah() {
        return this.aa;
    }

    public void t(int i) {
        this.aa = i;
    }

    public int ad() {
        return this.f;
    }

    public void o(int i) {
        this.f = i;
    }

    public int w() {
        return this.d;
    }

    public void g(int i) {
        this.d = i;
    }

    public long ae() {
        return this.ah;
    }

    public void i(long j) {
        this.ah = j;
    }

    public long af() {
        return this.af;
    }

    public void j(long j) {
        this.af = j;
    }

    public int ac() {
        return this.m;
    }

    public void k(int i) {
        this.m = i;
    }

    public String aa() {
        return this.g;
    }

    public void i(String str) {
        this.g = str;
    }

    public int u() {
        return this.j;
    }

    public void m(int i) {
        this.j = i;
    }

    public String v() {
        return this.c;
    }

    public void h(String str) {
        this.c = str;
    }

    public int ai() {
        return this.an;
    }

    public void p(int i) {
        this.an = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof nob) {
            nob nobVar = (nob) obj;
            String str = this.p;
            if (str != null && str.equals(nobVar.h()) && nobVar.ah() == this.aa && nobVar.ac() == this.m) {
                return true;
            }
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(nob nobVar) {
        if (nobVar == null) {
            return 0;
        }
        int i = this.u;
        int i2 = nobVar.u;
        return i != i2 ? i2 - i : nobVar.aa - this.aa;
    }

    public String toString() {
        return "KakaTaskInfo{taskId=" + this.p + ", taskName='" + this.x + "', taskDes='" + this.k + "', taskSpecification='" + this.ac + "', taskDetailUrl='" + this.q + "', taskFrequency=" + this.s + ", taskRewardKaka=" + this.w + ", taskRewardExperience=" + this.y + ", taskTypes=" + this.ag + ", taskConditions='" + this.o + "', eventTimestamp=" + this.e + ", taskSyncTimestamp=" + this.ai + ", taskStartTime=" + this.z + ", taskEndTime=" + this.t + ", taskStatus='" + this.ad + "', taskPriority=" + this.u + ", taskIcon='" + this.r + "', taskIsShow='" + this.v + "', lastTimestamp='" + this.h + "', taskSyncLocation='" + this.ab + "', taskSyncStatus=" + this.ae + ", healthTaskType=" + this.b + ", kakaContinuous=" + this.i + ", preBotton='" + this.l + "', postBotton='" + this.n + "', category=" + this.f16060a + ", taskRule=" + this.aa + ", level=" + this.f + ", bonusType=" + this.d + ", updateTime=" + this.ah + ", timeZoneOffset=" + this.af + ", pictureUrl='" + this.g + "', scenario=" + this.m + ", labelMatch=" + this.j + ", buttonColor='" + this.c + '}';
    }
}
