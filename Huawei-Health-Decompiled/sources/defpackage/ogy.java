package defpackage;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class ogy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("discountCode")
    private String f16367a;

    @SerializedName("discountPrice")
    private String b;

    @SerializedName("discountType")
    private String c;

    @SerializedName("discountId")
    private String d;

    @SerializedName("discountEndTime")
    private String e;

    @SerializedName("startTime")
    private String f;

    @SerializedName("markUrl")
    private String g;

    @SerializedName("markText")
    private String h;

    @SerializedName("givePrice")
    private String i;

    @SerializedName("updateTime")
    private String j;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(255);
        stringBuffer.append("BriefDiscountInfo{discountId=");
        stringBuffer.append(this.d);
        stringBuffer.append(", discountType=").append(this.c);
        stringBuffer.append(", discountPrice=").append(this.b);
        stringBuffer.append(", startTime=").append(this.f);
        stringBuffer.append(", discountEndTime=").append(this.e);
        stringBuffer.append(", discountCode=").append(this.f16367a);
        stringBuffer.append(", markText=").append(this.h);
        stringBuffer.append(", markUrl=").append(this.g);
        stringBuffer.append(", updateTime=").append(this.j);
        stringBuffer.append(", givePrice=").append(this.i);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
