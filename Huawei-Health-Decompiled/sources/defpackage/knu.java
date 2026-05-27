package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.utils.Constants;

/* JADX INFO: loaded from: classes5.dex */
public class knu {

    @SerializedName("country")
    private String c;

    @SerializedName("branchId")
    private int d;

    @SerializedName(Constants.VMALL_ARG_TYPE)
    private Integer e;

    public void e(Integer num) {
        this.e = num;
    }

    public void a(String str) {
        this.c = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HonorDevicePrivacy{agrType=");
        stringBuffer.append(this.e);
        stringBuffer.append(", country=").append(this.c);
        stringBuffer.append(", branchId=").append(this.d);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
