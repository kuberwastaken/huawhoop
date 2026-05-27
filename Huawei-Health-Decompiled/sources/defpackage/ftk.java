package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ftk implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("operationSchemeId")
    private String f13163a;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String b;

    @SerializedName("mediaType")
    private Integer c;

    @SerializedName("actionVersion")
    private String d;

    private ftk(a aVar) {
        this.b = aVar.b;
        this.d = aVar.e;
        this.f13163a = aVar.c;
        this.c = aVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.as();
    }

    public static final class a {
        private String b;
        private String c;
        private Integer d;
        private String e;

        public a a(String str) {
            this.b = str;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.c = str;
            return this;
        }

        public a c(Integer num) {
            this.d = num;
            return this;
        }

        public ftk b() {
            return new ftk(this);
        }
    }
}
