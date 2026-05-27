package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class erc {

    @SerializedName("infoList")
    private List<eqo> d;

    @SerializedName("resultCode")
    private int e;

    public int e() {
        return this.e;
    }

    public List<eqo> a() {
        return this.d;
    }

    public String toString() {
        return "GetUserSampleConfigResponse{mResultCode=" + this.e + ", mGetUserSampleConfigResultList=" + this.d + "}";
    }
}
