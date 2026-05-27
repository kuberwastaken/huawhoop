package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;

/* JADX INFO: loaded from: classes9.dex */
public class gec extends CloudCommonReponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("showData")
    private int f13406a;

    @SerializedName("authResult")
    private int e;

    public int e() {
        return this.e;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "AuthRsq{authResult=" + this.e + ", showData=" + this.f13406a + '}';
    }
}
