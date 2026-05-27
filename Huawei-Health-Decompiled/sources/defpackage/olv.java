package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class olv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("isAutoDetect")
    private int f16441a;

    @SerializedName("ftp")
    private int b;

    @SerializedName("source")
    private int c;

    @SerializedName("genTime")
    private long d;

    public int b() {
        return this.b;
    }

    public void c(int i) {
        this.b = i;
    }

    public int e() {
        return this.f16441a;
    }

    public void a(int i) {
        this.f16441a = i;
    }

    public void e(int i) {
        this.c = i;
    }

    public long a() {
        return this.d;
    }

    public void e(long j) {
        this.d = j;
    }

    public String toString() {
        return "CycleFtpConfig{mFtp=" + this.b + ", mIsAutoDetect=" + this.f16441a + ", mSource=" + this.c + ", mGenTime=" + this.d + '}';
    }
}
