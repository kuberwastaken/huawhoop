package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.pluginfitnessadvice.TargetConfig;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class fuw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String f13207a;

    @SerializedName("userDefinedType")
    private int b;

    @SerializedName("name")
    private String c;

    @SerializedName("description")
    private String d;

    @SerializedName("actionComposition")
    private List<e> e;

    private fuw(c cVar) {
        this.f13207a = cVar.e;
        this.d = cVar.f13209a;
        this.c = cVar.b;
        this.b = cVar.c;
        this.e = cVar.d;
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13209a;
        private String b;
        private int c;
        private List<e> d;
        private String e;

        public c e(String str) {
            this.e = str;
            return this;
        }

        public c b(String str) {
            this.f13209a = str;
            return this;
        }

        public c a(String str) {
            this.b = str;
            return this;
        }

        public c d(int i) {
            this.c = i;
            return this;
        }

        public c c(List<e> list) {
            this.d = list;
            return this;
        }

        public fuw d() {
            return new fuw(this);
        }
    }

    public static class e {

        @SerializedName("actionList")
        private List<b> b;

        @SerializedName("repeatTimes")
        private int e;

        private e(C0321e c0321e) {
            this.e = c0321e.d;
            this.b = c0321e.b;
        }

        /* JADX INFO: renamed from: fuw$e$e, reason: collision with other inner class name */
        public static final class C0321e {
            private List<b> b;
            private int d;

            public C0321e c(int i) {
                this.d = i;
                return this;
            }

            public C0321e e(List<b> list) {
                this.b = list;
                return this;
            }

            public e b() {
                return new e(this);
            }
        }
    }

    public static class b {

        @SerializedName("target")
        private TargetConfig b;

        @SerializedName("name")
        private String c;

        @SerializedName("strength")
        private TargetConfig d;

        @SerializedName("actionId")
        private String e;

        private b(d dVar) {
            this.e = dVar.b;
            this.c = dVar.e;
            this.b = dVar.f13208a;
            this.d = dVar.c;
        }

        public static final class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private TargetConfig f13208a;
            private String b;
            private TargetConfig c;
            private String e;

            public d a(String str) {
                this.b = str;
                return this;
            }

            public d b(String str) {
                this.e = str;
                return this;
            }

            public d a(TargetConfig targetConfig) {
                this.f13208a = targetConfig;
                return this;
            }

            public d b(TargetConfig targetConfig) {
                this.c = targetConfig;
                return this;
            }

            public b c() {
                return new b(this);
            }
        }
    }
}
