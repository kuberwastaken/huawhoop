package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class ohc extends CloudCommonReponse {

    @SerializedName("totalCount")
    private int b;

    @SerializedName("stickerList")
    private List<gic> c;

    public List<gic> d() {
        return this.c;
    }

    public int b() {
        return this.b;
    }
}
