package defpackage;

import com.braintreepayments.api.PayPalPaymentIntent;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.huawei.operation.h5pro.jsmodules.device.MatterDataContans;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class dgy implements Serializable {

    @SerializedName("marketingBacklog")
    private dhe b;

    @SerializedName(MatterDataContans.KEY_MAC_ADDRESS)
    private String c;

    @SerializedName(PayPalPaymentIntent.ORDER)
    private int d;

    @SerializedName("tag")
    private String g;

    @Expose(serialize = false)
    private String i;

    @SerializedName("isFinish")
    private boolean e = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("isViewed")
    private boolean f12241a = false;

    public dgy(String str, String str2) {
        this.g = str;
        this.i = str2;
    }

    public boolean c() {
        return this.e;
    }

    public boolean d() {
        return this.f12241a;
    }

    public void b(boolean z) {
        this.f12241a = z;
    }

    public void a(String str) {
        this.c = str;
    }

    public int b() {
        return this.d;
    }

    public void b(int i) {
        this.d = i;
    }

    public dhe a() {
        return this.b;
    }

    public void b(dhe dheVar) {
        this.b = dheVar;
    }

    public String e() {
        return this.i;
    }
}
