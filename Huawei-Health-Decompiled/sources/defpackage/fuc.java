package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fuc implements IRequest {

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String e;

    private fuc(a aVar) {
        this.e = aVar.b;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bn();
    }

    public static final class a {
        private String b;

        public a d(String str) {
            this.b = str;
            return this;
        }

        public fuc c() {
            return new fuc(this);
        }
    }
}
