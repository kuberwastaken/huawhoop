package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;

/* JADX INFO: loaded from: classes6.dex */
public class mxl extends mxm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("action")
    private int f15916a;

    @SerializedName("timestamp")
    private long b;

    @SerializedName("version")
    private String c;

    @SerializedName(HwPayConstant.KEY_USER_NAME)
    private String d;

    public mxl(String str, int i, int i2) {
        this.f15916a = i;
        c(str);
        a(i2);
    }

    public void d(String str) {
        this.c = str;
    }

    public void e(String str) {
        this.d = str;
    }
}
