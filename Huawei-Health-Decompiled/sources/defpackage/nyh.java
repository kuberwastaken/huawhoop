package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.pluginfitnessadvice.TargetConfig;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class nyh {

    @SerializedName("planExecuteTime")
    private long c;

    @SerializedName("resource")
    private e d;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String e;

    public String c() {
        return this.e;
    }

    public long d() {
        return this.c;
    }

    public e a() {
        return this.d;
    }

    public String toString() {
        return "CustomCourseParameter{workoutId='" + this.e + "', planExecuteTime=" + this.c + ", resource=" + this.d + '}';
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("duration")
        private long f16232a;

        @SerializedName("algCourseNameId")
        private String b;

        @SerializedName("difficulty")
        private int c;

        @SerializedName("customCourseInfo")
        private String d;

        @SerializedName("calorie")
        private long e;

        @SerializedName("title")
        private String h;

        @SerializedName("id")
        private String i;

        @SerializedName("sourceType")
        private String j;

        public String b() {
            return this.i;
        }

        public String e() {
            return this.j;
        }

        public String d() {
            return this.d;
        }

        public String c() {
            return this.h;
        }

        public String toString() {
            return "Resource{algCourseNameId='" + this.b + "', calorie=" + this.e + ", difficulty=" + this.c + ", duration=" + this.f16232a + ", id='" + this.i + "', sourceType='" + this.j + "', customCourseInfo='" + this.d + "', title='" + this.h + "'}";
        }
    }

    public static class c {

        @SerializedName("combNum")
        private int c;

        @SerializedName("courseComb")
        private List<a> d;

        public List<a> a() {
            return this.d;
        }

        public String toString() {
            return "CustomCourseInfo{combNum=" + this.c + ", courseComb=" + this.d + '}';
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("actionList")
        private List<d> f16231a;

        @SerializedName("actionNum")
        private int c;

        @SerializedName("repeatTimes")
        private int d;

        public int b() {
            return this.d;
        }

        public List<d> e() {
            return this.f16231a;
        }

        public String toString() {
            return "CourseComb{actionNum=" + this.c + ", repeatTimes=" + this.d + ", actionList=" + this.f16231a + '}';
        }
    }

    public static class d {

        @SerializedName("actionId")
        private String b;

        @SerializedName("target")
        private TargetConfig c;

        @SerializedName("name")
        private String d;

        @SerializedName("strength")
        private TargetConfig e;

        public String c() {
            return this.b;
        }

        public String e() {
            return this.d;
        }

        public TargetConfig b() {
            return this.e;
        }

        public TargetConfig a() {
            return this.c;
        }

        public String toString() {
            return "ActionList{actionId='" + this.b + "', name='" + this.d + "', strength=" + this.e + ", target=" + this.c + '}';
        }
    }
}
