package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwonesdk.datastructure.request.DataType;
import com.huawei.hwonesdk.datastructure.request.SyncDataModel;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class mob {

    @SerializedName("syncDataType")
    List<DataType> b;

    @SerializedName("syncDataModel")
    List<SyncDataModel> d;

    @SerializedName("syncTimeRange")
    mnq e;

    public List<DataType> c() {
        return this.b;
    }
}
