package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class frz implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String f13121a;

    @SerializedName("operType")
    private Integer b;

    @SerializedName("courseBelongType")
    private Integer d;

    private frz(a aVar) {
        this.f13121a = aVar.c;
        this.b = aVar.f13122a;
        this.d = aVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.g();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13122a;
        private String c;
        private Integer d;

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a c(Integer num) {
            this.f13122a = num;
            return this;
        }

        public a b(Integer num) {
            this.d = num;
            return this;
        }

        public frz b() {
            return new frz(this);
        }
    }
}
