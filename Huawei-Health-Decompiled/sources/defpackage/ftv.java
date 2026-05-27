package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;
import com.huawei.pluginachievement.manager.model.ParsedFieldTag;
import java.util.List;

/* JADX INFO: loaded from: classes10.dex */
public class ftv implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("difficulty")
    private Integer f13172a;

    @SerializedName("distance")
    private Integer b;

    @SerializedName("calorie")
    private Float c;

    @SerializedName("endDate")
    private Long d;

    @SerializedName(ParsedFieldTag.BEGIN_DATE)
    private Long e;

    @SerializedName("excludedDate")
    private String f;

    @SerializedName(ParsedFieldTag.GOAL)
    private Integer g;

    @SerializedName("movementTimes")
    private Integer h;

    @SerializedName("picture")
    private String i;

    @SerializedName("name")
    private String j;

    @SerializedName("type")
    private Integer k;

    @SerializedName("weekCount")
    private Integer l;

    @SerializedName("remindTime")
    private Integer m;

    @SerializedName("planId")
    private String n;

    @SerializedName("version")
    private String o;

    @SerializedName("weekInfos")
    private List<c> r;

    private ftv(a aVar) {
        this.n = aVar.o;
        this.j = aVar.f;
        this.k = aVar.n;
        this.f13172a = aVar.d;
        this.l = aVar.m;
        this.c = aVar.b;
        this.b = aVar.f13173a;
        this.i = aVar.h;
        this.o = aVar.l;
        this.e = aVar.e;
        this.d = aVar.c;
        this.f = aVar.j;
        this.h = aVar.i;
        this.g = aVar.g;
        this.m = aVar.k;
        this.r = aVar.q;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("courses")
        private List<d> f13174a;

        @SerializedName("sentence")
        private String b;

        @SerializedName("stage")
        private String c;

        @SerializedName("week_name")
        private String d;

        @SerializedName("displayorder")
        private Integer e;

        private c(b bVar) {
            this.f13174a = bVar.b;
            this.e = bVar.c;
            this.c = bVar.e;
            this.b = bVar.f13175a;
            this.d = bVar.d;
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f13175a;
            private List<d> b;
            private Integer c;
            private String d;
            private String e;

            public b a(List<d> list) {
                this.b = list;
                return this;
            }

            public b e(Integer num) {
                this.c = num;
                return this;
            }

            public b b(String str) {
                this.e = str;
                return this;
            }

            public b c(String str) {
                this.f13175a = str;
                return this;
            }

            public b a(String str) {
                this.d = str;
                return this;
            }

            public c e() {
                return new c(this);
            }
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("duration")
        private Integer f13176a;

        @SerializedName("description")
        private String b;

        @SerializedName("name")
        private String c;

        @SerializedName("displayorder")
        private Integer d;

        @SerializedName("runningParas")
        private String e;

        @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
        private String f;

        @SerializedName("version")
        private String h;

        @SerializedName("trainingDate")
        private Long i;

        @SerializedName("type")
        private Integer j;

        private d(e eVar) {
            this.i = eVar.h;
            this.f = eVar.j;
            this.c = eVar.e;
            this.b = eVar.f13177a;
            this.d = eVar.b;
            this.e = eVar.d;
            this.h = eVar.i;
            this.f13176a = eVar.c;
            this.j = eVar.f;
        }

        public static final class e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f13177a;
            private Integer b;
            private Integer c;
            private String d;
            private String e;
            private Integer f;
            private Long h;
            private String i;
            private String j;

            public e d(Long l) {
                this.h = l;
                return this;
            }

            public e b(String str) {
                this.j = str;
                return this;
            }

            public e a(String str) {
                this.e = str;
                return this;
            }

            public e d(String str) {
                this.f13177a = str;
                return this;
            }

            public e e(Integer num) {
                this.b = num;
                return this;
            }

            public e e(String str) {
                this.d = str;
                return this;
            }

            public e c(String str) {
                this.i = str;
                return this;
            }

            public e b(Integer num) {
                this.c = num;
                return this;
            }

            public e c(Integer num) {
                this.f = num;
                return this;
            }

            public d d() {
                return new d(this);
            }
        }
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.bf();
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f13173a;
        private Float b;
        private Long c;
        private Integer d;
        private Long e;
        private String f;
        private Integer g;
        private String h;
        private Integer i;
        private String j;
        private Integer k;
        private String l;
        private Integer m;
        private Integer n;
        private String o;
        private List<c> q;

        public a a(String str) {
            this.o = str;
            return this;
        }

        public a e(String str) {
            this.f = str;
            return this;
        }

        public a j(Integer num) {
            this.n = num;
            return this;
        }

        public a e(Integer num) {
            this.d = num;
            return this;
        }

        public a i(Integer num) {
            this.m = num;
            return this;
        }

        public a c(Float f) {
            this.b = f;
            return this;
        }

        public a b(Integer num) {
            this.f13173a = num;
            return this;
        }

        public a c(String str) {
            this.h = str;
            return this;
        }

        public a d(String str) {
            this.l = str;
            return this;
        }

        public a a(Long l) {
            this.e = l;
            return this;
        }

        public a c(Long l) {
            this.c = l;
            return this;
        }

        public a b(String str) {
            this.j = str;
            return this;
        }

        public a c(Integer num) {
            this.i = num;
            return this;
        }

        public a d(Integer num) {
            this.g = num;
            return this;
        }

        public a a(Integer num) {
            this.k = num;
            return this;
        }

        public a d(List<c> list) {
            this.q = list;
            return this;
        }

        public ftv b() {
            return new ftv(this);
        }
    }
}
