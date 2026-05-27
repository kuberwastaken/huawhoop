package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes4.dex */
public class fom {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("hotPathOperationInfo")
    private fol f13060a;

    @SerializedName("timeZone")
    private String c;

    @SerializedName("motionPathStartTime")
    private Long d;

    public Long d() {
        return this.d;
    }

    public fol c() {
        return this.f13060a;
    }

    public String toString() {
        return "HotPathParticipateHistory{motionPathStartTime=" + this.d + ", timeZone='" + this.c + "', hotPathOperationInfo=" + this.f13060a + '}';
    }
}
