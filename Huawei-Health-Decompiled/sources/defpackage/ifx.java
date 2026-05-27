package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes5.dex */
public class ifx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("startTime")
    private long f14096a;

    @SerializedName("imageUrl")
    private String b;

    @SerializedName("endTime")
    private long c;

    @SerializedName("imageBigUrl")
    private String d;

    @SerializedName("backgroundImageUrl")
    private String e;

    public void b(long j) {
        this.f14096a = j;
    }

    public void e(long j) {
        this.c = j;
    }

    public String c() {
        return this.b;
    }

    public void d(String str) {
        this.b = str;
    }

    public String a() {
        return this.d;
    }

    public void a(String str) {
        this.d = str;
    }

    public String b() {
        return this.e;
    }

    public void e(String str) {
        this.e = str;
    }

    public boolean d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.f14096a;
        if (j != 0) {
            long j2 = this.c;
            if (j2 != 0) {
                return jCurrentTimeMillis >= j && jCurrentTimeMillis <= j2;
            }
        }
        if (j != 0 && this.c == 0) {
            return jCurrentTimeMillis >= j;
        }
        if (j != 0) {
            return false;
        }
        long j3 = this.c;
        return j3 != 0 && jCurrentTimeMillis <= j3;
    }
}
