package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class eqx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("resultCode")
    private int f12746a;

    @SerializedName("messages")
    private List<eqh> b;

    @SerializedName("resultDesc")
    private String d;

    @SerializedName("unReadMsgCount")
    private int e;

    public int b() {
        return this.f12746a;
    }

    public List<eqh> a() {
        return this.b;
    }

    public int d() {
        return this.e;
    }

    public String toString() {
        return "DoctorImInfoResponse{mResultCode=" + this.f12746a + ", mResultDescription=" + this.d + ", mDoctorImInfoMapList=" + this.b + "}";
    }
}
