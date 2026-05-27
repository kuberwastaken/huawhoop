package com.huawei.health.marketing.datatype.overlay;

import android.os.Parcel;
import com.huawei.health.marketing.datatype.ColumRecommendInfo;
import com.huawei.health.marketing.datatype.RcmItem;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SpEffectButton extends ColumRecommendInfo {
    private String buttonPicUrl;
    private int interactiveEffect;
    private String pageLink;
    private List<RcmItem> recommendList;
    private String resourceId;
    private String sharePicUrl;
    private String spEffectId;

    public SpEffectButton(ColumRecommendInfo.Builder builder) {
        super(builder);
    }

    public SpEffectButton(Parcel parcel) {
        super(parcel);
    }

    public String getButtonPicUrl() {
        return this.buttonPicUrl;
    }

    public int getInteractiveEffect() {
        return this.interactiveEffect;
    }

    public String getPageLink() {
        return this.pageLink;
    }

    public String getSharePicUrl() {
        return this.sharePicUrl;
    }

    public String getResourceId() {
        return this.resourceId;
    }

    public String getSpEffectId() {
        return this.spEffectId;
    }

    public List<RcmItem> getRecommendList() {
        return this.recommendList;
    }

    @Override // com.huawei.health.marketing.datatype.ColumRecommendInfo
    public String toString() {
        StringBuilder sb = new StringBuilder("SpEffectButton{buttonPicUrl='");
        sb.append(this.buttonPicUrl);
        sb.append("', interactiveEffect=");
        sb.append(this.interactiveEffect);
        sb.append(", pageLink='");
        sb.append(this.pageLink);
        sb.append("', sharePicUrl='");
        sb.append(this.sharePicUrl);
        sb.append("', resourceId='");
        sb.append(this.resourceId);
        sb.append("', spEffectId='");
        sb.append(this.spEffectId);
        sb.append("', recommendList=");
        List<RcmItem> list = this.recommendList;
        sb.append(list == null ? " " : list.toString());
        sb.append('}');
        return sb.toString();
    }
}
