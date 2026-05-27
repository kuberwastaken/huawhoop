package com.huawei.trade.datatype;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DeviceInboxInfo extends BaseDeviceBenefitInfo {
    public static final Parcelable.Creator<DeviceInboxInfo> CREATOR = new Parcelable.Creator<DeviceInboxInfo>() { // from class: com.huawei.trade.datatype.DeviceInboxInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInboxInfo createFromParcel(Parcel parcel) {
            return new DeviceInboxInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DeviceInboxInfo[] newArray(int i) {
            return new DeviceInboxInfo[i];
        }
    };
    private boolean autoActivate;
    private int autoActivateDelay;
    private String cardUrl;
    private List<DeviceBenefitInfo> deviceBenefitInfos;
    private String deviceInboxId;
    private List<InboxBenefitInfo> inboxBenefitInfos;
    private String inboxDescription;
    private String inboxName;
    private String inboxSubTitle;
    private String introductionUrl;
    private List<OtherServiceInfo> otherServiceList;

    protected DeviceInboxInfo(Parcel parcel) {
        super(parcel);
        this.inboxBenefitInfos = parcel.readArrayList(InboxBenefitInfo.class.getClassLoader());
        this.deviceInboxId = parcel.readString();
        this.inboxName = parcel.readString();
        this.inboxSubTitle = parcel.readString();
        this.inboxDescription = parcel.readString();
        this.cardUrl = parcel.readString();
        this.introductionUrl = parcel.readString();
        if (Build.VERSION.SDK_INT >= 29) {
            this.autoActivate = parcel.readBoolean();
        } else {
            this.autoActivate = parcel.readInt() != 0;
        }
        this.autoActivateDelay = parcel.readInt();
    }

    @Override // com.huawei.trade.datatype.BaseDeviceBenefitInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeList(this.inboxBenefitInfos);
        parcel.writeString(this.deviceInboxId);
        parcel.writeString(this.inboxName);
        parcel.writeString(this.inboxSubTitle);
        parcel.writeString(this.inboxDescription);
        parcel.writeString(this.cardUrl);
        parcel.writeString(this.introductionUrl);
        if (Build.VERSION.SDK_INT >= 29) {
            parcel.writeBoolean(this.autoActivate);
        } else {
            parcel.writeInt(this.autoActivate ? 1 : 0);
        }
        parcel.writeInt(this.autoActivateDelay);
    }

    public String getDeviceInboxId() {
        return this.deviceInboxId;
    }

    public void setDeviceInboxId(String str) {
        this.deviceInboxId = str;
    }

    public String getCardUrl() {
        return this.cardUrl;
    }

    public void setCardUrl(String str) {
        this.cardUrl = str;
    }

    public String getInboxName() {
        return this.inboxName;
    }

    public void setInboxName(String str) {
        this.inboxName = str;
    }

    public String getInboxSubTitle() {
        return this.inboxSubTitle;
    }

    public void setInboxSubTitle(String str) {
        this.inboxSubTitle = str;
    }

    public String getInboxDescription() {
        return this.inboxDescription;
    }

    public void setInboxDescription(String str) {
        this.inboxDescription = str;
    }

    public String getIntroductionUrl() {
        return this.introductionUrl;
    }

    public void setIntroductionUrl(String str) {
        this.introductionUrl = str;
    }

    public List<InboxBenefitInfo> getInboxBenefitInfos() {
        return this.inboxBenefitInfos;
    }

    public void setInboxBenefitInfos(List<InboxBenefitInfo> list) {
        this.inboxBenefitInfos = list;
    }

    public boolean isAutoActivate() {
        return this.autoActivate;
    }

    public void setAutoActivate(boolean z) {
        this.autoActivate = z;
    }

    public int getAutoActivateDelay() {
        return this.autoActivateDelay;
    }

    public void setAutoActivateDelay(int i) {
        this.autoActivateDelay = i;
    }

    public List<OtherServiceInfo> getOtherServiceList() {
        return this.otherServiceList;
    }

    public void setOtherServiceList(List<OtherServiceInfo> list) {
        this.otherServiceList = list;
    }

    public List<DeviceBenefitInfo> getDeviceBenefitInfos() {
        return this.deviceBenefitInfos;
    }

    public void setDeviceBenefitInfos(List<DeviceBenefitInfo> list) {
        this.deviceBenefitInfos = list;
    }

    public String toString() {
        return "DeviceInboxInfo{deviceInboxId='" + this.deviceInboxId + "', inboxName='" + this.inboxName + "', inboxSubTitle='" + this.inboxSubTitle + "', inboxDescription='" + this.inboxDescription + "', cardUrl='" + this.cardUrl + "', introductionUrl='" + this.introductionUrl + "', inboxBenefitInfos=" + this.inboxBenefitInfos + ", autoActivate=" + this.autoActivate + ", autoActivateDelay=" + this.autoActivateDelay + ", deviceType='" + this.deviceType + "', productId='" + this.productId + "', benefitType=" + this.benefitType + ", linkType=" + this.linkType + ", linkValue='" + this.linkValue + "', timeZone='" + this.timeZone + "', effectiveStartTime=" + this.effectiveStartTime + ", effectiveEndTime=" + this.effectiveEndTime + ", activeStatus=" + this.activeStatus + ", pageTitle='" + this.pageTitle + "', pageDesc='" + this.pageDesc + "', deviceName='" + this.deviceName + "', serviceDescPicture=" + this.serviceDescPicture + ", validateType=" + this.validateType + ", otherServiceList=" + this.otherServiceList + '}';
    }
}
