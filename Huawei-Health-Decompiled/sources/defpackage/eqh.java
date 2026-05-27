package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class eqh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("timestamp")
    private String f12732a;

    @SerializedName("msgContent")
    private String b;

    @SerializedName("msgType")
    private String d;

    public String d() {
        return this.f12732a;
    }

    public String e() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public String toString() {
        return "DoctorImInfoMap{mTimestamp=" + this.f12732a + ", mMessageType=" + this.d + ", mMessageContent=" + this.b + "}";
    }
}
