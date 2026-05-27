package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class rdv {

    @SerializedName("resultDesc")
    private String b;

    @SerializedName("resultCode")
    private String e;

    public String c() {
        return this.e;
    }

    public String toString() {
        return "SetWorkoutRsp{resultCode='" + this.e + "', resultDesc='" + this.b + "'}";
    }
}
