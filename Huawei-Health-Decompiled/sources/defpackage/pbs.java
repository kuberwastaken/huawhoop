package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.common.CommonPickerConstant;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;

/* JADX INFO: loaded from: classes7.dex */
public class pbs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("discountPrice")
    private String f16611a;

    @SerializedName("userType")
    private String aa;

    @SerializedName("validDay")
    private String ad;

    @SerializedName("extendInfo")
    private String b;

    @SerializedName("canRenewFlag")
    private String c;

    @SerializedName("guideText")
    private String d;

    @SerializedName(HwPayConstant.KEY_CURRENCY)
    private String e;

    @SerializedName("isReceivedByCondition")
    private String f;

    @SerializedName("minAge")
    private String g;

    @SerializedName(ParsedFieldTag.PRICE)
    private String h;

    @SerializedName("markUrl")
    private String i;

    @SerializedName("maxAge")
    private String j;

    @SerializedName("priceLevelExtend")
    private String k;

    @SerializedName(HwPayConstant.KEY_PRODUCTNAME)
    private String l;

    @SerializedName("productCode")
    private String m;

    @SerializedName(HwPayConstant.KEY_PRODUCTDESC)
    private String n;

    @SerializedName("productInterpretation")
    private String o;

    @SerializedName("productType")
    private String p;

    @SerializedName(CommonPickerConstant.RequestParams.KEY_REDIRECT_URL)
    private String q;

    @SerializedName("promotionurl")
    private String r;

    @SerializedName("relProductCode")
    private String s;

    @SerializedName("promotiondesc")
    private String t;

    @SerializedName("relProductDes")
    private String u;

    @SerializedName("symbol")
    private String v;

    @SerializedName("renewPrice")
    private String w;

    @SerializedName("sendCount")
    private String x;

    @SerializedName("renewCode")
    private String y;

    public String b() {
        return this.m;
    }

    public String d() {
        return this.f;
    }
}
