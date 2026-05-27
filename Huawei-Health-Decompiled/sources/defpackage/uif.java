package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.ble.BleConstants;

/* JADX INFO: loaded from: classes11.dex */
public class uif {

    @SerializedName(BleConstants.LIMIT)
    private int b;

    @SerializedName("start")
    private String e;

    public uif(int i) {
        this.b = i;
    }

    public void c(int i) {
        this.b = i;
    }

    public void b(String str) {
        this.e = str;
    }
}
