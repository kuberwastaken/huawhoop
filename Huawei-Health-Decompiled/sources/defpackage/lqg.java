package defpackage;

/* JADX INFO: loaded from: classes6.dex */
public class lqg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15398a;
    private String b;
    private int c;
    private int d;
    private long e;

    public lqg(String str, String str2, int i, int i2, long j) {
        this.f15398a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = j;
    }

    public String b() {
        return this.f15398a;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public long a() {
        return this.e;
    }

    public void e(long j) {
        this.e = j;
    }

    public int c() {
        return this.d;
    }

    public String toString() {
        return "DeviceSyncStateBean{deviceId='" + this.f15398a + "', tableName='" + this.b + "', syncAllFlag=" + this.c + ", syncState=" + this.d + ", lastSyncTimestamp=" + this.e + '}';
    }
}
