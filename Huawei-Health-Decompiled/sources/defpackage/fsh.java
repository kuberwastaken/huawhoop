package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.hwdevice.phoneprocess.mgr.exercise.HwExerciseConstants;
import com.huawei.networkclient.IRequest;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class fsh implements IRequest {

    @SerializedName("list")
    private List<a> b;

    private fsh(b bVar) {
        this.b = bVar.d;
    }

    public static class a {

        @SerializedName(HwExerciseConstants.METHOD_PARAM_WORKOUT_ID)
        private String b;

        @SerializedName("courseBelongType")
        private Integer c;

        @SerializedName("version")
        private String d;

        private a(d dVar) {
            this.b = dVar.b;
            this.d = dVar.e;
            this.c = dVar.c;
        }

        public static final class d {
            private String b;
            private Integer c;
            private String e;

            public d c(String str) {
                this.b = str;
                return this;
            }

            public d b(String str) {
                this.e = str;
                return this;
            }

            public d b(Integer num) {
                this.c = num;
                return this;
            }

            public a d() {
                return new a(this);
            }
        }
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.k();
    }

    public static final class b {
        private List<a> d;

        public b e(List<a> list) {
            this.d = list;
            return this;
        }

        public fsh e() {
            return new fsh(this);
        }
    }
}
