package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class rks extends CloudCommonReponse {

    @SerializedName("sportTypeInfo")
    private e e;

    public rks() {
    }

    public rks(e eVar) {
        this.e = eVar;
    }

    public e c() {
        return this.e;
    }

    @Override // com.huawei.hwcloudmodel.model.CloudCommonReponse
    public String toString() {
        return "SportTabOrderData{" + super.toString() + "mSportTypeInfo='" + this.e + "'}";
    }

    public static class e {

        @SerializedName("resourceIdList")
        private List<String> b;

        public e() {
        }

        public e(List<String> list) {
            this.b = list;
        }

        public List<String> d() {
            return this.b;
        }

        public String toString() {
            return "SportTypeInfo{mResourceIds='" + this.b + "'}";
        }
    }
}
