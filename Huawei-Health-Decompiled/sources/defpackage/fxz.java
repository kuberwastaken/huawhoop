package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class fxz {

    @SerializedName("resultDesc")
    private String c;

    @SerializedName("resultCode")
    private String e;

    public String toString() {
        return "SetWorkoutRsp{resultCode='" + this.e + "', resultDesc='" + this.c + "'}";
    }
}
