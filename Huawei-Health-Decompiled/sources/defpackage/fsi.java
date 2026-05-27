package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fsi implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String f13131a;

    @SerializedName("userDefinedType")
    private int b;

    private fsi(d dVar) {
        this.f13131a = dVar.d;
        this.b = dVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.cj();
    }

    public static final class d {
        private int c;
        private String d;

        public d e(String str) {
            this.d = str;
            return this;
        }

        public d c(int i) {
            this.c = i;
            return this;
        }

        public fsi e() {
            return new fsi(this);
        }
    }
}
