package com.huawei.trade.datatype;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes7.dex */
public class InboxBenefitInfo implements Parcelable {
    public static final Parcelable.Creator<InboxBenefitInfo> CREATOR = new Parcelable.Creator<InboxBenefitInfo>() { // from class: com.huawei.trade.datatype.InboxBenefitInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InboxBenefitInfo createFromParcel(Parcel parcel) {
            return new InboxBenefitInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InboxBenefitInfo[] newArray(int i) {
            return new InboxBenefitInfo[i];
        }
    };
    private int benefitType;
    private boolean isMainBenefit;
    private String productId;
    private DeviceBenefitProductInfo productInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected InboxBenefitInfo(Parcel parcel) {
        this.benefitType = parcel.readInt();
        this.productId = parcel.readString();
        this.productInfo = (DeviceBenefitProductInfo) parcel.readParcelable(DeviceBenefitProductInfo.class.getClassLoader());
        this.isMainBenefit = parcel.readByte() != 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.benefitType);
        parcel.writeString(this.productId);
        parcel.writeParcelable(this.productInfo, i);
        parcel.writeByte(this.isMainBenefit ? (byte) 1 : (byte) 0);
    }

    public int getBenefitType() {
        return this.benefitType;
    }

    public void setBenefitType(int i) {
        this.benefitType = i;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public DeviceBenefitProductInfo getProductInfo() {
        return this.productInfo;
    }

    public void setProductInfo(DeviceBenefitProductInfo deviceBenefitProductInfo) {
        this.productInfo = deviceBenefitProductInfo;
    }

    public boolean isMainBenefit() {
        return this.isMainBenefit;
    }

    public void setMainBenefit(boolean z) {
        this.isMainBenefit = z;
    }
}
