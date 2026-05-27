package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ohh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("hitopId")
    private String f16374a;

    @SerializedName("countryCode")
    private String b;

    @SerializedName(HwPayConstant.KEY_CURRENCY)
    private String c;

    @SerializedName("categoryId")
    private String d;

    @SerializedName("fileInfo")
    private oha e;

    @SerializedName("discountList")
    private List<ogy> f;

    @SerializedName("id")
    private String g;

    @SerializedName("layoutType")
    private String h;

    @SerializedName("label")
    private String i;

    @SerializedName("previews")
    private List<ohg> j;

    @SerializedName(ParsedFieldTag.PRICE)
    private String k;

    @SerializedName("symbol")
    private String l;

    @SerializedName("type")
    private String m;

    @SerializedName("processCover")
    private String n;

    @SerializedName("productId")
    private String o;

    public oha d() {
        return this.e;
    }

    public List<ohg> a() {
        return this.j;
    }

    public String c() {
        return this.g;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(255);
        stringBuffer.append("ShareThemeInfo{hitopId=");
        stringBuffer.append(this.f16374a);
        stringBuffer.append(", label=").append(this.i);
        stringBuffer.append(", id=").append(this.g);
        stringBuffer.append(", fileInfo=").append(this.e);
        stringBuffer.append(", countryCode=").append(this.b);
        stringBuffer.append(", previews=").append(this.j);
        stringBuffer.append(", processCover=").append(this.n);
        stringBuffer.append(", price=").append(this.k);
        stringBuffer.append(", categoryId=").append(this.d);
        stringBuffer.append(", symbol=").append(this.l);
        stringBuffer.append(", currency=").append(this.c);
        stringBuffer.append(", layoutType=").append(this.h);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
