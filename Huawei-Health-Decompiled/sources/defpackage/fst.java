package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class fst implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("trainModeType")
    private int f13146a;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String d;

    public fst(String str, int i) {
        this.d = str;
        this.f13146a = i;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.cl();
    }
}
