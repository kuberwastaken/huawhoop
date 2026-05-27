package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes5.dex */
public class kob {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(Constants.VMALL_ARG_TYPE)
    private Integer f14779a;

    @SerializedName("country")
    private String b;

    @SerializedName("branchId")
    private int c;

    @SerializedName("isAgree")
    private boolean d;

    public void d(Integer num) {
        this.f14779a = num;
    }

    public void c(String str) {
        this.b = str;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HonorDevicePrivacy{agrType=");
        stringBuffer.append(this.f14779a);
        stringBuffer.append(", country=").append(this.b);
        stringBuffer.append(", branchId=").append(this.c);
        stringBuffer.append(", isAgree=").append(this.d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
