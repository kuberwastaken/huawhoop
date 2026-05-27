package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;

/* JADX INFO: loaded from: classes11.dex */
public class oco {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("nickName")
    private String f16289a = "";

    @SerializedName(HwPayConstant.KEY_USER_ID)
    private long b;

    @SerializedName("imageURL")
    private String e;

    public void a(long j) {
        this.b = j;
    }

    public void e(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.f16289a = str;
    }
}
