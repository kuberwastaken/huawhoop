package defpackage;

import com.braintreepayments.api.PayPalCheckoutRequest;
import com.braintreepayments.api.PayPalRequest;
import com.braintreepayments.api.PayPalVaultRequest;

/* JADX INFO: loaded from: classes9.dex */
public class up {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PayPalRequest f18421a;
    private String b;
    private String c;
    private String d;
    private String e;

    up(PayPalRequest payPalRequest) {
        this.f18421a = payPalRequest;
    }

    String c() {
        return this.d;
    }

    up e(String str) {
        this.d = str;
        return this;
    }

    String b() {
        return this.b;
    }

    up c(String str) {
        this.b = str;
        return this;
    }

    String d() {
        PayPalRequest payPalRequest = this.f18421a;
        if (payPalRequest instanceof PayPalCheckoutRequest) {
            return ((PayPalCheckoutRequest) payPalRequest).getIntent();
        }
        return null;
    }

    boolean f() {
        return this.f18421a instanceof PayPalVaultRequest;
    }

    String e() {
        return this.f18421a.getMerchantAccountId();
    }

    String a() {
        return this.e;
    }

    up d(String str) {
        this.e = str;
        return this;
    }

    String i() {
        return this.c;
    }

    up b(String str) {
        this.c = str;
        return this;
    }
}
