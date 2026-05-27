package defpackage;

import com.google.gson.annotations.SerializedName;
import com.hihonor.assistant.cardmgrsdk.CardMgrSdkConst;
import com.huawei.basefitnessadvice.model.Introduction;
import com.huawei.basefitnessadvice.model.PlanInfo;
import com.huawei.operation.h5pro.jsmodules.complaint.ComplaintConstants;
import com.tencent.open.SocialConstants;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class nyp extends PlanInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("alias")
    private String f16240a;

    @SerializedName("groupType")
    private int b;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String c;

    @SerializedName("imgUrl")
    private String d;

    @SerializedName(ComplaintConstants.GROUP_NAME_PARAM_KEY)
    private String e;

    @SerializedName(CardMgrSdkConst.KEY_RECOMMEND)
    private boolean f;
    private List<String> g;

    @SerializedName("introduction")
    private Introduction h;
    private int i;

    @SerializedName("name")
    private String j;

    @SerializedName("planType")
    private int n;

    @SerializedName("type")
    private int o = 0;

    public Introduction g() {
        return this.h;
    }

    public int a() {
        return this.n;
    }

    public void e(int i) {
        this.n = i;
    }

    public int d() {
        return this.i;
    }

    public void b(int i) {
        this.i = i;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public String f() {
        return this.j;
    }

    public void b(String str) {
        this.j = str;
    }

    public int b() {
        return this.b;
    }

    public String e() {
        return this.d;
    }

    @Override // com.huawei.basefitnessadvice.model.PlanInfo
    public int getType() {
        return this.o;
    }

    @Override // com.huawei.basefitnessadvice.model.PlanInfo
    public List<String> getLabels() {
        return this.g;
    }

    @Override // com.huawei.basefitnessadvice.model.PlanInfo
    public void setLabels(List<String> list) {
        this.g = list;
    }

    public String toString() {
        return "RunPlanInfo{mName='" + this.j + "', mAbbPlanName='" + this.f16240a + "', mDescription='" + this.c + "', mImageView=" + this.i + ", mPlanType=" + this.n + ", mType=" + this.o + ", mGroupType=" + this.b + ", mGroupName='" + this.e + "', mImageUrl='" + this.d + "', mIsRecommended=" + this.f + ", mLabels=" + this.g + ", mPriceTagBeanList=" + this.mPriceTagBeanList + ", mCommodityFlag=" + this.mCommodityFlag + ", mCornerImgDisplay=" + this.mCornerImgDisplay + ", mTransactionStatus=" + this.mTransactionStatus + '}';
    }
}
