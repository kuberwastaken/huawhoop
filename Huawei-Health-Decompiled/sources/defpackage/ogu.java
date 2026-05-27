package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ogu extends CloudCommonReponse {

    @SerializedName("backgroundImages")
    private List<ghz> d;

    @SerializedName("totalCount")
    private int e;

    public List<ghz> e() {
        return this.d;
    }

    public int a() {
        return this.e;
    }
}
