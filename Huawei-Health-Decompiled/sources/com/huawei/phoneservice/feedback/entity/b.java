package com.huawei.phoneservice.feedback.entity;

import com.braintreepayments.api.PayPalPaymentIntent;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("name")
    public String f8551a;

    @SerializedName("code")
    public String b;

    @SerializedName("child")
    public List<a> c = new ArrayList();

    @SerializedName(PayPalPaymentIntent.ORDER)
    public String e;
}
