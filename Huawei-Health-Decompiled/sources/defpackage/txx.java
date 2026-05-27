package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;

/* JADX INFO: loaded from: classes8.dex */
public class txx {

    @SerializedName("acctType")
    private int b;

    @SerializedName(HwPayConstant.KEY_USER_ID)
    private long c;

    @SerializedName("findType")
    private int d;

    @SerializedName("findContent")
    private String e;

    public long a() {
        return this.c;
    }

    public void a(long j) {
        this.c = j;
    }

    public int c() {
        return this.d;
    }

    public void c(int i) {
        this.d = i;
    }

    public String d() {
        return this.e;
    }

    public void b(String str) {
        this.e = str;
    }

    public int b() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{userID=");
        sb.append(a());
        sb.append(", findType=");
        sb.append(c());
        sb.append(", findContent=");
        sb.append(d());
        if (c() == 0) {
            sb.append(", acctType='");
            sb.append(b());
        }
        sb.append('}');
        return sb.toString();
    }
}
