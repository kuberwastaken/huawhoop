package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class fte implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("lang")
    private String f13155a;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_TYPE)
    private List<Integer> c;

    private fte(d dVar) {
        this.f13155a = dVar.b;
        this.c = dVar.f13156a;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ad();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List<Integer> f13156a;
        private String b;

        public d b(String str) {
            this.b = str;
            return this;
        }

        public d a(List<Integer> list) {
            this.f13156a = list;
            return this;
        }

        public fte b() {
            return new fte(this);
        }
    }
}
