package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class eox {

    @SerializedName("state")
    protected String c;

    @SerializedName("blockList")
    protected List<epa> d;

    @SerializedName(HwPayConstant.KEY_PRODUCTNAME)
    protected String e;
}
