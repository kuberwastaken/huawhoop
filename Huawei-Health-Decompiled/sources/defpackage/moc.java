package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes6.dex */
public class moc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("startTime")
    private long f15753a;

    @SerializedName("endTime")
    private long d;

    public long j() {
        return this.f15753a;
    }

    public void d(long j) {
        this.f15753a = j;
    }

    public long b() {
        return this.d;
    }

    public void c(long j) {
        this.d = j;
    }

    public String toString() {
        return "BaseUiData{startTime=" + this.f15753a + ", endTime=" + this.d + '}';
    }
}
