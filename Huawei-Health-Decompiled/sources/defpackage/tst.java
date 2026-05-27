package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;

/* JADX INFO: loaded from: classes8.dex */
public class tst {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("age")
    private int f18139a;

    @SerializedName(CommonConstant.KEY_GENDER)
    private int c;

    @SerializedName("weight")
    private double d;

    @SerializedName("height")
    private int e;

    public void b(int i) {
        this.c = i;
    }

    public void c(int i) {
        this.f18139a = i;
    }

    public int a() {
        return this.e;
    }

    public void a(int i) {
        this.e = i;
    }

    public double d() {
        return this.d;
    }

    public void b(double d) {
        this.d = d;
    }
}
