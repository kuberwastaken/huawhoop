package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class rdo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("onlineDate")
    private String f17304a;

    @SerializedName("audioWorkoutDetail")
    private rdk d;

    public rdk e() {
        return this.d;
    }

    public String b() {
        return this.f17304a;
    }

    public String toString() {
        return "AudioWorkoutDetailByDate{audioWorkoutDetail=" + this.d + ", onlineDate='" + this.f17304a + "'}";
    }
}
