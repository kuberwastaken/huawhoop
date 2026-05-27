package com.huawei.trade.datatype;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hwlogsmodel.LogUtil;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BaseDeviceBenefitInfo implements Parcelable {
    public static final Parcelable.Creator<BaseDeviceBenefitInfo> CREATOR = new Parcelable.Creator<BaseDeviceBenefitInfo>() { // from class: com.huawei.trade.datatype.BaseDeviceBenefitInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseDeviceBenefitInfo createFromParcel(Parcel parcel) {
            return new BaseDeviceBenefitInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BaseDeviceBenefitInfo[] newArray(int i) {
            return new BaseDeviceBenefitInfo[i];
        }
    };
    private static final String TAG = "BaseDeviceBenefitInfo";
    protected int activeStatus;
    protected int benefitType;
    private String buttonName;
    protected String deviceName;
    private String deviceSn;
    protected String deviceType;
    protected long effectiveEndTime;
    protected long effectiveStartTime;
    private String largeCardUrl;
    protected int linkType;
    protected String linkValue;
    protected String pageDesc;
    protected String pageTitle;
    protected String productId;
    protected List<PictureWithLink> serviceDescPicture;
    protected String timeZone;
    protected int validateType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected BaseDeviceBenefitInfo(Parcel parcel) {
        this.deviceType = parcel.readString();
        this.deviceSn = parcel.readString();
        this.productId = parcel.readString();
        this.benefitType = parcel.readInt();
        this.linkType = parcel.readInt();
        this.linkValue = parcel.readString();
        this.timeZone = parcel.readString();
        this.effectiveStartTime = parcel.readLong();
        this.effectiveEndTime = parcel.readLong();
        this.activeStatus = parcel.readInt();
        this.pageTitle = parcel.readString();
        this.pageDesc = parcel.readString();
        this.deviceName = parcel.readString();
        this.validateType = parcel.readInt();
        this.buttonName = parcel.readString();
        this.largeCardUrl = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceType);
        parcel.writeString(this.deviceSn);
        parcel.writeString(this.productId);
        parcel.writeInt(this.benefitType);
        parcel.writeInt(this.linkType);
        parcel.writeString(this.linkValue);
        parcel.writeString(this.timeZone);
        parcel.writeLong(this.effectiveStartTime);
        parcel.writeLong(this.effectiveEndTime);
        parcel.writeInt(this.activeStatus);
        parcel.writeString(this.pageTitle);
        parcel.writeString(this.pageDesc);
        parcel.writeString(this.deviceName);
        parcel.writeInt(this.validateType);
        parcel.writeString(this.buttonName);
        parcel.writeString(this.largeCardUrl);
    }

    public boolean isBenefitInfoValid() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        LogUtil.b(TAG, "pageTitle = ", this.pageTitle, ", benefitType = ", Integer.valueOf(this.benefitType), ", effectiveStartTime = ", Long.valueOf(this.effectiveStartTime), "; effectiveEndTime = ", Long.valueOf(this.effectiveEndTime), "; activeStatus = ", Integer.valueOf(this.activeStatus));
        return jCurrentTimeMillis >= this.effectiveStartTime && jCurrentTimeMillis <= this.effectiveEndTime && this.activeStatus == 1;
    }

    public String getLinkValue() {
        return this.linkValue;
    }

    public void setLinkValue(String str) {
        this.linkValue = str;
    }

    public int getLinkType() {
        return this.linkType;
    }

    public void setLinkType(int i) {
        this.linkType = i;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public long getEffectiveStartTime() {
        return this.effectiveStartTime;
    }

    public void setEffectiveStartTime(long j) {
        this.effectiveStartTime = j;
    }

    public long getEffectiveEndTime() {
        return this.effectiveEndTime;
    }

    public void setEffectiveEndTime(long j) {
        this.effectiveEndTime = j;
    }

    public int getActiveStatus() {
        return this.activeStatus;
    }

    public void setActiveStatus(int i) {
        this.activeStatus = i;
    }

    public void setDeviceType(String str) {
        this.deviceType = str;
    }

    public String getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(String str) {
        this.timeZone = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public int getBenefitType() {
        return this.benefitType;
    }

    public void setBenefitType(int i) {
        this.benefitType = i;
    }

    public String getPageTitle() {
        return this.pageTitle;
    }

    public void setPageTitle(String str) {
        this.pageTitle = str;
    }

    public String getPageDesc() {
        return this.pageDesc;
    }

    public void setPageDesc(String str) {
        this.pageDesc = str;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public List<PictureWithLink> getServiceDescPicture() {
        return this.serviceDescPicture;
    }

    public void setServiceDescPicture(List<PictureWithLink> list) {
        this.serviceDescPicture = list;
    }

    public int getValidateType() {
        return this.validateType;
    }

    public void setValidateType(int i) {
        this.validateType = i;
    }

    public String getDeviceSn() {
        return this.deviceSn;
    }

    public void setDeviceSn(String str) {
        this.deviceSn = str;
    }

    public String getButtonName() {
        return this.buttonName;
    }

    public void setButtonName(String str) {
        this.buttonName = str;
    }

    public String getLargeCardUrl() {
        return this.largeCardUrl;
    }

    public void setLargeCardUrl(String str) {
        this.largeCardUrl = str;
    }
}
