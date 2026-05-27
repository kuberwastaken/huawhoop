package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class kmu extends CloudCommonReponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("strategyId")
    private List<String> f14761a;

    @SerializedName("strategyName")
    private List<String> c;

    @SerializedName("bucketId")
    private List<String> e;

    public List<String> a() {
        return this.f14761a;
    }

    public List<String> b() {
        return this.c;
    }

    public List<String> c() {
        return this.e;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("arr_strategy_id")
        private List<String> f14762a;

        @SerializedName("arr_bucket_id")
        private List<String> b;

        public a(List<String> list, List<String> list2) {
            this.f14762a = list;
            this.b = list2;
        }

        public a(kmu kmuVar) {
            this.f14762a = kmuVar.f14761a;
            this.b = kmuVar.e;
        }

        public List<String> b() {
            return this.f14762a;
        }

        public List<String> a() {
            return this.b;
        }

        public String toString() {
            return "AbTestBiInfo{strategyId=" + this.f14762a + ", bucketId=" + this.b + '}';
        }
    }
}
