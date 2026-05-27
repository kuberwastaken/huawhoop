package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes9.dex */
public class kns extends knr {

    @SerializedName("healthScopes")
    private String b;

    @Override // defpackage.knr
    public String toString() {
        return "getScopeRsp{healthScopes='" + this.b + "'}";
    }

    public String b() {
        return this.b;
    }
}
