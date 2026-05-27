package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class erb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("resultDesc")
    private String f12749a;

    @SerializedName("resultCode")
    private int b;

    @SerializedName("healthWeekReport")
    private eqv c;

    public int d() {
        return this.b;
    }

    public eqv b() {
        return this.c;
    }

    public String toString() {
        return "HealthReportResponse{mResultCode=" + this.b + ", mResultDescription=" + this.f12749a + ", mHealthWeekReport=" + this.c + "}";
    }
}
