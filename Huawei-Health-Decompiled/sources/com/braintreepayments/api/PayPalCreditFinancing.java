package com.braintreepayments.api;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public class PayPalCreditFinancing implements Parcelable {
    private static final String CARD_AMOUNT_IMMUTABLE_KEY = "cardAmountImmutable";
    public static final Parcelable.Creator<PayPalCreditFinancing> CREATOR = new Parcelable.Creator<PayPalCreditFinancing>() { // from class: com.braintreepayments.api.PayPalCreditFinancing.3
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: cc_, reason: merged with bridge method [inline-methods] */
        public PayPalCreditFinancing createFromParcel(Parcel parcel) {
            return new PayPalCreditFinancing(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public PayPalCreditFinancing[] newArray(int i) {
            return new PayPalCreditFinancing[i];
        }
    };
    private static final String MONTHLY_PAYMENT_KEY = "monthlyPayment";
    private static final String PAYER_ACCEPTANCE_KEY = "payerAcceptance";
    private static final String TERM_KEY = "term";
    private static final String TOTAL_COST_KEY = "totalCost";
    private static final String TOTAL_INTEREST_KEY = "totalInterest";
    private boolean cardAmountImmutable;
    private PayPalCreditFinancingAmount monthlyPayment;
    private boolean payerAcceptance;
    private int term;
    private PayPalCreditFinancingAmount totalCost;
    private PayPalCreditFinancingAmount totalInterest;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private PayPalCreditFinancing() {
    }

    static PayPalCreditFinancing fromJson(JSONObject jSONObject) throws JSONException {
        PayPalCreditFinancing payPalCreditFinancing = new PayPalCreditFinancing();
        if (jSONObject == null) {
            return payPalCreditFinancing;
        }
        payPalCreditFinancing.cardAmountImmutable = jSONObject.optBoolean(CARD_AMOUNT_IMMUTABLE_KEY, false);
        payPalCreditFinancing.monthlyPayment = PayPalCreditFinancingAmount.fromJson(jSONObject.optJSONObject(MONTHLY_PAYMENT_KEY));
        payPalCreditFinancing.payerAcceptance = jSONObject.optBoolean(PAYER_ACCEPTANCE_KEY, false);
        payPalCreditFinancing.term = jSONObject.optInt(TERM_KEY, 0);
        payPalCreditFinancing.totalCost = PayPalCreditFinancingAmount.fromJson(jSONObject.optJSONObject(TOTAL_COST_KEY));
        payPalCreditFinancing.totalInterest = PayPalCreditFinancingAmount.fromJson(jSONObject.optJSONObject(TOTAL_INTEREST_KEY));
        return payPalCreditFinancing;
    }

    public int getTerm() {
        return this.term;
    }

    public boolean isCardAmountImmutable() {
        return this.cardAmountImmutable;
    }

    public PayPalCreditFinancingAmount getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public boolean hasPayerAcceptance() {
        return this.payerAcceptance;
    }

    public PayPalCreditFinancingAmount getTotalCost() {
        return this.totalCost;
    }

    public PayPalCreditFinancingAmount getTotalInterest() {
        return this.totalInterest;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.cardAmountImmutable ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.monthlyPayment, i);
        parcel.writeByte(this.payerAcceptance ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.term);
        parcel.writeParcelable(this.totalCost, i);
        parcel.writeParcelable(this.totalInterest, i);
    }

    private PayPalCreditFinancing(Parcel parcel) {
        this.cardAmountImmutable = parcel.readByte() != 0;
        this.monthlyPayment = (PayPalCreditFinancingAmount) parcel.readParcelable(PayPalCreditFinancingAmount.class.getClassLoader());
        this.payerAcceptance = parcel.readByte() != 0;
        this.term = parcel.readInt();
        this.totalCost = (PayPalCreditFinancingAmount) parcel.readParcelable(PayPalCreditFinancingAmount.class.getClassLoader());
        this.totalInterest = (PayPalCreditFinancingAmount) parcel.readParcelable(PayPalCreditFinancingAmount.class.getClassLoader());
    }
}
