package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;

/* JADX INFO: loaded from: classes4.dex */
public class gix {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("timbre")
    private String f13479a;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String b;

    @SerializedName("userDefinedType")
    private int c;

    @SerializedName("version")
    private String e;

    private gix(d dVar) {
        this.b = dVar.e;
        this.e = dVar.b;
        this.c = dVar.c;
        this.f13479a = dVar.f13480a;
    }

    public String d() {
        return this.b;
    }

    public String a() {
        return this.e;
    }

    public int e() {
        return this.c;
    }

    public String c() {
        return this.f13479a;
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13480a;
        private String b;
        private int c;
        private String e;

        public d b(String str) {
            this.e = str;
            return this;
        }

        public d a(String str) {
            this.b = str;
            return this;
        }

        public d b(int i) {
            this.c = i;
            return this;
        }

        public d c(String str) {
            this.f13480a = str;
            return this;
        }

        public gix e() {
            return new gix(this);
        }
    }
}
