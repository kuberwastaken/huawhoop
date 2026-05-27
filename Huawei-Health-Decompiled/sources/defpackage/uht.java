package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes11.dex */
public class uht {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("endTime")
    private int f18305a;

    @SerializedName("finalPrice")
    private double b;

    @SerializedName(HwPayConstant.KEY_AMOUNT)
    private double c;

    @SerializedName("couponId")
    private String d;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String e;

    @SerializedName("startTime")
    private int h;

    @SerializedName("originPrice")
    private double i;

    public String d() {
        return this.e;
    }

    public double c() {
        return this.c;
    }
}
