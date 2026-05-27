package com.braintreepayments.api;

/* JADX INFO: loaded from: classes9.dex */
public interface PayPalListener {
    void onPayPalFailure(Exception exc);

    void onPayPalSuccess(PayPalAccountNonce payPalAccountNonce);
}
