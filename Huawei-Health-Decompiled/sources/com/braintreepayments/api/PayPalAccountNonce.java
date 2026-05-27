package com.braintreepayments.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes9.dex */
public class PayPalAccountNonce extends PaymentMethodNonce {
    private static final String ACCOUNT_ADDRESS_KEY = "accountAddress";
    static final String API_RESOURCE_KEY = "paypalAccounts";
    private static final String BILLING_ADDRESS_KEY = "billingAddress";
    private static final String CLIENT_METADATA_ID_KEY = "correlationId";
    public static final Parcelable.Creator<PayPalAccountNonce> CREATOR = new Parcelable.Creator<PayPalAccountNonce>() { // from class: com.braintreepayments.api.PayPalAccountNonce.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: bZ_, reason: merged with bridge method [inline-methods] */
        public PayPalAccountNonce createFromParcel(Parcel parcel) {
            return new PayPalAccountNonce(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PayPalAccountNonce[] newArray(int i) {
            return new PayPalAccountNonce[i];
        }
    };
    private static final String CREDIT_FINANCING_KEY = "creditFinancingOffered";
    private static final String DETAILS_KEY = "details";
    private static final String EMAIL_KEY = "email";
    private static final String FIRST_NAME_KEY = "firstName";
    private static final String LAST_NAME_KEY = "lastName";
    private static final String PAYER_ID_KEY = "payerId";
    private static final String PAYER_INFO_KEY = "payerInfo";
    private static final String PAYMENT_METHOD_DATA_KEY = "paymentMethodData";
    private static final String PAYMENT_METHOD_DEFAULT_KEY = "default";
    private static final String PAYMENT_METHOD_NONCE_KEY = "nonce";
    private static final String PHONE_KEY = "phone";
    private static final String SHIPPING_ADDRESS_KEY = "shippingAddress";
    private static final String TOKENIZATION_DATA_KEY = "tokenizationData";
    private static final String TOKEN_KEY = "token";
    private final String authenticateUrl;
    private final PostalAddress billingAddress;
    private final String clientMetadataId;
    private final PayPalCreditFinancing creditFinancing;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String payerId;
    private final String phone;
    private final PostalAddress shippingAddress;

    /* JADX WARN: Can't wrap try/catch for region: R(25:0|2|(1:4)(22:5|(1:7)|9|42|10|(1:12)(1:14)|40|15|(1:17)|18|48|19|46|20|44|21|(1:23)|24|30|(1:35)(1:34)|36|37)|8|9|42|10|(0)(0)|40|15|(0)|18|48|19|46|20|44|21|(0)|24|30|(2:32|35)(0)|36|37|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00be, code lost:
    
        r14 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c0, code lost:
    
        r13 = "";
        r14 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c3, code lost:
    
        r7 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c4, code lost:
    
        r12 = "";
        r13 = r12;
        r14 = r13;
        r3 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c8, code lost:
    
        r11 = new com.braintreepayments.api.PostalAddress();
        r17 = r3;
        r16 = r4;
        r1 = new com.braintreepayments.api.PostalAddress();
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x006f A[Catch: JSONException -> 0x00c4, TRY_LEAVE, TryCatch #1 {JSONException -> 0x00c4, blocks: (B:10:0x0069, B:12:0x006f), top: B:42:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008b A[Catch: JSONException -> 0x00c3, TryCatch #0 {JSONException -> 0x00c3, blocks: (B:15:0x0079, B:17:0x008b, B:18:0x008f), top: B:40:0x0079 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b5 A[Catch: JSONException -> 0x00c8, TRY_LEAVE, TryCatch #2 {JSONException -> 0x00c8, blocks: (B:21:0x00ad, B:23:0x00b5), top: B:44:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.braintreepayments.api.PayPalAccountNonce fromJSON(org.json.JSONObject r21) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braintreepayments.api.PayPalAccountNonce.fromJSON(org.json.JSONObject):com.braintreepayments.api.PayPalAccountNonce");
    }

    private PayPalAccountNonce(String str, PostalAddress postalAddress, PostalAddress postalAddress2, String str2, String str3, String str4, String str5, String str6, PayPalCreditFinancing payPalCreditFinancing, String str7, String str8, boolean z) {
        super(str8, z);
        this.clientMetadataId = str;
        this.billingAddress = postalAddress;
        this.shippingAddress = postalAddress2;
        this.firstName = str2;
        this.lastName = str3;
        this.phone = str4;
        this.email = str5;
        this.payerId = str6;
        this.creditFinancing = payPalCreditFinancing;
        this.authenticateUrl = str7;
    }

    public String getEmail() {
        return this.email;
    }

    public PostalAddress getBillingAddress() {
        return this.billingAddress;
    }

    public PostalAddress getShippingAddress() {
        return this.shippingAddress;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getClientMetadataId() {
        return this.clientMetadataId;
    }

    public String getPayerId() {
        return this.payerId;
    }

    public PayPalCreditFinancing getCreditFinancing() {
        return this.creditFinancing;
    }

    public String getAuthenticateUrl() {
        return this.authenticateUrl;
    }

    @Override // com.braintreepayments.api.PaymentMethodNonce, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.clientMetadataId);
        parcel.writeParcelable(this.billingAddress, i);
        parcel.writeParcelable(this.shippingAddress, i);
        parcel.writeString(this.firstName);
        parcel.writeString(this.lastName);
        parcel.writeString(this.email);
        parcel.writeString(this.phone);
        parcel.writeString(this.payerId);
        parcel.writeParcelable(this.creditFinancing, i);
        parcel.writeString(this.authenticateUrl);
    }

    private PayPalAccountNonce(Parcel parcel) {
        super(parcel);
        this.clientMetadataId = parcel.readString();
        this.billingAddress = (PostalAddress) parcel.readParcelable(PostalAddress.class.getClassLoader());
        this.shippingAddress = (PostalAddress) parcel.readParcelable(PostalAddress.class.getClassLoader());
        this.firstName = parcel.readString();
        this.lastName = parcel.readString();
        this.email = parcel.readString();
        this.phone = parcel.readString();
        this.payerId = parcel.readString();
        this.creditFinancing = (PayPalCreditFinancing) parcel.readParcelable(PayPalCreditFinancing.class.getClassLoader());
        this.authenticateUrl = parcel.readString();
    }
}
