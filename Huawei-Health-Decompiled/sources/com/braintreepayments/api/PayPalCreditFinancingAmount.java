package com.braintreepayments.api;

import android.os.Parcel;
import android.os.Parcelable;
import defpackage.ua;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class PayPalCreditFinancingAmount implements Parcelable {
    public static final Parcelable.Creator<PayPalCreditFinancingAmount> CREATOR = new Parcelable.Creator<PayPalCreditFinancingAmount>() { // from class: com.braintreepayments.api.PayPalCreditFinancingAmount.3
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: cd_, reason: merged with bridge method [inline-methods] */
        public PayPalCreditFinancingAmount createFromParcel(Parcel parcel) {
            return new PayPalCreditFinancingAmount(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public PayPalCreditFinancingAmount[] newArray(int i) {
            return new PayPalCreditFinancingAmount[i];
        }
    };
    private static final String CURRENCY_KEY = "currency";
    private static final String VALUE_KEY = "value";
    private String currency;
    private String value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private PayPalCreditFinancingAmount() {
    }

    static PayPalCreditFinancingAmount fromJson(JSONObject jSONObject) {
        PayPalCreditFinancingAmount payPalCreditFinancingAmount = new PayPalCreditFinancingAmount();
        if (jSONObject == null) {
            return payPalCreditFinancingAmount;
        }
        payPalCreditFinancingAmount.currency = ua.e(jSONObject, "currency", null);
        payPalCreditFinancingAmount.value = ua.e(jSONObject, "value", null);
        return payPalCreditFinancingAmount;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return String.format("%s %s", this.value, this.currency);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.currency);
        parcel.writeString(this.value);
    }

    private PayPalCreditFinancingAmount(Parcel parcel) {
        this.currency = parcel.readString();
        this.value = parcel.readString();
    }
}
