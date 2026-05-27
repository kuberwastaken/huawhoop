package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class frv implements IRequest {

    @SerializedName("planType")
    private Integer b;

    @SerializedName(TypedValues.CycleType.S_WAVE_PERIOD)
    private Integer c;

    @SerializedName("pbType")
    private Integer d;

    @SerializedName("pb")
    private Integer e;

    private frv(e eVar) {
        this.d = eVar.f13117a;
        this.e = eVar.e;
        this.b = eVar.d;
        this.c = eVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.e();
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13117a;
        private Integer c;
        private Integer d;
        private Integer e;

        public e c(Integer num) {
            this.f13117a = num;
            return this;
        }

        public e d(Integer num) {
            this.e = num;
            return this;
        }

        public e e(Integer num) {
            this.d = num;
            return this;
        }

        public e b(Integer num) {
            this.c = num;
            return this;
        }

        public frv a() {
            return new frv(this);
        }
    }
}
