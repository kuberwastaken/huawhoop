package com.huawei.watchface.mvp.model.datatype;

/* JADX INFO: loaded from: classes11.dex */
public class PayIap4Info {
    private String applicationId;
    private String countryCode;
    private DeveloperPayload developerPayload;
    private String packageName;
    private String priceType;
    private String productId;
    private ReservedInfor reservedInfor;

    public String getPriceType() {
        return this.priceType;
    }

    public void setPriceType(String str) {
        this.priceType = str;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String str) {
        this.productId = str;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public DeveloperPayload getDeveloperPayload() {
        return this.developerPayload;
    }

    public void setDeveloperPayload(DeveloperPayload developerPayload) {
        this.developerPayload = developerPayload;
    }

    public ReservedInfor getReservedInfor() {
        return this.reservedInfor;
    }

    public void setReservedInfor(ReservedInfor reservedInfor) {
        this.reservedInfor = reservedInfor;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public void setApplicationId(String str) {
        this.applicationId = str;
    }
}
