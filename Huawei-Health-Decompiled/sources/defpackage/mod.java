package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwonesdk.datastructure.request.DataType;
import com.huawei.operation.jsoperation.JsUtil;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class mod extends moe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("configData")
    private String f15754a;

    @SerializedName("details")
    private String b;

    @SerializedName("configDescription")
    private String c;

    @SerializedName("configSubType")
    private DataType d;

    @SerializedName("fields")
    private Map<String, Object> e;

    @SerializedName("recordId")
    private String f;

    @SerializedName("scopeApp")
    private String g;

    @SerializedName("subDataType")
    private DataType h;

    @SerializedName(JsUtil.SUMMARIES_KEY)
    private Map<String, Object> i;

    @SerializedName("scopeDeviceType")
    private String j;

    @Override // defpackage.moe
    public String toString() {
        return "SampleData{fields=" + this.e + ", configSubtype=" + this.d + ", configData='" + this.f15754a + "', scopeApp='" + this.g + "', scopeDeviceType='" + this.j + "', configDescription='" + this.c + "', subDataType=" + this.h + ", summaries=" + this.i + ", details='" + this.b + "', recordId='" + this.f + "'}";
    }
}
