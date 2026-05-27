package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class izy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("healthLifeVersionList")
    private List<izr> f14384a;

    @SerializedName("resultCode")
    private int b;

    @SerializedName("resultDesc")
    private String c;

    public int d() {
        return this.b;
    }

    public List<izr> e() {
        return this.f14384a;
    }

    public String toString() {
        return "HealthLifeVersionResponse{mResultCode=" + this.b + ", mResultDesc='" + this.c + ", mHealthLifeVersionList=" + this.f14384a + '}';
    }
}
