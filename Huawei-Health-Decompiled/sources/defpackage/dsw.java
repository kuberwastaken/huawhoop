package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public class dsw {
    private int b;
    private int f;
    private String h;
    private long c = -1;
    private int d = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f12410a = null;
    private Long e = null;

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f12411a = 0;
        public static int b = 1;
        public static int e = 2;
    }

    public long b() {
        return this.c;
    }

    public void e(long j) {
        this.c = j;
    }

    public int d() {
        return this.d;
    }

    public void d(int i) {
        this.d = i;
    }

    public void d(byte[] bArr) {
        this.f12410a = bArr;
    }

    public byte[] c() {
        return this.f12410a;
    }

    public Long a() {
        return this.e;
    }

    public void b(Long l) {
        this.e = l;
    }

    public int e() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public String g() {
        return this.h;
    }

    public void a(String str) {
        this.h = str;
    }

    public void e(int i) {
        this.b = i;
    }

    public String toString() {
        return "SampleConfigInfo{mConfigId=" + this.c + ", mConfigAction=" + this.d + ", mByteConfigData=" + chk.e(chj.b(this.f12410a)) + ", mConfigModifyTime=" + this.e + ", mSupportCapability=" + this.f + ", mType=" + this.h + ", mChannelCapability=" + this.b + '}';
    }

    public boolean h() {
        return this.b == c.f12411a || this.b == c.e;
    }

    public boolean j() {
        return this.b == c.b || this.b == c.e;
    }
}
