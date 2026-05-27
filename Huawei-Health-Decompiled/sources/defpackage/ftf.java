package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ftf implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("version")
    private String f13157a;

    @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
    private String b;

    @SerializedName("operationSchemeId")
    private String c;

    @SerializedName("lang")
    private String d;

    @SerializedName("userDefinedType")
    private Integer e;

    private ftf(d dVar) {
        this.b = dVar.b;
        this.d = dVar.c;
        this.f13157a = dVar.f13158a;
        this.c = dVar.e;
        this.e = dVar.d;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.am();
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f13158a;
        private String b;
        private String c;
        private Integer d;
        private String e;

        public d b(String str) {
            this.b = str;
            return this;
        }

        public d e(String str) {
            this.c = str;
            return this;
        }

        public d d(String str) {
            this.f13158a = str;
            return this;
        }

        public d a(String str) {
            this.e = str;
            return this;
        }

        public d e(Integer num) {
            this.d = num;
            return this;
        }

        public ftf c() {
            return new ftf(this);
        }
    }
}
