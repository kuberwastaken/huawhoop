package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes11.dex */
public class uia extends CloudCommonReponse {

    @SerializedName("shoppingInfoItems")
    private List<uik> c = new ArrayList();

    @SerializedName("pagination")
    private uie e = new uie();

    public List<uik> e() {
        return this.c;
    }

    public uie a() {
        return this.e;
    }
}
