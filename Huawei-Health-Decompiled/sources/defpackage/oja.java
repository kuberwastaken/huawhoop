package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.phoneservice.faq.base.constants.FaqConstants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes7.dex */
public class oja implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("id")
    private String f16408a;

    @SerializedName("smallMask")
    private int b;

    @SerializedName(FaqConstants.FAQ_ISSELECTED)
    private boolean c;

    @SerializedName("bigMask")
    private int e;

    public oja(String str, int i, int i2) {
        this.f16408a = str;
        this.b = i;
        this.e = i2;
    }

    public String c() {
        return this.f16408a;
    }

    public int e() {
        return this.b;
    }

    public int b() {
        return this.e;
    }

    public boolean a() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }
}
