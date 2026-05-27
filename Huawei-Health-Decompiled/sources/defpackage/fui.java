package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fui implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("planType")
    private Integer f13189a;

    @SerializedName("planId")
    private String b;

    @SerializedName("dayNo")
    private Integer c;

    @SerializedName("propensityWorkoutId")
    private String d;

    @SerializedName("replacedWorkoutId")
    private String e;

    @SerializedName("weekNo")
    private Integer j;

    private fui(e eVar) {
        this.b = eVar.e;
        this.f13189a = eVar.c;
        this.j = eVar.h;
        this.c = eVar.f13190a;
        this.d = eVar.b;
        this.e = eVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bu();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13190a;
        private String b;
        private Integer c;
        private String d;
        private String e;
        private Integer h;

        public e c(String str) {
            this.e = str;
            return this;
        }

        public e c(Integer num) {
            this.c = num;
            return this;
        }

        public e d(Integer num) {
            this.h = num;
            return this;
        }

        public e e(Integer num) {
            this.f13190a = num;
            return this;
        }

        public e d(String str) {
            this.b = str;
            return this;
        }

        public e a(String str) {
            this.d = str;
            return this;
        }

        public fui c() {
            return new fui(this);
        }
    }
}
