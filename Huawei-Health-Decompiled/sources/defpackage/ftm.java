package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes9.dex */
public class ftm implements IRequest {

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_TYPE)
    private Integer b;

    @SerializedName("topicId")
    private Integer c;

    @SerializedName("lang")
    private String e;

    private ftm(a aVar) {
        this.c = aVar.c;
        this.b = aVar.b;
        this.e = aVar.f13166a;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ap();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13166a;
        private Integer b;
        private Integer c;

        public a c(Integer num) {
            this.c = num;
            return this;
        }

        public a d(Integer num) {
            this.b = num;
            return this;
        }

        public a c(String str) {
            this.f13166a = str;
            return this;
        }

        public ftm e() {
            return new ftm(this);
        }
    }
}
