package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.operation.jsoperation.JsUtil;

/* JADX INFO: loaded from: classes11.dex */
public class uik extends uih {

    @SerializedName("maxPrice")
    private String b;

    @SerializedName("minPrice")
    private String c;

    @SerializedName(JsUtil.SCORE)
    private float d;

    public String e() {
        return this.c;
    }

    public String d() {
        return this.b;
    }
}
