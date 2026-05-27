package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fts implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String f13169a;

    @SerializedName("version")
    private String b;

    @SerializedName("operType")
    private Integer c;

    @SerializedName("workoutPackageId")
    private String d;

    @SerializedName("courseBelongType")
    private Integer e;

    private fts(b bVar) {
        this.f13169a = bVar.e;
        this.d = bVar.c;
        this.e = bVar.f13170a;
        this.b = bVar.b;
        this.c = bVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.az();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13170a;
        private String b;
        private String c;
        private Integer d;
        private String e;

        public b e(String str) {
            this.e = str;
            return this;
        }

        public b d(String str) {
            this.c = str;
            return this;
        }

        public b e(Integer num) {
            this.f13170a = num;
            return this;
        }

        public b a(String str) {
            this.b = str;
            return this;
        }

        public b c(Integer num) {
            this.d = num;
            return this;
        }

        public fts c() {
            return new fts(this);
        }
    }
}
