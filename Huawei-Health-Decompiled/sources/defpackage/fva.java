package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes10.dex */
public class fva implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("planId")
    private String f13214a;

    @SerializedName("dayNum")
    private Integer b;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String c;

    @SerializedName("weekNum")
    private Integer d;

    @SerializedName("planType")
    private Integer e;

    private fva(b bVar) {
        this.e = bVar.e;
        this.f13214a = bVar.d;
        this.d = bVar.c;
        this.b = bVar.b;
        this.c = bVar.f13215a;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.cg();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13215a;
        private Integer b;
        private Integer c;
        private String d;
        private Integer e;

        public b a(Integer num) {
            this.e = num;
            return this;
        }

        public b e(String str) {
            this.d = str;
            return this;
        }

        public b d(Integer num) {
            this.c = num;
            return this;
        }

        public b e(Integer num) {
            this.b = num;
            return this;
        }

        public b d(String str) {
            this.f13215a = str;
            return this;
        }

        public fva e() {
            return new fva(this);
        }
    }
}
