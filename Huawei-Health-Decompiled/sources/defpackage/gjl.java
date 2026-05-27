package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;

/* JADX INFO: loaded from: classes4.dex */
public class gjl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("sex")
    private Integer f13493a;

    @SerializedName("lang")
    private String b;

    @SerializedName("mediaType")
    private Integer c;
    private transient boolean d;

    @SerializedName("operationSchemeId")
    private String e;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String g;

    @SerializedName("userDefinedType")
    private Integer h;

    @SerializedName("version")
    private String j;

    private gjl(b bVar) {
        this.g = bVar.h;
        this.f13493a = bVar.d;
        this.j = bVar.j;
        this.b = bVar.b;
        this.e = bVar.f13494a;
        this.h = Integer.valueOf(bVar.f);
        this.c = Integer.valueOf(bVar.e);
        this.d = bVar.c;
    }

    /* JADX INFO: loaded from: classes.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13494a;
        private String b;
        private boolean c = true;
        private Integer d;
        private int e;
        private int f;
        private String h;
        private String j;

        public b(String str) {
            this.h = str;
        }

        public b e(Integer num) {
            this.d = num;
            return this;
        }

        public b d(String str) {
            this.j = str;
            return this;
        }

        public b b(String str) {
            this.b = str;
            return this;
        }

        public b a(String str) {
            this.f13494a = str;
            return this;
        }

        public b b(int i) {
            this.f = i;
            return this;
        }

        public b d(int i) {
            this.e = i;
            return this;
        }

        public b b(boolean z) {
            this.c = z;
            return this;
        }

        public gjl c() {
            return new gjl(this);
        }
    }

    public String j() {
        return this.g;
    }

    public Integer a() {
        return this.f13493a;
    }

    public String g() {
        return this.j;
    }

    public String d() {
        return this.b;
    }

    public String c() {
        return this.e;
    }

    public int h() {
        return this.h.intValue();
    }

    public int e() {
        return this.c.intValue();
    }

    public boolean b() {
        return this.d;
    }
}
