package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hihealth.model.HealthTrendReport;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class jwd extends CloudCommonReponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("healthTrendReports")
    private List<HealthTrendReport> f14470a;

    public List<HealthTrendReport> d() {
        return this.f14470a;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "HealthTrendResponse{resultCode=" + getResultCode() + ", resultDesc='" + getResultDesc() + "', healthTrendReports=" + this.f14470a + "}";
    }
}
