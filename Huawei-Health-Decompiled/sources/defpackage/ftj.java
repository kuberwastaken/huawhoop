package defpackage;

import com.google.gson.annotations.SerializedName;
import com.huawei.networkclient.IRequest;

/* JADX INFO: loaded from: classes4.dex */
public class ftj implements IRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SerializedName("workoutPackageId")
    private String f13162a;

    @SerializedName("lang")
    private String e;

    private ftj(b bVar) {
        this.e = bVar.e;
        this.f13162a = bVar.c;
    }

    @Override // com.huawei.networkclient.IRequest
    public String getUrl() {
        return fve.ao();
    }

    public static final class b {
        private String c;
        private String e;

        public b d(String str) {
            this.e = str;
            return this;
        }

        public b b(String str) {
            this.c = str;
            return this;
        }

        public ftj e() {
            return new ftj(this);
        }
    }
}
