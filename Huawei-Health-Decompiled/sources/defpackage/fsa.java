package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fsa implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String f13124a;

    @SerializedName("courseBelongType")
    private int d;

    @SerializedName("workoutPackageId")
    private String e;

    private fsa(b bVar) {
        this.f13124a = bVar.d;
        this.d = bVar.b;
        this.e = bVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.f();
    }

    public static final class b {
        private int b;
        private String c;
        private String d;

        public b a(String str) {
            this.d = str;
            return this;
        }

        public b c(int i) {
            this.b = i;
            return this;
        }

        public b b(String str) {
            this.c = str;
            return this;
        }

        public fsa a() {
            return new fsa(this);
        }
    }
}
