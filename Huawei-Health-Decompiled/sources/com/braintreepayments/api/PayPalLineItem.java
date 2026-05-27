package com.braintreepayments.api;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class PayPalLineItem implements Parcelable {
    public static final Parcelable.Creator<PayPalLineItem> CREATOR = new Parcelable.Creator<PayPalLineItem>() { // from class: com.braintreepayments.api.PayPalLineItem.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: cg_, reason: merged with bridge method [inline-methods] */
        public PayPalLineItem createFromParcel(Parcel parcel) {
            return new PayPalLineItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public PayPalLineItem[] newArray(int i) {
            return new PayPalLineItem[i];
        }
    };
    private static final String DESCRIPTION_KEY = "description";
    private static final String IMAGE_URL_KEY = "image_url";
    public static final String KIND_CREDIT = "credit";
    public static final String KIND_DEBIT = "debit";
    private static final String KIND_KEY = "kind";
    private static final String NAME_KEY = "name";
    private static final String PRODUCT_CODE_KEY = "product_code";
    private static final String QUANTITY_KEY = "quantity";
    private static final String UNIT_AMOUNT_KEY = "unit_amount";
    private static final String UNIT_TAX_AMOUNT_KEY = "unit_tax_amount";
    private static final String UPC_CODE_KEY = "upc_code";
    public static final String UPC_TYPE_2 = "UPC-2";
    public static final String UPC_TYPE_5 = "UPC-5";
    public static final String UPC_TYPE_A = "UPC-A";
    public static final String UPC_TYPE_B = "UPC-B";
    public static final String UPC_TYPE_C = "UPC-C";
    public static final String UPC_TYPE_D = "UPC-D";
    public static final String UPC_TYPE_E = "UPC-E";
    private static final String UPC_TYPE_KEY = "upc_type";
    private static final String URL_KEY = "url";
    private String description;
    private String imageUrl;
    private String kind;
    private String name;
    private String productCode;
    private String quantity;
    private String unitAmount;
    private String unitTaxAmount;
    private String upcCode;
    private String upcType;
    private String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PayPalLineItem(String str, String str2, String str3, String str4) {
        this.kind = str;
        this.name = str2;
        this.quantity = str3;
        this.unitAmount = str4;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setKind(String str) {
        this.kind = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setProductCode(String str) {
        this.productCode = str;
    }

    public void setQuantity(String str) {
        this.quantity = str;
    }

    public void setUnitAmount(String str) {
        this.unitAmount = str;
    }

    public void setUnitTaxAmount(String str) {
        this.unitTaxAmount = str;
    }

    public void setUpcCode(String str) {
        this.upcCode = str;
    }

    public void setUpcType(String str) {
        this.upcType = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getDescription() {
        return this.description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getKind() {
        return this.kind;
    }

    public String getName() {
        return this.name;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public String getQuantity() {
        return this.quantity;
    }

    public String getUnitAmount() {
        return this.unitAmount;
    }

    public String getUnitTaxAmount() {
        return this.unitTaxAmount;
    }

    public String getUpcCode() {
        return this.upcCode;
    }

    public String getUpcType() {
        return this.upcType;
    }

    public String getUrl() {
        return this.url;
    }

    public JSONObject toJson() {
        try {
            return new JSONObject().putOpt("description", this.description).putOpt(IMAGE_URL_KEY, this.imageUrl).putOpt(KIND_KEY, this.kind).putOpt("name", this.name).putOpt(PRODUCT_CODE_KEY, this.productCode).putOpt(QUANTITY_KEY, this.quantity).putOpt(UNIT_AMOUNT_KEY, this.unitAmount).putOpt(UNIT_TAX_AMOUNT_KEY, this.unitTaxAmount).putOpt(UPC_CODE_KEY, this.upcCode).putOpt(UPC_TYPE_KEY, this.upcType).putOpt("url", this.url);
        } catch (JSONException unused) {
            return new JSONObject();
        }
    }

    PayPalLineItem(Parcel parcel) {
        this.description = parcel.readString();
        this.imageUrl = parcel.readString();
        this.kind = parcel.readString();
        this.name = parcel.readString();
        this.productCode = parcel.readString();
        this.quantity = parcel.readString();
        this.unitAmount = parcel.readString();
        this.unitTaxAmount = parcel.readString();
        this.upcCode = parcel.readString();
        this.upcType = parcel.readString();
        this.url = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.description);
        parcel.writeString(this.imageUrl);
        parcel.writeString(this.kind);
        parcel.writeString(this.name);
        parcel.writeString(this.productCode);
        parcel.writeString(this.quantity);
        parcel.writeString(this.unitAmount);
        parcel.writeString(this.unitTaxAmount);
        parcel.writeString(this.upcCode);
        parcel.writeString(this.upcType);
        parcel.writeString(this.url);
    }
}
