package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwonesdk.datastructure.request.DataType;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class mnu extends mnr {

    @SerializedName("dataType")
    private DataType b;

    @SerializedName("fields")
    private Map<String, Object> d;

    @SerializedName("dataSourceId")
    private String e;

    public DataType k() {
        return this.b;
    }

    public String l() {
        return this.e;
    }

    public Map<String, Object> n() {
        return this.d;
    }

    @Override // defpackage.mnr, defpackage.mnq
    public String toString() {
        return super.toString() + "SampleStatReadRequest{mType=" + this.b + "mDataSourceId=" + this.e + ", mFields=" + this.d + '}';
    }
}
