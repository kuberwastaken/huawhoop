package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;
import com.huawei.pluginachievement.manager.db.IAchieveDBMgr;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fsp implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("pageStart")
    private Integer f13143a;

    @SerializedName("operType")
    private Integer b;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_TYPE)
    private List<Integer> c;

    @SerializedName("courseCategory")
    private Integer d;

    @SerializedName(IAchieveDBMgr.PARAM_PAGE_SIZE)
    private Integer e;

    private fsp(d dVar) {
        this.f13143a = dVar.e;
        this.e = dVar.b;
        this.b = dVar.d;
        this.c = dVar.c;
        this.d = dVar.f13144a;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.v();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13144a;
        private Integer b;
        private List<Integer> c;
        private Integer d;
        private Integer e;

        public d e(Integer num) {
            this.e = num;
            return this;
        }

        public d b(Integer num) {
            this.b = num;
            return this;
        }

        public d d(Integer num) {
            this.d = num;
            return this;
        }

        public d b(List<Integer> list) {
            this.c = list;
            return this;
        }

        public d a(Integer num) {
            this.f13144a = num;
            return this;
        }

        public fsp b() {
            return new fsp(this);
        }
    }
}
