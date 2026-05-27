package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.health.device.api.IndoorEquipManagerApi;
import com.huawei.health.sport.model.WorkoutRecord;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fsl implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("by")
    private Integer f13134a;

    @SerializedName(WorkoutRecord.Extend.RunWorkout.RUN_WORKOUT_TRAJECTORY_ID)
    private String aa;

    @SerializedName("wearType")
    private Integer ab;

    @SerializedName("version")
    private String ac;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String ad;

    @SerializedName("bestPace")
    private Integer b;

    @SerializedName("actionSummary")
    private String c;

    @SerializedName("actualDistance")
    private Integer d;

    @SerializedName("actualCalorie")
    private Float e;

    @SerializedName("distance")
    private Integer f;

    @SerializedName("calorie")
    private Float g;

    @SerializedName(ParsedFieldTag.TASK_COMPLETE_TIME)
    private Long h;

    @SerializedName("displayorder")
    private Integer i;

    @SerializedName("completionRate")
    private Float j;

    @SerializedName("heartRateList")
    private List<b> k;

    @SerializedName("heartRateUp")
    private Integer l;

    @SerializedName("extend")
    private String m;

    @SerializedName("heartRateDown")
    private Integer n;

    @SerializedName("duration")
    private Integer o;

    @SerializedName("id")
    private Integer p;

    @SerializedName("recordModeType")
    private Integer q;

    @SerializedName(HwExerciseConstants.JSON_NAME_TRAINING_POINTS)
    private Integer r;

    @SerializedName("invalidHeartRateList")
    private List<b> s;

    @SerializedName(ParsedFieldTag.NPES_TOTAL_SCORE)
    private Long t;

    @SerializedName("name")
    private String u;

    @SerializedName("planId")
    private String v;

    @SerializedName("trainingLoadPeak")
    private Integer w;

    @SerializedName("trainingDate")
    private Long x;

    @SerializedName("oxygen")
    private Double y;

    @SerializedName("weekSequence")
    private Integer z;

    private fsl(d dVar) {
        this.p = dVar.s;
        this.f13134a = dVar.d;
        this.v = dVar.y;
        this.z = dVar.ac;
        this.x = dVar.u;
        this.ad = dVar.ab;
        this.u = dVar.w;
        this.i = dVar.f;
        this.f = dVar.h;
        this.g = dVar.j;
        this.d = dVar.b;
        this.e = dVar.c;
        this.j = dVar.i;
        this.o = dVar.o;
        this.l = dVar.k;
        this.n = dVar.n;
        this.b = dVar.e;
        this.h = dVar.g;
        this.y = dVar.v;
        this.w = dVar.x;
        this.aa = dVar.aa;
        this.c = dVar.f13136a;
        this.ac = dVar.ad;
        this.ab = dVar.z;
        this.m = dVar.l;
        this.r = dVar.r;
        this.t = dVar.q;
        this.q = dVar.t;
        this.k = dVar.m;
        this.s = dVar.p;
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName(IndoorEquipManagerApi.KEY_HEART_RATE)
        private Integer f13135a;

        @SerializedName("time")
        private Long d;

        private b(a aVar) {
            this.f13135a = aVar.c;
            this.d = aVar.b;
        }

        public static final class a {
            private Long b;
            private Integer c;

            public a a(Integer num) {
                this.c = num;
                return this;
            }

            public a a(Long l) {
                this.b = l;
                return this;
            }

            public b d() {
                return new b(this);
            }
        }
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.m();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13136a;
        private String aa;
        private String ab;
        private Integer ac;
        private String ad;
        private Integer b;
        private Float c;
        private Integer d;
        private Integer e;
        private Integer f;
        private Long g;
        private Integer h;
        private Float i;
        private Float j;
        private Integer k;
        private String l;
        private List<b> m;
        private Integer n;
        private Integer o;
        private List<b> p;
        private Long q;
        private Integer r;
        private Integer s;
        private Integer t;
        private Long u;
        private Double v;
        private String w;
        private Integer x;
        private String y;
        private Integer z;

        public d h(Integer num) {
            this.s = num;
            return this;
        }

        public d c(Integer num) {
            this.d = num;
            return this;
        }

        public d e(String str) {
            this.y = str;
            return this;
        }

        public d m(Integer num) {
            this.ac = num;
            return this;
        }

        public d c(Long l) {
            this.u = l;
            return this;
        }

        public d j(String str) {
            this.ab = str;
            return this;
        }

        public d a(String str) {
            this.w = str;
            return this;
        }

        public d e(Integer num) {
            this.f = num;
            return this;
        }

        public d d(Integer num) {
            this.h = num;
            return this;
        }

        public d a(Float f) {
            this.j = f;
            return this;
        }

        public d a(Integer num) {
            this.b = num;
            return this;
        }

        public d c(Float f) {
            this.c = f;
            return this;
        }

        public d b(Float f) {
            this.i = f;
            return this;
        }

        public d i(Integer num) {
            this.o = num;
            return this;
        }

        public d g(Integer num) {
            this.k = num;
            return this;
        }

        public d j(Integer num) {
            this.n = num;
            return this;
        }

        public d b(Integer num) {
            this.e = num;
            return this;
        }

        public d d(Long l) {
            this.g = l;
            return this;
        }

        public d d(Double d) {
            this.v = d;
            return this;
        }

        public d k(Integer num) {
            this.x = num;
            return this;
        }

        public d c(String str) {
            this.aa = str;
            return this;
        }

        public d d(String str) {
            this.f13136a = str;
            return this;
        }

        public d g(String str) {
            this.ad = str;
            return this;
        }

        public d o(Integer num) {
            this.z = num;
            return this;
        }

        public d b(String str) {
            this.l = str;
            return this;
        }

        public d e(List<b> list) {
            this.m = list;
            return this;
        }

        public d e(Long l) {
            this.q = l;
            return this;
        }

        public d f(Integer num) {
            this.t = num;
            return this;
        }

        public d d(List<b> list) {
            this.p = list;
            return this;
        }

        public fsl a() {
            return new fsl(this);
        }
    }
}
