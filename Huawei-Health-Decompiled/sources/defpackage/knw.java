package defpackage;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class knw extends knr {

    @SerializedName("appInfos")
    private List<knt> c;

    public List<knt> a() {
        return this.c;
    }

    @Override // defpackage.knr
    public String toString() {
        return "ThirdAuthPermissionRsp{appInfos=" + this.c + '}';
    }
}
