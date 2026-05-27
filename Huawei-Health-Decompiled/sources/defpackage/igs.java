package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes.dex */
public class igs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("mSportType")
    private int f14106a;

    @SerializedName("mSportResult")
    private long e;

    public void c(int i) {
        this.f14106a = i;
    }

    public void a(long j) {
        this.e = j;
    }

    public String toString() {
        return "SportResult{mSportType=" + this.f14106a + ", mSportResult=" + this.e + '}';
    }
}
